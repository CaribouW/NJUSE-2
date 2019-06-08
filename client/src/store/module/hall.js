const state = {
  hallList: [{
    id: '2',
    state: '0', // 0 可用 ; 1 不可用
    row: '10',  //行数
    col: '5', //列数
    type: 'IMAX', //规格
  },{
    id: '1',
    state: '0', // 0 可用 ; 1 不可用
    row: '10',  //行数
    col: '5', //列数
    type: 'IMAX', //规格
  },{
    id: '1',
    state: '0', // 0 可用 ; 1 不可用
    row: '10',  //行数
    col: '5', //列数
    type: 'IMAX', //规格
  },{
    id: '1',
    state: '0', // 0 可用 ; 1 不可用
    row: '10',  //行数
    col: '5', //列数
    type: 'IMAX', //规格
  },{
    id: '1',
    state: '0', // 0 可用 ; 1 不可用
    row: '10',  //行数
    col: '5', //列数
    type: 'IMAX', //规格
  }, {
    id: '1',
    state: '0', // 0 可用 ; 1 不可用
    row: '10',  //行数
    col: '5', //列数
    type: 'IMAX', //规格
  }, {
    id: '1',
    state: '0', // 0 可用 ; 1 不可用
    row: '10',  //行数
    col: '5', //列数
    type: 'IMAX', //规格
  }, {
    id: '1',
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
