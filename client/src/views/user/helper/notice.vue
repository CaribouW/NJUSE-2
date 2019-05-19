<template>
  <user>
    <div class="notice">
      <div class="notice_header">  
          <b>观影须知</b>         
      </div>
      <div class="notice_body">
        <div class="children_header">
            <img src="@/assets/images/preferentialpolicy/39D3279D-FF59-43E1-8203-8B21429B4AE4.png" alt="" style="width:650px;height:300px;">
        </div>
    </div>
    </div>
  </user>
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
// .children_body,.student_body,.other_body,.vip_body{
//     margin: 6px 0 15px 35px;
// }
</style>