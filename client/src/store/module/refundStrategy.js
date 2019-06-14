import {doGet, doDelete, doPost, dealResponse, doPut} from "../../service/baseService";

const state = {
  refundStrategyList: [{}]
};

const getters = {
  //获取时间
  refunds: state => state.refundStrategyList
};
const actions = {
  async getRefundList({commit, state}) {
    return doGet({
      url: '/refund/strategy/list',
    }).then(res => {
      return dealResponse(res)
    }).then(list => {
      commit('flushList', list)
      return list
    })
  },
  async modifyRefundItem({commit, state}, payload) {
    return doPut({
      url: '/refund/strategy',
      body: payload
    }).then(res => {
      return dealResponse(res);
    }).then(res => {
    })
  },
  async newRefundStrategy({commit, state}) {
    return doPost({
      url: '/refund/strategy',
    }).then(res => {
      return dealResponse(res)
    }).then(res => {
      commit('appendList', res)
    })
  },
  async removeRefundStrategy({commit, state}, {id}) {
    return doDelete({
      url: '/refund/strategy',
      params: {
        id
      }
    }).then(res => {
      console.log(res);
      return dealResponse(res)
    }).then(res => {
      commit('popItem', {id})
    })
  }
};
const mutations = {
  flushList: (state, payload) => {
    state.refundStrategyList = payload;
  },
  appendList: (state, payload) => {
    state.refundStrategyList.push(payload)
  },
  popItem: (state, {id}) => {
    state.refundStrategyList = state.refundStrategyList.filter(item => {
      return item.id !== id
    });
  }
};

export default {
  state,
  getters,
  actions,
  mutations
}

