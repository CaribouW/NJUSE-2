const state = {
  hallList: [{
    id: '1',
    state: 0, // 0 可用 ; 1 不可用
    row: '10',  //行数
    col: '5', //列数
    type: 'IMAX', //规格
  },{
    id: '2',
    state: 1, // 0 可用 ; 1 不可用
    row: '10',  //行数
    col: '5', //列数
    type: 'IMAX', //规格
  },{
    id: '3',
    state: 1, // 0 可用 ; 1 不可用
    row: '10',  //行数
    col: '5', //列数
    type: '3D', //规格
  },{
    id: '4',
    state: 1, // 0 可用 ; 1 不可用
    row: '10',  //行数
    col: '5', //列数
    type: 'IMAX', //规格
  },{
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
    type: 'IMAX', //规格
  }, ]
};
const getters = {
  //获取所有的影厅
  getHallList: state => state.hallList
};

const actions = {};

const mutations = {};
export default {
  state,
  getters,
  actions,
  mutations
}
