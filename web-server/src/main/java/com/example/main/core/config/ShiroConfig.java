package com.example.main.core.config;

import com.example.main.core.security.filter.AuthFilter;
import com.example.main.core.security.filter.LoginFilter;
import com.example.main.core.security.filter.PermissionFilter;
import com.example.main.core.security.filter.RoleFilter;
import com.example.main.core.security.listener.CustomSessionListener;
import com.example.main.core.security.listener.PswAuthenticationListener;
import com.example.main.core.security.realm.UserRealm;
import com.example.main.core.security.session.CustomShiroSessionDAO;
import org.apache.shiro.authc.AbstractAuthenticator;
import org.apache.shiro.authc.AuthenticationListener;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authc.pam.AtLeastOneSuccessfulStrategy;
import org.apache.shiro.authc.pam.ModularRealmAuthenticator;
import org.apache.shiro.codec.Base64;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.session.mgt.ExecutorServiceSessionValidationScheduler;
import org.apache.shiro.session.mgt.eis.EnterpriseCacheSessionDAO;
import org.apache.shiro.session.mgt.eis.JavaUuidSessionIdGenerator;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.CookieRememberMeManager;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.servlet.SimpleCookie;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

import javax.servlet.Filter;
import java.util.*;

@Configuration
public class ShiroConfig {
    private final Logger logger = LoggerFactory.getLogger(ShiroConfig.class);

    @Bean
    public UserRealm userRealm() {
        UserRealm userRealm = new UserRealm();
        userRealm.setCredentialsMatcher(hashedCredentialsMatcher());
        userRealm.setCachingEnabled(true);
        return userRealm;
    }

    /**
     * 认证器,添加两个realm管理
     */
    @Bean
    public AbstractAuthenticator abstractAuthenticator(UserRealm userRealm) {
        // 自定义模块化认证器，用于解决多realm抛出异常问题
        ModularRealmAuthenticator authenticator = new ModularRealmAuthenticator();
        // 认证策略：AtLeastOneSuccessfulStrategy(默认)，AllSuccessfulStrategy，FirstSuccessfulStrategy
        authenticator.setAuthenticationStrategy(new AtLeastOneSuccessfulStrategy());
        authenticator.setAuthenticationListeners(Collections.singletonList(pswLoginListener()
        ));
        // 加入realms
        List<Realm> realms = new ArrayList<>();
        realms.add(userRealm);
        authenticator.setRealms(realms);
        return authenticator;
    }

    @Bean
    public AuthenticationListener pswLoginListener() {
        return new PswAuthenticationListener();
    }

    @Bean
    public ShiroFilterFactoryBean shiroFilter(SecurityManager manager) {
        ShiroFilterFactoryBean bean = new ShiroFilterFactoryBean();
        bean.setSecurityManager(manager);
        //配置登录的url和登录成功的url
        bean.setLoginUrl("/job-seeker/loginByPassword");
        bean.setSuccessUrl("/index");
        bean.setUnauthorizedUrl("/403");

        Map<String, Filter> map = new HashMap<>();
        map.put("simpleAuth", authFilter());
        map.put("login", login());
        map.put("role", role());
        map.put("permission", permission());

        bean.setFilters(map);
        LinkedHashMap<String, String> filterChainDefinitionMap = new LinkedHashMap<>();
        filterChainDefinitionMap.put("/**", "anon");
        filterChainDefinitionMap.put("/*.*", "anon"); //暂时所有的接口都设置为不需要进行认证
        bean.setFilterChainDefinitionMap(filterChainDefinitionMap);
        return bean;
    }

    @Bean
    public SecurityManager securityManager(
            UserRealm userRealm, AbstractAuthenticator abstractAuthenticator
    ) {
        logger.info("-----------shiro-------已经加载");
        DefaultWebSecurityManager manager
                = new DefaultWebSecurityManager();
        //添加自定义realm
        List<Realm> realms = new ArrayList<>();
        realms.add(userRealm);
        manager.setRealms(realms);
        manager.setSessionManager(sessionManager());
        manager.setRememberMeManager(rememberMeManager());
        manager.setAuthenticator(abstractAuthenticator);
        return manager;
    }

    /**
     * 开启hash加密
     * SignUpHelper 类中实现注册时的密码加密操作
     * 开发初期阶段改功能可以先关闭
     */
    @Bean
    public HashedCredentialsMatcher hashedCredentialsMatcher() {
        HashedCredentialsMatcher matcher = new HashedCredentialsMatcher();
        matcher.setHashAlgorithmName("md5");
        matcher.setHashIterations(1024);
        matcher.setStoredCredentialsHexEncoded(true);
        return matcher;
    }

    @Bean
    public LifecycleBeanPostProcessor lifecycleBeanPostProcessor() {
        return new LifecycleBeanPostProcessor();
    }

    /**
     * 开启shiro aop注解支持.
     * 使用代理方式;所以需要开启代码支持;否则@RequiresRoles等注解无法生效
     *
     * @param securityManager
     * @return
     */
    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager) {
        AuthorizationAttributeSourceAdvisor
                advisor = new AuthorizationAttributeSourceAdvisor();
        advisor.setSecurityManager(securityManager);
        return advisor;
    }

    /**
     * 自动创建代理
     *
     * @return
     */
    @Bean
    @DependsOn({"lifecycleBeanPostProcessor"})
    public DefaultAdvisorAutoProxyCreator advisorAutoProxyCreator() {
        DefaultAdvisorAutoProxyCreator advisorAutoProxyCreator = new DefaultAdvisorAutoProxyCreator();
        advisorAutoProxyCreator.setProxyTargetClass(true);
        return advisorAutoProxyCreator;
    }

    //  filter begin-------------------------
    @Bean
    public AuthFilter authFilter() {
        return new AuthFilter();
    }

    @Bean
    public LoginFilter login() {
        return new LoginFilter();
    }

    @Bean
    public PermissionFilter permission() {
        return new PermissionFilter();
    }

    @Bean
    public RoleFilter role() {
        return new RoleFilter();
    }
    //  filter end-------------------------

    //***session begin------------------------
    //会话Session ID生成器
    @Bean
    public JavaUuidSessionIdGenerator sessionIdGenerator() {
        return new JavaUuidSessionIdGenerator();
    }

    //会话验证调度器  定期完成无效Session清理
    @Bean
    public ExecutorServiceSessionValidationScheduler sessionValidationScheduler() {
        ExecutorServiceSessionValidationScheduler validationScheduler = new ExecutorServiceSessionValidationScheduler();
//        validationScheduler.setSessionManager(sessionManager());
        validationScheduler.setInterval(20000);
        return validationScheduler;
    }

    //会话持久层
//    @Bean
//    public CustomShiroSessionDAO sessionDAO(){
//        CustomShiroSessionDAO sessionDAO=new CustomShiroSessionDAO();
//        sessionDAO.setSessionIdGenerator(sessionIdGenerator());
//        return sessionDAO;
//    }
    @Bean
    public EnterpriseCacheSessionDAO sessionDAO() {
        EnterpriseCacheSessionDAO sessionDAO = new EnterpriseCacheSessionDAO();
        sessionDAO.setSessionIdGenerator(sessionIdGenerator());
        return sessionDAO;
    }

    //session 管理器：管理所有Subject的session包括创建、维护、删除、失效、验证等工作
    @Bean
    public DefaultWebSessionManager sessionManager() {
        DefaultWebSessionManager sessionManager = new DefaultWebSessionManager();
        sessionManager.setSessionDAO(sessionDAO());        //会话持久层
//        sessionManager.setCacheManager(cacheManager());
        sessionManager.setSessionListeners(Collections.singleton(sessionListener()));
        sessionManager.setSessionValidationInterval(30 * 60 * 1000);        //相隔多久检查一次session有效性
        sessionManager                              //设置会话验证调度器
                .setSessionValidationScheduler(sessionValidationScheduler());
        sessionManager.setGlobalSessionTimeout(1800000); //session有效时间为半个小时
        sessionManager
                .setSessionValidationSchedulerEnabled(true);
        sessionManager.setDeleteInvalidSessions(true); //选择删除无效的session

        //设置会话cookie模板
        sessionManager.setSessionIdCookie(sessionIdCookie());
        sessionManager.setSessionIdCookieEnabled(true);

        return sessionManager;
    }

    //session监听器
    @Bean
    public CustomSessionListener sessionListener() {
        return new CustomSessionListener();

    }
    //session end--------------------------

    //***cookie begin-------------------------
    //cookie 模板
    @Bean
    public SimpleCookie sessionIdCookie() {
        SimpleCookie cookie = new SimpleCookie();
        //cookie 有效时间
        cookie.setMaxAge(600000);
        cookie.setHttpOnly(true);
        cookie.setName("wxj");
        return cookie;
    }

    @Bean
    public CookieRememberMeManager rememberMeManager() {
        CookieRememberMeManager meManager = new CookieRememberMeManager();
        meManager.setCipherKey(Base64.decode("4AvVhmFLUs0KTA3Kprsdag=="));

        meManager.setCookie(sessionIdCookie());
        return meManager;
    }

}
