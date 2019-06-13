//进行会员相关的接口操作
import {doGet, doDelete, doPost, doPut, dealResponse} from "./baseService";

// 购买会员卡
export function purchaseMemberCard({userId,cardBalance,ownDate}) {
  return doPost({
    url: '/vip/',
    body: {
      userId: userId,
      cardBalance: cardBalance,
      ownDate: ownDate
    }
  }).then(res => {
    return dealResponse(res)
  })
}

// 获取会员信息
export function getMemberInfo({userId}) {
  console.log(userId)
  return doGet({
    url: '/vip/',
    params: {
      userId: userId,
    }
  }).then(res => {
    return dealResponse(res)
  })
}

// 会员卡充值
export async function rechargeVIP(payload) {
  return doPut({
    url: '/vip/recharge',
    body: payload
  }).then(res => {
    console.log(res)
    return dealResponse(res)
  })
}