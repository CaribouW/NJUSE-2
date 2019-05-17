<template>
  <user>
    <div class="basicinfo">
      <div class="main_portrait">  
        <img src="@/assets/images/homepage/personal-image.png" alt="" style="width:140px;height:140px;">
      </div>
      <div class="main_id">
        <b>啊我前端好菜 </b><br/>
        ID:12345678
      </div>
      <div class="main_other">
        <span>
          <img src="@/assets/images/header/fullsizerender(4).png" alt="" style="width:22px;height:31px;">
          VIP 1
        </span><br/>
        <span>
          <img src="@/assets/images/basicinfo/nan.png" alt="" style="width:21px;height:21px;">
          生日：2019-01-01
        </span><br/>
        <el-button round style="color:#CFF9FE;">修改信息</el-button>
      </div>
    </div>
  </user>
</template>

<script>
import user from "../index.vue"
export default {
  name: 'basicInfo',
  components: {
    user,
  },
  data () {
    return {
      tabPosition: 'left'
    }
  },
  methods: {
  }
}
</script>


<style lang="scss">
.basicinfo{
  padding: 29px 50px 50px 50px;
  &_rectangle{
    background: url('../../../assets/images/homepage/Assets.png') no-repeat;
    background-size: 100% 100%;
    height: 790px;
    margin-bottom: 50px ;
  }  
  .el-aside {
    background-color: #131C1C;
    color: #FFFFFF;
    // text-align: center;
    height: 565px;
  }
  
  .el-main {
    background-color: rgba($color: #131C1C, $alpha: 0.5);
    color: #FFFFFF;
    height: 565px;
  }
  .main_portrait{
    height: 140px;
    padding-top: 70px;
  }
  .main_id{
    background-color:rgba($color: #D8D8D8, $alpha: 0.05);
    padding: 22px;
    margin-top: 28px;
    text-align: center
  }
  .main_id>b{
    font-size: 30px;
    
  }
  .main_other{
    margin-top: 10px
  }
  .el-button{
    margin-top: 20px;
    border-radius: 25px;
    padding: 8px 65px;
    background-color: rgba($color: #131C1C, $alpha: 0.5);
    font-size: 20px;
    color: #CFF9FE;
    border-color: #CFF9FE
  }
}
</style>

