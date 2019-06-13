<template>
        <div class="buyCard">
            <div class="card_header">  
                <b>会员注册</b>         
            </div>
            <div class="card_body">
                <div class="hint">
                    <p>您当前还不是会员！ 点击购买会员卡</p>
                </div>
                <div class="card">
                    <img src="@/assets/images/vip/34A5E5AE-3165-47C0-977E-B540DE3067DE.png" alt="" style="width:320px;height:200px;">
                    <p>¥300/张</p>
                </div>
                <div class="card_button">
                    <el-button round style="color:#CFF9FE;">购买</el-button>
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
.buyCard{
  padding: 10px 10px 10px 20px;
  &_rectangle{
    background: url('../../assets/images/homepage/Assets.png') no-repeat;
    background-size: 100% 100%;
    height: 790px;
    margin-bottom: 50px ;
  }
  .el-button{
    margin-top: 20px;
    border-radius: 25px;
    padding: 8px 65px;
    background-color: rgba($color: #131C1C, $alpha: 0.5);
    font-size: 20px;
    color: #CFF9FE;
    border-color: #CFF9FE;
    width:35%
}
}
.card_header{
    font-size: 30px;
    text-align: left;
    margin-bottom: 10px;
}
.hint{
    margin-top:50px;
}



</style>
