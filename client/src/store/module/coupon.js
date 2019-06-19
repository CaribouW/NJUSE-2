import {getCoupon, useCoupon  } from '../../service/couponService.js'
import {getCouponStrategyList ,giveCoupon} from '../../service/UserCouponService.js'
const state = {
  userId:'',
};
const getters = {}; 

const actions = {
  async getCoupon({}, payload) {
    return getCoupon({
      userId: payload.userId
    }).then(res => {
      console.log(res)
      return res
    })
  },

  async getCouponStrategyList({}, userId) {
    return getCouponStrategyList().then(res => {
      return res
    })
  },

  async giveCoupon({}, {vipIdList,couponId}) {
    return giveCoupon({
      vipIdList: vipIdList,
      couponId: couponId
    }).then(res => {
      return res
    })
  },

  async useCoupon({}, {couponId, userId}) {
    return useCoupon({
      couponId: couponId,
      userId: userId
    }).then(res => {
      console.log(res)
      return res
    })
  },
};

const mutations = {};
export default {
  state,
  getters,
  actions,
  mutations
} 
