import axios from 'axios'

const baseIP = 'http://localhost:18080';

export async function dealResponse(response) {
  const body = response.data;
  if (body.status === 200)
    return body.data;
  else
    return body.status;
}

export async function doGet({url, params}) {
  return axios.get(url, {
    params: params,
    withCredentials: true,
    baseURL: baseIP,
    responseType: 'application/json'
  })
}

export async function doPost({url, params, body}) {
  return axios.post(url, body, {
    params: params,
    withCredentials: true,
    baseURL: baseIP,
    responseType: 'application/json'
  })
}

export async function doPut({url, params, body}) {
  return axios.put(url, body, {
    params: params,
    withCredentials: true,
    baseURL: baseIP,
    responseType: 'application/json'
  })
}

export async function doDelete({url, params, body}) {
  return axios.delete(url, body, {
    params: params,
    withCredentials: true,
    baseURL: baseIP,
    responseType: 'application/json'
  })
}