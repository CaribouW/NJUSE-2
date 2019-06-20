<template>
  <div class="register_body">
    <div class="register_body_content">
      <div class="register_body_content_motto"><img src="@/assets/images/Login/motto.png" alt=""></div>
      <div class="register_body_content_left">
        <img src="@/assets/images/Login/fullsizerender(11).png" alt="">
      </div>
      <div class="register_body_content_right">
          <input type="text" placeholder="请输入账号" v-model="account"><br>
          <input type="password" placeholder="请输入密码" v-model="password_again"><br>
          <input type="password" placeholder="请再次输入密码" v-model="password"><br>
          <button @click="rigister()">注册</button>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  data () {
    return {
      account: '',
      password_again: '',
      password: ''
    }
  },
  methods: {
    rigister() {
      if (this.password != this.password_again) {
        this.$message.error('两次输入的密码不一致')
        // console(this.password+' '+this.passowrd_again)
      } else {
        this.$store.dispatch('userSignUp', {
          account:this.account,
          password:this.password
        })
        .then(res => {
        console.log('register',res)
      });
      }
      
    }
  }
}
</script>


<style lang="scss">
.register_body{
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
      >input{
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
