import axios from 'axios'

const baseIP = 'http://localhost:18080';

/**
 * 获取用户信息
 * */
export function getUserInfo(uid) {
  return axios.get('', {
    params: {
      userId: uid
    },
    withCredentials: true,
    baseURL: baseIP
  }).then(res => {
    return res.data;
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
    responseType: 'application/json'
  }).then(res => {
    return res.data;
  }).then(res => {
    if (res.status === 200) {
      return res.data
    } else {
      return res.status
    }
  });
}
