<template>
    <admin>
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
                            <el-form>
                                <el-form-item label="地区">
                                    <el-select v-model="formInline.region" placeholder="活动区域">
                                        <el-option label="区域一" value="shanghai"></el-option>
                                        <el-option label="区域二" value="beijing"></el-option>
                                    </el-select>
                                </el-form-item>
                                <el-form-item label="类型">
                                    <el-select v-model="formInline.region" placeholder="活动区域">
                                        <el-option label="区域一" value="shanghai"></el-option>
                                        <el-option label="区域二" value="beijing"></el-option>
                                    </el-select>
                                </el-form-item>
                                <el-form-item label="规格">
                                    <el-select v-model="formInline.region" placeholder="活动区域">
                                        <el-option label="区域一" value="shanghai"></el-option>
                                        <el-option label="区域二" value="beijing"></el-option>
                                    </el-select>
                                </el-form-item>
                                <el-form-item label="状态">
                                    <el-select v-model="formInline.region" placeholder="活动区域">
                                        <el-option label="区域一" value="shanghai"></el-option>
                                        <el-option label="区域二" value="beijing"></el-option>
                                    </el-select>
                                </el-form-item>
                            </el-form>
                        </div>
                    </div>
                    <div class="_box_card_item">
                        <div class="_box_card_item_title"><span><strong>* </strong>电影名称</span></div>
                        <div class="_box_card_item_content">
                            <textarea name="电影简介" id="movieDescription"  placeholder="请输入电影简介"></textarea></div>
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
                        <div class="_box_card_item_content"><el-input-number v-model="num" controls-position="right" @change="handleChange" :min="1" ></el-input-number><span id="lasting">分钟</span></div>
                    </div>
                    <div class="_box_card_item">
                        <div class="_box_card_item_title"><span><strong>* </strong>电影上映日期</span></div>
                        <div class="_box_card_item_content">
                            <div class="block">
                                <el-date-picker
                                v-model="value2"
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
                                v-model="value2"
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
                            
                        </div>
                    </div>
                    <div class="_box_card_item">
                        <div class="_box_card_item_title"><span>剧照</span></div>
                        <div class="_box_card_item_content">
                            
                        </div>
                    </div>
                    <div class="_box_card_item">
                        <div class="_box_card_item_title"><span>视频</span></div>
                        <div class="_box_card_item_content">
                            
                        </div>
                    </div>

                </div>
                <div class="_box_card" id="_bt_submit">
                    <button id="submit"><span>确认上架</span></button>
                </div>
            </div>
        </div>
    </admin>
</template>

<script>
import admin from '../../views/admin/index.vue'
export default {
    name: 'movieManagement',
    components: {
        admin
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
        formInline: {
          user: '',
          region: ''
        },
        num: 120,
        pickerOptions: {
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
        value2: '',
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
      }
    }
}
</script>

<style lang="scss">
._box{
    border: none;
    width: 94%;
    margin: 0 auto;
    padding-top: 3%;
    padding-bottom: 3%;
    ._box_card{
        color: #ffffff;
        background-color: rgba($color: #d8d8d8, $alpha: 0.08);
        border-radius: 3px;
        text-align: start;
        padding-left: 25px;
        padding-bottom: 20px;
        ._box_card_title{
            ._box_card_title_name{
            padding-top: 10px;
            padding-left: 12px;
            font-size: 20px;
            }
            ._box_card_title_divider{
                width: 98%;
                height: 1px;
                background-color: #979797;
                margin: 10px auto;
            }
        }
        ._box_card_item{
            padding-left: 30px;
            margin-top: 25px;
            margin-bottom: 10px;
            #lasting{
                margin-left: 12px;
            }
            ._box_card_item_content{
                padding-left: 18px;
                margin-top: 10px;
            }
            // 电影名称的输入框
            #movieName{
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
            #movieDescription{
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
            *{
                background-color: transparent;
            }
        }
        // 处理确认提交的按钮
        #submit{
            display: block;
            background-color: transparent;
            border-radius: 4px;
            border: none;
            color: #FFFFFF;
            text-align: center;
            font-size: 23px;
            font-weight: 400;
            width: 170px;
            transition: all 0.5s;
            cursor: pointer;
            margin: 0px auto;
            border: solid #cff9fe;
        }
    }
    #_bt_submit{
        margin-top: 20px;
        padding-top: 20px;
        background-color: #131c1c;
    }
}
</style>


