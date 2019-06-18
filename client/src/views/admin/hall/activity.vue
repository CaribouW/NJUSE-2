<template>
	<div class="activity">
		<div class="activity_title">
			<span class="name">优惠策略</span>
			<el-button type="primary" icon="el-icon-plus" round size="medium" @click="addCoupon">发布活动</el-button>
		</div>
		<template>
			<div class="activity_content" @click="doChange(item)" v-for="item in activities" :key="item.couponID">
				<div class="activity_content_left">
					<div class="couponName">{{item.couponName}}</div>
					<div class="dateRange">
						活动时间：
						<span>{{item.startDate.substring(0,10)}}至{{item.endDate.substring(0,10)}}</span>
					</div>
					<div class="movieList">
						参与电影：
						<span>{{ item.movieList }}</span> 
					</div>
				</div>
				<div class="activity_content_right">
					<span class="coupon">优惠券</span>
					<span class="description">满 {{item.conditionPrice}} 减 {{item.discountPrice}} 元</span>
				</div>
			</div>
		</template>
		<!-- 新增优惠策略 -->
    <el-dialog title="发布活动"
               :visible.sync="dialogFormVisible"
               append-to-body
               width="35%">
      <el-form :model="form">
        <el-form-item label="*优惠券名称：" :label-width="formLabelWidth">
          <el-input v-model="form.couponName" autocomplete="off" placeholder="请输入优惠券名称"></el-input>
        </el-form-item>
        <el-form-item label="*开始日期：" :label-width="formLabelWidth">
          <el-date-picker
            v-model="form.startDate"
            align="right"
            type="date"
            placeholder="选择开始日期">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="*结束日期：" :label-width="formLabelWidth">
          <el-date-picker
            v-model="form.endDate"
            align="right"
            type="date"
            placeholder="选择结束日期">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="*优惠券数：" :label-width="formLabelWidth">
          <el-input-number v-model="form.couponNumber" :min='0'></el-input-number>
        </el-form-item>
		<el-form-item label="*需满金额：" :label-width="formLabelWidth">
          <el-input-number v-model="form.conditionPrice" :min='0'></el-input-number>
        </el-form-item>
		<el-form-item label="*优惠金额：" :label-width="formLabelWidth">
          <el-input-number v-model="form.discountPrice" :min='0'></el-input-number>
        </el-form-item>
		<el-form-item label="*参与电影：" :label-width="formLabelWidth">
          <el-select v-model="form.movieList" filterable multiple placeholder="(默认为全部电影)">
				<el-option
				v-for="item in movies"
				:key="item.movieId"
				:label="item.name"
				:value="item.movieId">
				</el-option>
			</el-select>
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
import { addActivity,deleteActivity,modifyActivity,getActivityList } from '@/service/couponService.js'
import { getAllMovie } from '@/service/movieService.js'

export default {
	name: 'activity',
	components: {admin},
	data(){
		return{
			movies: [],
			couponStrategy: [],
			form: {
				movieList: [],
				couponNumber: 0,
				conditionPrice: 0,
				discountPrice: 0,
				endDate: null,
				startDate: null,
				couponName: ''
			},
			dialogFormVisible: false,
			formLabelWidth: '150px',
			throughChange: false,
			throughAdd: false,
			toChange: ''
		}
	},
	methods: {
		addCoupon(){
			this.throughAdd = true
			this.dialogFormVisible = true
		},
		onSubmit(){
			if(this.form.couponName===''){
				alert('请输入优惠券名称')
			}else if(this.form.startDate==null){
				alert('请设置活动的开始日期')
			}else if(this.form.endDate==null){
				alert('请设置活动的结束日期')
			}else if(this.form.couponNumber==0){
				alert('请设置发布优惠券的张数')
			}else if(this.form.conditionPrice==0){
				alert('请设置满减条件')
			}else if(this.form.discountPrice==0){
				alert('请设置优惠金额')
			}
			else{
				var activity = {
					couponName: this.form.couponName,
					startDate: this.dateToFormat(this.form.startDate),
					endDate: this.dateToFormat(this.form.endDate),
					couponNumber: this.form.couponNumber,
					conditionPrice: this.form.conditionPrice,
					discountPrice: this.form.discountPrice,
					movies: this.form.movieList
				}
				// console.log(activity)
				addActivity(activity).then(res => {
					// console.log(res)
					activity.couponID = res.couponId
					this.couponStrategy.unshift(activity)
					this.form = {
						movieList: [],
						couponNumber: 0,
						conditionPrice: 0,
						discountPrice: 0,
						endDate: null,
						startDate: null,
						couponName: ''
					}
					this.dialogFormVisible = false
					this.throughAdd = false
				})
			}
		},
		onCancel(){
			this.form = {
				movieList: [],
				couponNumber: 0,
				conditionPrice: 0,
				discountPrice: 0,
				endDate: null,
				startDate: null,
				couponName: ''
			}
			this.dialogFormVisible = false
			this.throughChange = false
			this.throughAdd = false
			this.toChange = ''
		},
		doChange(coupon){
			this.throughChange = true
			this.dialogFormVisible = true
			this.form.couponName = coupon.couponName
			this.form.startDate = new Date(coupon.startDate)
			this.form.endDate = new Date(coupon.endDate)
			this.form.couponNumber = coupon.couponNumber
			this.form.conditionPrice = coupon.conditionPrice
			this.form.discountPrice = coupon.discountPrice
			this.form.movies = coupon.movies
			this.toChange = coupon.couponID
		},
		onChange(){
			if(this.form.couponName===''){
				alert('请输入优惠券名称')
			}else if(this.form.startDate==null){
				alert('请设置活动的开始日期')
			}else if(this.form.endDate==null){
				alert('请设置活动的结束日期')
			}else if(this.form.couponNumber==0){
				alert('请设置发布优惠券的张数')
			}else if(this.form.conditionPrice==0){
				alert('请设置满减条件')
			}else if(this.form.discountPrice==0){
				alert('请设置优惠金额')
			}
			else{
				var activity = {
					couponId: this.toChange,
					couponName: this.form.couponName,
					startDate: this.dateToFormat(this.form.startDate),
					endDate: this.dateToFormat(this.form.endDate),
					couponNumber: this.form.couponNumber,
					conditionPrice: this.form.conditionPrice,
					discountPrice: this.form.discountPrice,
					movies: this.form.movieList
				}
				// console.log(activity)
				modifyActivity(activity).then(res => {
					// console.log(res)
					activity.couponID = activity.couponId
					for(var i = 0; i<this.couponStrategy.length;i++){
						if(this.couponStrategy[i].couponID==activity.couponId){
							this.couponStrategy[i] = activity
						}
					}
					this.form = {
						movieList: [],
						couponNumber: 0,
						conditionPrice: 0,
						discountPrice: 0,
						endDate: null,
						startDate: null,
						couponName: ''
					}
					this.dialogFormVisible = false
					this.throughChange = false
				})
			}
		},
		onDelete(){
			deleteActivity({
				couponId: this.toChange
			}).then( res => {
				this.couponStrategy = this.couponStrategy.filter(function(item){
					return item.couponID!=this.toChange
				},this)
				this.toChange = ''
				this.throughChange = false
				this.dialogFormVisible = false
			})
		},
		dateToFormat(time){
			var year = time.getFullYear()
			var month = time.getMonth()+1
			if (month<10){
				month = '0'+month
			}
			var day = time.getDate()
			if (day<10){
				day = '0'+day
			}
			return year+'-'+month+'-'+day
		}
	},
	computed: {
		activities: function(){
			this.couponStrategy.forEach(item => {
				var movieList = ''
				if(item.movies.length!=0){
					item.movies.forEach(element => {
						for(var i = 0; i<this.movies.length; i++){
							if(this.movies[i].movieId==element){
								movieList = movieList + this.movies[i].name + ','
							}
						}
					})
				}
				if(movieList!=''){
					movieList = movieList.substring(0,movieList.length-1)
				}else{
					movieList = '全部电影'
				}
				item.movieList = movieList
			});
			return this.couponStrategy
		}
	},
	mounted:function(){
	  getAllMovie().then(
        res => {
          this.movies = res
        }
	  )
	  getActivityList().then(
		  res => {
			  this.couponStrategy = res
		  }
	  )
	}
}
</script>

<style lang="scss">

.activity{
	padding-left: 20px;
	padding-top: 10px;
	text-align: start;
	.activity_title{
		margin-bottom: 10px;
		.name{
			display: inline-block;
			margin-right: 75%;
			font-size: 22px;
		}
	}
	.activity_content{
		width: 98%;
		display: flex;
		flex-direction: row;
		border: 1px solid rgb(201, 235, 255);
		margin-top: 20px;
		cursor: pointer;
		.activity_content_left{
			flex: 3;
			display: flex;
			flex-direction: column;
			justify-content: space-between;
			padding: 15px;
			.couponName{
				font-size: 30px;
				// margin-top: 5px;
			}
			.dateRange,.movieList{
				font-size: 15px;
				margin-top: 7px;
			}
		}
		.activity_content_right{
			flex: 1;
			display: flex;
			flex-direction: column;
			justify-content: space-around;
			padding: 20px;
			background-color: rgb(201, 235, 255);
			color: black;
			.coupon{
				font-size: 24px;
			}
		}
	}
}
</style>
