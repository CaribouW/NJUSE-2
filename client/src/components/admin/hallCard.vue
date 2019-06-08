<template>
  <el-card class="card-body"
           shadow="hover"
  >
    <div slot="header" class="header">

      <div class="id">
        <span>{{hallItem.id}}号</span>
      </div>
      <div class="size">
        <span>{{hallItem.row}}*{{hallItem.col}}</span>
      </div>
      <div class="type">
        <span>{{hallItem.type}}</span>
      </div>
      <el-badge value="不可用"
                class="state"
                v-if="available">
      </el-badge>
      <el-badge value="可用"
                class="state-avaliable"
                v-else>
      </el-badge>

    </div>
    <div class="card-content">
      <el-button @click="handleModify">修改</el-button>
      <el-button @click="handleRemove">删除</el-button>
    </div>
  </el-card>
</template>

<script>
  import {mapActions, mapMutations} from 'vuex'

  export default {
    props: ['hallItem'],
    name: "hallCard",
    data() {
      return {}
    },
    created() {
    },
    computed: {
      available() {
        return this.hallItem.state === 1
      }
    },
    methods: {
      ...mapMutations({
        append: 'appendHallList',
        remove: 'removeHallList'
      }),
      //显示新的修改弹窗
      handleModify: function () {
        this.append({
          id: 1 + this.hallItem.id,
          state: '0', // 0 可用 ; 1 不可用
          row: '13',  //行数
          col: '5', //列数
          type: 'IMAX', //规格
        })
      },
      //显示新的删除确认弹框
      handleRemove: function () {
        this.remove({
          id: this.hallItem.id
        })
      },

    }
  }
</script>

<style lang="scss">
  .card-body {
    width: 259px;
    max-height: 220px;
    /*background: #D8D8D8;*/
    mix-blend-mode: normal;
    text-align: left;
    position: relative;

    .header {
      display: flex;
      flex-direction: row;
      height: fit-content;
      align-items: flex-end;

      & > div {
        text-align: left;
        min-width: 20%;
        max-width: 25%;
        text-wrap: none;
        overflow: hidden;
      }

      .el-badge__content {
        flex: 1 0 auto;
        width: 35px;
      }

      .state {
        display: inline;
        line-height: 0;
        flex: 1 0 auto;

        .el-badge__content {
          background-color: rgba(163, 24, 27, 0.97);
        }
      }

      .state-avaliable {
        display: inline;
        line-height: 0;
        flex: 1 0 auto;

        .el-badge__content {
          background-color: rgba(73, 155, 77, 0.97);
        }
      }

      & > span {
        font-style: normal;
        font-weight: normal;
      }

      .id {
        flex: 0 0 auto;
        font-size: 20px;
        line-height: 25px;
        padding-right: 20px;
      }

      .size {
        font-size: 14px;
        line-height: 18px;
      }

      .type {
        flex: 1 0 auto;
        padding-left: 10px;
        font-size: 14px;
        line-height: 18px;
      }
    }

    .card-content {
      display: flex;
      justify-content: space-evenly;
    }
  }


</style>
