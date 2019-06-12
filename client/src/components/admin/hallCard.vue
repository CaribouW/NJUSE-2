<template>
  <el-card class="card-body"
           shadow="hover"
  >
    <div slot="header" class="header">

      <div class="id">
        <span>{{hall.name}}厅</span>
      </div>
      <div class="size">
        <span>{{hall.row}}*{{hall.col}}</span>
      </div>
      <div class="type">
        <span>{{hall.category}}</span>
      </div>
      <el-badge value="不可用"
                class="state"
                v-if="!hall.state"
      >
      </el-badge>
      <el-badge value="可用"
                class="state-avaliable"
                v-else>
      </el-badge>

    </div>
    <div class="card-content">
      <el-button @click="handleModify">修改</el-button>
<!--      <el-button @click="handleRemove" style="visibility: hidden">删除</el-button>-->
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
        <el-form ref="form" :model="form" label-width="80px">
          <el-form-item label="影厅名称">
            <el-input v-model="form.name"></el-input>
          </el-form-item>
          <el-form-item label="影厅大小" class="size">
            <span>行数:</span>
            <el-input v-model="form.row" placeholder="请选择座位行数">
            </el-input>
            &nbsp;<span>列数:</span>
            <el-input v-model="form.col" placeholder="请选择座位列数">
            </el-input>
          </el-form-item>
          <el-form-item label="影厅类型">
            <el-radio-group v-model="form.category">
              <el-radio label="IMAX" value="IMAX"></el-radio>
              <el-radio label="3D" value="3D"></el-radio>
              <el-radio label="2D" value="2D"></el-radio>
              <el-radio label="亲子厅" value="CP"></el-radio>
            </el-radio-group>
          </el-form-item>
          <el-form-item label="当前可用">
            <el-switch v-model="form.state"></el-switch>
            <span v-if="form.state">可用</span>
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
        form: {
          name: '',
          row: 0,
          col: 1,
          state: false,
          category: ''
        },
        hall: {
          id: '',
          name: '',
          row: '',
          col: '',
          state: false,
          category: ''
        }
      }
    },
    created() {
      let item = this.hallItem;
      //初始化影厅
      this.hall = {
        id: item.id,
        name: item.name,
        row: item.row,
        col: item.col,
        state: item.state,
        category: item.category
      };
      this.form = {
        id: item.id,
        name: item.name,
        row: item.row,
        col: item.col,
        state: item.state,
        category: item.category
      }
    },
    computed: {
    },
    methods: {
      ...mapActions({
        modify: 'modifyHall',
        addHall: 'addHall'
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
            id: this_.hall.id
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
        const data = this.form;
        const this_ = this;
        let f = null;
        if (data.id !== undefined) {
          f = this_.modify
        } else {
          f = this_.addHall
        }
        f({
          hallId: data.id,
          state: data.state,
          row: data.row,
          col: data.col,
          category: data.category,
          name: data.name
        }).then(res => {
          this_.hall = res;
          this_.$message({
            type: 'success',
            message: '修改成功'
          });
          this_.modifyVisible = false
        });
      },
      onCancel: function () {
        this.$message({
          type: 'info',
          message: '已取消修改'
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
      .el-button {
        flex: 1 0 auto;
      }
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
