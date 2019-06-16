
import {dealResponse,baseIP,doDelete, doGet, doPost, doPut} from './baseService.js'


/**
 * 获取用户喜爱电影列表
 */
export function getFavorList({userId}) {
    return doGet({
        url: '/favor/user/list',
        params: {
            userId:userId
          }
      }).then(res => {
        return dealResponse(res)
         
      })
  }

  export function getFavorCounter({movieId}) {
    return doGet({
      url: '/favor/counter',
      params: {
        movieId: movieId,
      }
    }).then(res => {
      return dealResponse(res)
    })
  }

  export function addFavor({userId, movieId}) {
    
    return doPost({
        url: '/favor/',
        body: {
            userId:userId,
            movieId: movieId,
        }
      }).then(res => {
        return dealResponse(res)
      })
  } 

  export async function deleteFavor(payload) {
    return doDelete({
      url: "/favor/",
      data: {
        userId: payload.userId,
        movieId: payload.movieId
      }
    })
  }
