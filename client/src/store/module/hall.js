import {getHallList, modifyHall} from "../../service/HallService";

const state = {
  hallList: [{
    id: '1',
    state: 0, // 0 可用 ; 1 不可用
    row: '10',  //行数
    col: '5', //列数
    type: 'IMAX', //规格
  }, {
    id: '2',
    state: 1, // 0 可用 ; 1 不可用
    row: '10',  //行数
    col: '5', //列数
    type: 'IMAX', //规格
  }, {
    id: '3',
    state: 1, // 0 可用 ; 1 不可用
    row: '10',  //行数
    col: '5', //列数
    type: '3D', //规格
  }, {
    id: '4',
    state: 1, // 0 可用 ; 1 不可用
    row: '10',  //行数
    col: '5', //列数
    type: 'IMAX', //规格
  }, {
    id: '5',
    state: '0', // 0 可用 ; 1 不可用
    row: '10',  //行数
    col: '5', //列数
    type: 'IMAX', //规格
  }, {
    id: '6',
    state: '0', // 0 可用 ; 1 不可用
    row: '10',  //行数
    col: '5', //列数
    type: 'IMAX', //规格
  }, {
    id: '7',
    state: 1, // 0 可用 ; 1 不可用
    row: '10',  //行数
    col: '5', //列数
    type: 'IMAX', //规格
  }, {
    id: '8',
    state: '0', // 0 可用 ; 1 不可用
    row: '10',  //行数
    col: '5', //列数
    type: 'IMAXAAA', //规格
  },]
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
            state: item.state, // 0 可用 ; 1 不可用
            row: arr[0],  //行数
            col: arr[1], //列数
            type: item.type, //规格
          }
        });
        return commit('flushList', list);
      }
    )
  },

  async modifyHall({dispatch, commit, state}, payload) {
    const data = modifyHall(payload)
      .then(res => {
        const arr = item.size.split(',');
        return commit('appendHallList', {
          id: payload.hallId,
          state: payload.state, // 0 可用 ; 1 不可用
          row: arr[0],  //行数
          col: arr[1], //列数
          type: payload.category, //规格
        })
      });
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
  }
};
export default {
  state,
  getters,
  actions,
  mutations
}
