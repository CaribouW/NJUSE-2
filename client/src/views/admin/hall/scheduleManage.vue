<template>
  <div class="schedule_manage">
    <!-- 顶部选项栏（包含影厅和日期过滤） -->
    <div class="schedule_manage_settings">
      <div class="hallSelector">
        <span>影厅选择:</span>
        <el-select v-model="value" placeholder="请选择">
          <el-option
            v-for="item in hallList"
            :key="item.hallId"
            :label="item.name+'厅'"
            :value="item.hallId">
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
          :clearable="clearable"
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
        <div class="s_m_card_title_date" v-for="item in timeline" :key="item">{{ item }}</div>
        
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
          <li class="s_m_card_content_detail_item" v-for="item in schedules0" :key="item.slotId" v-bind:style="mapScheduleStyle(item)" @click="doChange(item)">
            <span>{{item.movieName}}</span>
            <span>{{"￥"+item.ticketPrize}}</span>
            <span>{{item.startTime.substring(11,16)+'-'+item.endTime.substring(11,16)}}</span>
          </li>
        </ul>
        <ul class="s_m_card_content_detail">
          <li class="s_m_card_content_detail_item" v-for="item in schedules1" :key="item.slotId" v-bind:style="mapScheduleStyle(item)" @click="doChange(item)">
            <span>{{item.movieName}}</span>
            <span>{{"￥"+item.ticketPrize}}</span>
            <span>{{item.startTime.substring(11,16)+'-'+item.endTime.substring(11,16)}}</span>
          </li>
        </ul>
        <ul class="s_m_card_content_detail">
          <li class="s_m_card_content_detail_item" v-for="item in schedules2" :key="item.slotId" v-bind:style="mapScheduleStyle(item)" @click="doChange(item)">
            <span>{{item.movieName}}</span>
            <span>{{"￥"+item.ticketPrize}}</span>
            <span>{{item.startTime.substring(11,16)+'-'+item.endTime.substring(11,16)}}</span>
          </li>
        </ul>
        <ul class="s_m_card_content_detail">
          <li class="s_m_card_content_detail_item" v-for="item in schedules3" :key="item.slotId" v-bind:style="mapScheduleStyle(item)" @click="doChange(item)">
            <span>{{item.movieName}}</span>
            <span>{{"￥"+item.ticketPrize}}</span>
            <span>{{item.startTime.substring(11,16)+'-'+item.endTime.substring(11,16)}}</span>
          </li>
        </ul>
        <ul class="s_m_card_content_detail">
          <li class="s_m_card_content_detail_item" v-for="item in schedules4" :key="item.slotId" v-bind:style="mapScheduleStyle(item)" @click="doChange(item)">
            <span>{{item.movieName}}</span>
            <span>{{"￥"+item.ticketPrize}}</span>
            <span>{{item.startTime.substring(11,16)+'-'+item.endTime.substring(11,16)}}</span>
          </li>
        </ul>
        <ul class="s_m_card_content_detail">
          <li class="s_m_card_content_detail_item" v-for="item in schedules5" :key="item.slotId" v-bind:style="mapScheduleStyle(item)" @click="doChange(item)">
            <span>{{item.movieName}}</span>
            <span>{{"￥"+item.ticketPrize}}</span>
            <span>{{item.startTime.substring(11,16)+'-'+item.endTime.substring(11,16)}}</span>
          </li>
        </ul>
        <ul class="s_m_card_content_detail">
          <li class="s_m_card_content_detail_item" v-for="item in schedules6" :key="item.slotId" v-bind:style="mapScheduleStyle(item)" @click="doChange(item)">
            <span>{{item.movieName}}</span>
            <span>{{"￥"+item.ticketPrize}}</span>
            <span>{{item.startTime.substring(11,16)+'-'+item.endTime.substring(11,16)}}</span>
          </li>
        </ul>
      </div>
    </div>

    <!-- 新增排片 -->
    <el-dialog title="新增排片"
               :visible.sync="dialogFormVisible"
               append-to-body
               width="35%">
      <el-form :model="form">
        <el-form-item label="*电影名称：" :label-width="formLabelWidth">
          <!-- <el-input v-model="form.name" autocomplete="off" placeholder="请输入电影名称"></el-input> -->
          <el-autocomplete
            class="inline-input"
            v-model="form.movieName"
            :fetch-suggestions="querySearch"
            placeholder="请输入电影名称"
            @select="selectMovie"
          ></el-autocomplete>
        </el-form-item>
        <el-form-item label="*放映影厅：" :label-width="formLabelWidth">
          <el-select v-model="form.hall" placeholder="请选择影厅">
            <el-option v-for="item in hallList"
            :key="item.hallId"
            :label="item.name+'厅'"
            :value="item.hallId"></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="*开始时间：" :label-width="formLabelWidth">
          <el-date-picker
            v-model="form.startTime"
            align="right"
            type="datetime"
            placeholder="选择开始时刻">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="*结束时间：" :label-width="formLabelWidth">
          <el-date-picker
            v-model="form.endTime"
            align="right"
            type="datetime"
            placeholder="选择结束时刻">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="*场次票价：" :label-width="formLabelWidth">
          <el-input v-model="form.ticketPrice" autocomplete="off" placeholder="请输入本场次的票价"></el-input>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="onCancel">取 消</el-button>
        <el-button type="primary" @click="onSubmit" v-if="throughAdd">确 定</el-button>
        <el-button type="danger" @click="onDelete" v-if="throughChange">删 除</el-button>
        <el-button type="primary" @click="onChange" v-if="throughChange">修 改</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
  import admin from '../index.vue'
  import { getHallList } from '@/service/HallService.js'
  import { getAllMovie } from '@/service/movieService.js'
  import { addMovieSchedule,getMovieSchedule,modifyMovieSchedule,deleteMovieSchedule } from '@/service/scheduleService.js'

  export default {
    name: 'scheduleManagement',
    components: {
      admin
    },
    data() {
      return {
        halls: [], // 所有影厅
        movies: [], // 所有上架的电影
        schedules:[], // 全部的排片信息
        value: '',
        clearable: false,
        // 查看排片
        pickerOptions1: {
          // disabledDate(time) {
          //   return time.getTime() > Date.now();
          // },
          shortcuts: [{
            text: '后天',
            onClick(picker) {
              const date = new Date();
              date.setTime(date.getTime() + 3600 * 1000 * 24 * 2);
              picker.$emit('pick', date);
            }
          },{
            text: '明天',
            onClick(picker) {
              const date = new Date();
              date.setTime(date.getTime() + 3600 * 1000 * 24);
              picker.$emit('pick', date);
            }
          },{
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
        checkScheduleValue: new Date(),
        // 新增排片
        dialogFormVisible: false,
        form: {
          movieId: '',
          startTime: null,
          endTime: null,
          hall: '',
          ticketPrice: '',
          movieName: '',
        },
        formLabelWidth: '100px',
        selectedSlotId: '', // 选中排片的id
        throughAdd: false,
        throughChange: false
      }
    },
    methods: {
      addSchedule() {
        this.throughAdd = true
        this.dialogFormVisible = true
      },
      doChange(item){
        this.form.movieId = item.movieId
        this.form.movieName = item.movieName
        this.form.startTime = new Date(item.startTime)
        this.form.endTime = new Date(item.endTime)
        this.form.hall = item.hallId
        this.form.ticketPrice = item.ticketPrize
        this.selectedSlotId = item.slotId
        this.throughChange = true
        this.dialogFormVisible = true
        console.log(item)
      },
      onSubmit() {
        if(this.form.movieName===''){
          alert('请选择需要排片的电影')
        }else if(this.form.movieId==''){
          alert('您输入的电影未存在于已上架电影列表')
        }else if(this.form.hall==''){
          alert('请选择影厅')
        }else if(this.form.startTime==null){
          alert('请设置排片的开始时间')
        }else if(this.form.endTime==null){
          alert('请设置排片的结束时间')
        }else if(this.form.ticketPrice==''){
          alert('请设置场次的票价')
        }
        else{
          var newSchedule = {
            movieId: this.form.movieId,
            hallId: this.form.hall,
            startTime: this.timeToFormat(this.form.startTime),
            endTime: this.timeToFormat(this.form.endTime),
            price: Number(this.form.ticketPrice),
            slotId: this.form.movieName
          }
          addMovieSchedule(newSchedule).then(res => {
            this.schedules.slot.unshift({
              movieId: newSchedule.movieId,
              hallId: newSchedule.hallId,
              startTime: newSchedule.startTime,
              endTime: newSchedule.endTime,
              ticketPrize: newSchedule.price,
              slotId: res.slotId
            })
            this.form = {
              movieId: '',
              startTime: null,
              endTime: null,
              hall: '',
              ticketPrice: '',
              movieName: '',
            }
            this.dialogFormVisible = false
            this.throughAdd = false
          })
          // this.dialogFormVisible = false
        }
      },
      onCancel() {
        this.form = {
          movieId: '',
          startTime: null,
          endTime: null,
          hall: '',
          ticketPrice: '',
          movieName: '',
        }
        this.dialogFormVisible = false
        this.throughAdd = false
        this.throughChange = false
        this.selectedSlotId = ''
      },
      onDelete(){
        deleteMovieSchedule({
          slotId: this.selectedSlotId
        }).then( res => {
          this.schedules.slot = this.schedules.slot.filter(function(schedule){
            return schedule.slotId!=this.selectedSlotId
          },this)
          this.dialogFormVisible = false
          this.selectedSlotId = ''
          this.throughChange = false
        })

      },
      onChange(){
        if(this.form.movieName===''){
          alert('请选择需要排片的电影')
        }else if(this.form.movieId==''){
          alert('您输入的电影未存在于已上架电影列表')
        }else if(this.form.hall==''){
          alert('请选择影厅')
        }else if(this.form.startTime==null){
          alert('请设置排片的开始时间')
        }else if(this.form.endTime==null){
          alert('请设置排片的结束时间')
        }else if(this.form.ticketPrice==''){
          alert('请设置场次的票价')
        }
        else{
          var newSchedule = {
            movieId: this.form.movieId,
            hallId: this.form.hall,
            startTime: this.timeToFormat(this.form.startTime),
            endTime: this.timeToFormat(this.form.endTime),
            price: Number(this.form.ticketPrice),
            slotId: this.selectedSlotId
          }
          modifyMovieSchedule(newSchedule).then(res => {
            for(var i = 0;i<this.schedules.slot.length;i++){
              if(this.schedules.slot[i].slotId==this.selectedSlotId){
                this.schedules.slot[i] = {
                  movieId: newSchedule.movieId,
                  hallId: newSchedule.hallId,
                  startTime: newSchedule.startTime,
                  endTime: newSchedule.endTime,
                  ticketPrize: newSchedule.price,
                  slotId: this.selectedSlotId
                }
              }
            }
            
            this.form = {
              movieId: '',
              startTime: null,
              endTime: null,
              hall: '',
              ticketPrice: '',
              movieName: '',
            }
            this.dialogFormVisible = false
            this.throughChange = false
            this.selectedSlotId = ''
          })
        }
      },
      querySearch(queryString, cb) {
        var movieList = this.movieList
        var results = queryString ? movieList.filter(this.createFilter(queryString)) : movieList;
        // 调用 callback 返回建议列表的数据
        cb(results);
      },
      createFilter(queryString) {
        return (movie) => {
          return (movie.name.toLowerCase().indexOf(queryString.toLowerCase()) === 0);
        };
      },
      selectMovie(item){
        this.form.movieId = item.movieId
      },
      /**
       * 将Date对象转换成“年月日 时分秒”格式的字符串
       */
      timeToFormat(time){
        var year = time.getFullYear()
        var month = time.getMonth()+1
        if(month<10){
          month = '0'+month
        }
        var day = time.getDate()
        if(day<10){
          day = '0'+day
        }
        var moment = time.toTimeString().substring(0,8)
        return year+'-'+month+'-'+day+' '+moment
      },
      /**
       * 元素定位，返回高度和顶部距离
       */
      mapScheduleStyle(schedule) {
        var start = new Date(schedule.startTime).getHours()+new Date(schedule.startTime).getMinutes()/60,
            end = new Date(schedule.endTime).getHours()+new Date(schedule.endTime).getMinutes()/60 ;
        return {
            top: 40*start+'px',
            height: 40*(end-start)+'px'
        }
      }
    },
    mounted: function(){
      getHallList().then(
        res => {
          this.halls = res
        }
      )
      getAllMovie().then(
        res => {
          this.movies = res
        }
      )
      getMovieSchedule().then(
        res => {
          this.schedules = res
        }
      )
    },
    computed: {
      hallList: function(){
        return this.halls.filter(function(item){
          return item.state === true
        })
      },
      movieList: function(){
        var movies = this.movies
        for(var i = 0; i < this.movies.length; i++){
          this.movies[i].value = this.movies[i].name
        }
        return movies
      },
      timeline: function(){
        var setting = this.checkScheduleValue.getTime()
        var tmp = new Date()
        var result = []
        for(var i = 0;i<7;i++){
          tmp.setTime(setting + 3600*1000*24*i)
          result.push(this.timeToFormat(tmp).substring(0,10))
        }
        return result
      },
      scheduleList: function(){
        var this3 = this
        var tmp = this3.schedules
        for(var i = 0;i<tmp.slot.length;i++){
          for(var j = 0;j<this3.movies.length;j++){
            if(this3.movies[j].movieId===tmp.slot[i].movieId){
              tmp.slot[i].movieName = this3.movies[j].name
            }
          }
        }
        // tmp.slot.forEach(item => {
        //   this.movies.forEach(element => {
        //     if(element.movieId==item.movieId){
        //       item.movieName = element.name
        //     }
        //   });
        // });
        return tmp
      },
      schedules0: function(){
        return this.scheduleList.slot.filter(function(item){
          var tmp = item.startTime.substring(0,10)
          return tmp===this.timeline[0]
        },this)
      },
      schedules1: function(){
        return this.scheduleList.slot.filter(function(item){
          var tmp = item.startTime.substring(0,10)
          return tmp===this.timeline[1]
        },this)
      },
      schedules2: function(){
        return this.scheduleList.slot.filter(function(item){
          var tmp = item.startTime.substring(0,10)
          return tmp===this.timeline[2]
        },this)
      },
      schedules3: function(){
        return this.scheduleList.slot.filter(function(item){
          var tmp = item.startTime.substring(0,10)
          return tmp===this.timeline[3]
        },this)
      },
      schedules4: function(){
        return this.scheduleList.slot.filter(function(item){
          var tmp = item.startTime.substring(0,10)
          return tmp===this.timeline[4]
        },this)
      },
      schedules5: function(){
        return this.scheduleList.slot.filter(function(item){
          var tmp = item.startTime.substring(0,10)
          return tmp===this.timeline[5]
        },this)
      },
      schedules6: function(){
        return this.scheduleList.slot.filter(function(item){
          var tmp = item.startTime.substring(0,10)
          return tmp===this.timeline[6]
        },this)
      },
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
          // top: 160px;
          // height: 100px;
          cursor: pointer;
          width: 96%;
          display: flex;
          flex-direction: column;
          align-items: center;
          color: #fff;
          position: absolute;
          border: 2px solid #ccc;
          border-radius: 5px;
          // overflow-y: scroll;
          justify-content: space-around;
          span{
            font-size: 10px;
          }
        }
      }
    }
  }
</style>
