<template>
  <div class="_movieShow">
    <div class="_movieShow_header">
      <div class="_movieShow_header_title">已上架电影</div>
      <div class="_movieShow_header_divider"></div>
    </div>
    <div class="_movieShow_menu">
      <div class="_movieShow_menu_item startTime">
        <span>电影上映日期: </span>
        <div class="block">
          <el-date-picker
            v-model="startTime"
            type="date"
            placeholder="选择日期">
          </el-date-picker>
        </div>
      </div>
      <div class="_movieShow_menu_item endTime">
        <span>电影下映日期: </span>
        <div class="block">
          <el-date-picker
            v-model="endTime"
            type="date"
            placeholder="选择日期">
          </el-date-picker>
        </div>
      </div>
      <div class="_movieShow_menu_item movieState">
        <span>电影状态:&emsp;&emsp;</span>
        <el-select v-model="value" placeholder="请选择状态">
          <el-option
            v-for="item in options"
            :key="item.value"
            :label="item.label"
            :value="item.value">
          </el-option>
        </el-select>
      </div>
    </div>
    <div class="_movieShow_content">
      <el-table
        :data="tableData.filter(data => !search || data.name.toLowerCase().includes(search.toLowerCase()))"
        style="width: 100%">
        <el-table-column
          label="电影上映日期"
          prop="uploadDate"
          sortable>
        </el-table-column>
        <el-table-column
          label="电影名称"
          prop="name">
        </el-table-column>
        <el-table-column
          label="电影下映日期"
          prop="downDate"
          sortable>
        </el-table-column>
        <el-table-column
          label="状态"
          prop="state">
        </el-table-column>
        <el-table-column
          align="right">
          <template slot="header" slot-scope="scope">
            <el-input
              v-model="search"
              size="mini"
              placeholder="输入关键字搜索"/>
          </template>
          <template slot-scope="scope">
            <el-button
              size="mini"
              @click="handleEdit(scope.$index, scope.row)">修改
            </el-button>
            <el-button
              size="mini"
              type="info"
              @click="handleDelete(scope.$index, scope.row)">删除
            </el-button>
          </template>
        </el-table-column>
      </el-table>
    </div>
  </div>
</template>

<script>
  import admin from '../index.vue'
  import { getAllMovie } from '@/service/movieService.js'

  export default {
    name: 'movieShow',
    components: {admin},
    data() {
      return {
        // 所有上架电影
        movieList: [],
        // 状态筛选设置项
        options: [{
          value: '全部',
          label: '全部'
        },{
          value: '已下映',
          label: '已下映'
        }, {
          value: '热映中',
          label: '热映中'
        },{
          value: '未上映',
          label: '未上映'
        }],
        value: '',     // 电影状态筛选值
        startTime: null,  //电影上映时间
        endTime: null,   //电影下映时间
        // tableData: [{
        //   uploadDate: '2016-04-01',
        //   downDate: '2016-05-02',
        //   name: '复仇者联盟',
        //   state: '已上映'
        // }, {
        //   uploadDate: '2016-04-01',
        //   downDate: '2016-05-04',
        //   name: '蜘蛛侠',
        //   state: '未上映'
        // }, {
        //   uploadDate: '2016-04-01',
        //   downDate: '2016-05-01',
        //   name: '复仇者联盟',
        //   state: '已上映'
        // }, {
        //   uploadDate: '2016-04-01',
        //   downDate: '2016-05-03',
        //   name: '蚁人',
        //   state: '未上映'
        // }],
        search: '',
      }
    },
    computed: {
      tableData: function(){
        var movies = this.movieList
        if(this.startTime!==null){
          console.log(this.startTime)
          movies = movies.filter(function(movie){
            return new Date(movie.uploadDate).toDateString() === this.startTime.toDateString()
          },this)
        }
        if(this.endTime!==null){
          movies = movies.filter(function(movie){
            return new Date(movie.downDate).toDateString() === this.endTime.toDateString()
          },this)
        }
        if(this.value!==''&this.value!=='全部'){
          movies = movies.filter(function(movie){
            return movie.state===this.value
          },this)
        }
        return movies
      }
    },
    methods: {
      handleEdit(index, row) {
        console.log(index, row);
      },
      handleDelete(index, row) {
        console.log(index, row);
      },
      mark(movieList){
        var tmp = movieList
        for(var i = 0; i<tmp.length;i++){
            var start = new Date(tmp[i].uploadDate).getTime()
            var end = new Date(tmp[i].downDate).getTime()
            var now = new Date().getTime()
            if(start>now){
              tmp[i].state = '未上映'
            }
            else if(start<=now & now<=end){
              tmp[i].state = '热映中'
            }
            else{
              tmp[i].state = '已下映'
            }
          }
        return tmp
      }
    },
    mounted: function(){
      // getAllMovie().then(
      //   res => {
      //     console.log(res)
          
      //     this.movieList = this.mark(res)
      //   }
      // )
      this.movieList = this.mark([{
          uploadDate: '2016-04-01',
          downDate: '2016-05-02',
          name: '复仇者联盟',
          state: '已上映'
        }, {
          uploadDate: '2016-04-01',
          downDate: '2016-05-04',
          name: '蜘蛛侠',
          state: '未上映'
        }, {
          uploadDate: '2016-04-01',
          downDate: '2016-05-01',
          name: '复仇者联盟',
          state: '已上映'
        }, {
          uploadDate: '2019-07-01',
          downDate: '2019-08-03',
          name: '蚁人',
        }])
      
    }
  }
</script>

<style lang="scss">
  ._movieShow {
    text-align: start;
    color: #ffffff;
    padding: 15px 25px 15px 25px;
    // 页面首部
    ._movieShow_header {
      ._movieShow_header_title {
        font-size: 20px;
        padding-top: 10px;
      }

      ._movieShow_header_divider {
        width: 100%;
        height: 1px;
        background-color: #979797;
        margin: 10px auto;
      }
    }

    // 分级选择器
    ._movieShow_menu {
      font-size: 15px;
      padding-left: 20px;
      margin-bottom: 25px;

      ._movieShow_menu_item {
        margin-bottom: 17px;

        .block {
          display: inline-block;
        }
      }
    }

    // 内容表格
    ._movieShow_content {
      margin-left: 20px;
      border: solid 1px #cff9fe;
    }
  }
</style>
