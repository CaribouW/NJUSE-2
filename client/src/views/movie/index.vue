<template>
  <div class="movie">
    <div class="movie_poster">
      <img src="@/assets/images/movie/海王.png" alt="@/assets/images/movie/海王.png">
      <div class="movie_poster_name">{{movieInfo.name}}</div>
      <div class="movie_poster_typeAndFavour" v-if="movieInfo.basicInfo.type">{{movieInfo.basicInfo.type}}<span>{{favorCounter}}人想看</span>
      </div>
      <div class="movie_poster_mark">
        <span v-if="!favor" @click="addFavor">标记为喜爱</span>
        <span v-else class="favour" @click="deleteFavor">已标记为喜爱</span>
      </div>
      <div class="movie_poster_purchase" @click="purchaseDialogVisible = true">
        立即购票
      </div>
    </div>
    <div class="movie_info">
      <div class="movie_info_head">
        <img src="@/assets/images/homepage/dianying.png" alt="">
        DETAILS
      </div>
      <div class="movie_info_content">
        <el-tabs tab-position="left">
          <el-tab-pane label="信息">
            <div class="movie_info_content_briefIntro"><span>电影简介</span>
              《海王》是由美国华纳兄弟影片公司出品的动作奇幻片，由华裔导演温子仁执导，
              杰森·莫玛、艾梅柏·希尔德、帕特里克·威尔森、叶海亚·阿卜杜勒-迈丁、妮可·基德曼、
              威廉·达福、杜夫·龙格尔联合主演。《海王》根据DC漫画改编，讲述了半人半亚特兰蒂
              斯血统的亚瑟·库瑞踏上永生难忘的征途——他不但需要直面自己的特殊身世，更不得不
              面对生而为王的考验，以及和湄拉一同对抗同母异父的兄弟奥姆的故事。
            </div>
            <img :src="movieInfo.pic" alt="" class="briefIntro_img">
            <div>
              <span class="basicInfo_title">基本信息</span>
              <div class="movie_info_content_basicInfo">
                <div>中文名</div>
                <div>{{movieInfo.basicInfo.ChineseName || '无'}}</div>
                <div>类型</div>
                <div v-if="movieInfo.basicInfo.type">{{movieInfo.basicInfo.type || '无'}}</div>
              </div>
              <div class="movie_info_content_basicInfo">
                <div>英文名</div>
                <div>{{movieInfo.basicInfo.EnglishName || '无'}}</div>
                <div>片长</div>
                <div>{{movieInfo.basicInfo.duration || '无'}}分钟</div>
              </div>
              <div class="movie_info_content_basicInfo">
                <div>出品公司</div>
                <div>{{movieInfo.basicInfo.productionCompany || '无'}}</div>
                <div>上映时间</div>
                <div>{{movieInfo.basicInfo.showTime || '无'}}</div>
              </div>
              <div class="movie_info_content_basicInfo">
                <div>发行公司</div>
                <div>{{movieInfo.basicInfo.distributionCompany || '无'}}</div>
                <div>导演</div>
                <div>{{movieInfo.basicInfo.director || '无'}}</div>
              </div>
              <div class="movie_info_content_basicInfo">
                <div>语言</div>
                <div>{{movieInfo.basicInfo.language || '无'}}</div>
                <div>imdb编码</div>
                <div>{{movieInfo.basicInfo.imdb || '无'}}</div>
              </div>
            </div>
          </el-tab-pane>
          <el-tab-pane label="演职人员">
            <div>导演</div>
            <div class="movie_info_content_director">
              <div class="movie_info_content_director_each" v-for="i in 2">
                <img :src="movieInfo.pic" alt="">
                <div>杰森·莫玛</div>
                <div>饰</div>
                <div>亚瑟·库瑞</div>
              </div>
            </div>
            <div>演员</div>
            <div class="movie_info_content_actor">
              <div class="movie_info_content_director_each" v-for="i in 10">
                <img :src="movieInfo.pic" alt="">
                <div>杰森·莫玛</div>
                <div>饰</div>
                <div>亚瑟·库瑞</div>
              </div>
            </div>
          </el-tab-pane>
          <el-tab-pane label="视频和剧照">
            <div>剧照</div>
            <div class="movie_info_content_director">
              <div class="movie_info_content_director_each" v-for="i in 2">
                <img :src="movieInfo.pic" alt="">
              </div>
            </div>
            <div>视频</div>
            <div class="movie_info_content_actor">
              <div class="movie_info_content_director_each" v-for="i in 10">
                <img :src="movieInfo.pic" alt="">
              </div>
            </div>
          </el-tab-pane>
          <el-tab-pane label="票房">票房
            <ve-line :data="chartData" width="800px" height="400px"></ve-line>
            <div></div>
          </el-tab-pane>
        </el-tabs>
      </div>
    </div>
    <div class="movie_purchase">
      <el-dialog
        :visible.sync="purchaseDialogVisible"
        :modal-append-to-body='false'
        top="5vh"
        width="60%">
        <div class="movieInfo">
          <span>{{movieInfo.name}}</span> <span>豆瓣评分 {{movieInfo.score}}</span>
          <span v-if="movieInfo.basicInfo.type">{{movieInfo.basicInfo.type}}</span><span>{{movieInfo.basicInfo.duration}}分钟</span>
        </div>
        <div class="movieDate">
          <span v-for="each in scheduleDate">{{each}}</span>
        </div>
        <div class="movieTime" v-if="scheduleDate.length !== 0">
          <el-carousel :interval="0" type="card" height="430px" indicator-position="none" :autoplay="false"
                       :loop="false">
            <el-carousel-item v-for="(item, index) in scheduleDate" :key="index" v-if="scheduleDate">
              <span class="medium">{{ item }}</span>
              <div class="movieTime_ticket">
                <ticket v-for="i in schedule" :key="i.startTime" @selectSeatChildNotify="confirmSeat" :schedule="i"
                        v-if="i.startTime.slice(0, 10) === item" :id="i.slotId"></ticket>
              </div>
            </el-carousel-item>
          </el-carousel>
        </div>
        <div v-else class="error">
          暂无排片
        </div>
        <div slot="title" class="header-title">
          <img src="@/assets/images/movie/title.png" alt="">
        </div>
      </el-dialog>
    </div>
    <div class="movie_selectSeat">
      <el-dialog
        :visible.sync="selectSeatDialogVisible"
        :modal-append-to-body='false'
        top="5vh"
        width="60%">
        <div class="movie">
          <span>{{movieInfo.name}}</span><span>{{(ticketInfo.startTime || '').slice(0,10)}}</span>
          <span>{{(ticketInfo.startTime || '').slice(10,16)}}-{{(ticketInfo.endTime || '').slice(10,16)}}</span><span>普通3D</span>
        </div>
        <div class="seat">
          <div class="seat_head">
            <img src="@/assets/images/movie/TIM图片20190609150257.png" alt=""><span>已选</span>
            <img src="@/assets/images/movie/TIM图片20190609150410.png" alt=""><span>可选</span>
            <img src="@/assets/images/movie/TIM图片20190610142614.png" alt=""><span>当前选择</span>
          </div>
          <div class="seat_content">
            <div class="seat_content_screen">
              {{hall.name}}厅 银幕
            </div>
            <div v-for="(cols,colIndex) in seat" :key="colIndex">
              <div v-for="(each, rolIndex) in cols" :key="rolIndex">
                <img src="@/assets/images/movie/TIM图片20190609150257.png" alt="" v-if="each==0">
                <img src="@/assets/images/movie/TIM图片20190609150410.png" alt="" v-if="each==1"
                     class="canSelect" @click="selectSeat(colIndex, rolIndex, $event)">
                <img src="@/assets/images/movie/TIM图片20190610142614.png" alt="" v-if="each==2"
                     class="canSelect" @click="selectSeat(colIndex, rolIndex, $event)">
              </div>
            </div>
          </div>
        </div>
        <div class="selectedTicket">
          <div v-for="item in selectedSeat">
            <span>{{item[0]+1}}排{{item[1]+1}}座</span>
            <span>{{ticketInfo.ticketPrize}}元</span>
          </div>
        </div>
        <div class="seatConfirmbuttom" @click="comfirmOrder" v-if="selectedSeat.length>0">
          {{totalPrice}}元 确认选座
        </div>
        <div slot="title" class="header-title">
          <img src="@/assets/images/movie/title.png" alt="">
        </div>
      </el-dialog>
    </div>
    <div class="movie_confirmOrder">
      <el-dialog
        :visible.sync="confirmOrderDialogVisible"
        :before-close="cancelOrder"
        :modal-append-to-body='false'
        top="0vh"
        width="60%">
        <div class="confirmOrder_ticket">
          <div class="confirmOrder_ticket_left">
            <span>{{movieInfo.name}}</span><span>{{selectedSeat.length}}张</span><br/>
            <span>{{(ticketInfo.startTime || '').slice(0,10)}}</span><span>{{(ticketInfo.startTime || '').slice(10,16)}}～{{(ticketInfo.endTime || '').slice(10,16)}}</span><span>（普通3D）</span><br/><span>凉凉电影院南京大学仙林校区店</span><br/>
            <span>{{hall.name}}厅</span><span v-for="item in selectedSeat"
                                             class="seat">{{item[0]+1}}排{{item[1]+1}}座</span>
          </div>
          <div class="confirmOrder_ticket_center">
            <img :src="movieInfo.pic" alt="">
          </div>
          <div class="confirmOrder_ticket_right">{{PrefixInteger(time.minute, 2)}} : {{PrefixInteger(time.second, 2)}}
          </div>
        </div>
        <div class="confirmOrder_coupon">
          <el-collapse>
            <el-collapse-item title="电影优惠券" name="1">
              <el-radio v-model="coupon" label="1">不使用优惠券</el-radio>
              <br/>
              <el-radio v-model="coupon" label="2">使用优惠券</el-radio>
              <div v-if="coupon === '2'">
                <el-radio v-model="couponSelect" :label="item" v-for="(item, index) in trueCoupon" :key="index">
                  <div class="confirmOrder_coupon_each">
                    <div>{{item.couponName}}</div>
                    <div>满{{item.useCondition}}减{{item.couponAmount}}</div>
                  </div>
                </el-radio>
                <div v-if="falseCoupon.length !== 0">不满足条件的优惠券</div>
                <div v-if="falseCoupon.length !== 0" class="confirmOrder_coupon_each" v-for="(item, index) in falseCoupon" :key="index">
                  <div>{{item.couponName}}</div>
                  <div>满{{item.useCondition}}减{{item.couponAmount}}</div>
                </div>
              </div>
              <br/>
            </el-collapse-item>
          </el-collapse>
        </div>
        <div class="confirmOrder_price">
          <span>票价总计</span><span>{{needPrice}}元</span>
        </div>
        <div class="confirmOrder_know">
          <h3>购票须知</h3>
          <li> 1.方特主题乐园门票一经预定成功后购票订单一经确认即时成交，有关退改规定，请详见门票《预订须知》对应的退票
            和改期规则。请务必确认信息无误再进行购买。
          </li>
          <li>2.方特主题乐园的所有门票均为指定日票，游客购买门票需指定入园日期，日期选择以购票页面可选日期为准。购票前
            请根据提示选择入园日期，填写正确的联系方式、身份证号码等信息，购票成功将收到确认信息。
          </li>
          <li>3.同一订单下的所有游客需同时入园，购票时登记的有效证件持有人本人必须在场，同行游客无需出示证件。</li>
          <li>4.购买成功的门票仅限选择的入园日期当日有效，仅限使用一次，出园后再次入园需重新购买。同一订单为同一个取票
            凭证，如不同时间入园，请提供不同身份证分批下单。景区现场当天最迟取票激入园截止时间为乐园闭园前两小时。
          </li>
        </div>
        <div class="confirmOrder_pay">
          <span>不支持退票/改签</span><span>应付：<span>{{needPrice}}元</span></span>
          <div class="confirmOrder_pay_buttom" @click="pay()">立即付款</div>
        </div>
        <div slot="title" class="header-title">
          确认订单
        </div>
      </el-dialog>
    </div>
    <div class="movie_pay">
      <el-dialog
        :visible.sync="payDialogVisible"
        :modal-append-to-body='false'
        top="20vh"
        width="40%">
        <div class="movie_pay_price">¥{{needPrice}}元</div>
        <el-radio-group v-model="payRadio">
          <el-radio label="1">会员卡支付</el-radio>
          <el-radio label="2">银行卡支付</el-radio>
        </el-radio-group>
        <div class="movie_pay_memberCard" v-if="payRadio=='1'">
          <div class="movie_pay_memberCard_account">
            <span>会员卡账号</span><span>123456790129388</span>
          </div>
          <div class="movie_pay_memberCard_pay" @click="payByMember">立即付款</div>
        </div>
        <div class="movie_pay_bankCard" v-else>
          <div>
            <span>银行卡号：</span>
            <el-input v-model="bank.account" placeholder="请输入账号"></el-input>
            <br/>
          </div>
          <div>
            <span>密码：</span>
            <el-input v-model="bank.password" placeholder="请输入密码"></el-input>
          </div>
          <div class="movie_pay_bankCard_pay" @click="payByBank">立即付款</div>
        </div>
        <div slot="title" class="header-title">
          确认付款
        </div>
      </el-dialog>
    </div>
    <div class="movie_paySuccess">
      <el-dialog
        :visible.sync="paySuccessDialogVisible"
        :modal-append-to-body='false'
        top="2vh"
        width="60%">
        <!-- <div class="Separator"></div> -->
        <div class="movie_paySuccess_status">
          <span>付款成功</span>
          <span>已完成付款，请在电影开始前15分钟到达，进行取票</span>
          <div @click="goOrderHistory">查看历史订单</div>
          <div @click="goHomepage">返回首页</div>
        </div>
        <div class="movie_paySuccess_ticket">
          <div class="movie_paySuccess_ticket_left">
            <span style="white-space: nowrap">{{movieInfo.name}}</span>
            <span>{{selectedSeat.length}}张</span><br/>
            <span>{{(ticketInfo.startTime || '').slice(0,10)}}</span>
            <span>{{(ticketInfo.startTime || '').slice(10,16)}}～{{(ticketInfo.endTime || '').slice(10,16)}}</span><span>（普通3D）</span><br/><span>凉凉电影院南京大学仙林校区店</span><br/>
            <div class="last-line">
              <span>{{hall.name}}厅</span>
              <div>
              <span v-for="item in selectedSeat"
                    class="seat">{{item[0]+1}}排{{item[1]+1}}座</span>
              </div>
            </div>
          </div>
          <div class="movie_paySuccess_ticket_right">
            <img :src="movieInfo.pic" alt="">
          </div>
        </div>
        <div class="movie_paySuccess_cinema">
          <div class="movie_paySuccess_cinema_left">
            <div>NULL&NONE南京仙林影城</div>
            <div>栖霞区学津路1号金鹰湖滨广场B区4层</div>
          </div>
          <div class="movie_paySuccess_cinema_right">
            <img src="@/assets/images/movie/dianhua.png" alt="">
            <div>18852096585</div>
          </div>
        </div>
        <div class="movie_paySuccess_orderDetail">
          <li>实付金额: <span>{{needPrice}}元</span></li>
          <li>订单号：277647390117524527</li>
          <li>购买时间：{{nowTime}}</li>
          <li>电影票由凉凉电影院提供</li>
        </div>
        <div slot="title" class="header-title">
          电影票详情
        </div>
      </el-dialog>
    </div>
  </div>
</template>


<script>
  import $ from "jquery";
  import ticket from '@/views/movie/components/ticket.vue'
  import {mapGetters, mapActions} from 'vuex'

  export default {
    components: {
      ticket
    },
    data() {
      return {
        nowTime: '2019-06-07 18：18：46',
        favorList: [],
        ticketInfo: {},
        hall: {},
        chartData: {
            columns: ['日期', '票房'],
            rows: [
              { '日期': '6月1日', '票房': 1231 },
              { '日期': '6月2日', '票房': 1223 },
              { '日期': '6月3日', '票房': 2123 },
              { '日期': '6月4日', '票房': 4123 },
              { '日期': '6月5日', '票房': 3123 },
              { '日期': '6月6日', '票房': 7123 }
            ]
          },
        // 座位
        seat: [],

        seatImg: [
          require('@/assets/images/movie/TIM图片20190609150257.png'),
          require('@/assets/images/movie/TIM图片20190609150410.png'),
          require('@/assets/images/movie/TIM图片20190610142614.png')
        ],
        // 银行卡账号密码
        bank: {
          account: '',
          password: ''
        },
        // 选择支付方式
        payRadio: '1',
        // 选择优惠券
        coupon: '1',
        // 倒计时控制
        time: {
          total: 900,
          minute: 15,
          second: 0,
        },
        // 弹出对话框控制
        purchaseDialogVisible: false,
        selectSeatDialogVisible: false,
        confirmOrderDialogVisible: false,
        payDialogVisible: false,
        paySuccessDialogVisible: false,
        movieInfo: {},
        // 计时器
        oTimer: null,
        schedule: [],
        orderId: '',
        favorCounter: 0,
        // 用户优惠券
        couponList: [],
        couponSelect: {
          couponAmount: 0
        }
      }
    },
    computed: {
      selectedSeat: function () {
        let arr = []
        let _this = this
        for (let i = 0; i < _this.seat.length; i++) {
          for (let j = 0; j < _this.seat[0].length; j++) {
            if (_this.seat[i][j] == 2) {
              arr.push(new Array(i, j))
            }
          }
        }
        return arr
      },
      totalPrice: function () {
        return this.selectedSeat.length * this.ticketInfo.ticketPrize
      },
      needPrice: function () {
        return this.totalPrice - this.couponSelect.couponAmount
      },
      scheduleDate: function () {
        var arr = []
        var time = this.getNowFormatDate()
        console.log(time)
        this.schedule.forEach(function (obj) {
          if (arr.indexOf(obj.startTime.slice(0, 10)) == -1 && obj.startTime > time) {
            arr.push(obj.startTime.slice(0, 10))
          }
        })
        return arr
      },
      ticketDate: function () {
        // return this.ticketInfo.startTime.slice(0,10)
      },
      favor: function () {
        var ret = false;
        if (this.favorList.length === 0) {
          return false
        } else {
          this.favorList.forEach(each => {
            if (each.movieId === this.$route.query.movieId) {
              ret = true
            }
          });
          return ret
        }
      },
      trueCoupon: function () {
        var ret = []
        this.couponList.forEach(element => {
          if (element.useCondition <= this.totalPrice && element.state == 1) {
            ret.push(element)
          }
        });
        return ret
      },
      falseCoupon: function () {
        var ret = []
        this.couponList.forEach(element => {
          if (element.useCondition > this.totalPrice && element.state == 1) {
            ret.push(element)
          }
        });
        return ret
      },
      ...mapGetters({
        halls: 'hallList'
      })
    },
    methods: {
      ...mapActions({
        flushHall: 'getHalls'
      }),
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
      checkQuickPurchase() {
        var _this = this
        if (_this.$store.state.movie.quickPurchase) {
          _this.$store.dispatch('getMovieSchedule').then(res => {
            _this.schedule = []
            res.slot.forEach(function (obj) {
              if (_this.$route.query.movieId === obj.movieId) {
                _this.schedule.push(obj)
              }
            })
            return _this.schedule
          }).then((data) => {
            // console.log(data)
            // console.log(_this.$store.state.movie.quickPurchase)
            _this.purchaseDialogVisible = true
            // console.log($("#"+_this.$store.state.movie.quickPurchase.scheduleId))
            $("#"+_this.$store.state.movie.quickPurchase.scheduleId).click()
          })
        }
      },
      addFavor() {
        this.$store.dispatch('addFavor', {
          userId: sessionStorage.getItem('userId'),
          movieId: this.$route.query.movieId,
        }).then(res => {
          console.log(res)
          this.getFavorList()
          this.getFavorCounter()
        })
      },
      deleteFavor() {
        this.$store.dispatch('deleteFavor', {
          userId: sessionStorage.getItem('userId'),
          movieId: this.$route.query.movieId,
        }).then(res => {
          this.getFavorList()
          this.getFavorCounter()
        })
      },
      getFavorCounter() {
        this.$store.dispatch('getFavorCounter', {
          movieId: this.$route.query.movieId
        }).then(res => {
          this.favorCounter = res.sum
        })
      },
      // 获取当前用户想看列表
      getFavorList() {
        this.$store.dispatch('getFavorList', {
          userId: sessionStorage.getItem('userId')
        }).then(res => {
          this.favorList = res
          console.log(this.favorList)
        })
      },
      // 消耗优惠券
      useCoupon() {
        console.log(this.couponSelect)
        this.$store.dispatch('useCoupon', {
          userId: sessionStorage.getItem('userId'),
          couponId: this.couponSelect.couponUserId
        }).then(res => {
          console.log(res)
        })
      },
      // 返回首页
      goOrderHistory() {
        this.$router.push('/user/history')
      },
      goHomepage() {
        this.$router.push('/index')
      },
      // 显示倒计时时自动补零函数
      PrefixInteger(num, n) {
        return (Array(n).join(0) + num).slice(-n);
      },
      // 倒计时函数
      startCountDown() {
        this.oTimer = setInterval(() => {
          this.time.total--
          this.time.second = parseInt(this.time.total % 60)
          this.time.minute = parseInt(this.time.total / 60)
          if (this.time.total == 0) {
            this.stopCountDown()
          }
        }, 1000)
      },
      stopCountDown() {
        window.clearInterval(this.oTimer)
      },
      // 选座函数
      selectSeat(col, rol, event) {
        var el = event.currentTarget
        if (this.seat[col][rol] === 1) {
          this.$set(this.seat[col], rol, 2)
          el.src = this.seatImg[2]
        } else {
          // 取消选座
          this.$set(this.seat[col], rol, 1)
          el.src = this.seatImg[1]
        }
      },
      confirmSeat(data) {
        this.purchaseDialogVisible = false
        this.selectSeatDialogVisible = true
        // 获取座位信息
        this.hall = data[0]
        this.ticketInfo = data[1]
        console.log(this.ticketInfo)
        console.log(this.hall)
        this.$store.dispatch('getRestSchedule', {
          scheduleId: this.ticketInfo.slotId
        }).then(res => {
          this.seat = res
        })
      },
      // 确认订单函数
      comfirmOrder() {
        this.selectSeatDialogVisible = false
        this.confirmOrderDialogVisible = true
        this.time.total = 900
        this.startCountDown()

      },
      // 取消订单函数
      cancelOrder(done) {
        // 初始化倒计时
        this.stopCountDown()
        this.time.total = 900
        this.time.second = parseInt(this.time.total % 60)
        this.time.minute = parseInt(this.time.total / 60)
        done()
      },
      // 确认订单后付款
      pay() {
        var seats = []
        this.selectedSeat.forEach(each => {
          var ret = each[0] + "," + each[1]
          seats.push(ret)
        })
        // 确认订单
        this.$store.dispatch('confirmOrder', {
          userId: sessionStorage.getItem('userId'),
          scheduleId: this.ticketInfo.slotId,
          confirmTime: this.getNowFormatDate(),
          seats: seats
        }).then(res => {
          console.log(res)
          if (res.orderId) {
            this.orderId = res.orderId
            this.payDialogVisible = true
            this.useCoupon()
          } else {
            this.$message.error('出错了')
          }
        })
      },
      // 银行卡付款
      payByBank() {
        if (this.bank.account === '12345678' && this.bank.password === '12345678') {
          this.payDialogVisible = false
          this.confirmOrderDialogVisible = false
          this.paySuccessDialogVisible = true
          this.nowTime = this.getNowFormatDate()
        } else {
          this.$message.error('账号密码错误！')
        }
      },
      // 会员卡付款
      payByMember() {
        this.payDialogVisible = false
        this.confirmOrderDialogVisible = false
        this.$store.dispatch('consume', {
          userId: sessionStorage.getItem('userId'),
          consumption: this.needPrice,
          orderId: this.orderId,
        }).then(res => {
          console.log(res)
          if (res === 605) {
            this.$message.error('您的余额不足，请充值。')
          } else {
            this.paySuccessDialogVisible = true
            this.nowTime = this.getNowFormatDate()
          }
        })

      },
      getNowFormatDate() {
        var date = new Date();
        var seperator1 = "-";
        var seperator2 = ":";
        var month = date.getMonth() + 1 < 10 ? "0" + (date.getMonth() + 1) : date.getMonth() + 1;
        var strDate = date.getDate() < 10 ? "0" + date.getDate() : date.getDate();
        var hours = date.getHours() < 10 ? "0" + date.getHours() : date.getHours()
        var minutes = date.getMinutes() < 10 ? "0" + date.getMinutes() : date.getMinutes()
        var seconds = date.getSeconds() < 10 ? "0" + date.getSeconds() : date.getSeconds()
        var currentdate = date.getFullYear() + seperator1 + month + seperator1 + strDate
          + " " + hours + seperator2 + minutes
          + seperator2 + seconds
        return currentdate;
      }
    },
    created() {
      var _this = this
      
      // 获取电影详情
      this.$store.dispatch('getMovieBasicInfo', {
        userId: sessionStorage.getItem('userId'),
        movieId: this.$route.query.movieId
      }).then(res => {
        this.movieInfo = res
        console.log(this.movieInfo)
      })
      // 获取电影排片
      _this.$store.dispatch('getMovieSchedule').then(res => {
        res.slot.forEach(function (obj) {
          if (_this.$route.query.movieId === obj.movieId) {
            _this.schedule.push(obj)
          }
        })
      })
      _this.checkQuickPurchase()
      // 获取用户拥有优惠券
      _this.$store.dispatch('getCoupon', {
        userId: sessionStorage.getItem('userId'),
      }).then(res => {
        console.log(res)
        _this.couponList = res
      })
      // 获取
      _this.getFavorList()
      _this.getFavorCounter()
    }
  }
</script>

<style lang="scss">
  .movie {
    &_poster {
      background: url('../../assets/images/movie/Assets.png') no-repeat;
      background-size: 100% 100%;
      margin: 20px 0;
      padding-bottom: 40px;
      position: relative;
      &_mark, &_purchase {
        position: absolute;
        width: 240px;
        height: 57px;
        box-sizing: border-box;
        line-height: 54px;
        border-radius: 15px;
        border: 2px solid #CFF9FE;
        font-size: 24px;
        left: 200px;
        top: 350px;
        cursor: pointer;
      }

      &_mark {
        > span {
          display: block;
        }
      }

      &_purchase {
        top: 450px;
        // font-weight: bold;
        color: #CFF9FE;
      }

      .favour {
        color: #CFF9FE;
      }

      &_mark:hover, &_purchase:hover {
        font-weight: bold;
      }

      &_name, &_typeAndFavour {
        position: absolute;
        left: 200px;
        top: 130px;
        font-size: 80px;
        // font-weight: bold;
      }

      &_typeAndFavour {
        // font-weight: normal;
        top: 260px;
        font-size: 16px;

        > span {
          display: inline-block;
          margin-left: 70px;
        }
      }
    }

    &_info {
      &_head {
        color: #CFF9FE;
        font-size: 48px;
        margin-bottom: 30px;
      }

      &_content {
        padding-left: 50px;

        .el-tabs__item {
          height: 100px;
          line-height: 100px;
          font-size: 20px;
          color: #CFF9FE;

          &:hover {
            color: #CFF9FE;
            font-weight: 1000;
          }

          &.is-active {
            font-weight: 1000;
            color: #CFF9FE;
          }
        }

        .el-tabs__active-bar {
          background-color: #CFF9FE;
        }

        .el-tabs__content {
          text-align: left;
        }

        .el-tabs__header {
          margin-right: 100px !important;
        }

        #pane-0 {
          .basicInfo_title {
            color: #CFF9FE;
            font-size: 28px;
            display: block;
            margin-bottom: 30px;
          }

          .briefIntro_img {
            width: 170px;
            height: 255px;
            display: inline-block;
            vertical-align: top;
            margin-left: 50px;
          }
        }

        &_briefIntro {
          text-align: left;
          width: 700px;
          font-size: 18px;
          display: inline-block;
          vertical-align: top;

          > span {
            color: #CFF9FE;
            font-size: 28px;
            display: block;
            margin-bottom: 30px;
          }
        }

        &_basicInfo {
          border-bottom: #979797 solid 1px;
          height: 30px;
          width: 800px;
          padding: 0 20px;
          box-sizing: border-box;

          > div {
            display: inline-block;
          }

          > div:nth-of-type(odd) {
            color: #CFF9FE;
            width: 100px;
          }

          > div:nth-of-type(even) {
            width: 350px;
          }

          > div:last-of-type {
            width: 150px;
          }
        }

        #pane-1 {
          > div:nth-of-type(odd) {
            color: #CFF9FE;
            font-size: 28px;
            margin-bottom: 30px;
          }

          > div:nth-of-type(even) {
            > div {
              width: 138px;
              display: inline-block;
              margin-right: 20px;
              margin-bottom: 20px;

              > div {
                text-align: center;
              }

              > img {
                width: 138px;
                height: 187px;
              }
            }
          }
        }

        #pane-2 {
          > div:nth-of-type(odd) {
            color: #CFF9FE;
            font-size: 28px;
            margin-bottom: 30px;
          }

          > div:nth-of-type(even) {
            > div {
              width: 138px;
              display: inline-block;
              margin-right: 20px;
              margin-bottom: 20px;

              > img {
                width: 138px;
                height: 187px;
              }
            }
          }
        }
      }
    }

    .el-dialog {
      background-color: #21201E;
      border-radius: 15px;
      border: 1.5px solid #D0F3F8;
      min-width: 900px;

      &__body {
        padding: 0;
      }
    }

    .header-title {
      font-size: 26px;
      color: #CFF9FE;
    }

    &_purchase {
      .movieInfo {
        margin: 10px 0;

        > span {
          display: inline-block;
          padding: 5px 10px;
          color: white;
        }

        > span:first-of-type {
          font-size: 20px;
          font-weight: bold;
          color: #CFF9FE
        }

        > span:nth-of-type(2) {
          border-left: 1px solid #CFF9FE;
          border-right: 1px solid #CFF9FE;
          width: 100px;
        }

        > span:nth-of-type(3) {
          border-right: 1px solid #CFF9FE;
          width: 100px;
        }
      }

      .movieDate {
        width: 500px;
        margin: 0 auto;
        border-top: 2px solid #3C3C3A;
        padding: 10px 0;

        > span {
          display: inline-block;
          margin: 0 30px;
        }
      }

      .movieTime {
        // margin-bottom: 20px;
        padding: 20px 20px;

        .el-carousel__item {
          background-color: #3C3C3A;
          border-radius: 10px;
          // width: 680px;
          padding: 15px 40px;
          box-sizing: border-box;
          text-align-last: left;
          overflow: auto;
          text-align: left;
        }

        .el-carousel__item::-webkit-scrollbar { /*滚动条整体样式*/
          width: 5px; /*高宽分别对应横竖滚动条的尺寸*/
          // height: 5px;
        }

        .el-carousel__item::-webkit-scrollbar-thumb { /*滚动条里面小方块*/
          border-radius: 10px;
          -webkit-box-shadow: inset 0 0 5px #CFF9FE;;
          background: #535353;
        }

        .is-active {
          width: 680px;
          left: -115px;
          cursor: default;
        }

        &_ticket {
          > div {
            display: inline-block;
          }
        }
      }

      .error {
        font-size: 40px;
        margin-bottom: 20px;
      }
    }

    &_selectSeat {
      .el-dialog__body {
        padding: 0 30px;
      }

      .movie {
        border-top: 1px solid #979797;
        border-bottom: 1px solid #979797;
        height: 60px;
        text-align: left;
        margin-bottom: 10px;

        > span {
          display: inline-block;
          width: 100px;
          line-height: 60px;
        }

        > span:first-of-type {
          color: #CFF9FE;
          font-size: 20px;
        }
      }

      .seat {

        img {
          width: 30px;
          height: 30px;
        }

        &_head {
          > img, > span {
            vertical-align: middle;
          }

          > span {
            display: inline-block;
            margin: 0 30px 0 10px;
          }
        }

        &_content {
          background-color: #302F2D;
          margin-top: 20px;
          padding: 20px 0;

          &_screen {
            background: url('../../assets/images/movie/Path3.png') no-repeat center center;
            height: 60px;
            line-height: 50px;
            font-size: 18px;
            background-size: contain;
            margin-bottom: 10px;
          }

          > div > div {
            display: inline-block;
          }

          img {
            margin: 2px 8px;
          }

          .canSelect {
            cursor: pointer;
          }
        }
      }

      .selectedTicket {
        margin: 30px 0;
        text-align: left;

        > div {
          text-align: center;
          width: 100px;
          margin-right: 30px;
          height: 50px;
          border: 1px solid #CFF9FE;
          display: inline-block;
          margin-bottom: 20px;

          > span {
            display: block;
          }
        }
      }

      .seatConfirmbuttom {
        width: 250px;
        height: 54px;
        border-radius: 15px;
        border: 1.5px solid #D0F3F8;
        color: #CFF9FE;
        font-size: 24px;
        line-height: 54px;
        font-weight: bold;
        cursor: pointer;
        margin: 20px auto;
        margin-top: 0;
      }
    }

    &_confirmOrder {
      .confirmOrder_ticket {
        width: 800px;
        border-radius: 15px;
        border: 1.5px solid #D0F3F8;
        // height: 168px;
        margin-left: 50px;
        margin-bottom: 20px;
        padding: 10px 40px;
        box-sizing: border-box;
        text-align: left;
        display: flex;
        font-size: 18px;

        &_center {
          flex: 0 1 auto;

          > img {
            height: 113px;
            width: 75px;
            margin-top: 25px;
            margin-right: 20px;
          }
        }

        &_right {
          flex: 0 1 auto;
          width: 110px;
          height: 34px;
          line-height: 34px;
          background-color: #343331;
          text-align: center;
          border-radius: 25px;
        }

        &_left {
          flex: 1 1 auto;

          > span {
            display: inline-block;
          }

          > span:first-of-type {
            color: #CFF9FE;
            font-size: 24px;
            margin-right: 20px;
            padding-right: 20px;
            border-right: 1px solid #CFF9FE;
          }

          > span:nth-of-type(2) {
            padding-left: 15px;
            line-height: 50px;
            height: 50px;
          }

          > span:nth-of-type(n+3) {
            line-height: 30px;
            height: 30px;
          }

          .seat {
            margin-left: 20px;
          }
        }
      }

      .confirmOrder_coupon {
        background-color: #343331;
        text-align-last: left;
        padding: 0 30px;
        &_each{
          width: 150px;
          height: 60px;
          display: inline-block;
          margin-left: 20px;
          border: 1px solid #CFF9FE;
          >div{margin: 0 auto; width: fit-content; line-height: 30px;}
        }
        > h3 {
          height: 50px;
          line-height: 50px;
        }

        .el-radio {
          display: block;
        }

        .el-collapse-item__content{
          >div{
            .el-radio{display: inline-block;}
          }
        }
        .el-collapse-item__wrap, .el-collapse-item__header {
          background-color: #343331;
          border: none;
        }

        .el-collapse {
          border: none
        }
      }

      .confirmOrder_price {
        height: 50px;
        line-height: 50px;
        text-align: left;
        border-top: 1px solid #343331;
        border-bottom: 1px solid #343331;
        margin: 20px 30px;

        > span {
          display: inline-block;
          width: 150px;
        }

        > span:last-of-type {
          color: #CFF9FE;
        }
      }

      .confirmOrder_know {
        text-align-last: left;
        margin: 20px 30px;
        list-style-type: none;

        > h3 {
          height: 35px;
        }

        > li {
          font-size: 13px;
          padding: 0 10px;
        }
      }

      .confirmOrder_pay {
        background-color: #343331;
        border-bottom-right-radius: 15px;
        border-bottom-left-radius: 15px;
        padding: 10px 20px;

        > span {
          display: inline-block;
        }

        > span:first-of-type {
          width: 250px;
        }

        > span:nth-of-type(2) {
          width: 250px;

          > span {
            color: #CFF9FE;
            font-size: 20px;
          }
        }

        // border: 1.5px solid #D0F3F8;
        > div {
          width: 250px;
          height: 54px;
          border-radius: 15px;
          border: 1.5px solid #D0F3F8;
          color: #CFF9FE;
          font-size: 24px;
          line-height: 54px;
          font-weight: bold;
          cursor: pointer;
          margin: 20px auto;
          margin-bottom: 0;
        }
      }
    }

    &_pay {
      .el-dialog {
        min-width: 500px;
      }

      .el-dialog__body {
        padding: 0 20px;
      }

      &_price {
        border-top: 1px solid #979797;
        padding: 20px 0;
        color: #CFF9FE;
        font-size: 24px;
      }

      &_memberCard {
        &_account {
          display: flex;
          border-bottom: 1px solid #979797;
          padding: 10px 10px;
          margin-bottom: 20px;

          > span {
            display: block;
            text-align: left;
            flex: 1 1 auto;
            font-size: 18px;
          }

          > span:last-of-type {
            flex: 0 1 auto;
          }
        }

        &_pay {
          width: 250px;
          height: 54px;
          border-radius: 15px;
          border: 1.5px solid #D0F3F8;
          color: #CFF9FE;
          font-size: 24px;
          line-height: 54px;
          font-weight: bold;
          cursor: pointer;
          margin: 20px auto;
        }
      }

      &_bankCard {
        text-align: left;

        .el-input {
          width: 300px;
        }

        > div:not(:last-of-type) {
          margin: 10px 0;
        }

        > div > span {
          display: inline-block;
          width: 100px;
          text-align: right;
        }

        &_pay {
          width: 250px;
          height: 54px;
          border-radius: 15px;
          border: 1.5px solid #D0F3F8;
          color: #CFF9FE;
          font-size: 24px;
          line-height: 54px;
          font-weight: bold;
          cursor: pointer;
          margin: 20px auto;
          text-align: center;
        }
      }
    }

    &_paySuccess {
      .Separator {
        // height: 10px;
        border-top: 1px solid;
        margin: 15px 40px;
      }

      &_status {
        background-color: #343331;

        > span {
          display: block;
        }

        > span:first-of-type {
          font-size: 24px;
          line-height: 50px;
        }

        > span:last-of-type {
          line-height: 30px;
        }

        > div {
          display: inline-block;
          width: 200px;
          height: 45px;
          line-height: 45px;
          border-radius: 15px;
          border: 1.5px solid #D0F3F8;
          cursor: pointer;
          margin: 20px 20px;
          font-size: 18px;
        }

        > div:hover {
          font-weight: bold;
        }
      }

      &_ticket {
        width: 90%;
        border-radius: 15px;
        border: 1.5px solid #D0F3F8;
        height: 50%;
        min-height: fit-content;
        margin: 0 auto;
        margin-top: 20px;
        padding: 10px 40px;
        box-sizing: border-box;
        text-align: left;
        display: flex;
        font-size: 18px;

        &_right {
          flex: 0 1 auto;

          > img {
            height: 113px;
            width: 75px;
            margin-top: 25px;
            margin-right: 20px;
          }
        }

        &_left {
          flex: 1 1 auto;

          > span {
            /*display: inline-block;*/
            flex: 1 0 auto;
          }

          > span:first-of-type {
            color: #CFF9FE;
            font-size: 24px;
            width: 60px;
            /*border-right: 1px solid #CFF9FE;*/
          }

          > span:nth-of-type(2) {
            padding-left: 15px;
            line-height: 50px;
            height: 50px;
          }

          > span:nth-of-type(n+3) {
            line-height: 30px;
            height: 30px;
          }

          > span:nth-last-of-type(2) {
            width: 120px;
          }

          .last-line {
            display: flex;

            :first-child {
              flex: 1 0 auto;
            }

            :last-child {
              flex: 9 0 auto;
              /*display: flex;*/
              span {
                margin-right: 4%;
              }
            }
          }
        }
      }

      &_cinema {
        display: flex;
        text-align-last: left;
        margin: 15px 60px;
        border-top: 1px solid;
        border-bottom: 1px solid;
        padding: 20px 30px;
        font-size: 16px;

        &_left {
          flex: 1 1 auto;

          > div:first-of-type {
            font-size: 24px;
            line-height: 40px;
          }
        }

        &_right {
          flex: 0 1 auto;

          > img {
            display: block;
            margin: 0 auto;
          }
        }
      }

      &_orderDetail {
        text-align: left;
        margin: 15px 60px;
        padding: 0px 30px;

        > li {
          list-style-type: none;
          line-height: 25px;
        }

        > li:first-of-type {
          font-size: 24px;
          line-height: 40px;

          > span {
            color: #CFF9FE;
          }
        }
      }
    }
  }
</style>
