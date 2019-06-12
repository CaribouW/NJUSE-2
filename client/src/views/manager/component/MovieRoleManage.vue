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
  </div>
</template>

<script>
  import RoleCard from "../../../components/admin/roleCard";
  import {dealResponse, doGet} from '../../../service/baseService'

  export default {
    name: "MovieRoleManage",
    components: {RoleCard},
    data() {
      return {
        roles: [{
          id: '',
          name: '',
        }]
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
          return res.list;
        }).then(res => {
          this_.roles = res;
        });
      },
      handleNewRole:function () {
        
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
  }
</style>
