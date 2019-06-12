<template>
    <div class="vipManage">
        <div class="vip_buy">
            <span>会员卡购买</span>
            <el-divider direction="horizontal"></el-divider>
            会员卡购买价格：<el-input v-model="price" placeholder="请输入内容"></el-input><br/>
            购买赠送金额：<el-input v-model="giveaway" placeholder="请输入内容"></el-input>
        </div>
        <div class="vip_strategy">
            <span>会员卡优惠策略</span>
            <el-divider direction="horizontal"></el-divider>
            <div class="table">
                <el-table
                    :data="tableData"
                    border
                    style="width: 95%">
                    <el-table-column
                    prop="rank"
                    label="会员等级"
                    width="180">
                    </el-table-column>
                    <el-table-column
                    prop="name"
                    label="会员名称"
                    width="180">
                    </el-table-column>
                    <el-table-column
                    prop="discount"
                    label="充值折扣">
                    <el-input v-model="discount_input" placeholder="请输入折扣"></el-input>
                    </el-table-column>
                </el-table>
            </div>
        </div>
        <div class="vip_coupon">
            <span>会员优惠券</span>
            <el-divider direction="horizontal"></el-divider>
            消费累计达到：<el-input v-model="minimal" placeholder="请输入内容"></el-input><br/>
            选择优惠券：<el-select v-model="coupon" placeholder="请选择">
                <el-option
                v-for="item in options"
                :key="item.value"
                :label="item.label"
                :value="item.value">
                </el-option>
            </el-select><br/>
            选择会员：<el-select v-model="vips" multiple placeholder="请选择">
                <el-option
                v-for="item in options"
                :key="item.value"
                :label="item.label"
                :value="item.value">
                </el-option>
            </el-select>
            <el-button round class="send">发送优惠券</el-button>
        </div>
        <el-divider direction="horizontal"></el-divider>
        <el-button round class="modify">确定修改</el-button>
    </div>
</template>

<script>
export default {
    data(){
        return{
            vipCard:{},
            price: '',
            giveaway:'',
            discount_input:'',
            minimal:'',
            tableData: [{
                rank: 'VIP 1',
                name: '青铜会员',
                discount:'',
                }, {
                rank: 'VIP 2',
                name: '白银会员',
                discount:'',
                }, {
                rank: 'VIP 3',
                name: '黄金会员',
                discount:'',
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
            vips:[],
        }
    }

}
</script>

<style lang="scss">
.vipManage{
    padding: 0 30px;


    .vip_buy{
        text-align: left;
        margin-top:20px;

        .el-divider {
            border: 0.5px solid #979797;
            margin:10px 0;
        }
        .el-input{
            width: 40%;
            margin:5px 0;
        }
    }
    .vip_strategy{
        text-align: left;
        margin-top:20px;

        .el-divider {
            border: 0.5px solid #979797;
            margin:10px 0;
        }
        .table{
            margin-left: 30px;
            .el-input{
                width: 70%;
                margin-left: 20px;
            }
            .el-table th, .el-table td{
                text-align: center;
            }
        }
    }
    .vip_coupon{
        text-align: left;
        margin-top:20px;

        .el-divider {
            border: 0.5px solid #979797;
            margin:10px 0;
        }
        .el-input{
            width: 40%;
            margin:5px 0;
        }
        .el-select{
            width: 700px;
        }
        .send{
            margin-left: 40%;
            margin-top:10px;
        }
    }
    .el-divider {
            border: 0.5px solid #979797;
            margin:10px 0;
        }
    .modify{
        margin-top: 20px;
        border-radius: 25px;
        padding: 8px 65px;
        font-size: 20px;
        color: #CFF9FE;
        border-color: #CFF9FE
    }
}


    
</style>
