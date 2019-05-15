<template>
  <div class="homepage">
    <div class="homepage_poster">
      yyp弟弟做不出一模一样的我就是一刀( ￣ ▽￣)o╭╯☆#╰ _─﹏─)╯
      <el-carousel :interval="4000" type="card" height="400px" :autoplay="false" indicator-position="none"> 
        <el-carousel-item v-for="item in 6" :key="item">
          <h3 class="medium">{{ item }}</h3>
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
            <img src="@/assets/images/homepage/161905.30186585_1000 copy.png" alt="">
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
    .el-carousel__item h3 {
      color: #475669;
      font-size: 14px;
      opacity: 0.75;
      line-height: 400px;
      margin: 0;
    }
    .el-carousel__item:nth-child(2n) {
      background-color: #99a9bf;
    }
    
    .el-carousel__item:nth-child(2n+1) {
      background-color: #d3dce6;
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
          margin-bottom: 60px;
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
          >span{
            color: #EAEAEA;
          }
          >img{display: block;}
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

