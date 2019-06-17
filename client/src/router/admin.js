import movieManage from '@/views/admin/hall/movieManage'
import scheduleManage from '@/views/admin/hall/scheduleManage'
import movieShow from '@/views/admin/hall/movieShow'
import statistic from '@/views/admin/hall/statistic'
import activity from '@/views/admin/hall/activity'
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
    path: 'activity',
    name: 'activity',
    component: activity
  }
];
export {childernAmin}
