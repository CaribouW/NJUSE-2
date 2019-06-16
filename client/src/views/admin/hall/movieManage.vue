<template>
  <div class="movie_manage">
    <div class="_box">
      <div class="_box_card" id="info1">
        <div class="_box_card_title">
          <div class="_box_card_title_name">基础信息</div>
          <div class="_box_card_title_divider"></div>
        </div>
        <div class="_box_card_item">
          <div class="_box_card_item_title"><span><strong>* </strong>电影名称</span></div>
          <div class="_box_card_item_content"><input id=movieName v-model="movieName" placeholder="请输入电影名称"></div>
        </div>
        <div class="_box_card_item">
          <div class="_box_card_item_title"><span><strong>* </strong>电影横版海报</span></div>
          <div class="_box_card_item_content">
            <el-upload
              class="poster"
              action="https://jsonplaceholder.typicode.com/posts/"
              list-type="picture-card"
              :on-preview="handlePictureCardPreview"
              :on-remove="handleRemove">
              <i class="el-icon-plus"></i>
            </el-upload>
            <el-dialog :visible.sync="dialogVisible">
              <img width="100%" :src="dialogImageUrl" alt="">
            </el-dialog>
          </div>
        </div>
        <div class="_box_card_item">
          <div class="_box_card_item_title"><span><strong>* </strong>电影竖版海报</span></div>
          <div class="_box_card_item_content">
            <el-upload
              action="https://jsonplaceholder.typicode.com/posts/"
              list-type="picture-card"
              :on-preview="handlePictureCardPreview"
              :on-remove="handleRemove">
              <i class="el-icon-plus"></i>
            </el-upload>
            <el-dialog :visible.sync="dialogVisible">
              <img width="100%" :src="dialogImageUrl" alt="">
            </el-dialog>
          </div>
        </div>
        <div class="_box_card_item">
          <div class="_box_card_item_title"><span><strong>* </strong>分类</span></div>
          <div class="_box_card_item_content">
            <div class="region category">
              <span class="category_title">地区：</span>
              <input class="category_input" v-model="region" placeholder="请输入地区"/>
            </div>
            <div class="language category">
              <span class="category_title">语言：</span>
              <input class="category_input" v-model="language" placeholder="请输入语言"/>
            </div>
            <div class="type category">
              <span class="category_title">类型：</span>
              <el-select v-model="type" multiple placeholder="请选择电影类型">
                <el-option
                  v-for="item in options"
                  :key="item.value"
                  :label="item.label"
                  :value="item.value">
                </el-option>
              </el-select>
            </div>
          </div>
        </div>
        <div class="_box_card_item">
          <div class="_box_card_item_title"><span><strong>* </strong>电影名称</span></div>
          <div class="_box_card_item_content">
            <textarea name="电影简介" id="movieDescription" placeholder="请输入电影简介"></textarea></div>
        </div>
      </div>
      <br>
      <!-- 放映信息 -->
      <div class="_box_card" id="info2">
        <div class="_box_card_title">
          <div class="_box_card_title_name">放映信息</div>
          <div class="_box_card_title_divider"></div>
        </div>
        <div class="_box_card_item">
          <div class="_box_card_item_title"><span><strong>* </strong>电影时长</span></div>
          <div class="_box_card_item_content">
            <el-input-number v-model="num" controls-position="right" @change="handleChange" :min="1"></el-input-number>
            <span id="lasting">分钟</span></div>
        </div>
        <div class="_box_card_item">
          <div class="_box_card_item_title"><span><strong>* </strong>电影上映日期</span></div>
          <div class="_box_card_item_content">
            <div class="block">
              <el-date-picker
                v-model="upDate"
                align="right"
                type="date"
                placeholder="选择日期"
                :picker-options="pickerOptions">
              </el-date-picker>
            </div>
          </div>
        </div>
        <div class="_box_card_item">
          <div class="_box_card_item_title"><span><strong>* </strong>电影下映日期</span></div>
          <div class="_box_card_item_content">
            <div class="block">
              <el-date-picker
                v-model="downDate"
                align="right"
                type="date"
                placeholder="选择日期"
                :picker-options="pickerOptions">
              </el-date-picker>
            </div>
          </div>
        </div>
      </div>
      <br>
      <!-- 更多信息 -->
      <div class="_box_card" id="info3">
        <div class="_box_card_title">
          <div class="_box_card_title_name">更多信息</div>
          <div class="_box_card_title_divider"></div>
        </div>
        <div class="_box_card_item">
          <div class="_box_card_item_title"><span>电影预告片</span></div>
          <div class="_box_card_item_content">
            <el-upload
              class="upload-demo"
              drag
              action="https://jsonplaceholder.typicode.com/posts/"
              multiple>
              <i class="el-icon-upload"></i>
              <div class="el-upload__text">将文件拖到此处，或<em>点击上传</em></div>
              <!-- <div class="el-upload__tip" slot="tip">只能上传jpg/png文件，且不超过500kb</div> -->
            </el-upload>
          </div>
        </div>
        <div class="_box_card_item">
          <div class="_box_card_item_title"><span>剧照</span></div>
          <div class="_box_card_item_content">
            <el-upload
              action="https://jsonplaceholder.typicode.com/posts/"
              list-type="picture-card"
              :on-preview="handlePictureCardPreview"
              :on-remove="handleRemove">
              <i class="el-icon-plus"></i>
            </el-upload>
            <el-dialog :visible.sync="dialogVisible">
              <img width="100%" :src="dialogImageUrl" alt="">
            </el-dialog>
          </div>
        </div>
        <div class="_box_card_item">
          <div class="_box_card_item_title"><span>视频</span></div>
          <div class="_box_card_item_content">
            <el-upload
              class="upload-demo"
              drag
              action="https://jsonplaceholder.typicode.com/posts/"
              multiple>
              <i class="el-icon-upload"></i>
              <div class="el-upload__text">将文件拖到此处，或<em>点击上传</em></div>
              <!-- <div class="el-upload__tip" slot="tip">只能上传jpg/png文件，且不超过500kb</div> -->
            </el-upload>
          </div>
        </div>

      </div>
      <div class="_box_card" id="_bt_submit">
        <el-button round style="color:#CFF9FE;" @click="goSubmit()">确认上架</el-button>
      </div>
    </div>
  </div>
</template>

<script>
  export default {
    name: 'movieManagement',
    components: {
    },
    data() {
      return {
        movieName: '',
        labelPosition: 'top',
        formLabelAlign: {
          name: '',
          region: '',
          type: ''
        },
        dialogImageUrl: '',
        dialogVisible: false,

        options: [{
          value: '喜剧',
          label: '喜剧'
        }, {
          value: '爱情',
          label: '爱情'
        }, {
          value: '动作',
          label: '动作'
        }, {
          value: '枪战',
          label: '枪战'
        }, {
          value: '犯罪',
          label: '犯罪'
        }, {
          value: '惊悚',
          label: '惊悚'
        }, {
          value: '恐怖',
          label: '恐怖'
        }, {
          value: '悬疑',
          label: '悬疑'
        }, {
          value: '动画',
          label: '动画'
        }, {
          value: '家庭',
          label: '家庭'
        }, {
          value: '奇幻',
          label: '奇幻'
        }, {
          value: '魔幻',
          label: '魔幻'
        }, {
          value: '科幻',
          label: '科幻'
        }, {
          value: '战争',
          label: '战争'
        }, {
          value: '青春',
          label: '青春'
        }],
        region: '',
        language: '',
        type:[],

        num: 120, // 放映时长
        pickerOptions: {
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
        upDate: '', //上映时间
        downDate: '', //下映时间

      };
    },
    methods: {
      handleRemove(file, fileList) {
        console.log(file, fileList);
      },
      handlePictureCardPreview(file) {
        this.dialogImageUrl = file.url;
        this.dialogVisible = true;
      },
      handleChange(value) {
        console.log(value);
      },
      goSubmit(){
        alert("暂未与后端接通")
      }
    }
  }
</script>

<style lang="scss">
  ._box {
    border: none;
    width: 94%;
    margin: 0 auto;
    padding-top: 3%;
    padding-bottom: 3%;

    ._box_card {
      color: #ffffff;
      background-color: rgba($color: #d8d8d8, $alpha: 0.08);
      border-radius: 3px;
      text-align: start;
      padding-left: 25px;
      padding-bottom: 20px;

      ._box_card_title {
        ._box_card_title_name {
          padding-top: 10px;
          padding-left: 12px;
          font-size: 20px;
        }

        ._box_card_title_divider {
          width: 98%;
          height: 1px;
          background-color: #979797;
          margin: 10px auto;
        }
      }

      ._box_card_item {
        padding-left: 30px;
        margin-top: 25px;
        margin-bottom: 10px;

        #lasting {
          margin-left: 12px;
        }

        ._box_card_item_content {
          padding-left: 18px;
          margin-top: 10px;
          .category{
            font-size: 15px;
            margin-bottom: 10px;
            .category_input{
              background-color: transparent;
              border: solid 1px #cff9fe;
              border-radius: 4px;
              width: 40%;
              height: 40px;
              padding-left: 10px;
              color: #ffffff;
              // font-size: 17px;
            }
          }
        }

        // 电影名称的输入框
        #movieName {
          background-color: transparent;
          border: solid 1px #cff9fe;
          border-radius: 4px;
          width: 90%;
          height: 40px;
          padding-left: 10px;
          color: #ffffff;
          font-size: 17px;
        }

        // 电影简介的多行输入框
        #movieDescription {
          background-color: transparent;
          border: solid 1px #cff9fe;
          border-radius: 4px;
          width: 90%;
          height: 200px;
          padding: 10px;
          color: #ffffff;
          font-size: 17px;
        }

        // 处理element组件背景不一致的问题
        * {
          background-color: transparent;
        }
      }
    }

    #_bt_submit {
      margin-top: 20px;
      padding-top: 20px;
      background-color: #212323;
      .el-button{
        width: 220px;
        border-radius: 25px;
        padding: 8px 65px;
        background-color: rgba($color: #131C1C, $alpha: 0.5);
        font-size: 20px;
        color: #CFF9FE;
        border-color: #CFF9FE;
        margin-left: 36%;
        
      }
    }
    .el-select{
      width: 41.5%;
    }
  }
</style>


