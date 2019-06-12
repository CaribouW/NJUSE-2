import {dealResponse, baseIP, doDelete, doGet, doPost, doPut} from './baseService.js'

/**
 * 获取影厅列表
 * */
export async function getHallList() {
  return doGet({
    url: '/hall/strategy/list'
  }).then(res => {
    return dealResponse(res)
  })
}

export async function newHall(payload) {
  return doPost({
    url: "/hall/strategy",
    body: {
      // hallId: payload.id,
      state: payload.state,
      name: payload.name,
      size: payload.row + ',' + payload.col,
      category: payload.category
    }
  }).then(res => {
    return dealResponse(res)
  })
}

/**
 * 修改电影影厅信息
 * */
export async function modifyHall(payload) {
  return doPut({
    url: "/hall/strategy",
    body: {
      size: payload.row + ',' + payload.col,
      category: payload.category,
      hallId: payload.hallId,
      state: payload.state,
      name: payload.name,
    }
  }).then(res => {
    return dealResponse(res)
  })
}

/**
 * 删除电影院
 * */
export async function deleteHall({id}) {
  return doDelete({
    url: "/hall/strategy",
    params: {
      id: id
    }
  })
}



