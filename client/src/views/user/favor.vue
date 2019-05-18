<template>
  <user>
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
                        <el-dropdown-item>按标记时间排序</el-dropdown-item>
                    </el-dropdown-menu>
                    </el-dropdown>
              </div>
              </el-col>
          </el-row>
      </div>
      <el-divider></el-divider>
      <div class="favor_movies">
        
      </div>
    </div>
  </user>
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
  .el-divider{
    color: #979797;
    margin: 7px;
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
    li{
      background-color: #131C1C;
    }
  }
  .el-dropdown-item{
      color: #fff;
  }
}
.el-popper{
  background-color: #131C1C;
}
.el-dropdown-menu__item{
  color: #ffffff;
}
</style>


