<template>
  <div class="basicinfo">
    <div class="basicinfo_rectangle">
      <el-container>
      <el-aside width="260px">
        <el-row class="tac">
          <el-col :span="24">
            <el-menu
              default-active="2"
              class="el-menu-vertical-demo"
              @open="handleOpen"
              @close="handleClose"
              background-color="#131c1c"
              text-color="#fff"
              active-text-color="#ffd04b">
              <el-menu-item index="1" @click="goBasicInfo()">
                  <i class="el-icon-location"></i>
                  <span>基本信息</span>
              </el-menu-item>
              <el-submenu index="2">
                <template slot="title" style="padding-left:5px;">
                  <i class="el-icon-location"></i>
                  <span @click="goCoupon()">相关优惠</span>
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
              <el-menu-item index="4" @click="goFavor()">
                <i class="el-icon-setting"></i>
                <span slot="title" >标记喜爱</span>
              </el-menu-item>
              <el-submenu index="5">
                <template slot="title">
                  <i class="el-icon-location"></i>
                  <span @click="goPolicy()">帮助中心 </span>
                </template>
                <el-menu-item-group>
                  <el-menu-item index="1-1" @click="goPolicy()">优惠政策</el-menu-item>
                  <el-menu-item index="1-2" @click="goNotice()">观影须知</el-menu-item>
                  <el-menu-item index="1-3">常见问题</el-menu-item>
                  <el-menu-item index="1-4" @click="goContact()">联系我们</el-menu-item>
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
    handleClose(key, keyPath) {
        console.log(key, keyPath);
    },
    goBasicInfo() {
      this.$router.push("/user")
    },
    goCoupon() {
      this.$router.push("/user/coupon")
    },
    goFavor() {
      this.$router.push("/user/favor")
    },
    goPolicy() {
      this.$router.push("/user/helper/preferentialpolicy")
    },
    goNotice() {
      this.$router.push("/user/helper/notice")
    },
    goContact() {
      this.$router.push("/user/helper/contact")
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

