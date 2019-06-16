import {getFavorList} from '../../service/favorService.js'
const state = {
  userId:'',
};
const getters = {
  // getUserId: state => state.userId
}; 

const actions = {  
  async getFavorList({}, userId) {
    return getFavorList({
      userId: userId
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
