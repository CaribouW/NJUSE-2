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
    <div class="cards">
      <refund-card class="card-item"
                   v-for="item in refunds"
                   :key="item.id"
                   v-bind:item="item"
      ></refund-card>
    </div>
  </div>
</template>

<script>
  import RefundCard from "../../../components/admin/refundCard";
  import {mapGetters, mapActions, mapMutations} from 'vuex'

  export default {
    name: "refundStrategy",
    components: {RefundCard},
    computed: {
      ...mapGetters({
        refunds: 'refunds'
      })
    }
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
