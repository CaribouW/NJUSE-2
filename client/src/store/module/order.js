import {refund,getHistory} from '../../service/orderService.js'
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
};

const mutations = {};
export default {
  state,
  getters,
  actions,
  mutations
} 
