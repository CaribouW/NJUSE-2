package com.example.main.repository;


import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

/**
 * {@code BaseRepository} 接口实现
 * @param <T> {@code BaseEntity} 子类
 */
public class BaseRepositoryImpl<T> extends SimpleJpaRepository<T, String> implements BaseRepository<T>
{
    /**
     * 实体类的Class
     */
    private final Class<T> domainClass;

    /**
     * 实体类管理器EntityManager
     */
    private final EntityManager entityManager;

    /**
     * 自定义构造函数
     * @param domainClass 实体类的Class
     * @param entityManager 实体类管理器
     */
    public BaseRepositoryImpl(Class<T> domainClass, EntityManager entityManager)
    {
        super(domainClass, entityManager);
        this.domainClass = domainClass;
        this.entityManager = entityManager;
    }

    /**
     * 是否互相支持
     * @param modelType 模式类型
     * @return 是否支持
     */
    @Override
    public boolean support(String modelType)
    {
        return domainClass.getName().equals(modelType);
    }

    public EntityManager getEntityManager()
    {
        return this.entityManager;
    }

    /**
     * 执行Sql语句
     * @param sql 符合语法的sql语句
     * @param paramsMap 参数表
     * @param <U> 返回列表所包含的对象类型
     * @return 返回所查询的对象列表
     */
    @SuppressWarnings("unchecked")
    @Override
    public <U> List<U> executeSql(String sql, HashMap<String, Object> paramsMap)
    {
        Query query = this.entityManager.createNativeQuery(sql);
        setParams(query, paramsMap);

        return query.getResultList();
    }

    /**
     * 执行Sql语句
     * @param sql 符合语法的sql语句
     * @return 执行是否成功
     */

    @Override
    public int executeSql(String sql)
    {
        Query query = this.entityManager.createNativeQuery(sql);
        return query.executeUpdate();
    }

    /**
     * 执行Hql语句
     * @param hql 符合语法的hql语句
     * @param paramsMap 参数列表
     * @return 返回产讯的对象列表
     */
    @SuppressWarnings("unchecked")
    @Override
    public List<T> executeHql(String hql, HashMap<String, Object> paramsMap)
    {
        Query query = this.entityManager.createQuery(hql);
        setParams(query, paramsMap);

        return query.getResultList();
    }


    /**
     * 执行Hql语句
     * @param hql 符合语法的hql语句
     * @param paramsMap 参数列表
     * @param <U> 返回列表所包含的对象类型
     * @return 返回所查询的对象列表
     */
    @SuppressWarnings("unchecked")
    @Override
    public <U> List<U> executeHqlIndicatingType(String hql, HashMap<String, Object> paramsMap)
    {
        Query query = this.entityManager.createQuery(hql);

        if(paramsMap != null)
        {
            Iterator <Entry <String, Object>> iter = paramsMap.entrySet().iterator();
            while(iter.hasNext())
            {
                Entry <String, Object> entry = iter.next();

                String paramName = entry.getKey();
                Object paramValue = entry.getValue();

                query.setParameter(paramName, paramValue);
            }
        }

        return query.getResultList();
    }

    /**
     * 给query设置参数
     * @param query 目标query语句
     * @param paramsMap 参数列表
     */
    private void setParams(Query query, HashMap<String, Object> paramsMap)
    {
        if(paramsMap != null)
        {
            Iterator<Entry <String, Object>> iter = paramsMap.entrySet().iterator();
            while(iter.hasNext())
            {
                Entry <String, Object> entry = iter.next();

                String paramName = entry.getKey();
                Object paramValue = entry.getValue();

                query.setParameter(paramName, paramValue);
            }
        }
    }


    /**
     * 获取sql查询结果的行数
     * @param sql sql语句
     * @return 行数
     */
    private String genCountSql(String sql)
    {
        String regex = "\\s*SELECT\\s+[^\\s]+";

        if(sql.matches(regex))
        {
            String countSql = sql.replaceFirst(regex, "SELECT COUNT(1)");
            return countSql;
        }
        else
        {
            String countSql = "SELECT COUNT(1) " + sql;
            return countSql;
        }
    }
}

