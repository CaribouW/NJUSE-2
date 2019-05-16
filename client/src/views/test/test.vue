<template>
    <div class="main">
        <h1>This is a todoList!</h1>
        <div class="main_box">
            <form action="onSubmit">
                <input type="text" id="newTodo" v-model="todo_title" placeholder="add todos...">
                <input type="submit" value="submit">
            </form>
            <div 
            v-for="todo in allTodos" 
            :key="todo.id" 
            class="todo">
                {{ todo.title }}
            </div>
        </div>
    </div>
</template>

<script>
import { mapGetters,mapActions } from 'vuex'

export default {
    name: 'todoList',
    data() {
        return {
            todo_title: ''
        }
    },
    computed: {
        ...mapGetters(['allTodos']),
        
    },
    methods: {
        ...mapActions(['fetchTodos','addTodo']),
        onSubmit(e){
            e.preventDefault();
            this.addTodo(this.todo_title);
        }
    },
    created() {
        this.fetchTodos();
    }
}
</script>

<style lang="scss">

.main{
    width: 400px;
    margin: 10px auto;
    color: black;
    >.mian_box{
        width: 300px;
        margin: 0 auto;
        text-align: center;
        font-size: 20px;
        color: black;
    }
}
.todo{
    background-color: bisque;
    color: black;
    width: 270px;
    margin: 10px auto;
}
.completed{
    background-color: cadetblue;
    color: black;
    width: 270px;
    margin: 10px auto;
}
</style>

