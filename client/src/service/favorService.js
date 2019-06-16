
import {dealResponse,baseIP,doDelete, doGet, doPost, doPut} from './baseService.js'


/**
 * 获取用户喜爱电影列表
 */
export function getFavorList({userId}) {
    console.log(userId)
    return doGet({
        url: '/favor/user/list',
        params: {
            userId:userId
          }
      }).then(res => {
        console.log(res)
        return dealResponse(res)
        
      })
  }