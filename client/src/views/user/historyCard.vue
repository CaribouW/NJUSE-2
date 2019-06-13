
<template>
<historyCard>
    <div class="success">
        <div class="success_header">
          <el-row>
            <el-col :span="20">
              <div class="grid-content bg-purple">
                <el-row style="margin-bottom:10px;">
                  <el-col :span="8">
                    <div class="success_name">
                      <b>{{movie.name}}</b>
                    </div>
                  </el-col>
                  <el-col :span="16">
                    <div class="success_counttime">
                      {{timeSubtract(slot.startTime,order.confirmDate)}}
                    </div>
                  </el-col>
                </el-row>
                <div class="success_details">
                  <el-row style="font-size:14px;">
                    <el-col :span="16">
                      <div class="success_date">
                        {{dateFormat(slot.startTime)}} ～ {{dateFormat(slot.endTime)}}
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
                        {{hall.category}}
                      </div>
                    </el-col>
                  </el-row>
                  <el-row style="font-size:14px;">
                    <el-col :span="8">
                      <div class="success_kind">
                        影厅名：{{hall.name}}
                      </div>
                    </el-col>
                    <el-col :span="8">
                      <div class="success_seat">
                        <div class="tickets" v-for="ticket in tickets" :key="ticket.ticketId">
                          {{ticket.row}}排{{ticket.col}}座
                      </div>
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
                 {{tickets.length}}张电影票
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
          <el-row>
            <el-col :span="12"><div class="grid-content bg-purple" style="padding:0;">
              <el-collapse v-model="activeNames" @change="handleChange">
                <el-collapse-item title="观影须知" name="1">
                  <div>1、请预先购票，凭票入场,对号入座，并保留电影票；1.3米以下儿童观看3D电影需购票。</div>
                  <div>2、请爱护影厅内的设施。</div>
                  <div> 3、影厅内严禁吸烟、大声喧哗。</div>
                  <div> 4、影厅内严禁录像、拍照。</div>
                </el-collapse-item>
              </el-collapse>
            </div>
            </el-col>
            <el-col :span="12">
              <div class="success_footer_right">
                <div class="success_total">
                共{{tickets.length}}张   合计：¥{{slot.ticketPrize*tickets.length}}.00
                </div>
                <div class="buttons" style="padding-top:5px;">
                  <el-button round @click="handleRefund(order.orderId)">退票</el-button>
                  <el-dialog
                    :visible.sync="refundVisible"
                    :modal-append-to-body='false'
                    title="影厅信息"
                    top="20vh"
                    width="40%"
                    class="refund-dialog"
                  >
                    <div class="refund_main">
                      <el-form>
                        <el-form-item label="">
                          <span>当前已购票 {{mintues}} 分钟,退还比例为 {{percent}}% ,共计 {{total}} 元。是否确认退票？</span>
                        </el-form-item>
                        <el-form-item>
                          <el-button type="primary" @click="onSubmit(order.orderId)">退票</el-button>
                          <el-button @click="onCancel">取消</el-button>
                        </el-form-item>
                      </el-form>
                    </div>
                  </el-dialog>
                </div>
              </div>
            </el-col>
          </el-row>
        </div> 
      </div>
</historyCard>
</template>

<script>
export default {
  props: {
    cardMsg: null,

  },
  data(){
    return{
      movie:this.cardMsg.movie,
      hall:this.cardMsg.hall,
      slot:this.cardMsg.slot,
      order:this.cardMsg.order,
      tickets:this.cardMsg.tickets,
      mintues:'100',
      percent:'80',
      total:'98',
      distance:'',
      // startTime:this.slot.startTime

    }
  },
  methods: {
    handleChange(val) {
        console.log(val);
      },

      //时间格式化函数，此处仅针对yyyy-MM-dd hh:mm:ss 的格式进行格式化
  dateFormat:function(time) {
    var date=new Date(time);
    var year=date.getFullYear();
    var month= date.getMonth()+1<10 ? "0"+(date.getMonth()+1) : date.getMonth()+1;
    var day=date.getDate()<10 ? "0"+date.getDate() : date.getDate();
    var hours=date.getHours()<10 ? "0"+date.getHours() : date.getHours();
    var minutes=date.getMinutes()<10 ? "0"+date.getMinutes() : date.getMinutes();
    // 拼接
    return year+"-"+month+"-"+day+" "+hours+":"+minutes;
  },
  timeSubtract:function(time1,time2){
    var date1 = new Date(time1)
    var date2 = new Date(time2)
    
    // var s1 = date1.getTime(),s2 = date2.getTime();
    var total = (date1 - date2)/1000;
    console.log(total)
    var day = parseInt(total / (24*60*60));//计算整数天数
    var afterDay = total - day*24*60*60;//取得算出天数后剩余的秒数
    var hour = parseInt(afterDay/(60*60));//计算整数小时数
    var afterHour = total - day*24*60*60 - hour*60*60;//取得算出小时数后剩余的秒数
    var min = parseInt(afterHour/60);//计算整数分
    return "距离开场时间还有   "+day+" 天 "+hour+" 小时 "+min+" 分钟 ";
  },

    //显示新的修改弹窗
      handleRefund: function () {
        this.refundVisible = true;

      },
      onSubmit: function () {
        var that = this;
      console.log(orderId)
      this.$store.dispatch('refund', sessionStorage.getItem('userId'),orderId).then(res => {
        console.log(res)
      });
      }
  },
  created () {
    // this.distance=this.slot.startTime-this.order.confirmDate
    console.log(this.cardMsg)
    console.log(this.movie)
  },

}

</script>

<style lang='scss'>
.success{
  margin:10px;
  border:1px solid #CFF9FE;
  height: 400px; 
  border-radius: 15px;
  padding-left: 40px;
  text-align: left;
  width: 92%;

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
    font-size: 14px;
    height: 48px;
  }
  .grid-content {
    border-radius: 4px;
    // min-height: 36px;
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
    height: 25px;
  }
  .el-collapse{
    border: 0;
  }
  .el-button{
    // margin-top: 20px;
    border-radius: 9px;
    padding: 4px 15px;
    background-color: rgba($color: #131C1C, $alpha: 0.5);
    font-size: 14px;
    border-color: #CFF9FE
  }
  .success_footer_right{
    text-align: right;
    margin-right:10%; 
    font-size: 14px;
  }
  .el-dialog{
    text-align: left;
  }
}


</style>
