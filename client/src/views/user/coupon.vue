<template>
    <div class="coupon">
      <div class="vip_coupon">  
        <span>
          <img src="@/assets/images/header/fullsizerender(4).png" alt="" style="width:22px;height:31px;">
          会员优惠券
        </span><br/>
        <div class="coupon_pattern" v-for="coupon in coupons" :key="coupon.couponId">
          <el-row>
          <div class="couponCard" v-if="coupon.state==1">
            <el-col :span="12">
            <div class="coupon_info">
              <b>{{coupon.couponName}} </b>  
              <b>  -{{coupon.couponAmount}}</b><br/>  
              <span style="font-size:14px;">最低使用金额:{{coupon.useCondtion}}</span><br/>
              <span style="font-size:12px;">{{coupon.startDate}} ～ </span><br/>
              <span style="font-size:12px;">{{coupon.endDate}}</span>
            </div>
            </el-col>
            <el-col :span="1">
              <el-button round @click="goMovieList">立即使用</el-button>
              </el-col>
        </div>
        </el-row>
        </div>
      </div>
    </div>
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
      coupons:[],
    }
  },
  methods: {
    goMovieList() {
      this.$router.push("/movielist")
    },

  },
  /**
   * 页面加载之前获取数据
   */
  created: function () {
    console.log(sessionStorage.getItem('userId'))
    var that = this;
      this.$store.dispatch('getCoupon', sessionStorage.getItem('userId')).then(res => {
        this.coupons=res
        console.log(this.coupons)
        
      });
      
  },

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
  .couponCard{
        background-image: url('../../assets/images/coupon/coupon.png');
        background-repeat: no-repeat;
        background-size: 100%;
        width: 360px;
        height: 110px;
        margin: 10px;

      .coupon_info{
        margin-left: 25px;
        font-size: 16px;
        padding-top:5px;

        // width: 60%
        // margin-top: 5px;
      }
    }
  .vip_coupon {
    color: #FFFFFF;
    text-align: left;
    height: 240px;
    margin-bottom: 30px
  }

  .el-button{
    padding-top : 40px;
    padding-left: 78px;
    background-color: transparent;
    font-size: 16px;
    color: #ffffff;
    border: 0
  }
}
</style>

