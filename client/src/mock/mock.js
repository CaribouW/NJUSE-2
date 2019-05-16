/*
 * @Description: mock
 * @Author: Zhou
 * @Date: 2019-05-12 23:48:07
 * @LastEditTime: 2019-05-14 23:02:01
 * @LastEditors: Please set LastEditors
 */
import Mock from 'mockjs';

// 登录接口
Mock.mock('http://localhost:3000/user/Login', {
    //模拟返回数据自行定义

  'id': 666,
  'role': 1

});

var todolist = [
  {
    id: 1,
    title: 'do my homework',
    completed: false
  },
  {
    id: 2,
    title: 'play with friends',
    completed: false
  },
  {
    id: 3,
    title: 'sweep the floor',
    completed: true
  },
  {
    id: 4,
    title: 'do my homework',
    completed: false
  },
  {
    id: 5,
    title: 'experiment',
    completed: false
  },
  {
    id: 6,
    title: 'do some reading',
    completed: true
  },
]


Mock.mock('http://localhost:3000/vuex/test/add', function(todoItem){
  var newItem = {
    id: todolist.length+1,
    title: todoItem.title,
    completed: false
  };
  todolist.unshift(newItem);
  return newItem;
});

Mock.mock('http://localhost:3000/vuex/test/change',function(id){
  var index = todolist.findIndex(id);
  if (index !== -1){
    todolist[index].completed = !todolist[index].completed;
  }
  return {}
})

Mock.mock('http://localhost:3000/vuex/test/delete', function(id){
  // todolist.
  return {'todolist': todolist}
});

Mock.mock('http://localhost:3000/vuex/test/get', function(){
  // if (todolist.length >= num){
  //   return {'todolist': todolist.slice(0,num)}
  // }
  // else{
  //   return {};
  // }
  return {'todolist': todolist}
});