<template>
    <div class="favor">
      <div class="favor_header">  
        <el-row>
            <el-col :span="12">
              <div class="grid-content bg-purple">
                共10部影片
              </div>
            </el-col>
            <el-col :span="12">
              <div class="grid-content bg-purple-light">
                <el-dropdown>
                    <span class="el-dropdown-link">
                        按上映时间<i class="el-icon-arrow-down el-icon--right"></i>
                    </span>
                    <el-dropdown-menu slot="dropdown">
                        <el-dropdown-item>按上映时间排序</el-dropdown-item>
                        <el-divider></el-divider>
                        <el-dropdown-item>按标记时间排序</el-dropdown-item>
                    </el-dropdown-menu>
                  </el-dropdown>
              </div>
              </el-col>
          </el-row>
      </div>

      <div class="favor_movies">
        <div class="favor_date">
          <el-row>
            <el-col :span="24"><div class="grid-content bg-purple2">2019-05-19 周日</div></el-col>
          </el-row>
        </div>
        <div class="favor_details">
          <el-row>
            <el-col :span="4">
              <div class="grid-content bg-purple3">
                <img src="@/assets/images/movielist/161905.30186585_1000 copy.png" alt="" style="width:72px;height:109px;">
              </div>
            </el-col>
            <el-col :span="12">
              <div class="grid-content bg-purple-light3">
                <span style="color:#CFF9FE;font-size:20px;"><b>海王</b> </span><br/>
                <span>豆瓣评分：9.1</span><br/>
                <span>主演名</span><br/>
                <span>2019-05-01 在中国大陆上映</span>
              </div>
            </el-col>
            <el-col :span="8">
              <div class="grid-content bg-purple4">
                <el-button round disabled>即将上映</el-button>
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
      tabPosition: 'left'
    }
  },
  methods: {
  }
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
  .row-bg {
    padding: 10px 0;
    background-color: #f9fafc;
  }
  .el-dropdown-link {
    cursor: pointer;
    color: #ffffff;
  }
  .el-icon-arrow-down {
    font-size: 15px;
  }
  .el-dropdown-menu{
    background-color: #131C1C;
    border: #ffffff;
  }
  .el-dropdown-item{
      color: #fff;
  }
}
.el-popper{
  background-color: #131C1C;
  padding: 0;
}
.el-dropdown-menu__item{
  color: #ffffff;
  padding: 0 10px 0 10px;
  
}
.el-divider--horizontal{
  margin: 1px;
}
.favor_date{
  margin-top: 5px;
  height: 40px;
  background-color: rgba($color: #d8d8d8, $alpha: 0.05);
}
.bg-purple2  {
  padding-left: 20px;
  padding-top: 10px;
  text-align: left;
  margin-bottom: 10px;
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
.el-button.is-disabled{
  margin-top: 20px;
  border-radius: 25px;
  padding: 8px 20px;
  background-color: rgba($color: #131C1C, $alpha: 0.5);
  font-size: 16px;
  color: #ffffff;
  border-color: #CFF9FE
}
</style>


