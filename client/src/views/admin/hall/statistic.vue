<template>
  <div class="statistic">
    <!-- 今日排片率 （条形图）-->
    <div class="scheduleRate statistic_card">
      <div class="s_title">今日排片率</div>
      <div class="s_content" >
        <ve-bar :data="chartData_scheduleRate" :settings="chartSettings_scheduleRate" theme-name="dark"></ve-bar>
      </div>
    </div>
    <!-- 所有电影票房：当日票房 （柱状图） -->
    <div class="boxOffice statistic_card">
      <div class="s_title">所有电影票房</div>
      <div class="s_content">
        <ve-histogram :data="chartData_boxOffice" :settings="chartSettings_boxOffice" theme-name="dark"></ve-histogram>
      </div>
    </div>
    <!-- 上座率：当日 （条形图）-->
    <div class="occupancyRate statistic_card">
      <div class="s_title">上座率</div>
      <div class="s_content">
        <ve-bar :data="chartData_occupancyRate" :settings="chartSettings_occupancyRate" theme-name="dark"></ve-bar>
      </div>
    </div>
    <!-- 每日客单价：近一个星期以来 （柱状图） -->
    <div class="perCustomerTx statistic_card">
      <div class="s_title">每日客单价</div>
      <div class="s_content">
        <ve-histogram :data="chartData_perCustomerTx" :settings="chartSettings_perCustomerTx" theme-name="dark"></ve-histogram>
      </div>
    </div>
    <!-- 最受欢迎电影：按照近期的票房来排序 （饼状图）-->
    <div class="mostPopularMovie statistic_card">
      <div class="s_title">最受欢迎电影</div>
      <div class="s_content">
        <ve-pie :data="chartData_popular" :settings="chartSettings_popular" theme-name="dark"></ve-pie>
      </div>
    </div>
  </div>
</template>

<script>
  import admin from '../index.vue'
  import 'echarts/theme/dark.js'

  export default {
    name: 'statistic',
    components: {
      admin
    },
    data(){
      this.chartSettings_scheduleRate = {
        metrics: ['排片率'],
        dimension: ['电影']
      };
      this.chartSettings_boxOffice = {
        metrics: ['票房'],
        dimension: ['电影']
      };
      this.chartSettings_occupancyRate = {
        metrics: ['上座率'],
        dimension: ['电影']
      };
      this.chartSettings_perCustomerTx = {
        metrics: ['客单价'],
        dimension: ['日期']
      };
      this.chartSettings_popular = {
        dataType: 'normal'
      };
      return {
        chartData_scheduleRate: {
          columns: ['电影', '排片率'],
          rows: [
            { '电影': '钢铁侠', '排片率': 0.32},
            { '电影': '蜘蛛侠', '排片率': 0.54},
            { '电影': '复联2', '排片率': 0.69},
            { '电影': '蚁人', '排片率': 0.47},
            { '电影': '超人', '排片率': 0.98},
            { '电影': '绿巨人', '排片率': 0.54}
          ]
        },
        chartData_boxOffice: {
          columns: ['电影', '票房'],
          rows: [
            { '电影': '钢铁侠', '票房': 1393 },
            { '电影': '蜘蛛侠', '票房': 3530 },
            { '电影': '蝙蝠侠', '票房': 2923 },
            { '电影': '绿灯侠', '票房': 1723 },
            { '电影': 'xxxx侠', '票房': 3792 }
          ]
        },
        chartData_occupancyRate:{
          columns: ['电影', '上座率'],
          rows: [
            { '电影': '钢铁侠', '上座率': 0.76},
            { '电影': '蜘蛛侠', '上座率': 0.44},
            { '电影': '复联2', '上座率': 0.96},
            { '电影': '蚁人', '上座率': 0.27},
            { '电影': '超人', '上座率': 0.98},
            { '电影': '绿巨人', '上座率': 0.64}
          ]
        },
        chartData_perCustomerTx: {
          columns: ['日期', '客单价'],
          rows: [
            { '日期': '2019-06-05', '客单价': 38 },
            { '日期': '2019-06-06', '客单价': 36 },
            { '日期': '2019-06-07', '客单价': 49 },
            { '日期': '2019-06-08', '客单价': 23 },
            { '日期': '2019-06-09', '客单价': 64 },
            { '日期': '2019-06-10', '客单价': 30 },
            { '日期': '2019-06-11', '客单价': 27.5 }
          ]
        },
        chartData_popular: {
          columns: ['电影', '近期票房'],
          rows: [
            { '电影': '钢铁侠', '近期票房': 1393 },
            { '电影': '蜘蛛侠', '近期票房': 3530 },
            { '电影': '蝙蝠侠', '近期票房': 2923 },
            { '电影': '绿灯侠', '近期票房': 1723 },
            { '电影': 'xxxx侠', '近期票房': 3792 }
          ]
        }
      }
    }
  }
</script>

<style lang="scss">
 .statistic_card{
   border: 1px solid #ccc;
   padding: 10px 10px 10px 20px;
   margin: 0 10px 20px 10px;
   border-radius: 5px;
   .s_title{
     width: 90%;
     text-align: start;
     font-size: 20px;
     color: #CFF9FE;
    //  border-bottom: 1px solid #ccc;
     margin-bottom: 20px;
     line-height: 35px;
   }
 }
 .mostPopularMovie{
     margin-bottom: 0px;
 }
</style>
