
import {dealResponse,baseIP,doDelete, doGet, doPost, doPut} from './baseService.js'

/**
 * 用户退票
 */
export function refund({userId, orderId}) {
    
    return doPost({
        url: '/order/refund',
        body: {
            userId:userId,
            orderId: orderId,
        }
      }).then(res => {
          console.log(res)
        return dealResponse(res)
      })
  } 

/**
 * 获取用户订单列表
 */
export function getHistory({userId}) {
    console.log(userId)
    return doGet({
        url: '/order/history',
        params: {
            userId:userId
          }
      }).then(res => {
        console.log(res)
        return dealResponse(res)
        
      })
  }