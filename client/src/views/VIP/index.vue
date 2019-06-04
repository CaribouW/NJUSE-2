<template>
  <div class="VIP">
      <el-container>
        <el-aside width="260px">
          <el-row class="tac">
            <el-col :span="24">
              <el-menu
                default-active="1"
                class="vip_menu"
                @open="handleOpen"
                @close="handleClose"
                background-color="#131c1c"
                text-color="#fff"
                active-text-color="#ffd04b">
                <el-menu-item index="1" @click="goBuyCard()">
                  <i class="vip_buyCard"></i>
                  <span>会员注册</span>
                </el-menu-item>
                <el-menu-item index="2" @click="goVIPrights()">
                  <i class="VIPrights"></i>
                  <span >会员权益</span>
                </el-menu-item>
              </el-menu>
            </el-col>
          </el-row>
        </el-aside>
        <el-main>
          <slot></slot>
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
      goBuyCard() {
        this.$router.push("/VIP/buyCard")
      },
      goVIPrights() {
        this.$router.push("/VIP/VIPrights")
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

