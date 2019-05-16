<template>
  <div class="homepage">
    <div class="homepage_poster">
      <el-carousel :interval="4000" type="card" height="400px" indicator-position="none"> 
        <el-carousel-item v-for="item in posters" :key="item">
          <img :src="item.url" alt="">
        </el-carousel-item>
      </el-carousel>
    </div>
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
          <img src="@/assets/images/homepage/fullsizerender(16).png" alt=""><br/>
          <img src="@/assets/images/homepage/GO！GET A MOVIE.png" alt="">
        </div>
        <div class="homepage_movie_middle_right">
          <div class="homepage_movie_middle_right_title">
            <div><img src="@/assets/images/homepage/fullsizerender(6).png" alt="">正在热映</div>
            <i class="el-icon-d-arrow-right" @click="changePage()"></i>
          </div>
          <div class="homepage_movie_middle_right_movie" v-for="movie in movieList">
            <img :src="movie.url" alt="">
            <span>{{movie.name}}</span>
          </div>
          </div>
        </div>
      </div>
      <div class="homepage_movie_buttom">
        <span @click="goMovieList()">更多内容</span>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  data () {
    return {
      movieList: [
        {id: '123456',url: require('@/assets/images/test/filmPoster0.jpg'),name: '头号玩家'},
        {id: '123456',url: require('@/assets/images/test/filmPoster1.jpg'),name: '头号玩家'},
        {id: '123456',url: require('@/assets/images/test/filmPoster2.jpg'),name: '头号玩家'},
        {id: '123456',url: require('@/assets/images/test/filmPoster3.jpg'),name: '头号玩家'},
        {id: '123456',url: require('@/assets/images/test/filmPoster4.jpg'),name: '头号玩家'},
        {id: '123456',url: require('@/assets/images/test/filmPoster0.jpg'),name: '头号玩家'},
        {id: '123456',url: require('@/assets/images/test/filmPoster1.jpg'),name: '头号玩家'},
        {id: '123456',url: require('@/assets/images/test/filmPoster2.jpg'),name: '头号玩家'},
      ],
      posters: [
        {index: 0, url: require('@/assets/images/test/pictest0.jpg')},
        {index: 1, url: require('@/assets/images/test/pictest1.jpg')},
        {index: 2, url: require('@/assets/images/test/pictest2.jpg')},
        {index: 3, url: require('@/assets/images/test/pictest3.jpg')}
      ],
    }
  },
  methods: {
    goMovieList () {
      this.$router.push('/movielist')
    },
    changePage () {
      // 翻页
    }
  }
}
</script>


<style lang="scss">
.homepage{
  padding: 29px 50px 50px 50px;
  &_poster{
    background: url('../../assets/images/homepage/Assets.png') no-repeat;
    background-size: 100% 100%;
    height: 520px;
    box-sizing: border-box;
    padding-top: 30px;
    padding: 50px 70px 0 70px;
    .el-carousel__item img {
      width: 100%;
      height: 100%;
    }
    .is-active{
      width: 80%;
      left: -170px;
    }
  }
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
        margin-top: 50px;
        >img:first-of-type{
          margin-top: 20px;
          margin-bottom: 40px;
          transition: 0.5s;
          transform-origin: 50% 50%;  
          animation: rotate 10s linear infinite;
        }
      }
      &_right{
        width: 860px;
        flex: 0 1 auto;
        &_title{
          padding: 0 50px;
          // text-align: left;
          display: flex;
          align-items: center;
          margin-bottom: 30px;
          >div{flex: 1 0 auto;text-align: left;display: flex; align-items: center;font-size: 24px;color:#EAEAEA;
            >img{ margin-right: 20px;}
          }
        >i{flex: 0 1 auto; cursor: pointer;}
        }
        &_movie{
          display: inline-block;
          margin: 10px 30px;
          font-size: 18px;
          width: 154px;
          height: 255px;
          >span{
            color: #EAEAEA;
            cursor: pointer;
          }
          >img{display: block;cursor: pointer;margin-bottom: 10px;}
        }
      }
    }
    &_buttom{
      text-align: right;
      height: 50px;
      background: url('../../assets/images/homepage/fullsizerender(17).png') no-repeat;
      background-position: right bottom;
      >span{
        display: inline-block;
        margin-right: 160px;
        margin-top: 7px;
        color: #CFF9FE;
        cursor: pointer;
      }
    }
  }
}
</style>

