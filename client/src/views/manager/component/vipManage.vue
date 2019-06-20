<template>
  <div class="vipManage">
    <el-collapse v-model="activeNames">
      <el-collapse-item title="会员卡购买" name="1">
        <el-divider direction="horizontal"></el-divider>
        <el-form ref="cardForm" :model="cardForm" label-width="120px">
          <el-form-item label="会员卡购买价格:">
            <el-col :span="12">
              <el-input v-model="cardForm.price"></el-input>
            </el-col>
          </el-form-item>
          <el-form-item label="购买赠送金额：">
            <el-col :span="12">
              <el-input v-model="cardForm.bonus"></el-input>
            </el-col>
          </el-form-item>
          <el-form-item>
            <el-col :span="12">
              <el-button round class="modify" @click="modifyPurchase">确定修改</el-button>
            </el-col>
          </el-form-item>
        </el-form>
      </el-collapse-item>
      <el-collapse-item title="会员卡优惠策略" name="2">
        <el-divider direction="horizontal"></el-divider>
        <div class="vip_strategy">
          <div class="table">
            <el-table
              :data="VipStrategyForm"
              border
              :fit="true"
              style="width: 100%">
              <el-table-column
                prop="rank"
                label="会员等级"
                width="100">
              </el-table-column>
              <el-table-column
                prop="rankName"
                label="会员名称">
              </el-table-column>
              <el-table-column
                prop="discount"
                label="充值折扣">
                <template slot-scope="scope">
                  <el-input v-model="scope.row.discount" placeholder="请输入折扣(%)"
                            @click="console.log(scope.row.discount)"></el-input>
                </template>
              </el-table-column>
            </el-table>
            <el-button round class="modify" @click="modifyVipStrategy()">确定修改</el-button>
          </div>
        </div>
      </el-collapse-item>
      <el-collapse-item title="会员优惠券" name="3">
        <el-divider direction="horizontal"></el-divider>
        <div class="vip_coupon">
          <el-form ref="cardForm" :model="cardForm" label-width="120px">
            <el-form-item label="消费累计达到：">
              <el-col :span="12">
                <el-input v-model="couponForm.limitation" placeholder="请输入金额"
                          @mouseout.native="getMemberList"></el-input>
              </el-col>
            </el-form-item>
            <el-form-item label="选择优惠券：">
              <el-col :span="12">
                <el-select v-model="couponID" placeholder="请选择">
                  <el-option
                    v-for="item in couponForm.couponList"
                    :key="item.couponID"
                    :label="item.couponName"
                    :value="item.couponID">
                    <span style="float: left">满{{item.conditionPrice}}减{{ item.discountPrice }}</span>
                  </el-option>
                </el-select>
              </el-col>
            </el-form-item>
            <el-form-item label="选择会员：">
              <el-col :span="12">
                <el-select v-model="vips" multiple placeholder="请选择">
                  <el-option
                    v-for="item in couponForm.memberList"
                    :key="item.cardId"
                    :label="item.cardId"
                    :value="item.cardId">
                  </el-option>
                </el-select>
              </el-col>
            </el-form-item>
            <el-form-item>
              <el-col :span="12">
                <el-button round class="send" @click="giveCoupon">发送优惠券</el-button>
              </el-col>
            </el-form-item>
          </el-form>
        </div>
      </el-collapse-item>
      <el-divider direction="horizontal"></el-divider>
    </el-collapse>

  </div>
</template>

<script>
  export default {
    data() {
      return {
        activeNames: ['1'],
        couponForm: {
          limitation: '',
          couponList: [],
          memberList: []
        },
        vipCard: {},
        price: '',
        giveaway: '',
        minimal: '',
        cardForm: {
          price: '',
          bonus: '',
        },
        couponID: '',
        vips: [], 
        VipStrategyForm: []
      }
    },
    methods: {
      modifyPurchase() {
        localStorage.setItem('price', this.cardForm.price)
        localStorage.setItem('bonus', this.cardForm.bonus)
        this.$message.success('修改成功')
      },
      getMemberList() {
        this.$store.dispatch('getMemberList', {
          limitation: this.couponForm.limitation
        }).then(res => {
          this.couponForm.memberList = res
        })
      },
      giveCoupon() {
        this.$store.dispatch('giveCoupon', {
          vipIdList: this.vips,
          couponId: this.couponID
        }).then(res => {
          this.$message.success('赠送成功')
        })
      },
      modifyVipStrategy() {
        var vipRank = []
        var vip1 = {}
        vip1.rank = '1'
        vip1.rankName = '青铜会员'
        vip1.rechargePrice = 500
        vip1.discount = this.VipStrategyForm[0].discount
        vip1.id = this.VipStrategyForm[0].id
        vipRank.push(vip1)
        var vip2 = {}
        vip2.rank = '2'
        vip2.rankName = '白银会员'
        vip2.rechargePrice = 1000
        vip2.discount = this.VipStrategyForm[1].discount
        vip2.id = this.VipStrategyForm[1].id
        vipRank.push(vip2)
        var vip3 = {}
        vip3.rank = '3'
        vip3.id = this.VipStrategyForm[2].id
        vip3.rankName = '黄金会员'
        vip3.rechargePrice = 5000
        vip3.discount = this.VipStrategyForm[2].discount
        vipRank.push(vip3)
        var vip4 = {}
        vip4.rank = '4'
        vip4.id = this.VipStrategyForm[3].id
        vip4.rankName = '尊贵皇族会员'
        vip4.rechargePrice = 10000
        vip4.discount = this.VipStrategyForm[3].discount
        vipRank.push(vip4)
        // console.log(vipRank)
        this.$store.dispatch('modifyVipStrategy', {
          vipRank: vipRank,
        }).then(res => {
          console.log(res)
        })
      }
    },
    created() {
      this.cardForm.price = localStorage.getItem('price')
      this.cardForm.bonus = localStorage.getItem('bonus')
      this.$store.dispatch('getCouponStrategyList').then(res => {
        this.couponForm.couponList = res
      })
      this.$store.dispatch('getVipStrategy').then(res => {
        this.VipStrategyForm = res
      })
    },
    computed: {}
  }
</script>

<style lang="scss">
  .vipManage {
    .el-collapse-item {
      padding: 0.5% 2% 0.5% 2%;

      > div {
        background-color: rgba(34, 41, 51, 0);
      }

      .el-collapse-item__header {
        font-size: 20px;
        background-color: rgba(29, 28, 26, 0.21);
      }
    }

    .el-divider {
      border: 0.5px solid #979797;
      margin: 10px 0;
    }

    .vip_buy {
      div {
        text-align: right;
      }
    }

    .vip_strategy {
      text-align: center;

      .table {
        .el-input {
          width: 95%;
        }

        .el-table th, .el-table td {
          text-align: center;
        }
      }
    }

    .vip_coupon {
      text-align: left;
      width: 100%;

      .el-input {
      }

      .el-button {
        margin: 0 auto;
        border-radius: 25px;
        font-size: 14px;
        color: #CFF9FE;
        border-color: #CFF9FE
      }
    }

    .el-divider {
      border: 0.5px solid #979797;
      margin: 10px 0;
    }

    .modify {
      margin-top: 20px;
      border-radius: 25px;
      padding: 8px 65px;
      font-size: 20px;
      color: #CFF9FE;
      border-color: #CFF9FE
    }
  }


</style>
