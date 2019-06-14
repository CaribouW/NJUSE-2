<template>
    <div class="coupon">
      <div class="vip_coupon">  
        <span>
          <img src="@/assets/images/header/fullsizerender(4).png" alt="" style="width:22px;height:31px;">
          会员优惠券
        </span><br/>
        <div class="coupon_pattern" v-for="coupon in coupons" :key="coupon.couponId">
          <div class="couponCard">
            <div class="coupon_info">
              <b>{{coupon.couponName}} </b>  
              <b>  -{{coupon.couponAmount}}</b><br/>  
              <span>最低使用金额:{{coupon.useCondtion}}</span><br/>
              <span style="font-size:12px;">{{coupon.startDate}} ～ {{coupon.endDate}}</span>
            </div>
              <el-button round >立即使用</el-button>
        </div>
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
        width: 300px;
        height: 90px;
        margin: 10px;

      .coupon_info{
        margin-left: 15px;
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
    margin-top: 22px;
    padding: 8px 208px;
    background-color: transparent;
    font-size: 16px;
    color: #ffffff;
    border: 0
  }
}
</style>

