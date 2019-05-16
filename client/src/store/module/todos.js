import axios from 'axios'

const state = {
    Todos:[]
};

const getters = {
    allTodos: (state) => state.Todos
};

const actions = {
    fetchTodos({ commit }){
        axios.get(
            'http://localhost:3000/vuex/test/get'
        ).then(res => {
            console.log(res);
            commit('setTodos',res.data.todolist);
        }).catch(err => {
            console.log(err);
        })
    },
    addTodo({ commit }, title){
        axios.post('http://localhost:3000/vuex/test/add',{
            "title": title
        }).then(res => {
            console.log(res);
            commit('newTodo', res.data)
        }).catch(err => {
            console.log(err);
        })
    }

};

const mutations = {
    setTodos: (state, Todos) => state.Todos = Todos,
    newTodo: (state, todo) => state.Todos.unshift(todo),

};

export default {
    state,
    getters,
    actions,
    mutations
}