<template>
  <div class="VIPInfo">
    <div class="info_header">
      <b>会员信息</b>
    </div>
    <div class="info_body">
      <p class="info_level">会员等级：黄金会员</p>
      <p class="info_balance">会员卡余额：¥ {{vipInfo.VIPCardBalance}}</p>
      <p>会员卡号：5343765353259682</p>
      <el-input
        placeholder="最多不超过99999元"
        v-model="amount"
        oninput="value=value.replace(/[^\d]/g,'')"
        maxlength="5"
        clearable>
      </el-input>
      <el-button @click="rechargeVIP" class="recharge-btn">充值</el-button>
      <div class="VIPInfo_record">
        <el-collapse v-model="activeNames">
          <el-collapse-item title="充值记录" name="1">
            <div v-for="(record, index) in history" :key="index">
              <span>充值金额：{{record.amount}}</span><span>充值时间：{{record.time}}</span>
            </div>
            <el-pagination
              layout="prev, pager, next"
              :total="rechargeList.length"
              :current-page.sync="currentPage"
              :page-size="5">
            </el-pagination>
          </el-collapse-item>
        </el-collapse>
      </div>
    </div>
  </div>
</template>

<script>
  import vip_aside from "../VIP/index.vue"

  export default {
    name: "VIP",
    components: {
      vip_aside,
    },
    data() {
      return {
        currentPage: 1,
        tabPosition: 'left',
        activeNames: ['1'],
        amount: '',
        vipInfo: {},
        rechargeList: []
      }
    },
    computed: {
      history: function () {
        return this.rechargeList.slice((this.currentPage - 1) * 5, this.currentPage * 5)
      }
    },
    methods: {
      getNowFormatDate() {
        var date = new Date();
        var seperator1 = "-";
        var seperator2 = ":";
        var month = date.getMonth() + 1 < 10 ? "0" + (date.getMonth() + 1) : date.getMonth() + 1;
        var strDate = date.getDate() < 10 ? "0" + date.getDate() : date.getDate();
        var hours = date.getHours() < 10 ? "0" + date.getHours() : date.getHours()
        var minutes = date.getMinutes() < 10 ? "0" + date.getMinutes() : date.getMinutes()
        var currentdate = date.getFullYear() + seperator1 + month + seperator1 + strDate
          + " " + hours + seperator2 + minutes
        return currentdate;
      },
      rechargeVIP() {
        console.log(this.getNowFormatDate());
        this.$store.dispatch('rechargeVIP', {
          rechargeAmount: parseInt(this.amount),
          VIPCardId: this.vipInfo.VIPCardId,
          rechargeTime: this.getNowFormatDate()
        }).then(res => {
          if (res === 200) {
            this.$store.commit('recharge', parseInt(this.amount))
            this.getRechargeHistory()
            this.$message.success('充值成功')
          } else {
            this.$message.error('充值失败')
          }
        })
      },

      getRechargeHistory() {
        this.$store.dispatch('getRechargeHistory', {
          userId: sessionStorage.getItem('userId')
        }).then(res => {
          console.log(res)
          this.rechargeList = res.rechargeList.reverse()
          console.log(this.rechargeList)
        }).catch(err => {
          console.log(err)
        })
      }
    },
    mounted() {
      this.vipInfo = this.$store.state.member.basicInfo
      this.getRechargeHistory()
      console.log(this.getNowFormatDate())
    }

  }
</script>

<style lang='scss'>
  .VIPInfo {
    padding: 10px 10px 10px 20px;

    .info_body {
      padding: 20px 30px;
      text-align-last: left;

      > p {
        line-height: 40px;
      }

      .recharge-btn {
        margin: 0 auto;
        border-radius: 25px;
        font-size: 14px;
        color: #CFF9FE;
        border-color: #CFF9FE
      }
    }

    .el-input.el-input--suffix {
      width: 300px;
      margin-top: 30px;
      margin-right: 30px;
      margin-bottom: 30px;
    }

    .el-collapse-item__content {
      padding-bottom: 0;

      > div {
        height: 40px;
        line-height: 40px;
        width: fit-content;
        margin: 0 auto;

        > span {
          width: 200px;
          display: inline-block;
        }
      }
    }
  }

  .info_header {
    font-size: 30px;
    text-align: left;
    margin-bottom: 10px;
  }

  .divider {
    color: #ffffff;
    height: 1px;
  }


</style>
