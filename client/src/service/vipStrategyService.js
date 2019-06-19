
import {dealResponse,baseIP,doDelete, doGet, doPost, doPut} from './baseService.js'



/**
 * 修改会员卡优惠策略
 */
export function modifyVipStrategy(payload) {
  console.log(payload)
    return doPut({
        url: '/vip/strategy',
        body: {
          vipRank: payload.vipRank
        }
      }).then(res => {
        console.log(res)
        return dealResponse(res)
        
      })
  }

/**
 * 获取会员卡优惠策略
 */
export function getVipStrategy() {
    return doGet({
        url: '/vip/strategy',
      }).then(res => {
        console.log(res)
        return dealResponse(res)
        
      })
  }