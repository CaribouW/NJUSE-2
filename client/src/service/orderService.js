
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

  export function confirmOrder(payload) {
    return doPost({
        url: '/order/confirm',
        body: {
          userId: payload.userId,
          scheduleId: payload.scheduleId,
          confirmTime: payload.confirmTime,
          price: payload.price,
          seats: payload.seats
        }
      }).then(res => {
        return dealResponse(res)
      })
  }

  // 消费
  export async function consume(payload) {
    return doPut({
      url: "/order/consume",
      body: payload
    }).then(res => {
      return dealResponse(res)
    })
  }
