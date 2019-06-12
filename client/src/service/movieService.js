//进行电影相关的接口操作
import {doGet, doDelete, doPost, doPut, dealResponse} from "./baseService";

// 获取电影详情
export function getMovieBasicInfo({userId, movieId}) {
  return doGet({
    url: '/movie/detail/basicInfo',
    params: {
      userId: userId,
      movieId: movieId
    }
  }).then(res => {
    return dealResponse(res)
  })
}

// 获取影库电影所有信息
export function getAllMovie() {
  return doGet({
    url: '/movie/list',
  }).then(res => {
    return dealResponse(res)
  })
}

// 获取电影剧照
export function getMoviePhoto({movieId}) {
  return doPut({
    url: '/movie/detail/photo',
    body: {
      movieId: movieId
    }
  }).then(res => {
    return dealResponse(res)
  })
}

// 获取电影演职员表
export function getMovieStaff({movieId}) {
  return doPut({
    url: '/movie/detail/staff',
    body: {
      movieId: movieId
    }
  }).then(res => {
    return dealResponse(res)
  })
}