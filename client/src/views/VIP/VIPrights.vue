<template>
        <div class="VIPrights">
            <div class="rights_header">  
                <b>会员权益</b>         
            </div>
            <div class="rights_body">
                <div class="credit_header">
                    <span style="font-size:16px;color:#CFF9FE;">
                        <img src="@/assets/images/vip/jifen.png" alt="" style="width:30px;height:30px;">
                        积分相关
                    </span><br/>
                    <div class="credit_body">
                        <span>1.影院会员卡积分为消费积分。每消费一元积一分。</span><br/>
                        <span>2.会员卡积分只针对使用会员卡余额购买电影票，其他付款方式不能积分。</span><br/>
                        <span>3.若使用优惠券购买电影票，按照实际支付金额累计积分。</span>
                    </div>
                </div>
                <div class="level_header">
                    <span style="font-size:16px;color:#CFF9FE;">
                        <img src="@/assets/images/vip/dengji.png" alt="" style="width:30px;height:30px;">
                        会员等级划分
                    </span><br/>
                    <div class="credit_body">
                        <span>1.青铜会员：成功购买一张价值300元的影院会员卡即可成为青铜会员。</span><br/>
                        <span>2.白银会员：消费金额累计至500即可成为白银会员。</span><br/>
                        <span>3.黄金会员：消费金额累计至1000即可成为黄金会员。</span>
                    </div>
                </div>
                <div class="vip_header">
                    <span style="font-size:16px;color:#CFF9FE;">
                        <img src="@/assets/images/preferentialpolicy/dianyingpiao.png" alt="" style="width:30px;height:25px;">
                        会员日
                    </span><br/>
                    <div class="vip_body">
                        <span>会员可在会员日凭特殊会员优惠券半价购买电影票。</span><br/>
                    </div>
                </div>
            </div>
        </div>
</template>

<script>
export default {
    name:"VIPrights",
    data(){
        return{
            tabPosition:'left',
        }
    }

}
</script>

<style lang='scss'>
.VIPrights{
  padding: 10px 10px 10px 20px;
  &_rectangle{
    background: url('../../assets/images/homepage/Assets.png') no-repeat;
    background-size: 100% 100%;
    height: 790px;
    margin-bottom: 50px ;
  }
}
.rights_header{
    font-size: 30px;
    text-align: left;
    margin-bottom: 10px;
}
.rights_body{
    text-align: left;
    font-size: 14px;
}
.credit_body,.level_body,.vip_body{
    margin: 6px 0 15px 35px;
}

</style>
