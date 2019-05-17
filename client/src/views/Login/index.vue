<template>
  <div class="login_body">
    <div class="login_body_content">
      <div class="login_body_content_motto"><img src="@/assets/images/Login/motto.png" alt=""></div>
      <div class="login_body_content_left">
        <img src="@/assets/images/Login/fullsizerender(11).png" alt="">
      </div>
      <div class="login_body_content_right">
          <input type="text" placeholder="请输入账号"><br>
          <input type="password" placeholder="请输入密码"><br>
          <div>
            <input type="checkbox"><span>一周之内自动登录</span>
          </div>
          <button @click="login()">登录 </button>
          <div>
            <span>没有账号？</span><span @click="goToRegister()">点击注册</span>
          </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  data () {
    return {

    }
  },
  methods: {
    login() {
      // this.$message.error('别试了，接口还没写呢！');
      // console.log('fsf')
      // 测试axios + mock
      var _this = this
      console.log(_this.GLOBAL.server+'/user/login')
      
      this.$axios.post(_this.GLOBAL.server + '/user/login',{
        'account':123,
        'password':123456
      }).then(res => {
        console.log(res)
        localStorage.setItem('account', this.account)
        localStorage.setItem('roleId', res.data.role)
        this.$router.push('/')
      }).catch(err => {
        console.log(err);
      })
    },
    goToRegister() {
      this.$router.push('/register')
    }
  }
}
</script>

<style lang="scss">
.login_body{
  width: 100%;
  height: 100vh;
  background-color: rgba(32, 31, 29, 1);
  position: relative;
  color: #CFF9FE;
  &_content{
    width: fit-content;
    // height: 402px;
    top: 0; left: 0; bottom: 0; right: 0; 
    margin: auto;
    font-size: 0px;
    position:absolute;
    &_motto{
      position: relative;
      width: 330px;
      top: 135px;
      left: -10px;
    }
    &_left{
      box-sizing: border-box;
      width: 261px;
      height: 402px;
      display: inline-block;
      vertical-align: top;
      background: url(../../assets/images/Login/QQ20190331-123453@2x.png) no-repeat center #132D36;
      >img{
        position: relative;
        top: 364px;
        right: 60px;
      }
    }&_right
    {
      box-sizing: border-box;
      width: 434px;
      height: 402px;
      display: inline-block;
      background-color: #161D1D;
      vertical-align: top;
      padding-top: 50px;
      >input:nth-of-type(-n+2){
        box-sizing: border-box;
        font-size: 18px;
        width: 340px;
        height: 50px;
        margin-bottom: 40px;
        border-radius: 10px;
        background-color: #E9E9E8;
        padding: 0 20px;
        color: #192C35;
      }
      input[type='checkbox']{
        width: 20px;
        height: 20px;
        appearance: none;
        -webkit-appearance: none;
        outline: none;
        border: 2px solid #CFF1F5;
        border-radius: 2px;
        cursor: pointer;
        vertical-align: middle;
      }
      input[type='checkbox']:checked{
        background: url(../../assets/images/Login/checkbox.png) no-repeat center;
      }
      >div:first-of-type{
        // width: fit-content;
        // margin-left: 55px;
        margin-bottom: 30px;
        >span{
          color: #CFF1F5;
          font-Size:16px;
          vertical-align:middle;
          margin-left: 20px;
        }
      }
      >div:last-of-type{
        margin-top: 10px;
        font-size: 16px;
        color: #ABA5A5;
        >span:last-of-type{
          color:#CFF9FE;
          cursor: pointer;
        }
      }
      ::-webkit-input-placeholder { /* WebKit browsers */ 
color: #192C35; 
} 
:-moz-placeholder { /* Mozilla Firefox 4 to 18 */ 
color: #192C35; 
} 
::-moz-placeholder { /* Mozilla Firefox 19+ */ 
color: #192C35; 
} 
:-ms-input-placeholder { /* Internet Explorer 10+ */ 
color: #192C35; 
} 
      >button{
        font-size:28px;
        padding:5px 40px;
        border: 2px solid #CFF9FE;
        border-radius: 50px;
        background-color: #132D36;
        color: #CFF9FE;
        box-sizing: content-box;
        font-weight: bold;
        cursor: pointer;
      }
      >button:hover {
    box-shadow: 0 12px 16px 0 rgba(0,0,0,0.24), 0 17px 50px 0 rgba(0,0,0,0.19);
}
    }
  }
}
</style>
