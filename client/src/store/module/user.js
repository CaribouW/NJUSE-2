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
  async getUserInfo({dispatch, commit, state}, userId) {
    await dispatch('userLogin', userId);
    const data = getUserInfo(state)
      .then(res => {
        commit('updateUser',{
          res
        });
        return state.basicInfo
      });
  },
  async userLogin({commit, state}, payload) {
    return userLogin({
      account: payload.account,
      password: payload.password
    }).then(response => {
      if (typeof response === "number") {
        console.log('error occur');
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
        commit('updateUser', response);
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
    state.basicInfo = payload;
  },
};
export default {
  state,
  getters,
  actions,
  mutations
}
