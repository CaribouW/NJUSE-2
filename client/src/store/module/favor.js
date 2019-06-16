import {getFavorList, getFavorCounter, addFavor, deleteFavor} from '../../service/favorService.js'
const state = {
  favorList: [],
};
const getters = {
  // getUserId: state => state.userId
};

const actions = {  
  async getFavorList({commit}, payload) {
    return getFavorList({
      userId: payload.userId
    }).then(res => {
      commit('getFavorList', res.favorList)
      return state.favorList
    })
  },

  async getFavorCounter({}, payload) {
    return getFavorCounter({
      movieId: payload.movieId
    }).then(res => {
      return res
    })
  },

  async addFavor({}, payload) {
    return addFavor({
      userId: payload.userId,
      movieId: payload.movieId,
    }).then(res => {
      return res
    })
  },

  async deleteFavor({}, payload) {
    return deleteFavor({
      userId: payload.userId,
      movieId: payload.movieId,
    }).then(res => {
      return res
    })
  },
};

const mutations = {
  getFavorList: (state, payload) => {
    state.favorList= payload
  }
};
export default {
  state,
  getters,
  actions,
  mutations
} 
