import {getUserInfo, userLogin, register} from '../../service/userService.js'

const state = {
  basicInfo: {
    account: 'Null and None',
    name: 'yyp ',
    userId: '',
    birth: '1998',
    roleName: ''
  }
};

const getters = {
  getBasicInfo: state => state.basicInfo
};

const actions = {
  getUserInfo: ({commit, state}, userId) => {
    const data = getUserInfo()
      .then(res => {
        state.basicInfo = res;
        return state.basicInfo
      });

  },
  userLogin: ({commit, state}, payload) => {
    return userLogin({
      account: payload.account,
      password: payload.password
    }).then(response => {
      if (typeof response === "number") {
        return response;
      } else {
        //更新model
        commit('updateUser', {
          userId: response.userId,
          account: response.account,
          roleName: response.roleName,
        });
        return state
      }
    });

  },
  userSignUp: ({commit, state}, payload) => {
    return register({
      account: payload.account,
      password: payload.password
    }).then(response => {
      if (typeof response === "number") {
        console.log(response);
        return response;
      } else {
        commit('updateUser', response);
        return {
          userId: getUserInfo(state).userId,
        };
      }
    })
  }
};
const mutations = {
  updateUser: (state, payload) => {
    state.basicInfo = payload;
  },
};
export default {
  state,
  getters,
  actions,
  mutations
}
