import {doGet, doDelete, doPost, dealResponse, doPut} from "../../service/baseService";

const state = {
  refundStrategyList: [{
    id: '1',    //id
    rate: 0.3,  //退票返还比例
    time: 10    //约定期限
  }, {
    id: '2',
    rate: 0.3,
    time: 10
  }, {
    id: '3',
    rate: 0.3,
    time: 10
  }]
};

const getters = {
  //获取时间
  refunds: state => state.refundStrategyList
};
const actions = {
  async getRefundList({commit, state}) {
    return doGet({
      url: '/refund/strategy',
    }).then(res => {
      return dealResponse(res)
    }).then(list => {
      commit('flushList', list)
    })
  }
};
const mutations = {
  flushList: (state, payload) => {
    state.refundStrategyList = payload
  },
};

export default {
  state,
  getters,
  actions,
  mutations
}

