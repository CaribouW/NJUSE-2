<template>
  <div class="header">
    <div class="header_left">
      <img src="@/assets/images/header/矩形.png" alt="" @click="goHomepage()">
      <ul class="homepageNav" v-if="roleName==='gust' || roleName==='audience'">
          <li v-for="items in userNavList" :class="{selected:items.isActive}" @click="activeFun(items)">
                  {{items.text}}
          </li>
      </ul>
      <ul class="homepageNav" v-else-if="roleName==='manager'">
          <li v-for="items in managerNavList" :class="{selected:items.isActive}" @click="activeFun(items)">
                  {{items.text}}
          </li>
      </ul>
      <ul class="homepageNav" v-else>
          <li v-for="items in adminNavList" :class="{selected:items.isActive}" @click="activeFun(items)">
                  {{items.text}}
          </li>
      </ul>
    </div>
    <div class="header_right">
      <el-input
        class="el-input"
        placeholder="Search"
        v-model="keyword"
        resize="true"
        @keyup.enter.native="search()"
      >
        <i slot="prefix" class="el-input__icon el-icon-search" @click="search()"></i>
      </el-input>
      <div class="logined" v-if="logined">
        <img src="@/assets/images/header/fullsizerender(4).png" alt="" @click="goVIP(id)">
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
  </div>
</template>


<script>
import $ from 'jquery'
import mock from '@/mock/mock.js'
export default {
  data () {
    return {
      roleName: 'gust',
      id: '',
      VIP: false,
      keyword: '',
      // 登陆or未登录
      logined: true,
      showDropdown: false,
      managerNavList: [
        {text: '首页', isActive: true, index: 'index'},
        {text: '影库', isActive: false, index: 'movielist'},
        {text: '经理入口', isActive: false, index: 'manager'},
      ],
      adminNavList: [
        {text: '首页', isActive: true, index: 'index'},
        {text: '影库', isActive: false, index: 'movielist'},
        {text: '管理员入口', isActive: false, index: 'admin'},
      ],
      userNavList: [
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
    goVIP(id) {
      if (this.VIP) {
        this.$router.push({
          path: '/VIP/VIPInfo',
          query: {
            id: '1'
            // id: id
          }
        })
      } else {
        this.$router.push({
          path: '/VIP/buyCard',
          query: {
            id: '1'
            // id: id
          }
        })
      }
    },
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
      $(".homepageNav li:first").click()
    },
    // 导航栏切换
    activeFun: function(data){
      this.$router.push('/' +data.index)
      if (this.roleName === 'admin') {
        console.log(this.roleName)
        this.adminNavList.forEach(function(obj){
            obj.isActive = false;
        });
        data.isActive = !data.isActive;
      } else if (this.roleName === 'manager'){
        this.managerNavList.forEach(function(obj){
            obj.isActive = false;
        });
        data.isActive = !data.isActive;
      } else {
        this.userNavList.forEach(function(obj){
            obj.isActive = false;
        });
        data.isActive = !data.isActive;
      }
    },
    clickDropdown: function (data) {
      this.showDropdown = !this.showDropdown
      if (data.index === 'logout') {
        this.logout()
      } else {
        this.navList.forEach(function(obj){
            obj.isActive = false;
        });
        this.$router.push('/' + data.index)
      }
    },
    // 登出
    logout () {
      var _this = this

      _this.$store.dispatch('userLogout' ,{
        userId: sessionStorage.getItem('userId'),
      }).then(res => {
        this.$message.success('已退出登录')
        sessionStorage.removeItem('roleName')
        sessionStorage.removeItem('account')
        sessionStorage.removeItem('userId')
        this.logined = !this.logined
      })
      // this.$axios.post('http://localhost:3000/user/Logout').then(res => {
      //   if (res.data.status === 200) {
      //     this.$message.success('已退出登录')
      //     sessionStorage.removeItem('id')
      //     sessionStorage.removeItem('role')
      //     this.logined = !this.logined
      //   } else {
      //     this.navList.forEach(function (obj) {
      //       obj.isActive = false;
      //     });
      //     this.$router.push('/' + data.index)
      //   }
      // }).catch(err => {
      //   this.$message.error('出错啦，请稍后再试')
      // })
      // this.$axios.post(_this.GLOBAL.server + '/user/login',{
      //   account: localStorage.getItem('id')
      // }).then(res => {
      //   // this.$router.push('login')
      //   if (res.data.status === 200) {
      //     this.$message.success('已退出登录')
      //     localStorage.removeItem('roleName')
      //     localStorage.removeItem('account')
      //     localStorage.removeItem('id')
      //     this.logined = !this.logined
      //   } else {
      //     this.$message.error('出错了，请稍后再试')
      //   }
      // }).catch(err => {
      //   this.$message.error('出错啦，请稍后再试')
      // })
      this.$router.push('/index')
    },
    search () {
      this.$router.push('/search')
    }
  },
  // 保证header在登录注册时不会显示
  created: function () {
    if (sessionStorage.getItem('roleName') === 'audience') {
      this.logined = true
      this.roleName = 'audience'
    } else if (sessionStorage.getItem('roleName') === 'admin') {
      this.logined = true
      this.roleName = 'admin'
    } else if (sessionStorage.getItem('roleName') === 'engineer') {
      this.logined = true
      this.roleName = 'engineer'
    } else {
      this.logined = false
      this.roleName = 'gust'
    }
    console.log(this.roleName)
  }
}
</script>


<style lang="scss">
  .selected {
    font-weight: bold;
    color: white
  }

  .header {
    // background-color: #201f1d;
    // background-color: red;
    height: 70px;
    display: block;
    padding: 50px 20px 0 20px;
    display: flex;
    position: relative;

    &_left {
      text-align: initial;
      flex: 1 0 auto;
      display: flex;
      align-items: baseline;
      font-size: 22px;

      > img {
        cursor: pointer;
        margin-right: 40px;
      }

      li {
        display: inline-block;
        color: #CFF9FE;
        margin-left: 40px;
        cursor: pointer;
      }
    }

    &_right {
      flex: 0 1 auto;
      display: flex;
      align-items: flex-end;

      .el-input {
        transition: width 2s;
        -moz-transition: width 2s; /* Firefox 4 */
        -webkit-transition: width 2s; /* Safari and Chrome */
        -o-transition: width 2s; /* Opera */
        :hover {
        }
      }

      > div:first-of-type {
        width: 350px;
        margin-right: 60px;
        border-radius: 10px;

        > input {
          background-color: #2E2D2C;
          border: none
        }

        .el-icon-search {
          cursor: pointer;
        }
      }

      .logined {
        > img:first-of-type {
          // display: inline-block;
          cursor: pointer;
          margin-right: 20px;
        }

        > img:last-of-type {
          height: 50px;
          cursor: pointer;
        }
      }

      > div:last-of-type {
        > div {
          display: flex;
          align-items: center;
          font-size: 20px;
          // margin-bottom: 20px;
          cursor: pointer;

          > span {
            margin-left: 10px;
            color: #CFF9FE;
          }
        }

        > div:first-of-type {
          margin-bottom: 20px;
        }
      }
    }

    &_dropdown {
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

      > ul > li {
        line-height: 51.5px;
        color: #CFF9FE;
        cursor: pointer;

        .el-badge__content {
          color: #201f1d;
          background-color: white;
          border: #CFF9FE solid 1px;
        }
      }

      > ul > li:hover {
        background-color: #EAEAEA;
        color: #666;
        font-weight: bold;
      }

      > ul > li:first-of-type {
        border-top-left-radius: 15px;
        border-top-right-radius: 15px;
      }

      > ul > li:last-of-type {
        border-bottom-left-radius: 15px;
        border-bottom-right-radius: 15px;
      }
    }
  }
</style>
