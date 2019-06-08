<template>
  <div class="hall-main">
    <div class="header">
      <div class="header-text">
        <span>当前可用影厅</span>
      </div>
      <div class="choose">

      </div>
      <el-divider direction="horizontal"></el-divider>
    </div>
    <div class="cards">
      <hall-card class="card-item"
                 v-for="item in halls"
                 :key="item.id"
                 v-bind:hall-item="item"
      ></hall-card>
    </div>
  </div>
</template>

<script>
  import {mapGetters, mapActions} from 'vuex'
  import HallCard from "../../../components/admin/hallCard";

  export default {
    name: "hallManage",
    components: {HallCard},
    data() {
      return {
        hallList: [
          {}
        ]
      }
    },
    computed: {
      ...mapGetters({
        halls: 'hallList'
      })
    },
    created() {
      // this.flushHall()
    },
    methods: {
      ...mapActions({
        flushHall: 'getHalls'
      })
    },
  }
</script>

<style lang="scss">
  .hall-main {
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

    .cards {
      padding: 20px 20px 40px;
      display: flex;
      justify-content: space-evenly;
      flex-wrap: wrap;
    }
  }
</style>
