//进行用户优惠券的接口操作
import {doGet, doDelete, doPost, doPut, dealResponse} from "./baseService";

//用户消耗优惠券
export function consumeCoupon({userId, couponId}) {
  return doPut({
    url: '/coupon',
    body: {
      userId: userId,
      couponId: couponId
    }
  }).then(res => {
    return dealResponse(res)
  })
}

//获取用户拥有的优惠券信息
export function getCouponList({userId}) {
  return doGet({
    url: '/coupon/list',
    params: {
      userId: userId
    }
  }).then(res => {
    return dealResponse(res)
  })
}

// 获取优惠策略列表
export function getCouponStrategyList() {
  return doGet({
    url: '/coupon/strategy/list',
  }).then(res => {
    return dealResponse(res)
  })
}

// 主动给予指定会员以优惠券
export function giveCoupon({vipIdList,couponId}) {
  return doPost({
    url: '/coupon/vip',
    body: {
      vipIdList: vipIdList,
      couponId: couponId,
    }
  }).then(res => {
    return dealResponse(res)
  })
}
