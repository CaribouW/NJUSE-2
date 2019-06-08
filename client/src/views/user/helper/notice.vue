<template>
    <div class="notice">
      <div class="notice_header">  
          <b>观影须知</b>         
      </div>
      <img src="@/assets/images/preferentialpolicy/39D3279D-FF59-43E1-8203-8B21429B4AE4.png" alt="" style="width:650px;height:300px;">
      <div class="notice_body">
        <div class="law_header">
            <span style="font-size:16px;color:#CFF9FE;">
                <img src="@/assets/images/preferentialpolicy/falv.png" alt="" style="width:30px;height:30px;">
                法律条款
            </span><br/>
            <div class="law_body">
                <span>1.NULL N NONE影院保留直接修改或终止积分奖励计划的权利，且拥有会员卡的所有权。</span><br/>
                <span>2.NULL N NONE影院禁止一切积分买卖行为，否则后果自负</span><br/>
                <span>3.如因会员个人原因造成个人账户密码丢失，导致积分被盗用等后果，NULL N NONE影院将不负任何责任。</span><br/>
                <span>4.所有会员的个人资料均按NULL N NONE影院资料隐私制度进行管理。</span>
            </div>
        </div>
      </div>
    </div>
</template>

<script>
import user from "../index.vue"
export default {
  name: 'notice',
  components: {
    user,
  },
  data () {
    return {
      tabPosition: 'left'
    }
  },
  methods: {
  }
}
</script>


<style lang="scss">
.notice{
  padding: 10px 10px 20px 10px;
  &_rectangle{
    background: url('../../../assets/images/homepage/Assets.png') no-repeat;
    background-size: 100% 100%;
    height: 790px;
    margin-bottom: 50px ;  }  
}
.notice_header{
    font-size: 30px;
    text-align: left;
    margin-bottom: 10px;
}
.notice_body{
    text-align: left;
    font-size: 14px;
}
.law_body{
    margin: 6px 0 15px 35px;
}
</style>
