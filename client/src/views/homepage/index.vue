<template>
  <div class="homepage">
    <div class="homepage_poster">
      <el-carousel :interval="4000" type="card" height="400px" indicator-position="none">
        <el-carousel-item v-for="item in posters" :key="item.index">
          <img :src="item.url" alt="" @click="selectMovie(item.id)">
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
          <subCircle class="subCircle" @getMovieNotify="getMovie"></subCircle>
<!--          <ul>-->
<!--            <li v-for="item in type" :key="item.index" :class="{selectedType:item.isSelected}" @click="getMovie(item)">-->
<!--              {{item.text}}-->
<!--            </li>-->
<!--          </ul>-->
<!--          <img src="@/assets/images/homepage/fullsizerender(16).png" alt=""><br/>-->
<!--          <img src="@/assets/images/homepage/GO！GET A MOVIE.png" alt="">-->
        </div>
        <div class="homepage_movie_middle_right">
          <div class="homepage_movie_middle_right_title">
            <div><img src="@/assets/images/homepage/fullsizerender(6).png" alt="">{{selected}}</div>
            <i class="el-icon-d-arrow-right" @click="changePage()"></i>
          </div>
          <div class="homepage_movie_middle_right_movie" v-for="movie in showedMovie" :key="movie.movieId">
            <img :src="movie.poster" alt="" @click="selectMovie(movie.movieId)">
            <span>{{movie.name}}</span>
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
  import $ from 'jquery'
  import subCircle from "../../components/circle";
  export default {
    components: {subCircle},
    data() {
      return {
        movieList: [],
        random: Math.floor(Math.random()*92),
        posters: [
          {index: 0, url: require('@/assets/images/test/pictest0.jpg')},
          {index: 1, url: require('@/assets/images/test/pictest1.jpg')},
          {index: 2, url: require('@/assets/images/test/pictest2.jpg')},
          {index: 3, url: require('@/assets/images/test/pictest3.jpg')}
        ],
        selected: '正在热映'
      }
    },
    computed: {
      showedMovie: function () {
        return this.movieList.slice(this.random, this.random+8)
      }
    },
    methods: {
      // 正在热映和即将上映
      getMovie(tag) {
        switch (tag) {
          case '正在热映':
            this.selected = '正在热映'
            this.random = Math.floor(Math.random()*92);
            break;
          case '即将上映':
            this.selected = '即将上映'
            this.random = Math.floor(Math.random()*92);
            break;
          default:
            break;
        }
      },
      getRandomMovie() {

      },
      goMovieList() {
        this.$router.push('/movielist')
        $("#test li:eq(1)").click()
      },
      changePage() {
        // 翻页
      },
      selectMovie(id) {
        if (sessionStorage.getItem('userId')) {
          this.$router.push({
            path: '/movie/detail',
            query: {
              movieId: id
            }
          })
        } else {
          this.$message.error('请先登录')
          this.$router.push('/login')
        }
        
      },
    },
    mounted () {
      this.$store.dispatch('getAllMovie').then(res => {
        this.movieList = res
      })
    }
  }
</script>


<style lang="scss">
  .homepage {
    padding: 29px 50px 50px 50px;

    &_poster {
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

      .is-active {
        width: 80%;
        left: -170px;
      }
    }

    &_movie {
      &_top {
        color: #CFF9FE;
        font-size: 48px;
        margin-bottom: 30px;
      }

      &_middle {
        display: flex;

        &_left {
          flex: 1 1 auto;
          margin-top: 50px;

          .subCircle {
            margin-top: 43%;
            margin-right: 10%;
          }

          li {
            cursor: pointer;
            margin-top: 20px;
            color: #CFF9FE;
          }

          > img:first-of-type {
            margin-top: 20px;
            margin-bottom: 40px;
            border-radius: 150px;
            transform-origin: 50% 50%;
            animation: rotate 10s linear infinite;
          }

          > img:first-of-type:hover {
            animation-play-state: paused;
          }
        }

        &_right {
          width: 860px;
          flex: 0 1 auto;

          &_title {
            padding: 0 50px;
            // text-align: left;
            display: flex;
            align-items: center;
            margin-bottom: 30px;

            > div {
              flex: 1 0 auto;
              text-align: left;
              display: flex;
              align-items: center;
              font-size: 24px;
              color: #CFF9FE;

              > img {
                margin-right: 20px;
              }
            }

            > i {
              flex: 0 1 auto;
              cursor: pointer;
            }
          }

          &_movie {
            display: inline-block;
            margin: 10px 30px;
            font-size: 18px;
            width: 154px;
            height: 255px;

            > span {
              color: #EAEAEA;
              cursor: pointer;
            }

            > img {
              display: block;
              width: 138px;
              height: 187px;
              cursor: pointer;
              margin-bottom: 10px;
            }
          }
        }
      }

      &_buttom {
        text-align: right;
        height: 50px;
        background: url('../../assets/images/homepage/fullsizerender(17).png') no-repeat;
        background-position: right bottom;

        > span {
          display: inline-block;
          margin-right: 160px;
          margin-top: 7px;
          color: #CFF9FE;
          cursor: pointer;
        }
      }
    }
  }

  .selectedType {
    color: #CDED02 !important;
  }
</style>

