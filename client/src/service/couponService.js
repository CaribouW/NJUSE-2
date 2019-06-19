// 管理员对优惠策略的增删改查
import {dealResponse,baseIP,doDelete, doGet, doPost, doPut} from './baseService.js'

// 添加优惠策略
export function addActivity({movies,couponNumber,conditionPrice,discountPrice,endDate,startDate,couponName}){
  return doPost({
    url: '/coupon/strategy',
    body: {
      movies: movies,
      couponNumber:couponNumber,
      conditionPrice: conditionPrice,
      discountPrice: discountPrice,
      endDate: endDate,
      startDate: startDate,
      couponName: couponName
    }
  }).then(res => {
    return dealResponse(res)
  })
}

// 删除优惠策略
export function deleteActivity({couponId}){
  return doDelete({
    url: "/coupon/strategy",
    data: {
      couponId: couponId
    }
  })
}

// 修改优惠策略
export function modifyActivity({couponId,movies,couponNumber,conditionPrice,discountPrice,endDate,startDate,couponName}){
  return doPut({
    url: "/coupon/strategy",
    body: {
      couponId: couponId,
      movies: movies,
      couponNumber:couponNumber,
      conditionPrice: conditionPrice,
      discountPrice: discountPrice,
      endDate: endDate,
      startDate: startDate,
      couponName: couponName
    }
  }).then(res => {
    return dealResponse(res)
  })
}

// 获取优惠策略列表
export function getActivityList(){
  return doGet({
    url: '/coupon/strategy/list'
  }).then(res => {
    return dealResponse(res)
  })
}

/**
 * 获取用户优惠券列表 
 */
export function getCoupon({userId}) {
    console.log(userId)
    return doGet({
        url: '/coupon/list',
        params: {
            userId:userId
          }
      }).then(res => {
        console.log(res)
        return dealResponse(res)
        
      })
  }

  export function useCoupon({couponId,userId}){
    return doPut({
      url: "/coupon",
      body: {
        couponId: couponId,
        userId: userId
      }
    }).then(res => {
      return dealResponse(res)
    })
  }