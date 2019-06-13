<template>
  <el-card class="refund-card-body"
           shadow="hover"
  >
    <div class="content">
      <div class="txt">
        <span class="rate">返还金额比例：
          <a style="font-size: 24px">{{rate}} %</a>
        </span>
        <span class="time">限制返额时间：
          <a style="font-size: 15px">{{time}} min</a>
        </span>
      </div>
      <div class="process" v-if="changeAble">
        <el-slider v-model="rate"
                   show-input
        ></el-slider>
        <el-slider v-model="time"
                   show-input
        ></el-slider>
      </div>
      <div class="btns" v-if="!changeAble">
        <el-button @click="handleModify">修改</el-button>
        <el-button @click="handleRemove">删除</el-button>
      </div>
      <div class="btns" v-else>
        <el-button @click="handleStore">保存修改</el-button>
        <el-button @click="handleCancle">取消修改</el-button>

      </div>
    </div>
  </el-card>
</template>

<script>
  import {mapActions, mapGetters, mapMutations} from 'vuex'

  export default {
    name: "refundCard",
    props: ['item'],
    data() {
      return {
        rate: 0,
        time: 0,
        changeAble: false,
        changeInput: false,
        tmpStore: {
          rate: '',
          time: '',
        }
      }
    },
    
    methods: {
      ...mapActions({
        modify: 'modifyRefundItem'
      }),
      //进入修改模式
      handleModify: function () {
        this.changeAble = true;
        //缓存
        this.tmpStore = {
          rate: this.rate,
          time: this.time
        };

      },

      //显示新的删除确认弹框
      handleRemove: function () {
        const this_ = this;

        this.$confirm('此操作将删除该退票策略, 是否继续?', '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(async () => {
          this.$store.dispatch('removeRefundStrategy', {id: this_.item.id})
            .then(res => {
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
      },

      handleStore: function () {
        this.modify({
          id: this.item.id,
          time: this.time,
          rate: this.rate / 100
        }).then(res => {
          this.$message({
            type: 'success',
            message: '修改成功!'
          });
          this.changeAble = false
        });

      },

      handleCancle: function () {
        this.time = this.tmpStore.time;
        this.rate = this.tmpStore.rate;
        this.$message({
          type: 'success',
          message: '取消修改!'
        });
        this.changeAble = false
      },
    },
    mounted() {
      this.rate = this.$props.item.rate * 100;
      this.time = this.$props.item.time;
    },
    computed: {}
  }
</script>

<style lang="scss">
  .refund-card-body {
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
          font-size: 24px;
        }

        :last-child {
          font-size: 15px;
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
