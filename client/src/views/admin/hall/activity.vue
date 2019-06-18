<template>
	<div class="activity">
		<div class="activity_title">
			<span class="name">优惠策略</span>
			<el-button type="primary" icon="el-icon-plus" round size="medium" @click="onSubmit">发布活动</el-button>
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
	</div>
</template>

<script>
import admin from '../index.vue'
import {addActivity,deleteActivity,modifyActivity,getActivityList} from '@/service/couponService.js'
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
				couponNumber: '',
				conditionPrice: '',
				discountPrice: '',
				endDate: null,
				startDate: null,
				couponName: ''
			}
		}
	},
	methods: {
		onSubmit(){
			
		},
		doChange(coupon){
			console.log(coupon)
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
