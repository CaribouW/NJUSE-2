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
const actions = {};
const mutations = {};

export default {
  state,
  getters,
  actions,
  mutations
}

