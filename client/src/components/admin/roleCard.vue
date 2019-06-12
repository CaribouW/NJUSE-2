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
          <a style="font-size:15px">{{func}}</a>
        </span>
        <span class="rate">管理员ID：
          <a style="font-size:15px">{{item.id}}</a>
        </span>

      </div>
      <div class="btns">
        <el-button @click="handleModify" v-if="!changeAble">修改权限</el-button>
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
        func: '管理员',
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
          }
        ]
      }
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
        this.func = this.tmpFunc; //store back


        this.$message({
          type: 'success',
          message: '修改成功!'
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
