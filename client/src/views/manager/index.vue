<template>
  <div class="manager-main">
    <div class="_head_divider">
      <el-divider></el-divider>

    </div>
    <div id="_test" class="_main_content">
      <el-container>
        <el-aside width="250px" style="border:solid 1px #cff9fe;">
          <!-- 左边导航栏 -->
          <div class="_leftBar">
            <el-col :span="24">
              <img src="../../assets/images/footer/{5C52A913-CCB9-6A3B-A07F-40653AF2D82D}.png" alt="This is our logo!">
              <el-menu
                class="el-menu-vertical"
                @open.stop="handleOpen"
                background-color="#131c1c"
                text-color="#fff"
                active-text-color="#cff9fe"
                router>
                <el-menu-item index="/manager/hallManage">
                  <i class="el-icon-menu"></i>
                  <span slot="title">影厅信息</span>
                </el-menu-item>
                <el-menu-item index="/manager/refundManage">
                  <i class="el-icon-menu"></i>
                  <span slot="title">退票策略</span>
                </el-menu-item>
                <el-menu-item index="/manager/movieRoleManage">
                  <i class="el-icon-setting"></i>
                  <span slot="title">影院角色</span>
                </el-menu-item>
                <el-menu-item index="/manager/vipManage">
                  <i class="el-icon-setting"></i>
                  <span slot="title">会员相关</span>
                </el-menu-item>
              </el-menu>
            </el-col>
          </div>
        </el-aside>
        <el-main class="router-content">
          <router-view/>
        </el-main>
      </el-container>
    </div>
  </div>
</template>

<script>
  export default {
    name: "index"
  }
</script>

<style lang="scss">
  .manager-main {
    ._main_content {
      background-color: rgba(19, 28, 28, 0.36);
      width: 92%;
      margin-left: auto;
      margin-right: auto;
      margin-top: 10px
    }

    ._head_divider {
      width: 93%;
      margin-left: auto;
      margin-right: auto;
    }

    ._leftBar img {
      width: 100px;
      height: 100px;
    }

    .el-submenu__title, .el-menu-item {
      font-size: 18px;
    }

    .el-main {
      padding: 0;
    }
    .router-content{
      min-height: 600px;
    }
  }
</style>
