<template>
  <div class="search">
    <div class="search_movie">
      <img class="search_movie_poster" src="@/assets/images/search/a_100294605_m_601_m1_180_236.jpg" alt="">
      <div class="search_movie_info">
        <div>我中国少年说第2季 2019</div>
        <div>地区：中国大陆 上映时间: 2019年05月18日</div>
        <div>我中国少年》是河北广播电视台卫视频道2019年强力打造的一档大型原创智力竞技节目，
          以12-18岁的00后少年为主体，以科学竞技为手段，展现少年们在记</div>
        <div>查看资料</div>
      </div>
    </div>
  </div>
</template>

<style lang="scss">
.search{
  &_movie{
    width: inherit;
    margin: 0 auto;
    height: 236px;
    width: 800px;
    font-size:0;
    background-color: #2B2A28;
    &_poster{
      height: 236px;
      width: 180px;
      display: inline-block;
    }
    &_info{
      display: inline-block;
      height: inherit;
      width: 620px;
      font-size: initial;
      vertical-align: top;
      color: white;
      >div:last-of-type{
        background-color: #D7F8FD;
        color: black;
        width: 110px;
        height: 40px;
        line-height: 40px;
        border-radius: 30px;
        cursor: pointer;
      }
      >div:last-of-type:hover{}
    }
  }
}
</style>
