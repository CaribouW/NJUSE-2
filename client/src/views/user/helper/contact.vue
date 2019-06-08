<template>
    <div class="contact">
      <div class="contact_header">  
          <b>联系我们</b>         
      </div>
      <div class="contact_body">
        <div class="children_header">
            <span style="font-size:16px;color:#CFF9FE;">
                <img src="@/assets/images/preferentialpolicy/git-copy.png" alt="" style="width:25px;height:25px;">
                Github
            </span><br/>
            <div class="children_body">
                <span> <el-link href="https://github.com/1071956678lfm/NJUSE-2" target="_blank" style="color:#fff;">
                https://github.com/1071956678lfm/NJUSE-2</el-link></span><br/>
            </div>
        </div>
      </div>
    </div>
</template>

<script>
import user from "../index.vue"
export default {
  name: 'contact',
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
.contact{
  padding: 10px 10px 20px 10px;
  &_rectangle{
    background: url('../../../assets/images/homepage/Assets.png') no-repeat;
    background-size: 100% 100%;
    height: 790px;
    margin-bottom: 50px ;  }  
}
.contact_header{
    font-size: 30px;
    text-align: left;
    margin-bottom: 10px;
}
.contact_body{
    text-align: left;
    font-size: 14px;
}
// .children_body,.student_body,.other_body,.vip_body{
//     margin: 6px 0 15px 35px;
// }
</style>
