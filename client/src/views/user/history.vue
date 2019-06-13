<template>
    <div class="history">
      <div class="cards" v-for="order in data_getHistory" :key="order.order.orderId">
        <historyCard :cardMsg="order"></historyCard>
      </div>
    </div>
</template>
 
<script>
import user from "./index.vue"
import historyCard from "./historyCard.vue"
export default {
  name: 'history',
  components: {
    user,
    historyCard,
  },
  data () {
    return {
      tabPosition: 'left',
      refundVisible: false,
      // activeNames: ['1'],//标记是否打开页面时默认展开
      orderId:'',
      data_getHistory:[],
    }
  },

  /**
   * 页面加载之前获取数据
   */
  created: function () {
    var that = this;
      console.log(sessionStorage.getItem('userId'))
      this.$store.dispatch('getHistory', sessionStorage.getItem('userId')).then(res => {
        this.data_getHistory=res.orderList
        console.log(this.data_getHistory)
      });
  },

  methods: {
    // handleChange(val) {
    //     console.log(val);
    //   },
    // //显示新的修改弹窗
    //   handleRefund: function () {
    //     this.refundVisible = true;
    //   },
    //   onSubmit: function () {
    //     var that = this;
    //   console.log(sessionStorage.getItem('userId'))
    //   this.$store.dispatch('refund', sessionStorage.getItem('userId'),orderId).then(res => {
    //     console.log(res)
    //   });
    //   }
  }
}
</script>


<style lang="scss">
.history{
  padding: 10px 10px 20px 10px;
  &_rectangle{
    background: url('../../assets/images/homepage/Assets.png') no-repeat;
    background-size: 100% 100%;
    height: 790px;
    margin-bottom: 50px ;
  }  
  .cards{

  }

}
</style>


