<template>
  <div class="homepage">
    <div class="homepage_poster">走马灯</div>
    <div class="homepage_movie">
      <div class="homepage_movie_top">
        <img src="@/assets/images/homepage/dianying.png" alt="">
        MOVIE
      </div>
      <div class="homepage_movie_middle">
        <div class="homepage_movie_middle_left">
          <ul>
            <li>正在热映</li>
            <li>即将上映</li>
          </ul>
          <img src="@/assets/images/homepage/fullsizerender(16).png" alt="">
        </div>
        <div class="homepage_movie_middle_right">
          <div class="homepage_movie_middle_right_title">
            <div><img src="@/assets/images/homepage/fullsizerender(6).png" alt="">正在热映</div>
            <i class="el-icon-d-arrow-right"></i>
          </div>
          <div class="homepage_movie_middle_right_movie" v-for="movie in movieList">
            <img src="@/assets/images/homepage/161905.30186585_1000 copy.png" alt="">
            <span>{{movie.name}}</span>
          </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  data () {
    return {
      movieList: [
        {id: '123456',url: '123456',name: '头号玩家'},
        {id: '123456',url: '123456',name: '头号玩家'},
        {id: '123456',url: '123456',name: '头号玩家'},
        {id: '123456',url: '123456',name: '头号玩家'},
        {id: '123456',url: '123456',name: '头号玩家'},
        {id: '123456',url: '123456',name: '头号玩家'},
        {id: '123456',url: '123456',name: '头号玩家'},
        {id: '123456',url: '123456',name: '头号玩家'},
      ]
    }
  }
}
</script>


<style lang="scss">
.homepage{
  padding: 0 20px;
  &_movie{
    &_top{
      color: #CFF9FE;
      font-size: 48px;
      margin-bottom: 30px;
    }
    &_middle{
      display: flex;
      &_left{
        flex: 1 1 auto;
      }
      &_right{
        width: 900px;
        flex: 0 1 auto;
        &_title{
          padding: 0 50px;
          // text-align: left;
          display: flex;
          align-items: center;
          margin-bottom: 30px;
          >div{flex: 1 0 auto;text-align: left;display: flex; align-items: center;font-size: 24px;color:#EAEAEA}
        >i{flex: 0 1 auto; }
        }
        &_movie{
          display: inline-block;
          margin: 10px 30px;
          font-size: 18px;
          >span{
            color: #EAEAEA;
          }
          >img{display: block;}
        }
      }
    }
  }
}
</style>

