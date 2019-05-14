<template>
  <div class="footer">
    <div class="footer_left">
      <img src="@/assets/images/footer/{5C52A913-CCB9-6A3B-A07F-40653AF2D82D}.png" alt="">
      
    </div>
    <img src="@/assets/images/footer/Line 9.png" alt="">
    <div class="footer_center">
      <span>NULL N NONE影院</span><br/>
      <span>公司地址：北京市朝阳区建国路93号</span><br/>
      <span>影城全国客服热线：400-080-6060</span><br/>
      <span>影城全国投诉电话：400-009-5066</span><br/>
      <span>集团服务监督电话：400-950-6666</span>
      
    </div>
    <img src="@/assets/images/footer/Line 9.png" alt="">
    <div class="footer_right">
      <img src="@/assets/images/footer/Bitmap.png" alt=""><br/>
      影院公众号
    </div>
  </div>
</template>

<script>
export default {
}
</script>

<style lang="scss">
.footer{
  // height: 100px;
  font-size: 18px;
  display: flex;
  align-items: center;
  &_left{
    flex: 1 1 auto;
  }
  &_center{
    flex: 1 1 auto;
    >span{
      color: #FFFFFF;
    }
    >span:first-of-type{
      color: #CFF9FE;
      font-size: 24px;
    }
  }
  &_right{
    flex: 1 1 auto;
    color: #CFF9FE;
  }
}
</style>
