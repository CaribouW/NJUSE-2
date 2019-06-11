<template>
  <div class="refund-strategy-main">
    <div class="header">
      <div class="header-text">
        <span>退票策略</span>
      </div>
      <div class="choose">

      </div>
      <el-divider direction="horizontal"></el-divider>
    </div>
  </div>
</template>

<script>
  export default {
    name: "refundStrategy"
  }
</script>

<style lang="scss">
  .refund-strategy-main {
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
        text-align: left;
        padding-bottom: 2%;

        & > span {
          height: 28px;
          font-size: 22px;
          line-height: 28px;
        }
      }
    }
  }
</style>
