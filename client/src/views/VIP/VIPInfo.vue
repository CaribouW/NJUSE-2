<template>
        <div class="VIPInfo">
            <div class="info_header">  
                <b>会员信息</b>         
            </div>
            <div class="info_body">
                <p class="info_level">会员等级：黄金会员</p>
                <p class="info_balance">会员卡余额：¥ 1000</p>
                <div class="record">
                    <div class="divider"></div>
                </div>
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
        }
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
