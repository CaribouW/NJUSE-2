<template>
  <div class="history">
    <div class="cards" v-for="order in data_getHistory_sorted" :key="order.order.orderId">
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
    data() {
      return {
        tabPosition: 'left',
        refundVisible: false,
        // activeNames: ['1'],//标记是否打开页面时默认展开
        orderId: '',
        data_getHistory: [],
      }
    },

    /**
     * 页面加载之前获取数据
     */
    created: function () {
      this.updateHistoryList()

    },
    computed: {
      data_getHistory_sorted: function(){
        return this.data_getHistory.sort(this.orderSort)
      }
    },
    methods: {
      updateHistoryList: function () {
        this.$store.dispatch('getHistory', sessionStorage.getItem('userId')).then(res => {
          this.data_getHistory = res.orderList
        });
      },
      orderSort: function(a,b){
        var time1 = new Date(a.slot.startTime)
        var time2 = new Date(b.slot.startTime)
        if (time1<=time2){
          return 1
        }else{
          return -1
        }
      }


    }
  }
</script>


<style lang="scss">
  ::-webkit-scrollbar { /*滚动条整体样式*/
    width: 5px; /*高宽分别对应横竖滚动条的尺寸*/
  }

  ::-webkit-scrollbar-thumb { /*滚动条里面小方块*/
    border-radius: 10px;
    -webkit-box-shadow: inset 0 0 5px #CFF9FE;;
    background: #535353;
  }
  .history {

    padding: 10px 10px 20px 10px;

    &_rectangle {
      background: url('../../assets/images/homepage/Assets.png') no-repeat;
      background-size: 100% 100%;
      height: 790px;
      margin-bottom: 50px;
    }

  }
</style>


