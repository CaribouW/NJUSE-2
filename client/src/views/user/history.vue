<template>
    <div class="history">
      <div class="cards" v-for="order in data_getHistory" :key="order.order.orderId">
        <history_card :cardMsg="order"></history_card>
      </div>
    </div>
</template>
 
<script>
import user from "./index.vue"
import history_card from "./historyCard.vue"
export default {
  name: 'history',
  components: { 
    user,
    history_card,
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
      this.updateHistoryList()
      
  },

  methods: {
    updateHistoryList:function(){
      this.$store.dispatch('getHistory', sessionStorage.getItem('userId')).then(res => {
        this.data_getHistory=res.orderList
        console.log(this.data_getHistory)
      });
    }


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

}
</style>


