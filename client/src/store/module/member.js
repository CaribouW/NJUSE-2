import {purchaseMemberCard, getMemberInfo, rechargeVIP, getRechargeHistory, getMemberList} from "../../service/memberService";

const state = {
  basicInfo: {
    VIPCardId: null,
    VIPLevel: 0,
    VIPCardBalance: 0,
    ownDate: null
  }
};
const getters = {};

const actions = {
  async purchaseMemberCard({commit, state}, payload) {
    // console.log('hh')
    return purchaseMemberCard({
      userId: payload.userId,
      cardBalance: payload.cardBalance, 
      ownDate: payload.ownDate
    }).then(response => {
      console.log(response)
      if (typeof response === "number") {
        return response
      } else {
        return response
      }
    });
  },

  async getMemberInfo({commit}, payload) {
    // console.log('hh')
    return getMemberInfo({
      userId: payload.userId,
    }).then(response => {
      console.log(response)
      if (typeof response === "number") {
        return response
      } else {
        commit('updateMember', response);
        return response
      }
    });
  },

  async rechargeVIP({commit, state}, payload) {
    // console.log('hh')
    return rechargeVIP({
      rechargeAmount: payload.rechargeAmount,
      VIPCardId: payload.VIPCardId,
      rechargeTime: payload.rechargeTime
    }).then(response => {
      if (response) {
        return response
      } else {
        // res为空才正常
        return 200
      }
    });
  },

  async getRechargeHistory({}, payload) {
    return getRechargeHistory({
      userId: payload.userId
    }).then(response => {
      return response
    });
  },

  async getMemberList({}, payload) {
    return getMemberList({
      limitation: payload.limitation
    }).then(response => {
      return response
    });
  }

};

const mutations = {
  updateMember: (state, payload) => {
    state.basicInfo = payload
  },
  recharge: (state, payload) => {
    state.basicInfo.VIPCardBalance += payload
  }
};
export default {
  state,
  getters,
  actions,
  mutations
}