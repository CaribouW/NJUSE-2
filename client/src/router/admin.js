import movieManage from '@/views/admin/hall/movieManage'
import scheduleManage from '@/views/admin/hall/scheduleManage'
import movieShow from '@/views/admin/hall/movieShow'
import statistic from '@/views/admin/hall/statistic'
import hallManage from '@/views/admin/hall/hallManage'

const childernAmin = [
  {
    path: 'movieShow',
    name: 'movieShow',
    component: movieShow
  },
  {
    path: 'movieManage',
    name: 'movieManage',
    component: movieManage,
  },
  {
    path: 'scheduleManage',
    name: 'scheduleManage',
    component: scheduleManage
  },
  {
    path: 'statistic',
    name: 'statistic',
    component: statistic
  },
  {
    path: 'hallManage',
    name: 'hallManage',
    component: hallManage
  }
];
export {childernAmin}
