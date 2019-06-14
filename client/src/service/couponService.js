
import {dealResponse,baseIP,doDelete, doGet, doPost, doPut} from './baseService.js'



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