import {purchaseMemberCard} from "../../service/memberService";

const state = {
  VIPCardId: '',
  VIPLevel: 0
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
        commit('updateUser', {
          VIPCardId: response.VIPCardId,
          VIPLevel: response.VIPLevel
        })
        return response
      }
      
      // if (typeof response === "number") {
      //   return response;
      // } else {
      //   //更新model
      //   commit('updateUser', {
      //     userId: response.id,
      //     account: response.account,
      //     roleName: response.roleName,
      //   });

      //   return state
      // }
    });
  }
};

const mutations = {};
export default {
  state,
  getters,
  actions,
  mutations
}