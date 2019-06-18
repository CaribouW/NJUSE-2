<template>
  <div class="vipManage">
    <el-collapse>
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
<!--        <div class="vip_buy">-->
<!--          会员卡购买价格:-->
<!--          <el-input v-model="cardForm.price"></el-input>-->
<!--          购买赠送金额：-->
<!--          <el-input v-model="cardForm.bonus"></el-input>-->
<!--          <el-button round class="modify" @click="modifyPurchase">确定修改</el-button>-->
<!--        </div>-->
      </el-collapse-item>
      <el-collapse-item title="会员卡优惠策略" name="2">
        <el-divider direction="horizontal"></el-divider>
        <div class="vip_strategy">
          <div class="table">
            <el-table
              :data="tableData"
              border
              :fit="true"
              style="width: 100%">
              <el-table-column
                prop="rank"
                label="会员等级"
                width="100">
              </el-table-column>
              <el-table-column
                prop="name"
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
            <el-button round class="modify" @click="goModify()">确定修改</el-button>
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
        tableData: [{
          rank: 'VIP 1',
          name: '青铜会员',
          discount: '',
        }, {
          rank: 'VIP 2',
          name: '白银会员',
          discount: '',
        }, {
          rank: 'VIP 3',
          name: '黄金会员',
          discount: '',
        }],
        couponID: '',
        vips: [],
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
          console.log(res)
        })
      }
    },
    created() {
      this.cardForm.price = localStorage.getItem('price')
      this.cardForm.bonus = localStorage.getItem('bonus')
      this.$store.dispatch('getCouponStrategyList').then(res => {
        console.log(res)
        this.couponForm.couponList = res
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
