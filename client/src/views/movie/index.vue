<template>
  <div class="movie">
    <div class="movie_poster">
      <img src="@/assets/images/movie\海王.png" alt="@/assets/images/movie\海王.png">
    </div>
    <div class="movie_info">
      <div class="movie_info_head">
        <img src="@/assets/images/homepage/dianying.png" alt="">
        DETAILS
      </div>
      <div class="movie_info_content">
         <el-tabs tab-position="left">
          <el-tab-pane label="信息">
            <div class="movie_info_content_briefIntro"><span>电影简介</span>
            《海王》是由美国华纳兄弟影片公司出品的动作奇幻片，由华裔导演温子仁执导，
杰森·莫玛、艾梅柏·希尔德、帕特里克·威尔森、叶海亚·阿卜杜勒-迈丁、妮可·基德曼、
威廉·达福、杜夫·龙格尔联合主演。《海王》根据DC漫画改编，讲述了半人半亚特兰蒂
斯血统的亚瑟·库瑞踏上永生难忘的征途——他不但需要直面自己的特殊身世，更不得不
面对生而为王的考验，以及和湄拉一同对抗同母异父的兄弟奥姆的故事。</div>
            <img src="@/assets/images/movie\timg.png" alt="">
            <div>
              <span class="basicInfo_title">基本信息</span>
              <div class="movie_info_content_basicInfo">
                <div>中文名</div><div>{{movieInfo.ChineseName}}</div><div>类型</div><div>{{movieInfo.type}}</div>
              </div>
              <div class="movie_info_content_basicInfo">
                <div>英文名</div><div>{{movieInfo.EnglishName}}</div><div>片长</div><div>{{movieInfo.duration}}分钟</div>
              </div>
              <div class="movie_info_content_basicInfo">
                <div>出品公司</div><div>{{movieInfo.productionCompany}}</div><div>上映时间</div><div>{{movieInfo.showTime}}</div>
              </div>
              <div class="movie_info_content_basicInfo">
                <div>发行公司</div><div>{{movieInfo.distributionCompany}}</div><div>导演</div><div>{{movieInfo.director}}</div>
              </div>
              <div class="movie_info_content_basicInfo">
                <div>语言</div><div>{{movieInfo.language}}</div><div>imdb编码</div><div>{{movieInfo.imdb}}</div>
              </div>
            </div>
          </el-tab-pane>
          <el-tab-pane label="演职人员">演职人员</el-tab-pane>
          <el-tab-pane label="视频和剧照">视频和剧照</el-tab-pane>
          <el-tab-pane label="票房">票房</el-tab-pane>
        </el-tabs>
      </div>
    </div>
  </div>
</template>


<script>
export default {
  data () {
    return {
      movieInfo: {
        ChineseName: '海王',type:'科幻/动作',
        EnglishName: 'Aquaman',duration: '143',
        productionCompany: '华纳',showTime: '2018-12-7',
        distributionCompany: '华纳',director: '温子仁',
        language: '英语', imdb: 'tt1477834'
      }
    }
  }
}
</script>

<style lang="scss">
.movie{
  &_poster{
    background: url('../../assets/images/movie/Assets.png') no-repeat;
    background-size: 100% 100%;
    margin: 20px 0;
    padding-bottom: 40px;
    // height: 400px;
    >img{}
  }
  &_info{
    &_head{
      color: #CFF9FE;
      font-size: 48px;
      margin-bottom: 30px;
    }
    &_content{
      .el-tabs__item{
        height: 100px;
        line-height: 100px;
        color: #CFF9FE;
        &:hover{color: #00adff;}
        &.is-active{color: #00adff;}
      }
      .el-tabs__content{text-align: left;}
      .el-tabs__header{margin-right: 100px!important;}
      &_briefIntro{
        text-align: left;
        width: 700px;
        font-size: 18px;
        display: inline-block;
        vertical-align: top;
        >span{color:#CFF9FE; font-size: 28px;display: block;margin-bottom: 30px;}
      }
      &_basicInfo{
        border-bottom: #979797 solid 1px;
        height: 30px;
        width: 800px;
        padding: 0 20px;
        box-sizing: border-box;
        >div{display: inline-block;}
        >div:nth-of-type(odd){
          color: #CFF9FE;
          width: 100px;
        }
        >div:nth-of-type(even){
          width: 400px;
        }
        >div:last-of-type{
          width: 150px;
        }
      }
      .basicInfo_title{color:#CFF9FE; font-size: 28px;display: block;margin-bottom: 30px;}
      img{
        width: 170px;
        height: 255px;
        display: inline-block;
        vertical-align: top;
        margin-left: 50px;
      }
    }
  }
}
</style>
