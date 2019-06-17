<template>
  <div class="search">
    <div class="search_movie" v-for="i in 6">
      <img class="search_movie_poster" src="@/assets/images/search/a_100294605_m_601_m1_180_236.jpg" alt="">
      <div class="search_movie_info">
        <div>我中国少年说第2季 2019</div>
        <div>地区：中国大陆 上映时间: 2019年05月18日</div>
        <div>我中国少年》是河北广播电视台卫视频道2019年强力打造的一档大型原创智力竞技节目，
          以12-18岁的00后少年为主体，以科学竞技为手段，展现少年们在记</div>
        <div>查看资料</div>
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
    },
    methods: {
    //   search() {
    //   let that = this;
    //   if (that.searchData === '' || typeof(that.searchData)=="undefined")
    //   {
    //     that.list=that.modules;
    //   }else{
    //     that.list=[]
    //     that.modules.map(function(item) {
    //       console.log(typeof item.name);
    //     if (item.name.search(that.searchData) != -1) { // 筛选条件
    //       that.list.push(item);
    //     }
    //   });
    //   }
    //   console.log(this.list)
    // },
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
      >div:last-of-type{
        background-color: #D7F8FD;
        margin-top: 10px;
        color: black;
        width: 110px;
        height: 40px;
        line-height: 40px;
        border-radius: 30px;
        cursor: pointer;
        text-align: center;
      }
      // >div:last-of-type:hover{}
    }
  }
  &_page {
    margin: 30px 0;
    .el-pagination{
      color: white;
      li{background-color: #201f1d;font-size: 16px;}
      button{background-color: #201f1d;}
    }
  }
}
</style>
