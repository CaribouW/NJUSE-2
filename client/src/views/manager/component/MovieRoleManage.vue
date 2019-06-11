<template>
  <div class="role-main">
    <div class="header">
      <div class="header-text">
        <span>影院角色管理</span>
        <el-button  icon="el-icon-plus">添加新的角色</el-button>
      </div>
      <div class="choose">

      </div>
      <el-divider direction="horizontal"></el-divider>
    </div>
    <div class="cards">
    </div>
  </div>
</template>

<script>
  export default {
    name: "MovieRoleManage"
  }
</script>

<style lang="scss">
.role-main{
  color: #FFFFFF;
  padding: 30px;
  .header {
    display: flex;
    flex-direction: column;
    padding: 0;

    .el-divider {
      border: 1px solid #979797;
    }

    .header-text {
      display: flex;
      text-align: left;
      padding-bottom: 2%;

      & > span {
        flex: 1 0 auto;
        height: 28px;
        font-size: 22px;
        line-height: 28px;
      }
    }
  }

  .cards {
    padding: 20px 20px 40px;
  }
}
</style>
