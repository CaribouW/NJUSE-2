/*
 * @Description: mock
 * @Author: Zhou
 * @Date: 2019-05-12 23:48:07
 * @LastEditTime: 2019-05-13 00:08:49
 * @LastEditors: 周政
 */
import Mock from 'mockjs';

// 登录接口
Mock.mock('http://localhost:3000/user/Login', {
    //模拟返回数据自行定义

  'id': 666,
  'role': 1

});

// 有需要在下面增加就行了
Mock.mock('http://localhost:3000/user/register', {
    //模拟返回数据自行定义


});
