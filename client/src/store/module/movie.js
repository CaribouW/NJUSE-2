import {getMovieBasicInfo, getAllMovie, getMoviePhoto, getMovieStaff} from '../../service/movieService.js'

const state = {
  movieList: [{
    movieId:'',

  }]
};
const getters = {};

const actions = {
  async getAllMovie({commit, state}) {
    return getAllMovie().then(res => {
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

const mutations = {};
export default {
  state,
  getters,
  actions,
  mutations
}
