import hallManage from '@/views/manager/component/hallManage.vue'
import refundManage from '@/views/manager/component/refundStrategy.vue';
import movieRoleManage from '@/views/manager/component/MovieRoleManage';
import vipManage from '@/views/manager/component/vipManage';

const childernManager = [
  {
    path: 'hallManage',
    name: 'hallManage',
    component: hallManage
  }, {
    path: 'refundManage',
    name: 'refundManage',
    component: refundManage
  },
  {
    path: 'movieRoleManage',
    name: 'movieRoleManage',
    component: movieRoleManage
  },
  {
    path: 'vipManage',
    name: 'vipManage',
    component: vipManage
  },
];

export {childernManager}
