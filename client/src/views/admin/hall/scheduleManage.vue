<template>
  <div class="schedule_manage">
    <!-- 顶部选项栏（包含影厅和日期过滤） -->
    <div class="schedule_manage_settings">
      <div class="hallSelector">
        <span>影厅选择:</span>
        <el-select v-model="value" placeholder="请选择">
          <el-option
            v-for="item in options"
            :key="item.value"
            :label="item.label"
            :value="item.value">
          </el-option>
        </el-select>
      </div>
      <div class="dateSelector">
                <span>日期选择:
                </span>
        <el-date-picker
          v-model="checkScheduleValue"
          align="right"
          type="date"
          placeholder="请选择"
          :picker-options="pickerOptions1">
        </el-date-picker>
      </div>
      <div class="addSchedule">
        <el-button @click.native="addSchedule">新增排片</el-button>
      </div>
    </div>
    <!-- 排片信息展示卡片 -->
    <div class="schedule_manage_card">
      <div class="s_m_card_title">
        <div class="s_m_card_title_date">2019-05-21</div>
        <div class="s_m_card_title_date">2019-05-21</div>
        <div class="s_m_card_title_date">2019-05-21</div>
        <div class="s_m_card_title_date">2019-05-21</div>
        <div class="s_m_card_title_date">2019-05-21</div>
        <div class="s_m_card_title_date">2019-05-21</div>
        <div class="s_m_card_title_date">2019-05-21</div>
      </div>
      <div class="s_m_card_content">
        <ul class="s_m_card_content_moment">
          <li class="s_m_card_content_moment_item">0:00</li>
          <li class="s_m_card_content_moment_item">6:00</li>
          <li class="s_m_card_content_moment_item">12:00</li>
          <li class="s_m_card_content_moment_item">18:00</li>
          <li class="s_m_card_content_moment_item">24:00</li>
        </ul>
        <ul class="s_m_card_content_detail">
          <li class="s_m_card_content_detail_item">
            <span>钢铁侠</span>
            <span>￥30</span>
            <span>20:00--22:00</span>
          </li>
        </ul>
        <ul class="s_m_card_content_detail"></ul>
        <ul class="s_m_card_content_detail"></ul>
        <ul class="s_m_card_content_detail"></ul>
        <ul class="s_m_card_content_detail"></ul>
        <ul class="s_m_card_content_detail"></ul>
        <ul class="s_m_card_content_detail"></ul>
      </div>
    </div>

    <!-- 新增排片 -->
    <el-dialog title="新增排片"
               :visible.sync="dialogFormVisible"
               append-to-body
               width="35%">
      <el-form :model="form">
        <el-form-item label="*电影名称：" :label-width="formLabelWidth">
          <el-input v-model="form.name" autocomplete="off" placeholder="请输入电影名称"></el-input>
        </el-form-item>
        <el-form-item label="*放映影厅：" :label-width="formLabelWidth">
          <el-select v-model="form.hall" placeholder="请选择影厅">
            <el-option label="区域一" value="shanghai"></el-option>
            <el-option label="区域二" value="beijing"></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="*开始时间：" :label-width="formLabelWidth">
          <el-date-picker
            v-model="form.startTime"
            align="right"
            type="date"
            placeholder="选择日期"
            :picker-options="pickerOptions2">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="*结束时间：" :label-width="formLabelWidth">
          <el-date-picker
            v-model="form.endTime"
            align="right"
            type="date"
            placeholder="选择日期"
            :picker-options="pickerOptions2">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="*场次票价：" :label-width="formLabelWidth">
          <el-input v-model="form.ticketPrice" autocomplete="off" placeholder="请输入本场次的票价"></el-input>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="dialogFormVisible = false">取 消</el-button>
        <el-button type="primary" @click="dialogFormVisible = false">确 定</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
  import admin from '../index.vue'

  export default {
    name: 'scheduleManagement',
    components: {
      admin
    },
    data() {
      return {
        options: [{
          value: '选项1',
          label: '黄金糕'
        }, {
          value: '选项2',
          label: '双皮奶'
        }, {
          value: '选项3',
          label: '蚵仔煎'
        }],
        value: '',
        // 查看排片
        pickerOptions1: {
          disabledDate(time) {
            return time.getTime() > Date.now();
          },
          shortcuts: [{
            text: '今天',
            onClick(picker) {
              picker.$emit('pick', new Date());
            }
          }, {
            text: '昨天',
            onClick(picker) {
              const date = new Date();
              date.setTime(date.getTime() - 3600 * 1000 * 24);
              picker.$emit('pick', date);
            }
          }, {
            text: '一周前',
            onClick(picker) {
              const date = new Date();
              date.setTime(date.getTime() - 3600 * 1000 * 24 * 7);
              picker.$emit('pick', date);
            }
          }]
        },
        checkScheduleValue: '',
        dialogFormVisible: false,
        form: {
          movieName: '',
          startTime: '',
          endTime: '',
          hall: '',
          ticketPrice: '',
          delivery: false,
          type: [],
          resource: '',
          desc: ''
        },
        formLabelWidth: '100px',
        // 新增排片
        pickerOptions2: {
          disabledDate(time) {
            return time.getTime() > Date.now();
          },
          shortcuts: [{
            text: '今天',
            onClick(picker) {
              picker.$emit('pick', new Date());
            }
          }, {
            text: '昨天',
            onClick(picker) {
              const date = new Date();
              date.setTime(date.getTime() - 3600 * 1000 * 24);
              picker.$emit('pick', date);
            }
          }, {
            text: '一周前',
            onClick(picker) {
              const date = new Date();
              date.setTime(date.getTime() - 3600 * 1000 * 24 * 7);
              picker.$emit('pick', date);
            }
          }]
        }
      }
    },
    methods: {
      addSchedule() {
        this.dialogFormVisible = true;
      },
      onSubmit() {

      },
      onCancel() {
        this.dialogFormVisible = false
      }
    }
  }
</script>

<style lang="scss">

  .schedule_manage_settings {
    display: flex;
    flex-direction: row;
    justify-content: space-between;
    margin: 0 5px 10px 5px;
    padding: 20px;
    border: 1px solid rgb(201, 235, 255);
    border-radius: 5px;
  }

  .schedule_manage_card {
    padding: 20px;
    margin-left: 5px;
    margin-right: 5px;
    border: 1px solid rgb(201, 235, 255);
    border-radius: 5px;
    // height: 960px;
    .s_m_card_title {
      display: flex;
      flex-direction: row;
      justify-content: space-between;
      padding-left: 90px;
      padding-right: 5px;
    }

    .s_m_card_content {
      display: flex;

      .s_m_card_content_moment {
        width: 80px;
        display: flex;
        flex-direction: column;
        justify-content: space-between;
      }

      .s_m_card_content_detail {
        display: block;
        height: 960px;
        width: 120px;
        border-left: 1px solid #ccc;
        position: relative;

        .s_m_card_content_detail_item {

          width: 96%;
          display: flex;
          flex-direction: column;
          align-items: center;
          color: #fff;
          position: absolute;
          border: 2px solid #ccc;
          border-radius: 5px;
          // overflow-y: scroll;
        }
      }
    }
  }
</style>
