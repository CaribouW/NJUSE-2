<template>
  <div id="app">
    <div class="background">
      <div class="main_content">
        <!-- <div class="header" v-if="header_show">
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
          <div class="header_dropdown" v-if="showDropdown">
            <ul>
              <li v-for="items in userCenterList" :key="items.route" @click="clickDropdown(items)">{{items.text}}
                <el-badge class="mark" type='primary' :value="12" v-if="items.index==='message'"/>
              </li>
              
            </ul>
          </div>
        </div> -->
        <headnav v-if="header_show"></headnav>
        <router-view/>
        <foot v-if="header_show"></foot>

      </div>
    </div>
  </div>
</template>

<script>
  import mock from '@/mock/mock.js'
  import $ from 'jquery'
  import headnav from '@/components/header.vue'
  import foot from '@/components/footer.vue'

  export default {
    name: 'App',
    components: {
      headnav, foot
    },
    data() {
      return {
        // 是否显示header,footer
        header_show: true,
      }
    },
    methods: {
      // 切换到登录时不显示header
      hideHeader() {
        var path = this.$route.path.split('/')[1]
        if (path === "login" || path === "register") {
          this.header_show = false
        } else {
          this.header_show = true
        }
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
      $route(to, from) {
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

  body, html {
    height: 100%;
  }

  body {
    font: 16px/1.5 "微软雅黑", Arial, Tahoma, Helvetica, \5b8b\4f53, sans-serif
  }

  html, body, div, h1, h2, h3, h4, h5, h6, hr, p, blockquote, dl, dt, dd, ul, ol, li, pre, form, fieldset, object, code, em, span, var, legend, button, input, textarea, th, td, a, img, header, footer, nav, aside, audio, datalist, section {
    margin: 0;
    padding: 0;
    border: 0;
    outline: 0;
  }

  /*清除内外边距*/
  h1, h2, h3, h4, h5, h6 {
    font-weight: normal;
    font-size: 100%;
  }

  /*设置默认字体*/
  :focus {
    outline: 0;
  }

  ul, ol, ul li, ol li {
    list-style: none;
  }

  /*重置列表*/
  address, caption, cite, em, code, dfn, th, var {
    font-style: normal;
    font-weight: normal;
  }

  form label {
    cursor: pointer;
  }

  textarea {
    resize: none
  }

  input {
    vertical-align: middle;
  }

  img {
    border: 0;
  }

  /*重置图片元素*/
  table {
    border-collapse: collapse;
    border-spacing: 0;
  }

  /*重置表格*/
  /* .l { float:left; }
  .r { float:right; } */
  a {
    text-decoration: none;
  }

  a {
    color: #666;
  }

  a:hover {
    text-decoration: underline;
  }

  #app {
    font-family: 'Avenir', Helvetica, Arial, sans-serif;
    -webkit-font-smoothing: antialiased;
    -moz-osx-font-smoothing: grayscale;
    text-align: center;
    height: 100%;
    font-size: 18px;
  }

  .background {
    background-color: black;
    min-height: 100vh;

    .main_content {
      margin: 0 auto;
      background-color: #201f1d;
      min-height: inherit;
      width: 85%;
      min-width: 1300px;
    }
  }

</style>
