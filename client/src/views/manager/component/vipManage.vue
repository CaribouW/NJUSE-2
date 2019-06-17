<template>
  <div class="vipManage">
    <el-collapse>
      <el-collapse-item title="会员卡购买" name="1">
        <el-divider direction="horizontal"></el-divider>
        <div class="vip_buy">
          <el-form ref="cardForm"
                   :model="cardForm"
                   label-width="120px"
                   label-position="right"
          >
            <el-form-item label="会员卡购买价格:">
              <el-col span="12">
                <el-input v-model="cardForm.name"></el-input>
              </el-col>
            </el-form-item>
            <el-form-item label="购买赠送金额：">
              <el-col span="12">
                <el-input v-model="cardForm.bonus"></el-input>
              </el-col>
            </el-form-item>
          </el-form>
        </div>
      </el-collapse-item>
      <el-collapse-item title="会员卡优惠策略" name="2">
        <el-divider direction="horizontal"></el-divider>
        <div class="vip_strategy">
          <div class="table">
            <el-table
              :data="tableData"
              border
              fit="true"
              style="width: 100%">
              <el-table-column
                prop="rank"
                label="会员等级"
                width="100"
              >
              </el-table-column>
              <el-table-column
                prop="name"
                label="会员名称"
              >
              </el-table-column>
              <el-table-column
                prop="discount"
                label="充值折扣"
              >
                <el-input v-model="discount_input" placeholder="请输入折扣(%)"></el-input>
              </el-table-column>
            </el-table>
          </div>
        </div>
      </el-collapse-item>
      <el-collapse-item title="会员优惠券" name="3">
        <el-divider direction="horizontal"></el-divider>
        <div class="vip_coupon">
          <el-form ref="cardForm" :model="cardForm" label-width="120px">
            <el-form-item label="消费累计达到：">
              <el-col span="12">
                <el-input v-model="cardForm.name" placeholder="请输入内容"></el-input>
              </el-col>
            </el-form-item>
              <el-form-item label="选择优惠券：">
                <el-col span="12">
                  <el-select v-model="coupon" placeholder="请选择">
                    <el-option
                      v-for="item in options"
                      :key="item.value"
                      :label="item.label"
                      :value="item.value">
                    </el-option>
                  </el-select>
                </el-col>
              </el-form-item>
            <el-form-item label="选择会员：">
              <el-col span="12">
                <el-select v-model="vips" multiple placeholder="请选择">
                  <el-option
                    v-for="item in options"
                    :key="item.value"
                    :label="item.label"
                    :value="item.value">
                  </el-option>
                </el-select>
              </el-col>
            </el-form-item>
            <el-form-item>
              <el-col span="12">
                <el-button round class="send">发送优惠券</el-button>
              </el-col>
            </el-form-item>
          </el-form>
        </div>
      </el-collapse-item>
      <el-divider direction="horizontal"></el-divider>
    </el-collapse>
    <el-button round class="modify" @click="goModify()">确定修改</el-button>
  </div>
</template>

<script>
  export default {
    data() {
      return {
        vipCard: {},
        price: '',
        giveaway: '',
        discount_input: '',
        minimal: '',
        cardForm: {
          price: '',
          bonus: '',
        },
        tableData: [{
          rank: 'VIP 1',
          name: '青铜会员',
          discount_input: '9.5折',
        }, {
          rank: 'VIP 2',
          name: '白银会员',
          discount_input: '9.0折',
        }, {
          rank: 'VIP 3',
          name: '黄金会员',
          discount_input: '8.5折',
        }],
        options: [{
          value: '选项1',
          label: '黄金糕'
        }, {
          value: '选项2',
          label: '双皮奶'
        }, {
          value: '选项3',
          label: '蚵仔煎'
        }, {
          value: '选项4',
          label: '龙须面'
        }, {
          value: '选项5',
          label: '北京烤鸭'
        }],
        coupon: '',
        vips: [],
      }
    },
    methods: {
      goModify: function () {
        this.$message.success('修改成功')
      },
    }

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
      text-align: left;
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

      .el-button{
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
