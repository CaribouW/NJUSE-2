<template>
  <user>
    <div class="coupon">
      <div class="vip_coupon">  
        <span>
          <img src="@/assets/images/header/fullsizerender(4).png" alt="" style="width:22px;height:31px;">
          会员优惠券
        </span><br/>
        <div class="coupon_pattern"> 
          <el-row>
            <el-col :span="12">
              <div class="grid-content bg-purple">
                <el-button round @click="goMovieList()">立即使用</el-button>
              </div>
            </el-col>
            <el-col :span="12">
              <div class="grid-content bg-purple-light">
                <el-button round >立即使用</el-button>
              </div>
              </el-col>
          </el-row>
        </div>
      </div>
      <el-divider></el-divider>
      <div class="normal_coupon">
        <span>
          <img src="@/assets/images/header/fullsizerender(4).png" alt="" style="width:22px;height:31px;">
          普通优惠券
        </span><br/>
        <div class="coupon_pattern"> 
          <el-row>
            <el-col :span="12">
              <div class="grid-content bg-purple">
                <el-button round >立即使用</el-button>
              </div>
            </el-col>
            <el-col :span="12">
              <div class="grid-content bg-purple-light">
                <el-button round >立即使用</el-button>
              </div>
              </el-col>
          </el-row>
          <!-- <el-scrollbar> -->
          <!--以下是要滚动的内容-->
          <!-- <div class="zy-main__box">
            <transition name="move" mode="out-in">
              <router-view></router-view>
            </transition>
          </div>
        </el-scrollbar> -->
          <!-- <div class="demo-image__lazy"> -->
            <!-- <el-image v-for="url in urls" :key="url" :src="url" lazy>

            </el-image> -->
          <!-- </div> -->
        </div>
      </div>
    </div>
  </user>
</template>

<script>
import user from "../user/index.vue"
export default {
  name: 'coupon',
  components: {
    user,
  },
  data () {
    return {
      tabPosition: 'left',
      urls: [
          'https://fuss10.elemecdn.com/a/3f/3302e58f9a181d2509f3dc0fa68b0jpeg.jpeg',
          'https://fuss10.elemecdn.com/1/34/19aa98b1fcb2781c4fba33d850549jpeg.jpeg',
          'https://fuss10.elemecdn.com/0/6f/e35ff375812e6b0020b6b4e8f9583jpeg.jpeg',
          'https://fuss10.elemecdn.com/9/bb/e27858e973f5d7d3904835f46abbdjpeg.jpeg',
          'https://fuss10.elemecdn.com/d/e6/c4d93a3805b3ce3f323f7974e6f78jpeg.jpeg',
          'https://fuss10.elemecdn.com/3/28/bbf893f792f03a54408b3b7a7ebf0jpeg.jpeg',
          'https://fuss10.elemecdn.com/2/11/6535bcfb26e4c79b48ddde44f4b6fjpeg.jpeg'
        ]
    }
  },
  methods: {
    goMovieList() {
      this.$router.push("/movielist")
    },
  }
}
</script>


<style lang="scss">
.coupon{
  padding: 10px 10px 10px 20px;
  &_rectangle{
    background: url('../../assets/images/homepage/Assets.png') no-repeat;
    background-size: 100% 100%;
    height: 790px;
    margin-bottom: 50px ;
  }  
  .vip_coupon {
    color: #FFFFFF;
    text-align: left;
    height: 240px;
    margin-bottom: 30px
  }
  
  .normal_coupon {
    color: #FFFFFF;
    // height: 565px;
    text-align: left;
  }
  .coupon_pattern{
    padding-top: 30px;
    padding-left: 50px;
  }
  .el-divider{
    color: #979797;
  }
  .el-row {
  margin-bottom: 20px;
  &:last-child {
    margin-bottom: 0;
    }
  }
  .el-col {
    border-radius: 4px;
  }
    .bg-purple-dark {
    background: #99a9bf;
  }
  .bg-purple,.bg-purple-light  {
    background-image: url('../../assets/images/coupon/coupon.png');
    background-repeat: no-repeat;
  }
  .grid-content {
    border-radius: 4px;
    min-height: 90px;
  }
  .row-bg {
    padding: 10px 0;
    background-color: #f9fafc;
  }
  .el-button{
    margin-top: 20px;
    padding: 8px 155px;
    background-color: transparent;
    font-size: 16px;
    color: #ffffff;
    border: 0
  }
}
</style>

