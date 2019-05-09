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
          <input type="text" placeholder="请输入绑定的手机号"><br>
          <input type="password" placeholder="请输入密码"><br>
          <div>
            <input type="checkbox"><span>一周之内自动登录</span>
          </div>
          <button @click="login()">登录 </button>
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
    login() {
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
  color: #CFF9FE;
  &_content{
    width: fit-content;
    height: 402px;
    top: 0; left: 0; bottom: 0; right: 0; 
    margin: auto;
    font-size: 0px;
    position:absolute;  
    &_left{
      box-sizing: border-box;
      width: 261px;
      height: 402px;
      display: inline-block;
      vertical-align: top;
      background: url(../../assets/images/Login/QQ20190331-123453@2x.png) no-repeat center #132D36;
      >div{
        font: 36px/1.5 Arial bold;
        >span{
          color: #CFF9FE;
        }
      }
      >img{
        position: relative;
        top: 255px;
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
      >div{
        // width: fit-content;
        // margin-left: 55px;
        margin-bottom: 65px;
        >span{
          color: #CFF1F5;
          font-Size:16px;
          vertical-align:middle;
          margin-left: 20px;
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
