<template>
  <el-card class="card-body"
           shadow="hover"
  >
    <div slot="header" class="header">

      <div class="id">
        <span>{{hallItem.name}}厅</span>
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

    <el-dialog
      :visible.sync="modifyVisible"
      :modal-append-to-body='false'
      title="影厅信息"
      top="20vh"
      width="40%"
      class="modify-dialog"
    >
      <div class="main">
        <el-form ref="form" :model="hall" label-width="80px">
          <el-form-item label="影厅名称">
            <el-input v-model="hall.name"></el-input>
          </el-form-item>
          <el-form-item label="影厅大小" class="size">
            <span>行数:</span>
            <el-input v-model="hall.row" placeholder="请选择座位行数">
            </el-input>
            &nbsp;<span>列数:</span>
            <el-input v-model="hall.col" placeholder="请选择座位列数">
            </el-input>
          </el-form-item>
          <el-form-item label="影厅类型">
            <el-radio-group v-model="hall.type">
              <el-radio label="IMAX" value="IMAX"></el-radio>
              <el-radio label="3D" value="3D"></el-radio>
              <el-radio label="2D" value="2D"></el-radio>
              <el-radio label="亲子厅" value="CP"></el-radio>
            </el-radio-group>
          </el-form-item>
          <el-form-item label="当前可用">
            <el-switch v-model="hall.avail"></el-switch>
            <span v-if="hall.avail">可用</span>
            <span v-else>不可用</span>
          </el-form-item>

          <el-form-item>
            <el-button type="primary" @click="onSubmit">保存修改</el-button>
            <el-button @click="onCancel">取消</el-button>
          </el-form-item>
        </el-form>
      </div>
    </el-dialog>
  </el-card>
</template>

<script>
  import {mapActions, mapMutations} from 'vuex'

  export default {
    props: ['hallItem'],
    name: "hallCard",
    data() {
      return {
        modifyVisible: false,
        hall: {
          name: '',
          row: 0,
          col: 1,
          avail: false,
          category: ''
        }
      }
    },
    created() {
      let item = this.hallItem;
      this.hall = {
        id: item.id,
        name: item.name,
        row: item.row,
        col: item.col,
        avail: item.state === 0,
        category: item.category
      };
    },
    computed: {
      available() {
        return this.hallItem.state === 1
      }
    },
    methods: {
      ...mapActions({
        modify: 'modifyHall'
      }),
      ...mapMutations({
        append: 'appendHallList',
        remove: 'removeHallList'
      }),
      //显示新的修改弹窗
      handleModify: function () {
        this.modifyVisible = true;
      },
      //显示新的删除确认弹框
      handleRemove: function () {
        const this_ = this;
        this.$confirm('此操作将删除该影厅, 是否继续?', '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(async () => {
          await this.remove({
            id: this_.hallItem.id
          });
          this.$message({
            type: 'success',
            message: '删除成功!'
          });
        }).catch(() => {
          this.$message({
            type: 'info',
            message: '已取消删除'
          });
        });
      },
      onSubmit: function () {
        const data = this.hall;
        this.modify({
          hallId: data.id,
          state: data.avail === true ? 0 : 1,
          row: data.row,
          col: data.col,
          category: data.category,
          name: data.name
        }).then(res => {
          console.log(res)
        });
        this.$message({
          type: 'success',
          message: '修改成功'
        });
        this.modifyVisible = false
      },
      onCancel: function () {
        this.$message({
          type: 'info',
          message: '已取消删除'
        });
        this.modifyVisible = false
      }
    }
  }
</script>

<style lang="scss">
  .card-body {
    margin: 0.5%;
    width: 259px;
    max-height: 220px;
    /*background: #D8D8D8;*/
    mix-blend-mode: normal;
    text-align: left;
    position: relative;

    &:hover {
      margin: 0;
      opacity: 1.1;
      background-color: #383e43;
    }

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
        white-space: nowrap;
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

    .modify-dialog {
      .main {
        .size {
          span {
            flex: 0 0 auto;
          }
        }
      }
    }

    .el-input {
      display: inline;
      background-color: red;
    }
  }


</style>
