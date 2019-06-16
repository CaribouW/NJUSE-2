<template>
    <div class="favor">
      <div class="favor_header">  
        <div class="grid-content bg-purple" style="font-size:20px;">
          <b>共标记 {{favorList.length}} 部影片为喜爱</b>
        </div>
      </div>
      <div class="favor_movies" v-for="favor in favorList" :key="favor.movieId">
        <div class="favor_details" >
          <el-row>
            <el-col :span="4">
              <div class="grid-content bg-purple3">
                <img :src="favor.imgURL" alt="" style="width:72px;height:109px;">
              </div>
            </el-col>
            <el-col :span="12">
              <div class="grid-content bg-purple-light3">
                <span style="color:#CFF9FE;font-size:20px;"><b>{{favor.movieName}}</b> </span><br/>
                <span>豆瓣评分：9.1</span><br/>
                <span>主演:{{favor.mainActor}}</span><br/>
                <span>{{favor.releaseDate}} 在{{favor.releaseArea}}上映</span>
              </div>
            </el-col>
            <el-col :span="8">
              <div class="favor_buttons" >
                <div v-if="favor.state=='立即购票'">
                  <el-button round @click="toBuy(favor.movieId)">{{favor.state}}</el-button>
                </div>
                <div v-else>
                  <el-button round disabled="">{{favor.state}}</el-button>
                </div>
              </div>
            </el-col>
          </el-row>
        </div>
      </div>
    </div>
</template>

<script>
import user from "./index.vue"
export default {
  name: 'favor',
  components: {
    user,
  },
  data () {
    return {
      tabPosition: 'left',
      favorList:[],
      state:'',
    }
  },
  methods: {
    updateFavorList:function(){
      this.$store.dispatch('getFavorList', sessionStorage.getItem('userId')).then(res => {
        this.favorList=res
        console.log(this.favorList)
        this.handleState()
      });
    },
    handleState:function(){
      for(let i=0;i<this.favorList.length;i++){
        if(this.favorList[i].releaseDate!=null){
          let date=new Date(this.favorList[i].releaseDate)
          let dateCurrent=new Date()
          if(date<dateCurrent){
            this.favorList[i].state="立即购票"
          }else{
            this.favorList[i].state="即将上映"
          }
        }else{
          this.favorList[i].state="立即购票"
        }
        
      }
    },
    toBuy:function(movieId){
      this.$router.push('../movie/detail?movieId='+movieId)
    }
  },
  /**
   * 页面加载之前获取数据
   */ 
  created: function () {
      this.updateFavorList()
      
  },
}
</script>


<style lang="scss">
.favor{
  padding: 10px 10px 20px 10px;
  &_rectangle{
    background: url('../../assets/images/homepage/Assets.png') no-repeat;
    background-size: 100% 100%;
    height: 790px;
    margin-bottom: 50px ;
}  
  .el-row {
  margin-bottom: 20px;
  &:last-child {
    margin-bottom: 0;
    }
  }
  .el-col {
    border-radius: 4px;
  }

  .bg-purple  {
    padding-left: 40px;
    text-align: left;
  }
  .bg-purple-light{
      padding-right: 40px;
      text-align: right;
  }
  .grid-content {
    min-height: 30px;
    font-size: 15px
  }
  .favor_details{
    border: #CFF9FE solid 1px;
    border-radius: 10px;
    padding:10px;
    margin-top:10px;
  }
  .el-button.is-disabled,.el-button{
  margin-top: 35px;
  border-radius: 25px;
  padding: 8px 20px;
  background-color: rgba($color: #131C1C, $alpha: 0.5);
  font-size: 16px;
  color: #ffffff;
  border-color: #CFF9FE
  }
}
.bg-purple3  {
  height: 110px;
  width: 110px;
}
.bg-purple-light3{
    padding-top: 8px;
    text-align: left;
}
.bg-purple4  {
  padding-top: 20px;
  padding-right: 0;
}
</style>


