
import {dealResponse,baseIP,doDelete, doGet, doPost, doPut} from './baseService.js'



/**
 * 修改会员卡优惠策略
 */
export function modifyVipStrategy(payload) {
    return doPut({
        url: '/vip/strategy',
        params: {
            rechargePrice:payload.rechargePrice,
            rankName:payload.rankName,
            rank:payload.rank,
            discount:payload.discount
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