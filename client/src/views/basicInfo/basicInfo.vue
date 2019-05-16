<template>
  <div class="homepage">
    <div class="homepage_poster">
      <el-container>
      <el-aside width="260px">Aside

      </el-aside>
      <el-main>
        <div class="main_portrait">  
          <img src="@/assets/images/homepage/personal-image.png" alt="" style="width: 100px;height:100px;">
          ID:1234567
        </div>
      </el-main>
    </el-container>
    </div>
  </div>
</template>

<script>
export default {
  data () {
    return {
    }
  },
  methods: {
  }
}
</script>


<style lang="scss">
.homepage{
  padding: 29px 50px 50px 50px;
  &_poster{
    background: url('../../assets/images/homepage/Assets.png') no-repeat;
    background-size: 100% 100%;
    height: 790px;
    margin-bottom: 50px ;
  }  
  .el-aside {
    background-color: #131C1C;
    color: #FFFFFF;
    // text-align: center;
    line-height: 565px;
  }
  
  .el-main {
    background-color: rgba($color: #131C1C, $alpha: 0.5);
    color: #FFFFFF;
    text-align: center;
    line-height: 565px;
  }
    &_portrait{
      height: 140px;
    }
  
  .el-container {
    margin-bottom: 40px;
    padding: 70px 150px 70px 130px
  }
  
  // .el-container:nth-child(5) .el-aside,
  // .el-container:nth-child(6) .el-aside {
  //   line-height: 360px;
  // }
  
  // .el-container:nth-child(7) .el-aside {
  //   line-height: 320px;
  // }
}
</style>

