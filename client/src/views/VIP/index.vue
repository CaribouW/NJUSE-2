<template>
  <div class="VIP">
      <el-container>
        <el-aside width="260px">
          <el-row class="tac">
            <el-col :span="24">
              <el-menu
                default-active="/VIP/buyCard"
                :router="true"
                class="vip_menu"
                @open="handleOpen"
                @close="handleClose"
                background-color="#131c1c"
                text-color="#fff"
                active-text-color="#ffd04b">
                <el-menu-item index="/VIP/buyCard">
                  <i class="vip_buyCard"></i>
                  <span slot="title">会员注册</span>
                </el-menu-item>
                 <!-- <el-menu-item index="/user/history">
                  <i class="user_history"></i>
                  <span slot="title">历史订单</span>
                </el-menu-item> -->
                <el-menu-item index="/VIP/VIPrights" style="margin:10px;">
                  <i class="VIPrights"></i>
                  <span slot="title">会员权益</span>
                </el-menu-item>
              </el-menu>
            </el-col>
          </el-row>
        </el-aside>
        <el-main>
          <router-view/>
        </el-main>
      </el-container>
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
      handleClose(key, keyPath) {
        console.log(key, keyPath);
      },
    }
  }
</script>


<style lang="scss">
  .VIP{
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
    .el-container {
      margin-bottom: 20px;
      padding: 100px 100px 20px 120px

    }
    .el-main {
      background-color: rgba($color: #131C1C, $alpha: 0.5);
      color: #FFFFFF;
      // height: 565px;
    }
  }
</style>

