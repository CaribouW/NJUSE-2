<template>
  <div id="app">
    <div class="background">
      <div class="main_content">
        <div class="header" v-if="header_show">
          <div class="header_left">
            <img src="@/assets/images/header/矩形.png" alt="" @click="goHomepage()">
            <ul id="test">
                <li v-for="items in navList" :class="{selected:items.isActive}" @click="activeFun(items)">
                        {{items.text}}
                </li>
            </ul>
          </div>
          <div class="header_right">
            <el-input
              placeholder="Search"
              prefix-icon="el-icon-search"
              v-model="search">
            </el-input>
            <div class="logined" v-if="logined">
              <img src="@/assets/images/header/fullsizerender(4).png" alt="">
              <img src="@/assets/images/header/personal-image.png" alt="" @click="showDropdown = !showDropdown">
            </div>
            <div v-else>
              <div @click="goLogin()">
                <img src="@/assets/images/header/denglu.png" alt=""><span>登录</span> 
              </div>
              <div @click="goRegister()">
                <img src="@/assets/images/header/zhuce.png" alt=""><span>注册</span> 
              </div>
            </div>
          </div>
          <!-- 头像下拉框 -->
          <div class="header_dropdown" v-if="showDropdown">
            <ul>
              <li v-for="items in userCenterList" :key="items.route" @click="clickDropdown(items)">{{items.text}}<el-badge class="mark" :value="12" v-if="items.index==='message'"/></li>
              
            </ul>
          </div>
        </div>
        <router-view/>
        <foot v-if="header_show"></foot>
      </div>
    </div>
  </div>
</template>

<script>
import mock from '@/mock/mock.js'
import $ from 'jquery'
import foot from '@/components/footer.vue'
export default {
  name: 'App',
  components: {
    foot
  },
  data () {
    return {
      search: '',
      // 是否显示header,footer
      header_show: true,
      // 登陆or未登录
      logined: true,
      showDropdown: false,
      navList: [
        {text: '首页', isActive: true, index: 'index'},
        {text: '影库', isActive: false, index: 'movielist'},
        {text: '快速购票', isActive: false, index: 'quick'},
      ],
      userCenterList: [
        {text: '个人中心',index: 'user'},
        {text: '消息', index: 'message'},
        {text: '退出登陆', index: 'logout'},
      ]
    }
  },
  methods: {
    goLogin() {
      this.$router.push("/login")
    },
    goRegister() {
      this.$router.push("/register")
    },
    goPersonalCenter_basicInfo(){
      this.$router.push("/basicInfo")
    },
    goHomepage() {
      $("#test li:first").click()
    },
    // 导航栏切换
    activeFun: function(data){
      this.$router.push(data.index)
        this.navList.forEach(function(obj){
            obj.isActive = false;
        });
        data.isActive = !data.isActive;
    },
    clickDropdown: function (data) {
      this.showDropdown = !this.showDropdown
      if (data.index === 'logout') {
        this.logout()
      } else {
        this.navList.forEach(function(obj){
            obj.isActive = false;
        });
        this.$router.push(data.index)
      }
    },
    // 切换到登录时不显示header
    hideHeader () {
      var path = this.$route.path.split('/')[1]
      if (path === "login" || path === "register") {
        this.header_show = false
      } else {
        this.header_show = true
      }
    },
    // 登出
    logout () {
      this.$axios.post('http://localhost:3000/user/Logout',{
        account: '123456'
      }).then(res => {
        // this.$router.push('login')
        console.log(res)
        this.logined = !this.logined
        localStorage.setItem('roleId', '0')
      }).catch(err => {
        this.$message.error('出错啦，请稍后再试')
      })
      this.$router.push('/index')
    }
  },
  // 保证header在登录注册时不会显示
  created: function () {
    this.hideHeader()
    console.log(localStorage.getItem('roleId'))
    if (localStorage.getItem('roleId') !== '0') {
      this.logined = true
    } else {
      this.logined = false
    }
  },
  watch: {
    $route (to, from) {
      this.hideHeader()
      if (localStorage.getItem('roleId') !== '0') {
        this.logined = true
      } else {
        this.logined = false
      }
    }
  }
}
</script>

<style lang="scss">
/* CSS Document */
/* 基本css格式，清除浏览器默认配置 */
* { //color:#EAEAEA; 
}
body, html { height: 100%;}
body { font:16px/1.5 "微软雅黑",Arial,Tahoma, Helvetica,\5b8b\4f53, sans-serif}
html,body,div,h1,h2,h3,h4,h5,h6,hr,p,blockquote,dl,dt,dd,ul,ol,li,pre,form,fieldset,object,code,em,span,var,legend,button,input,textarea,th,td,a,img,header,footer,nav,aside,audio,datalist,section { margin:0;padding:0;border:0;outline:0; }/*清除内外边距*/
h1,h2,h3,h4,h5,h6 { font-weight:normal;font-size:100%; }/*设置默认字体*/
:focus { outline:0; }
ul,ol,ul li,ol li { list-style: none; }/*重置列表*/
address,caption,cite,em,code,dfn,th,var { font-style:normal;font-weight:normal; }
form label { cursor:pointer; }
textarea { resize:none }
input { vertical-align:middle; }
img { border:0; }/*重置图片元素*/
table { border-collapse:collapse;border-spacing: 0; }/*重置表格*/
/* .l { float:left; }
.r { float:right; } */
a { text-decoration:none;}
a { color:#666;}
a:hover { text-decoration:underline; }

#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  height: 100%;
  font-size: 18px;
}
.background{
  background-color: black;
  min-height: 100vh;
  .main_content{
    margin: 0 auto;
    background-color: #201f1d;
    min-height: inherit;
    width: 88%;
    min-width: 1300px;
  }
}
.selected{font-weight:bold;color:white}
.header{
  // background-color: #201f1d;
  // background-color: red;
  height: 70px;
  padding: 50px 20px 0 20px;
  display: flex;
  position: relative;
  &_left{
    text-align: initial;
    flex: 1 0 auto;
    display: flex;
    align-items:baseline;
    font-size: 28px;
    >img{
      cursor: pointer;
      margin-right: 40px;
    }
    li{
      display: inline-block;
      color: #CFF9FE;
      margin-left: 40px;
      cursor: pointer;
    }
  }
  &_right{
    flex:0 1 auto;
    display: flex;
    align-items:flex-end;
    >div:first-of-type{
      width: 350px;
      margin-right: 60px;
      border-radius: 10px;
      >input{background-color: #2E2D2C;border: none}
    }
    .logined{
      >img:first-of-type{
        // display: inline-block;
        cursor: pointer;
        margin-right: 20px;
      }
      >img:last-of-type{
        height: 50px;
        cursor: pointer;
      }
    }
    >div:last-of-type{
      >div{
        display: flex;
        align-items: center;
        font-size: 20px;
        // margin-bottom: 20px;
        cursor: pointer;
        >span{
          margin-left: 10px;
          color: #CFF9FE;
        }
      }
      >div:first-of-type{
        margin-bottom: 20px;
      }
    }
  }
  &_dropdown{
    z-index: 2;
    width: 138px;
    height: 156px;
    box-sizing: border-box;
    background-color: #201f1d;
    position: absolute;
    border: #CFF9FE solid 2px;
    border-radius: 15px;
    right: 30px;
    top: 118px;
    
    >ul >li{line-height: 51.5px; color: #CFF9FE;cursor: pointer;}
    >ul >li:hover{ background-color:#EAEAEA; color: #666; font-weight: bold;}
    >ul >li:first-of-type{border-top-left-radius: 15px; border-top-right-radius: 15px;}
    >ul >li:last-of-type{border-bottom-left-radius: 15px; border-bottom-right-radius: 15px;}
  }
}
</style>
