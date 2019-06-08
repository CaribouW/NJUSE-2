import axios from 'axios'
import {dealResponse,baseIP} from './baseService.js'

/**
 * 获取用户信息
 * */
export function getUserInfo({uid}) {
  return axios.get('', {
    params: {
      userId: uid
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


