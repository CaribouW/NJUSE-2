<template>
  <el-card class="role-card-body"
           shadow="hover"
  >
    <div class="content">
      <img src="../../assets/images/header/personal-image.png"/>
      <div class="txt">
        <span class="time">管理员姓名：
          <a style="font-size: 24px">{{item.name}}</a>
        </span>
        <span class="rate">管理员权限：
          <a style="font-size:15px">{{desc}}</a>
        </span>
        <span class="rate">管理员ID：
          <a style="font-size:15px">{{item.id}}</a>
        </span>

      </div>
      <div class="btns" v-if="!deleted">
        <el-button @click="handleModify" v-if="!changeAble">修改权限</el-button>
        <el-button @click="handleRemove" v-if="!changeAble">删除管理员</el-button>
        <div v-else>
          <el-button @click="handleStore">保存修改</el-button>
          <el-select v-model="tmpFunc"
                     placeholder="修改角色信息"
          >
            <el-option
              v-for="item in options"
              :key="item.value"
              :label="item.label"
              :value="item.value">
            </el-option>
          </el-select>
        </div>
      </div>
      <div class="dele" v-else
        style="color: rgba(255,63,73,0.8)"
      >该管理员已被删除</div>
    </div>
  </el-card>
</template>

<script>
  import {doPut, doGet, doPost, doDelete, dealResponse} from "../../service/baseService";

  export default {
    name: "roleCard",
    props: ['item'],
    data() {
      return {
        changeAble: false,
        deleted: false,
        desc: '管理员',
        tmpFunc: '',
        options: [
          {
            value: '经理',
            label: '经理'
          },
          {
            value: '管理员',
            label: '管理员'
          }, {
            value: '普通观众',
            label: '普通观众'
          }, {
            value: '吃瓜群众',
            label: '吃瓜群众',
          }, {
            value: '前台售票员',
            label: '前台售票员'
          }
        ]
      }
    },
    created() {
      this.desc = this.item.desc
    },
    methods: {
      handleModify: function () {
        this.changeAble = true;
        this.$message({
          type: 'info',
          message: '进行管理员角色修改!'
        });
      },
      handleStore: function () {
        this.changeAble = false;
        this.desc = this.tmpFunc; //store back
        const this_ = this;
        doPut({
          url: '/admin',
          body: {
            userId: this_.item.id,
            desc: this.tmpFunc,
          }
        }).then(res => {
          return dealResponse(res);
        }).then(res => {
          if (typeof res === "number") {
            this.$message({
              type: 'warn',
              message: '修改失败!'
            });
          } else {
            this.$message({
              type: 'info',
              message: '修改成功!'
            });
          }
        })

      },
      handleRemove: function () {
        const this_ = this;
        this.$confirm('此操作将删除该管理员,无法撤回, 是否继续?', '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(async () => {
          await doDelete({
            url: '/admin',
            params: {
              id: this_.item.id
            }
          }).then(res => {
            this_.deleted = true;
            this.$message({
              type: 'success',
              message: '删除成功!'
            });
          });
        }).catch(() => {
          this.$message({
            type: 'info',
            message: '已取消删除'
          });
        });
      }
    }
  }
</script>

<style lang="scss">
  .role-card-body {
    margin-bottom: 3%;

    .content {
      display: flex;
      align-items: center;
      min-height: 80px;

      > img {
        position: relative;
        padding-right: 2%;
      }

      .txt {
        flex: 1 0 auto;
        display: flex;
        flex-direction: column;
        text-align: left;

        > span {
          padding-bottom: 1%;
        }

        :first-child {
          font-size: 20px;
        }

        :last-child {
          font-size: 18px;
        }

        > span a:hover {
          color: white;
          cursor: pointer;
        }

        > span a {
          color: rgba(237, 210, 206, 0.76);
          transition: all 1s ease;
        }
      }

      .process {
        flex: 3 0 auto;
        margin: 0 auto;
      }

      .btns {
        flex: 1 0 auto;
        text-align: right;
      }
    }
  }
</style>
