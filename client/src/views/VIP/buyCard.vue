<template>
    <vip_aside>
        <div class="buyCard">

        </div>
    </vip_aside>
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
}


</style>
