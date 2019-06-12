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
          const size = item.size;
          const arr = size.split(',');
          return {
            id: item.hallID,
            name: item.name,
            state: item.state,
            row: arr[0],  //行数
            col: arr[1], //列数
            category:item.category
          }
        });
        return commit('flushList', list);
      }
    )
  },
  //修改单个电影信息
  async modifyHall({dispatch, commit, state}, payload) {
    console.log(payload)
    return modifyHall({
      size: payload.row + ',' + payload.col,
      category: payload.category,
      hallId: payload.hallId,
      state: payload.state,
      name: payload.name,
    }).then(res => {
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
