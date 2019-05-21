<template>
  <user>
    <div class="history">
      <div class="success">
        <div class="success_header">
          <el-row>
            <el-col :span="20">
              <div class="grid-content bg-purple">
                <el-row style="margin-bottom:10px;">
                  <el-col :span="8">
                    <div class="success_name">
                      <b>海王</b>
                    </div>
                  </el-col>
                  <el-col :span="16">
                    <div class="success_counttime">
                      距离放映 1 天 23 小时 12 分钟
                    </div>
                  </el-col>
                </el-row>
                <div class="success_details">
                  <el-row style="font-size:14px;">
                    <el-col :span="8">
                      <div class="success_date">
                        今天 05-07
                      </div>
                    </el-col>
                    <el-col :span="8">
                      <div class="success_time">
                        10:10 ～ 13:11
                      </div>
                    </el-col>
                  </el-row>
                  <el-row style="font-size:14px;">
                    <el-col :span="10">
                      <div class="success_location">
                        中影国际影城南京仙林金鹰店
                      </div>
                    </el-col>
                    <el-col :span="8">
                      <div class="success_hall">
                        3号激光厅
                      </div>
                    </el-col>
                  </el-row>
                  <el-row style="font-size:14px;">
                    <el-col :span="8">
                      <div class="success_kind">
                        （普通3D）
                      </div>
                    </el-col>
                    <el-col :span="8">
                      <div class="success_seat">
                        8排6座 8排7座
                      </div>
                    </el-col>
                  </el-row>
                </div>
              </div>
            </el-col>
            <el-col :span="4">
              <div class="grid-content bg-purple-light">
                <img src="@/assets/images/movielist/161905.30186585_1000 copy.png" alt="" style="width:70px;height:100px;">
              </div>
              </el-col>
          </el-row>  
        </div>
        <div class="success_body">
          <p style="color: #CFF9FE;">取电影票</p>
          <el-row>
            <el-col :span="12">
              <div class="success_qrcode">
                <img src="@/assets/images/basicinfo/erweima.png" style="width:90px;height:90px;"><br/>
                 2张电影票
              </div>
            </el-col>
            <el-col :span="12">
              <div class="success_codes">
                <div class="code_number">
                  取票号：7777 77
                </div>
                <div class="code_verification">
                  验证码：8888 88
                </div>
              </div>
            </el-col>
          </el-row>
        </div>
        <div class="success_footer">
          <el-collapse v-model="activeNames" @change="handleChange">
            <el-collapse-item title="观影须知" name="1">
              <div>1、请预先购票，凭票入场,对号入座，并保留电影票；1.3米以下儿童观看3D电影需购票。</div>
              <div>2、请爱护影厅内的设施。</div>
              <div> 3、影厅内严禁吸烟、大声喧哗。</div>
              <div> 4、影厅内严禁录像、拍照。</div>
            </el-collapse-item>
          </el-collapse>
        </div>
      </div>
    </div>
  </user>
</template>

<script>
import user from "./index.vue"
export default {
  name: 'history',
  components: {
    user,
  },
  data () {
    return {
      tabPosition: 'left',
      // activeNames: ['1'],//标记是否打开页面时默认展开
    }
  },
  methods: {
    handleChange(val) {
        console.log(val);
      }
  }
}
</script>


<style lang="scss">
.history{
  padding: 10px 10px 20px 10px;
  &_rectangle{
    background: url('../../assets/images/homepage/Assets.png') no-repeat;
    background-size: 100% 100%;
    height: 790px;
    margin-bottom: 50px ;
  }  
.success{
  border:1px solid #CFF9FE;
  height: 475px; 
  border-radius: 15px;
  padding-left: 40px;
  text-align: left;
  width: 92%;
}
  .el-row {
    &:last-child {
      margin-bottom: 0;
    }
  }
  .el-col {
    border-radius: 4px;
  }
  .bg-purple {
    padding-top: 20px;
  }
  .bg-purple-light {
    padding-top: 25px;
  }
  .grid-content {
    border-radius: 4px;
    min-height: 36px;
    // margin-left:20px
  }
  .row-bg {
    padding: 10px 0;
    background-color: #f9fafc;
  }
  .success_counttime{
    font-size: 14px;
    color: #CFF9FE;
  }
  .success_details{
    text-align: left;
  }
  .success_header{
    border-bottom: 1px solid #979797;
    height: 135px;
    margin:0 30px 10px 0; 
  }
  .success_body{
    border-bottom: 1px solid #979797;
    height: 165px;
    margin:0 30px 10px 0; 
    font-size: 14px;
  }
  .code_number,.code_verification{
    border:1px solid #CFF9FE;
    text-align: center;
    height: 30px;
    width: 50%;
    margin-top:15px;
    padding-top:10px; 
  }
  .success_qrcode{
    padding: 15px 0 0 40px;
    text-align: center;
  }
  .el-collapse-item__arrow{
    margin-left: 5px;
  }
  .el-collapse-item__header{
    background-color: transparent;
    border: 0;
  }
  .el-collapse{
    border: 0;
  }
}
</style>


