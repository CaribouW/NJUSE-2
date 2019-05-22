<template>
  <div class="movielist">
    <div class="movielist_sift">
      <div v-for="items in siftlist">
        <el-radio-group v-model="items.label" size="mini">
          <el-radio-button :label="each" v-for="each in items.select" :key="items.select.index"></el-radio-button>
        </el-radio-group>
      </div>
    </div>
    <div class="movielist_movie">
      <div class="movielist_movie_title">
        <img src="@/assets/images/homepage/dianying.png" alt="">
        MOVIE
      </div>
      <div class="movielist_movie_list">
        <div class="movielist_movie_list_each" v-for='i in 6'>
          <img src="@/assets/images/movielist/161905.30186585_1000 copy.png" alt="">
          <div>
            <span>头号玩家</span><span>9.1分</span><br>
          </div> 
          <span>简介</span>
        </div>
      </div>
    </div>
    <div class="movielist_page">
      <el-pagination
        :page-size="20"
        :pager-count="11"
        layout="prev, pager, next"
        :total="1000">
      </el-pagination>
    </div>
  </div>
</template>

<script>
export default {
  data () {
    return {
      siftlist: [
        {label: '综合排序', select: ['综合排序','票房榜','新上线'], sort: ''},
        {label: '全部地区', select: ['全部地区','内地','香港地区', '美国', '欧洲', '日韩', '泰国', '印度', '其他'], location: ''},
        {label: '全部类型', select: ['全部类型','喜剧','爱情', '动作', '犯罪', '惊悚', '悬疑', '动画', '奇幻', '魔幻'], selected: ''},
        {label: '全部规格', select: ['全部规格','3D','IMAX', '杜比音效', '曲面巨幕', '4K', '亲自影厅'], selected: ''},
        {label: '全部状态', select: ['全部状态','正在热映','即将上映'], selected: ''}
      ]
    }
  }
}
</script>


<style lang="scss">
.movielist{
  &_sift{
    margin-top: 40px;
    background: url('../../assets/images/homepage/Assets.png') no-repeat;
    background-size: 100% 100%;
    height: fit-content;
    box-sizing: border-box;
    padding: 30px 70px 30px 70px;
    text-align: left;
    margin-bottom: 30px;
    .el-radio-button__inner{
      border: none;
      font-size: 16px;
      background-color: #201f1d;
      border-color: #201f1d;
      color: white;
    }
    .el-radio-button__orig-radio:checked+.el-radio-button__inner{background-color: #201f1d;box-shadow: none;-webkit-box-shadow: none;color: #CFF9FE;}
    .el-radio-button:first-child .el-radio-button__inner{border: none;}
  }
  &_movie{
    &_title{color: #CFF9FE;
      font-size: 48px;
      // margin-bottom: 20px;
      }
    &_list{
      text-align: center;
      padding: 0 auto;
      &_each{
        display: inline-block;
        padding: 20px 20px;
        color: white;
        >img{width: 180px;height: 250px;display: block;}
        >div{
          display: flex;
          background-color: #343331;
          >span{
            text-align: left;
            flex: 1 1 auto;
            
          }
          >span:last-of-type{text-align: right;}
        }
        >span{display: block;
            background-color: #343331;}
      }
    }
  }
  &_page {
    margin: 30px 0;
    .el-pagination{
      color: white;
      li{background-color: #201f1d;font-size: 16px;}
      button{background-color: #201f1d;}
    }
  }
}
</style>
