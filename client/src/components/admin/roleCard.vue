<template>
  <el-card class="role-card-body"
           shadow="hover"
  >
    <div class="content">
      <div class="txt">
        <span class="time">管理员姓名：
          <a style="font-size: 24px">{{item.name}}</a>
        </span>
        <span class="rate">管理员ID：
          <a style="font-size:15px">{{item.id}}</a>
        </span>

      </div>
      <div class="btns">
        <el-button @click="handleModify">修改</el-button>
        <el-button @click="handleRemove">删除</el-button>
      </div>
    </div>
  </el-card>
</template>

<script>
  export default {
    name: "roleCard",
    props: ['item'],
    data() {
      return {
        changeAble: false,
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

      .txt {
        flex: 1 0 auto;
        display: flex;
        flex-direction: column;
        text-align: left;


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
