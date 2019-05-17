<template>
  <div class="basicinfo">
    <div class="basicinfo_rectangle">
      <el-container>
      <el-aside width="260px">
        <el-tabs :tab-position="tabPosition" style="height: 200px;">
          <el-tab-pane label="用户管理"></el-tab-pane>
          <el-tab-pane label="配置管理"></el-tab-pane>
          <el-tab-pane label="角色管理"></el-tab-pane>
          <el-tab-pane label="定时任务补偿"></el-tab-pane>
        </el-tabs>
      </el-aside>
      <el-main>
        <slot></slot>
      </el-main>
    </el-container>
    </div>
  </div>
</template>

<script>
export default {
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
    background: url('../../assets/images/homepage/Assets.png') no-repeat;
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
  .el-container {
    margin-bottom: 20px;
    padding: 100px 140px 20px 140px
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
  }
}
</style>

