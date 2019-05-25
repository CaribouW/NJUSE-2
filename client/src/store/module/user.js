import axios from 'axios'

const state = {
  basicInfo: {
    name: 'yyp nb',
    birth: '1998',
    account: 'Null and None',
  }
};

const getters = {
  getBasicInfo: state => state.basicInfo
};

const actions = {};

const mutations = {
  updateUser: (state, payload) => {
    state.basicInfo = payload.user
  },
};
export default {
  state,
  getters,
  actions,
  mutations
}
