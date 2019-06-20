import {getUserInfo, userLogin, register, logout} from '../../service/userService.js'

const state = {
  basicInfo: {
    account: 'Null and None a',
    name: 'yyp a',
    userId: '',
    birth: '1998',
    roleName: '',
    vip: {
      vipCardId: '',
      vipRank: '',

    }
  }
};

const getters = {
  getBasicInfo: state => state.basicInfo
};

const actions = {
  async getUserInfo({commit, state}, userId) {
    return getUserInfo({
      id: userId
    }).then(res => {
      console.log(res) 
      return res
    }) 
  },
  async userLogin({commit, state}, payload) {
    return userLogin({
      account: payload.account,
      password: payload.password
    }).then(response => {
      console.log(response)
      if (typeof response === "number") {
        return response;
      } else {
        //更新model
        commit('updateUser', {
          userId: response.id,
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
        commit('updateUser', {
          userId: response.id,
          account: response.account,
          roleName: response.roleName,
        });
        return {
          userId: getUserInfo(state).userId,
        };
      }
    })
  },
  userLogout: ({commit, state}, payload) => {
    return logout({
      userId: payload.userId
    }).then(response => {
      if (typeof response === "number") {
        console.log('error');
        return response
      }
    })
  }
};
const mutations = {
  updateUser: (state, payload) => {
    state.basicInfo = payload
    console.log(payload)
    sessionStorage.setItem('userId', payload.userId)
    sessionStorage.setItem('account', payload.account)
    sessionStorage.setItem('roleName', payload.roleName)
  },
};
export default {
  state,
  getters,
  actions,
  mutations
}
