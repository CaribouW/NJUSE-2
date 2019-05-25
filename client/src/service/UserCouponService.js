//进行用户优惠券的接口操作
import {doGet, doDelete, doPost, doPut, dealResponse} from "./baseService";

//用户消耗优惠券
export function consumeCoupon(payload) {
  return doPut({
    url: '/coupon',
    body: {
      userId: payload.userId,
      couponId: payload.couponId
    }
  }).then(res => {
    return dealResponse(res)
  })
}

//获取用户拥有的优惠券信息
export function getCouponList(payload) {
  return doGet({
    url: '/coupon/list',
    params: {
      userId: payload.userId
    }
  }).then(res => {
    return dealResponse(res)
  }).then(res => {
    if (isNumeric(res)) {
      return res
    } else {

    }
  })
}
