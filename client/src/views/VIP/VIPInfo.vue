<template>
        <div class="VIPInfo">
            <div class="info_header">  
                <b>会员信息</b>         
            </div>
            <div class="info_body">
                <p class="info_level">会员等级：黄金会员</p>
                <p class="info_balance">会员卡余额：¥ {{vipInfo.VIPCardBalance}}</p>
                <p>会员卡ID：{{vipInfo.VIPCardId}}</p>
                <div class="record">
                    <div class="divider"></div>
                </div>
                <el-button type="primary" round @click="rechargeVIP">充值</el-button>
            </div>
        </div>
</template>

<script>
import vip_aside from "../VIP/index.vue"
export default {
    name:"VIP",
    components:{
        vip_aside,
    },
    data(){
        return{
            tabPosition:'left',
            vipInfo: {}
        }
    },
    methods: {
      rechargeVIP () {
        this.$store.dispatch('rechargeVIP', {
          rechargeAmount: '100',
          VIPCardId: this.vipInfo.VIPCardId,
          rechargeTime: '2019-05-09 21:00'
        }).then(res => {
          if (res === 200) {
            this.$store.commit('recharge', 100)
            this.$message.success('充值成功')
          } else {
            this.$message.error('充值失败')
          }
        })
      }
    },
    mounted () {
      this.vipInfo = this.$store.state.member.basicInfo
      console.log(this.vipInfo)
    }

}
</script>

<style lang='scss'>
.VIPInfo{
  padding: 10px 10px 10px 20px;
  &_rectangle{
    background: url('../../assets/images/homepage/Assets.png') no-repeat;
    background-size: 100% 100%;
    height: 790px;
    margin-bottom: 50px ;
  }
}
.info_header{
    font-size: 30px;
    text-align: left;
    margin-bottom: 10px;
}
.divider{
    color: #ffffff;
    height: 1px;
}



</style>
