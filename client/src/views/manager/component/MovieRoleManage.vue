<template>
  <div class="role-main">
    <div class="header">
      <div class="header-text">
        <span>影院角色管理</span>
        <el-button icon="el-icon-plus" @click="handleNewRole">添加新的管理员</el-button>
      </div>
      <div class="choose">

      </div>
      <el-divider direction="horizontal"></el-divider>
    </div>
    <div class="cards">
      <role-card class="card-item"
                 v-for="item in roles"
                 :key="item.id"
                 v-bind:item="item"
      ></role-card>
    </div>

    <el-dialog
      :visible.sync="modifyVisible"
      :modal-append-to-body='false'
      title="注册管理员账号"
      top="20vh"
      width="40%"
      class="modify-dialog"
    >
      <div class="form">
        <el-form>
          <el-form-item label="账户名称">
            <el-input v-model="form.account"></el-input>
          </el-form-item>
          <el-form-item label="账户密码">
            <el-input v-model="form.password" show-password></el-input>
          </el-form-item>
          <el-form-item label="确认密码">
            <el-input v-model="form.check" show-password></el-input>
          </el-form-item>
          <el-form-item>
            <el-button @click="onSubmit">注册账户</el-button>
          </el-form-item>
        </el-form>
      </div>
    </el-dialog>
  </div>
</template>

<script>
  import RoleCard from "../../../components/admin/roleCard";
  import {dealResponse, doGet, doPost} from '../../../service/baseService'

  export default {
    name: "MovieRoleManage",
    components: {RoleCard},
    data() {
      return {
        modifyVisible: false,
        roles: [{
          id: '',
          name: '',
          desc: '',
        }],
        form: {
          account: '',
          password: '',
          check: ''
        }
      }
    },
    computed: {},
    methods: {
      fetchRoles: function () {
        const this_ = this;
        doGet({
          url: '/admin/list',
        }).then(res => {
          return dealResponse(res)
        }).then(res => {
          this_.roles = res.map(item => {
            return {
              id: item.userId,
              name: item.account,
              desc: item.adminDesc
            }
          });
        });
      },
      handleNewRole: function () {
        this.modifyVisible = true;
        this.$message({
          type: 'info',
          message: '开始新建管理员角色账号!'
        });
      },
      onSubmit: function () {
        const this_ = this;
        doPost({
          url: '/admin/new',
          body: {
            account: this_.form.account,
            password: this_.form.password
          }
        }).then(res => {
          return dealResponse(res)
        }).then(res => {
          this_.roles.push({
            id: res.userId,
            name: res.account,
            desc: res.adminDesc
          });
          this.$message({
            type: 'success',
            message: '管理员创建成功!'
          });
          this_.modifyVisible = false
        });
      }
    },
    mounted() {
      this.fetchRoles()
    }
  }
</script>

<style lang="scss">
  .role-main {
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
        display: flex;
        text-align: left;
        padding-bottom: 2%;

        & > span {
          flex: 1 0 auto;
          height: 28px;
          font-size: 22px;
          line-height: 28px;
        }
      }
    }

    .cards {
      padding: 20px 20px 40px;
    }

    .modify-dialog {
      .form {
        padding: 2%
      }
    }
  }
</style>
