<template>
  <div class="table-main">
    <el-table
      :data="tableData"
      border
      class="table"
      style="width: 100%;">
      <el-table-column
        prop="date"
        label="日期"
        width="150">
      </el-table-column>
      <el-table-column
        prop="movieName"
        label="电影名称"
        width="150">
      </el-table-column>
      <el-table-column
        prop="price"
        label="票价"
        width="70"
      >
      </el-table-column>
      <el-table-column
        prop="category"
        label="类型"
        width="80"
      >
      </el-table-column>
      <el-table-column
        prop="info"
        label="座位剩余情况"
        width="120"
      ></el-table-column>
      <el-table-column
        prop="refund"
        label="退改票"
        width="150"
      ></el-table-column>
      <el-table-column
        prop="btn"
        width="100"
      >
        <el-button
          type="text"
          style="color: #cff9fe;"
          @click="purchase()"
        >立即购买</el-button>

      </el-table-column>
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
          },{
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
      purchase:function () {
        console.log('buy ticket')
      }
    },
    computed: {}
  }
</script>

<style scoped lang="scss">
.table-main {
  text-align: center;
  font-family: "PingFangSC-Medium",serif;
  font-size: 18px;
  font-weight: 400;
  line-height: 23px;
  .table {
    background-color: transparent;
  }
}
.cell{

}
</style>
