<template>
  <div id="app">
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
        <div class="searchBox">
          <i class="el-icon-search"></i>
          <input type="text" placeholder="Search">
        </div>
        <div class="logined" v-if="logined">
          <img src="@/assets/images/header/fullsizerender(4).png" alt="">
          <img src="@/assets/images/header/personal-image.png" alt="">
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
    </div>
    <router-view/>
  </div>
</template>

<script>
export default {
  name: 'App',
  data () {
    return {
      // 是否显示header
      header_show: true,
      // 登陆or未登录
      logined: false,
      navList: [
        {text: '首页', isActive: true, route: 'index'},
        {text: '影库', isActive: false, route: 'movielist'},
        {text: '快速购票', isActive: false, route: 'marchant'},
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
    goHomepage() {
      this.$router.push("/index")
    },
    // 导航栏切换
    activeFun: function(data){
      this.$router.push(data.route)
        this.navList.forEach(function(obj){
            obj.isActive = false;
        });
        data.isActive = !data.isActive;
    }
  },
  // 保证header在登录注册时不会显示
  created: function () {
    console.log("fdsf")
    var path = this.$route.path.split('/')[1]
    if (path === "login" || path === "register") {
      this.header_show = false
    } else {
      this.header_show = true
    }
  },
  watch: {
    $route (to, from) {
      var path = this.$route.path.split('/')[1]
      if (path === "login" || path === "register") {
        this.header_show = false
      } else {
        this.header_show = true
      }
    }
  }
}
</script>

<style lang="scss">
/* CSS Document */
/* 基本css格式，清除浏览器默认配置 */
* { color:#444; }
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
  font-size: 28px;
}
.selected{font-weight:bold;}
.header{
  background-color: #201f1d;
  // background-color: red;
  height: 60px;
  padding: 20px 20px 0 20px;
  display: flex;
  &_left{
    text-align: initial;
    flex: 1 1 auto;
    display: flex;
    align-items: center;
    >img{
      cursor: pointer;
    }
    li{
      display: inline-block;
      color: #CFF9FE;
      margin-left: 20px;
      cursor: pointer;
    }
  }
  &_right{
    flex:0 1 auto;
    display: flex;
    align-items: center;
    .searchBox{
      width: 344px;
      height: 36px;
      background-color: green;
      text-align: left;
      border-radius: 10px;
      margin-right: 60px;
      >el-icon-search{
        vertical-align: middle;
      }
      >input{
        // height: 15px;
        vertical-align: middle;
        font-size: 24px;
      }
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
        margin-bottom: 5px;
        cursor: pointer;
        >span{
          margin-left: 10px;
          color: #CFF9FE;
        }
      }
    }
  }
}
</style>
