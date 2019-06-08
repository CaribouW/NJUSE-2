<template>
    <div class="preferential">
      <div class="preferential_header">  
          <b>优惠政策</b>         
      </div>
      <div class="preferential_body">
        <div class="children_header">
            <span style="font-size:16px;color:#CFF9FE;">
                <img src="@/assets/images/preferentialpolicy/ertong.png" alt="" style="width:30px;height:30px;">
                儿童优惠
            </span><br/>
            <div class="children_body">
                <span>1.如您在影城携1.3米（含）以下儿童观影，儿童可免费无座观影（VIP/IMAX等特殊影厅除外），
                    一名成人限携一名1.3米（含）以下儿童入场；超出数量的儿童和身高超过1.3米（含）的儿童，需要购票入场</span><br/>
                <span>2.观看特殊影片（VIP/IMAX等特殊影厅）时，身高超过1.3米（含）的儿童也需要购票入场</span><br/>
                <span>3.身高不足1.3米的儿童需具有完全民事行为能力的成年人陪同方能观看，陪同观影的成年人应
                    充分尽到对所陪同儿童的安全等照管义务，以免发生意外。</span><br/>
                <span>4.1.3米（含）以下儿童观看3D影片均有儿童3D眼镜提供。</span>
            </div>
        </div>
      <div class="student_header">
            <span style="font-size:16px;color:#CFF9FE;">
                <img src="@/assets/images/preferentialpolicy/xuesheng.png" alt="" style="width:30px;height:27px;">
                学生优惠
            </span><br/>
            <div class="children_body">
                <span>持全日制本科（含）以下的学生证，可享2D影片5-8折优惠（仅限在柜台购买）。</span><br/>
            </div>
        </div>
        <div class="other_header">
            <span style="font-size:16px;color:#CFF9FE;">
                <img src="@/assets/images/preferentialpolicy/zhengjian.png" alt="" style="width:30px;height:30px;">
                其他持证优惠
            </span><br/>
            <div class="other_body">
                <span>老年证、教师证、军官证、残疾人证，可享2D影片5-8折优惠（仅限在柜台购买）。</span><br/>
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
        <p>* 以上优惠不享受折上折</p>
      </div>
    </div>
</template>

<script>
import user from "../index.vue"
export default {
  name: 'preferential',
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
.preferential{
  padding: 10px 10px 20px 10px;
  &_rectangle{
    background: url('../../../assets/images/homepage/Assets.png') no-repeat;
    background-size: 100% 100%;
    height: 790px;
    margin-bottom: 50px ;  }  
}
.preferential_header{
    font-size: 30px;
    text-align: left;
    margin-bottom: 10px;
}
.preferential_body{
    text-align: left;
    font-size: 14px;
}
.children_body,.student_body,.other_body,.vip_body{
    margin: 6px 0 15px 35px;
}
</style>
