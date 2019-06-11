<template>
  <el-card class="refund-card-body"
           shadow="hover"
  >
    <div class="content">
      <div class="txt">
        <span class="rate">返还金额比例：{{item.rate}}</span>
        <span class="time">限制返额时间：{{item.time}} min</span>
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
    name: "refundCard",
    props: ['item'],
    methods: {
      handleModify: function () {

      },

      //显示新的删除确认弹框
      handleRemove: function () {
        const this_ = this;
        this.$confirm('此操作将删除该退票策略, 是否继续?', '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(async () => {
          await this.remove({
            id: this_.item.id
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
    }
  }
</script>

<style lang="scss">
  .refund-card-body {
    margin-bottom: 3%;

    .content {
      display: flex;
      align-items: center;

      .txt {
        flex: 1 0 auto;
        display: flex;
        flex-direction: column;
        text-align: left;

        :first-child {
          font-size: 24px;
        }

        :last-child {
          font-size: 15px;
        }
      }

      .btns {
      }
    }
  }
</style>
