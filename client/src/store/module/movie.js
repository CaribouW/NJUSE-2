import {getMovieBasicInfo, getAllMovie, getMovieSchedule, getMoviePhoto, getMovieStaff} from '../../service/movieService.js'

const state = {
  movieList: [{
    movieId:'',

  }],
  quickPurchase: {
    movieId: '1205',
    scheduleId: '111'
  }
};
const getters = {};

const actions = {
  async getAllMovie({commit, state}) {
    return getAllMovie().then(res => {
      return res
    })
  },

  async getMovieSchedule({commit, state}) {
    return getMovieSchedule().then(res => {
      return res
    })
  },
  
  async getMovieBasicInfo({commit, state}, payload) {
    return getMovieBasicInfo({
      userId: payload.userId,
      movieId: payload.movieId
    }).then(res => {
      return res
    })
  },
};

const mutations = {
  purchase: (state, payload) => {
    state.quickPurchase = payload
    console.log(payload)
  }
};
export default {
  state,
  getters,
  actions,
  mutations
}
