import {getHallList, modifyHall} from "../../service/HallService";

const state = {
  hallList: [{
    id: '',
    state: true, // 0 可用 ; 1 不可用
    row: '',  //行数
    col: '', //列数
    category: '', //规格
  }]
};
const getters = {
  //获取所有的影厅
  hallList: state => state.hallList
};

const actions = {
  async getHalls({dispatch, commit, state}) {
    const data = getHallList().then(
      res => {
        const list = res.map(item => {
          return {
            id: item.hallId,
            name: item.name,
            state: item.state,
            row: item.row,  //行数
            col: item.col, //列数
            category: item.category
          }
        });
        return commit('flushList', list);
      }
    )
  },
  //修改单个电影信息
  async modifyHall({dispatch, commit, state}, payload) {
    return modifyHall({
      row: payload.row,
      col: payload.col,
      category: payload.category,
      hallId: payload.hallId,
      state: payload.state,
      name: payload.name,
    }).then(res => {
      console.log(res)
      if (typeof res === "number")
        return res;
      //修改model内容
      return {
        id: payload.hallId,
        state: payload.state, // 0 可用 ; 1 不可用
        row: payload.row,  //行数
        col: payload.col, //列数
        category: payload.category, //规格
        name: payload.name
      }
    }).then(res => {
      if (typeof res === "number")
        return res;
      commit('changeHallItem', res);
      return res
    });

  },
  //添加影厅
  async addHall({dispatch, commit, state}, payload) {

  }
};

const mutations = {
  flushList: (state, payload) => {
    state.hallList = payload
  },

  appendHallList: (state, payload) => {
    state.hallList.push(payload)
  },
  removeHallList: (state, {id}) => {
    state.hallList = state.hallList.filter(item => {
      return item.id !== id
    });
  },
  changeHallItem: (state, payload) => {
    let i = 0;
    state.hallList.forEach((item, index) => {
      if (item.id === payload.id) {
        i = index
      }
    });
    state.hallList[i] = payload;
    return payload
  }
};
export default {
  state,
  getters,
  actions,
  mutations
}
