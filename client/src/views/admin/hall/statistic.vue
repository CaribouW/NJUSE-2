<template>
  <div class="statistic">
    <!-- 上座率 -->
    <div class="occupancyRate statistic_card">
      <div class="s_title">上座率</div>
      <div class="s_content">

      </div>
    </div>
    <!-- 今日排片率 -->
    <div class="scheduleRate statistic_card">
      <div class="s_title">今日排片率</div>
      <div class="s_content">

      </div>
    </div>
    <!-- 所有电影票房 -->
    <div class="scheduleRate statistic_card">
      <div class="s_title">所有电影票房</div>
      <div class="s_content">

      </div>
    </div>
    <!-- 每日客单价 -->
    <div class="scheduleRate statistic_card">
      <div class="s_title">每日客单价</div>
      <div class="s_content">

      </div>
    </div>
    <!-- 最受欢迎电影 -->
    <div class="scheduleRate statistic_card">
      <div class="s_title">最受欢迎电影</div>
      <div class="s_content">

      </div>
    </div>
  </div>
</template>

<script>
  import admin from '../index.vue'

  export default {
    name: 'statistic',
    components: {
      admin
    },

  }
</script>

<style lang="scss">
 .statistic_card{
   border: 1px solid rgb(201, 235, 255);
   padding: 10px 10px 10px 20px;
   margin: 0 10px 20px 10px;
   border-radius: 5px;
   .s_title{
     width: 90%;
     text-align: start;
     font-size: 23px;
    //  border-bottom: 1px solid #ccc;
     margin-bottom: 20px;
     line-height: 35px;
   }
   .s_content{

   }
 }
</style>
