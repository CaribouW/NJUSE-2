import axios from 'axios'
import {dealResponse,baseIP} from './baseService.js'

/**
 * 获取用户信息
 * */
export function getUserInfo({id}) {
  // console.log(id)
  return axios.get('/user/basicInfo', {
    params: {
      id:id
    },
    withCredentials: true,
    baseURL: baseIP
  }).then(res => {
    return dealResponse(res);
  });
} 
 
/**v\
 * 修改用户信息
 * */
export function updateUser(payload) {
  // console.log(id)
  return axios.get('/user/basicInfo/modify', {
    params: {
      id:payload.id,
      pic:payload.info.pic,
      name:payload.info.name,
      sex:payload.info.sex,
      birthday:payload.info.birthday
    },
    withCredentials: true,
    baseURL: baseIP
  }).then(res => {
    return dealResponse(res);
  });
} 

/**
 * 用户登录
 * */
export function userLogin({account, password}) {
  return axios.post('/user/login', {
    account: account,
    password: password,
  }, {
    baseURL: baseIP,
    withCredentials: true,
    // responseType: 'application/json'
  }).then(response => {
    return dealResponse(response);
  })
}

/**
 * 用户注册
 * */
export function register({account, password}) {
  return axios.post('/user/register', {
    account: account,
    password: password,
  }, {
    baseURL: baseIP,
    withCredentials: true,
    responseType: 'application/json'
  }).then(response => {
    return dealResponse(response);
  })
}

/**
 * 用户登出
 * */
export function logout({userId}) {
  return axios.delete('/user/logout', {
    params: {
      userId: userId
    },
    responseType: 'application/json',
    baseURL: baseIP,
    withCredentials: true,
  }).then(res => {
    return dealResponse(res);
  });
}


