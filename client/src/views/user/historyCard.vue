
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
                    <div v-if="order.state=='0'">
                      距离开场时间还有: {{timeSubtract(slot.startTime)}}
                    </div>
                    <div v-else-if="order.state=='1'">
                      订单已取消
                    </div>
                    <div v-else-if="order.state=='2'">
                      订单未支付
                    </div>
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
                <img :src="movie.poster" alt="" style="width:70px;height:100px;">
              </div>
              </el-col> 
          </el-row>  
        </div>
        <div class="success_body" v-if="order.state=='0'">
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

                  <div v-if="order.state=='0'">
                      <el-button round @click="handleRefund(order.orderId)">退票</el-button>
                  </div>
                  <div v-if="order.state=='1'">
                      <el-button round @click="handleRebuy">重购</el-button>
                  </div>
                  <div v-if="order.state=='2'">
                      <el-button round @click="handlePay(order.orderId)">支付</el-button>
                  </div>
                  
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
                          <span>当前已购票 {{timeSubtract(order.confirmDate)}},退还比例为 {{percent*100}}% ,共计 {{percent*slot.ticketPrize*tickets.length}} 元。是否确认退票？</span>
                        </el-form-item>
                        <el-form-item style="margin-left:35%;">
                          <el-button type="primary" @click="onSubmit">退票</el-button>
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
      refundVisible:false,
      refundStrategy:[],
      thisStrategy:{},

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

      return year+"-"+month+"-"+day+" "+hours+":"+minutes;
    },

    //距离开场还有多久时间
    timeSubtract:function(time2){
      var date1 = new Date()
      var date2 = new Date(time2)
      var total = (Math.abs(date2 - date1))/1000;
      var day = parseInt(total / (24*60*60));//计算整数天数
      var afterDay = total - day*24*60*60;//取得算出天数后剩余的秒数
      var hour = parseInt(afterDay/(60*60));//计算整数小时数
      var afterHour = total - day*24*60*60 - hour*60*60;//取得算出小时数后剩余的秒数
      var min = parseInt(afterHour/60);//计算整数分
      return day+" 天 "+hour+" 小时 "+min+" 分钟 ";
    },

     //距离开场还有多久时间 单位为分钟
    timeSubtract_minute:function(time2){
      let date1 = new Date()
      let date2 = new Date(time2)
      let total = (Math.abs(date2 - date1))/1000;
      var min = parseInt(total/60);//计算整数分
      return min
    },


    //显示新的修改弹窗，获取退票策略
    handleRefund: function () { 
      this.$store.dispatch('getRefundList').then(res => {
        this.refundStrategy=res
        this.getStrategy()
        this.refundVisible = true;
      });
      
    },

    getStrategy:function(){
      let time0=this.refundStrategy[0].time
      let time1=this.refundStrategy[1].time
      let time2=this.refundStrategy[2].time
      let time=this.timeSubtract_minute(this.slot.startTime)
      if(time0>=time){
        this.percent=this.refundStrategy[0].rate
      }
      else if(time0<time&&time<=time1){
        this.percent=this.refundStrategy[1].rate
      }
      else if(time1<time){
        this.percent=this.refundStrategy[2].rate
      }
    },

    onSubmit: function () {
      console.log(sessionStorage.getItem('userId'))
      this.$store.dispatch('refund', {
        userId:sessionStorage.getItem('userId'),
        orderId:this.order.orderId})
        .then(res => {
          this.$message({
            type: 'success',
            message: '修改成功'
          });
          this.refundVisible = false
          // this.$parent.created();
          console.log(res)
        
      });
    },
    onCancel: function () {
        this.$message({
          type: 'info',
          message: '已取消修改'
        });
        this.refundVisible = false
      },

/**
 * 
 */
    handleRebuy:function(){
      this.$router.push('/')
    },

    handlePay:function(orderId){

    },
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
  // height: 400px; 
  border-radius: 15px;
  padding-left: 40px;
  padding-bottom: 10px;
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
    margin-top:4px;
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
