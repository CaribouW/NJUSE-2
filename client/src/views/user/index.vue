<template>
  <div class="basicinfo">
    <div class="basicinfo_rectangle">
      <el-container>
      <el-aside width="260px">
        <el-row class="tac">
          <el-col :span="12">
            <el-menu
              default-active="2"
              class="el-menu-vertical-demo"
              @open="handleOpen"
              @close="handleClose"
              background-color="#131c1c"
              text-color="#fff"
              active-text-color="#ffd04b">
              <el-menu-item index="1">
                  <i class="el-icon-location"></i>
                  <span>基本信息</span>
              </el-menu-item>
              <el-submenu index="2">
                <template slot="title">
                  <i class="el-icon-location"></i>
                  <span>优惠券</span>
                </template>
                <el-menu-item-group>
                  <el-menu-item index="1-1">会员优惠券</el-menu-item>
                  <el-menu-item index="1-2">普通优惠券</el-menu-item>
                </el-menu-item-group>
              </el-submenu>
              <el-menu-item index="3">
                <i class="el-icon-document"></i>
                <span slot="title">历史订单</span>
              </el-menu-item>
              <el-menu-item index="4">
                <i class="el-icon-setting"></i>
                <span slot="title">标记喜爱</span>
              </el-menu-item>
              <el-submenu index="5">
                <template slot="title">
                  <i class="el-icon-location"></i>
                  <span>帮助中心</span>
                </template>
                <el-menu-item-group>
                  <el-menu-item index="1-1">优惠政策</el-menu-item>
                  <el-menu-item index="1-2">观影须知</el-menu-item>
                  <el-menu-item index="1-3">常见问题</el-menu-item>
                  <el-menu-item index="1-4">联系我们</el-menu-item>
                  <el-menu-item index="1-5">投诉建议</el-menu-item>
                </el-menu-item-group>
              </el-submenu>
            </el-menu>
          </el-col>
        </el-row>
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
    handleOpen(key, keyPath) {
        console.log(key, keyPath);
    },
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

