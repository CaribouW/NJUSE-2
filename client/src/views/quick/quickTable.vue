<template>
  <div class="table-main">
    <el-table
      :data="tableData"
      border
      class="table"
      fit='true'
      style="width: 100%;">
      <el-table-column
        prop="date"
        label="开始时间"
      >
      </el-table-column>
      <el-table-column
        prop="movieName"
        label="电影名称"
      >
      </el-table-column>
      <el-table-column
        prop="price"
        label="票价"
      >
      </el-table-column>
      <el-table-column
        prop="category"
        label="类型"
      >
      </el-table-column>
      <el-table-column
        prop="info"
        label="座位剩余情况"
      ></el-table-column>
      <el-table-column
        prop="refund"
        label="退改票"

      ></el-table-column>
      <el-table-column
        prop="index"
      >
        <template slot-scope="scope">
          <el-button
            type="text"
            style="color: #cff9fe;"
            @click="purchase(scope.$index, scope.row)"
          >立即购买
          </el-button>
        </template>

      </el-table-column>
      <div style="border: solid 1px #cff9fe;"></div>
    </el-table>
  </div>
</template>

<script>
  import {doGet, doPost, doPut, dealResponse} from "../../service/baseService";

  export default {
    name: "quickTable",
    props: {
      date: ''
    },
    data() {
      return {
        userId: '',
        tableData: [
          {
            movieId: '',
            date: '',
            movieName: '',
            price: '￥',
            category: '',
            info: '',
            refund: '可改票不可退票',
            scheduleId: '',
            hallId: ''
          },
        ]
      }
    },
    methods: {
      getDate: function () {
      },
      //Purchase the ticket
      //Redirect to the movie form
      purchase: function (index, row) {
        if (sessionStorage.getItem('userId')) {
          this.$router.push({
            path: '/movie/detail',
            query: {
              movieId: row.movieId
            }
          });
          this.$store.commit('purchase', {
            movieId: row.movieId,
            scheduleId: row.scheduleId
          })
        } else {
          this.$message.error('请先登录');
          this.$router.push('/login')
        }

      }
    },
    computed: {
      isBlank: function (data) {
        return data === null;
      }
    },
    async mounted() {
      const this_ = this;
      await doGet({
        url: '/schedule/list',
      }).then(res => {
        return dealResponse(res)
      }).then(res => {
        return res.slot.map(item => {
          return {
            movieId: item.movieId,
            scheduleId: item.slotId,
            price: '￥' + item.ticketPrize,
            date: item.startTime,
            hallId: item.hallId
          }
        });
      }).then(res => {
        console.log(res)
        this_.tableData = [];
        res.forEach((item, index) => {
          const mid = item.movieId;
          this_.$store.dispatch('getMovieBasicInfo', {
            movieId: mid,
            userId: '',
          }).then(res => {
            this_.tableData.push({
              movieName: res.name,
              category: res.basicInfo.type,
              refund: '可改票不可退票',
              info: '座位有多余',
              ...item
            })
          })
        })
      });

    }
  }
</script>

<style lang="scss">
  .table-main {
    text-align: center;
    font-family: "PingFangSC-Medium", serif;
    font-size: 18px;
    font-weight: 400;

    .table {
      background-color: transparent;

      .cell {
        text-align: center;
      }
    }

    .el-table {
      position: relative;
      /*border-collapse: collapse;*/
      overflow: hidden;

      th.gutter {
        display: table-cell !important;
      }

      .el-table__header {
        th {
          background-color: transparent;
          border: solid 1px #cff9fe;
          font-size: 18px;
          font-weight: 400;
          line-height: 23px;
        }
      }

      tr {
        background-color: transparent;

        td {
          border: solid 1px #cff9fe;
        }
      }

      .el-button {
        height: 0;
        line-height: 0;
      }
    }


  }


</style>
