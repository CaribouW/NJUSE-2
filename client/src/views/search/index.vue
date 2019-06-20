<template>
  <div class="search">
    <div class="search_movie" v-for=" search in this.$route.query.searchList" :key="search.movieId">
      <img class="search_movie_poster" :src="search.poster" alt="">
      <div class="search_movie_info">
        <b>{{search.name}}</b>
        <div>地区：{{search.nation}}</div>
        <div style="height:114px;">简介：{{search.briefIntro}}</div>
        <el-button @click="onCheck(search)">查看更多</el-button>
      </div>
    </div>
    <div class="search_page">
      <el-pagination
        :page-size="20"
        :pager-count="11"
        layout="prev, pager, next"
        :total="1000">
      </el-pagination>
    </div>
  </div>
</template>

<script>

  export default {
    data() {
      return {
      }
    },

    /** 
     * 页面加载之前获取数据
     */
    created: function () {
      console.log(this.$route.query.searchList)
    },
    methods: {
      onCheck:function(data){
        if (sessionStorage.getItem('userId')) {
          this.$router.push({
            path: '/movie/detail',
            query: {
              movieId: data.movieId
            }
          })
        } else {
          this.$message.error('请先登录')
          this.$router.push('/login')
        }
        
      }

    }
  }
</script>


<style lang="scss">
.search{
  padding-top: 30px;
  &_movie{
    width: inherit;
    margin: 0 auto;
    height: 236px;
    width: 800px;
    font-size:0;
    background-color: #2B2A28;
    margin-bottom: 20px;
    &_poster{
      height: 236px;
      width: 180px;
      display: inline-block;
      cursor: pointer;
    }
    &_info{
      display: inline-block;
      height: inherit;
      width: 620px;
      padding: 10px 20px;
      box-sizing: border-box;
      font-size: initial;
      vertical-align: top;
      color: white;
      text-align: left;
      >div{line-height: 40px;}
    }
  }
  &_page {
    margin: 30px 0;
    .el-pagination{
      color: white;
      li{background-color: #201f1d;font-size: 16px;}
    }
  }
  .el-button {
      // margin-top: 20px;
      border-radius: 25px;
      padding: 4px 15px;
      background-color: rgba($color: #131C1C, $alpha: 0.5);
      font-size: 14px;
      border-color: #CFF9FE
    }
}
</style>
