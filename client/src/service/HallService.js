import axios from 'axios'
import {dealResponse, baseIP} from './baseService.js'

/**
 * 获取影厅列表
 * */
export async function getHallList() {
  return axios.get('/hall/strategy/list', {
    withCredentials: true,
    baseURL: baseIP
  }).then(res => {
    console.log(res);
    return dealResponse(res)
  })
}

export async function newHall() {

}

/**
 * 修改电影影厅信息
 * */
export async function modifyHall(payload) {
  return axios.put("/hall/strategy", {
    hallId: payload.id,
    state: payload.state,
    name: payload.name,
    size: '5,10',
    category: payload.category
  }, {
    withCredentials: true,
    baseURL: baseIP
  }).then(res => {
    return dealResponse(res)
  })
}

export async function deleteHall({id}) {

}



