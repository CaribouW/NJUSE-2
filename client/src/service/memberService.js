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