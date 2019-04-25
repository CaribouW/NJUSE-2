<template>
  <div class="login_body">
    <div class="login_body_content">
      <div class="login_body_content_left">
        <div class="login_body_content_left_word">
          <span>COME&</span><br><span>JOIN US</span>
        </div>
        <img src="@/assets/images/Login/fullsizerender(11).png" alt="">
      </div>
      <div class="login_body_content_right">
          <input type="text" placeholder="请输入账号"><br>
          <input type="password" placeholder="请输入密码"><br>
          <input type="password" placeholder="请再次输入密码"><br>
          <button @click="rigister()">注册</button>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  data () {
    return {
      ruleForm: []
    }
  },
  methods: {
    rigister() {
      this.$message.error('别试了，接口还没写呢！');
    }
  }
}
</script>


<style lang="scss">
.login_body{
  width: 100%;
  height: 100%;
  background-color: rgba(32, 31, 29, 1);
  position: relative;
  &_content{
    width: 940px;
    height: 560px;
    top: 0; left: 0; bottom: 0; right: 0; 
    margin: auto;
    font-size: 0px;
    position:absolute;  
    &_left{
      box-sizing: border-box;
      width: 390px;
      height: 560px;
      display: inline-block;
      vertical-align: top;
      background: url(../../assets/images/Login/QQ20190331-123453@2x.png) no-repeat center #132D36;
      >div{
        font: 48px/1.5 Arial;
        >span{
          color: #CFF1F5;
        }
      }
      >img{
        position: relative;
        top: 360px;
        right: 88px;
      }
    }&_right
    {
      box-sizing: border-box;
      width: 550px;
      height: 560px;
      display: inline-block;
      background-color: #161D1D;
      vertical-align: top;
      padding-top: 80px;
      >input{
        box-sizing: border-box;
        font-size: 26px;
        width: 439px;
        height: 70px;
        margin-bottom: 40px;
        border-radius: 5px;
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
        font-size:40px;
        padding:14.6px 68px;
        border: 1px solid #CFF1F5;
        border-radius: 50px;
        background-color: #132D36;
        color: #CFF1F5;
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
