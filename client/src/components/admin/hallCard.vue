<template>
  <el-card class="card-body" shadow="hover">
    <div slot="header" class="header">
      <span class="id">{{hallItem.id}}号</span>
      <span class="size">{{hallItem.row}}*{{hallItem.col}}</span>
      <span class="type">{{hallItem.type}}</span>
    </div>
    <div slot="body"></div>
  </el-card>
</template>

<script>
  export default {
    props: ['hallItem'],
    name: "hallCard",
    data() {
      return {}
    },
    created() {
    },
  }
</script>

<style lang="scss">
  .card-body {
    width: 259px;
    height: 220px;
    /*background: #D8D8D8;*/
    mix-blend-mode: normal;
    text-align: left;

    .header {
      display: flex;
      flex-direction: row;
      height: fit-content;
      align-items: flex-end;

      & > span {
        font-style: normal;
        font-weight: normal;
      }

      .id {
        font-size: 20px;
        line-height: 25px;
        padding-right: 20px;
      }

      .size {
        font-size: 14px;
        line-height: 18px;
      }

      .type{
        position: absolute;
        right: 10px;
        font-size: 16px;
        line-height: 20px;
      }
    }
  }
</style>
