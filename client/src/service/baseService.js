import axios from 'axios'

// export const baseIP = 'http://106.14.140.93:8080/se-server/';
export const baseIP = 'http://localhost:18080'

export async function dealResponse(response) {
  const body = response.data;
  console.log(body);
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

export async function doDelete({url, params}) {
  return axios.delete(url, {
    params: params,
    withCredentials: true,
    baseURL: baseIP,
    responseType: 'application/json'
  })
}
