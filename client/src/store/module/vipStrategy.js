import {modifyVipStrategy,getVipStrategy} from '../../service/vipStrategyService.js'
const state = {
};
const getters = {
  // getUserId: state => state.userId 
};

const actions = {  
  async modifyVipStrategy({commit, state}, payload) { 
    return modifyVipStrategy({
        rechargePrice:payload.rechargePrice,
        rankName:payload.rankName,
        rank:payload.rank,
        discount:payload.discount
    }).then(res => { 
      console.log(res)
      return res
    })
  },
  async getVipStrategy({commit, state}) {
    return getVipStrategy({
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
