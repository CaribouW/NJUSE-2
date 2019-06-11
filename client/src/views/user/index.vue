<template>
  <div class="basicinfo">
    <div class="basicinfo_rectangle">
      <el-container>
        <el-aside width="260px">
          <el-row class="tac">
            <el-col :span="24">
              <el-menu
                default-active="/user"
                class="el-menu-vertical-demo"
                @open="handleOpen"
                @close="handleClose"
                background-color="#131c1c"
                text-color="#fff"
                active-text-color="#ffd04b"
                :router="true"
              >
                <el-menu-item index="/user">
                  <i class="user_menu">
                  </i>
                  <span>基本信息</span>
                </el-menu-item>
                <el-submenu>
                  <template slot="title" style="padding-left:5px;">
                    <i class="user_coupon"></i>
                    <span>相关优惠</span>
                  </template>
                  <el-menu-item-group>
                    <el-menu-item index="/user/coupon">会员优惠券</el-menu-item>
                    <el-menu-item index="/user/coupon">普通优惠券</el-menu-item>
                  </el-menu-item-group>
                </el-submenu>
                <el-menu-item index="/user/history">
                  <i class="user_history"></i>
                  <span slot="title">历史订单</span>
                </el-menu-item>
                <el-menu-item index="/user/favor">
                  <i class="user_favor"></i>
                  <span slot="title">标记喜爱</span>
                </el-menu-item>
                <el-submenu index="5">
                  <template slot="title">
                    <i class="user_helper"></i>
                    <span>帮助中心 </span>
                  </template>
                  <el-menu-item-group>
                    <el-menu-item index="/user/helper/preferentialpolicy">
                      优惠政策
                    </el-menu-item>
                    <el-menu-item index="/user/helper/notice">
                      观影须知
                    </el-menu-item>
                    <el-menu-item index="/user/helper/contact">联系我们</el-menu-item>
                  </el-menu-item-group>
                </el-submenu>
              </el-menu>
            </el-col>
          </el-row>
        </el-aside>
        <el-main>
          <router-view/>
        </el-main>
      </el-container>
    </div>
  </div>
</template>

<script>
  export default {
    data() {
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
  .basicinfo {
    padding: 29px 50px 50px 50px;

    &_rectangle {
      background: url('../../assets/images/homepage/Assets.png') no-repeat;
      background-size: 100% 100%;
      height: 790px;
      margin-bottom: 50px;
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

