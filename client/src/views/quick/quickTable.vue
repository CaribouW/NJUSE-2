<template>
  <div class="table-main">
    <el-table
      :data="tableData"
      border
      class="table"
      fit = 'true'
      style="width: 100%;">
      <el-table-column
        prop="date"
        label="日期"
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
        prop="btn"
      >
        <el-button
          type="text"
          style="color: #cff9fe;"
          @click="purchase()"
        >立即购买
        </el-button>

      </el-table-column>
      <div style="border: solid 1px #cff9fe;"></div>
    </el-table>
  </div>
</template>

<script>
  export default {
    name: "quickTable",
    props: {
      date: ''
    },
    data() {
      return {
        tableData: [
          {
            date: '12:00 - 14:00',
            movieName: '阿丽塔:战斗天使',
            price: '￥' + '45',
            category: '普通3D',
            info: '',
            refund: '可改票不可退票',
          }, {
            date: '12:00 - 14:00',
            movieName: '阿丽塔:战斗天使',
            price: '￥' + '45',
            category: '普通3D',
            info: '',
            refund: '可改票不可退票',
          }, {
            date: '12:00 - 14:00',
            movieName: '阿丽塔:战斗天使',
            price: '￥' + '45',
            category: '普通3D',
            info: '',
            refund: '可改票不可退票',
          }, {
            date: '12:00 - 14:00',
            movieName: '阿丽塔:战斗天使',
            price: '￥' + '45',
            category: '普通3D',
            info: '',
            refund: '可改票不可退票',
          }, {
            date: '12:00 - 14:00',
            movieName: '阿丽塔:战斗天使',
            price: '￥' + '45',
            category: '普通3D',
            info: '',
            refund: '可改票不可退票',
          }, {
            date: '12:00 - 14:00',
            movieName: '阿丽塔:战斗天使',
            price: '￥' + '45',
            category: '普通3D',
            info: '',
            refund: '可改票不可退票',
          }, {
            date: '12:00 - 14:00',
            movieName: '阿丽塔:战斗天使',
            price: '￥' + '45',
            category: '普通3D',
            info: '',
            refund: '可改票不可退票',
          },
        ]
      }
    },
    methods: {
      getDate: function () {
      },
      //Purchase the ticket
      //Redirect to the movie form
      purchase: function () {
        console.log(this.date)
      }
    },
    computed: {
      isBlank: function (data) {
        return data === null;
      }
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
