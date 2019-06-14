import {getCoupon} from '../../service/couponService.js'
const state = {
  userId:'',
};
const getters = {}; 

const actions = {
  async getCoupon({}, userId) {
    return getCoupon({
      userId: userId
    }).then(res => {
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
