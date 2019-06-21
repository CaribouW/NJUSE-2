// 进行排片相关的操作
import {doGet, doDelete, doPost, doPut, dealResponse} from "./baseService";

// 添加新的排片信息
export function addMovieSchedule({movieId,hallId,startTime,endTime,price,slotId}){
    return doPost({
        url: '/schedule',
        body: {
            movieId: movieId,
            hallId: hallId,
            startTime: startTime,
            endTime: endTime,
            price: price,
            slotId: slotId
        }
    }).then(res => {
        return dealResponse(res)
      })
}

// 获取电影排片信息
export function getMovieSchedule() {
    return doGet({
      url: '/schedule/list',
    }).then(res => {
      return dealResponse(res)
    })
  }

// 修改排片信息
export function modifyMovieSchedule({movieId,hallId,startTime,endTime,price,slotId}){
    return doPut({
      url: '/schedule',
      body: {
        movieId: movieId,
        hallId: hallId,
        startTime: startTime,
        endTime: endTime,
        price: price,
        slotId: slotId
      }
    }).then(res => {
      return dealResponse(res)
    })
}

// 删除排片信息
export function deleteMovieSchedule({slotId}){
    return doDelete({
      url: '/schedule',
      data: {
        slotId: slotId
      }
    })
}