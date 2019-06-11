<template>
  <el-card class="refund-card-body"
           shadow="hover"
  >
    <div class="content">
      <div class="txt">
        <span class="rate">{{item.rate}}</span>
        <span class="time">{{item.time}}</span>
      </div>
      <div class="btns">
        <el-button @click="handleModify">修改</el-button>
        <el-button @click="handleRemove">删除</el-button>
      </div>
    </div>
  </el-card>
</template>

<script>
  export default {
    name: "refundCard",
    props: ['item']
  }
</script>

<style lang="scss">
  .refund-card-body {
    background: rgba(56, 62, 67, 0.75);
    box-shadow: rgba(56,62,67,0.87);
    margin-bottom: 3%;
    .content {
      display: flex;

      .txt {
        flex: 1 0 auto;
        display: flex;
        flex-direction: column;
        text-align: left;
      }
    }
  }
</style>
