import {refund,getHistory, confirmOrder, consume} from '../../service/orderService.js'
const state = {
  userId:'',
  orderId:''
};
const getters = {
  // getUserId: state => state.userId
};

const actions = { 
  async refund({}, payload) { 
    return refund({
      userId:payload.userId,
      orderId: payload.orderId,
    }).then(res => { 
      console.log(res)
      return res
    })
  },
  async getHistory({commit, state}, userId) {
    return getHistory({
      userId: userId
    }).then(res => {
      console.log(res)
      return res
    })
  },
  async confirmOrder({}, payload) {
    return confirmOrder({
      userId: payload.userId,
      scheduleId: payload.scheduleId,
      confirmTime: payload.confirmTime,
      seats: payload.seats
    }).then(res => {
      console.log(res)
      return res
    })
  },
  async consume({}, payload) {
    return consume({
      userId: payload.userId,
      consumption: payload.consumption,
      orderId: payload.orderId,
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
