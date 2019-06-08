import Coupon from '@/views/user/coupon.vue'
import Favor from '@/views/user/favor.vue'
import ModifyInfo from '@/views/user/basicInfo/modifyinfo.vue'
import PreferentialPolicy from '@/views/user/helper/preferentialpolicy.vue'
import Notice from '@/views/user/helper/notice.vue'
import Contact from '@/views/user/helper/contact.vue'
import History from '@/views/user/history.vue'
import UserBasic from '@/views/user/basicInfo/basicInfo.vue'

const childrenUser = [
  {
    path: '',
    name: 'UserBasic',
    component: UserBasic
  },
  {
    path: 'coupon',
    name: 'Coupon',
    component: Coupon
  },
  {
    path: 'favor',
    name: 'Favor',
    component: Favor
  },
  {
    path: 'modifyinfo',
    name: 'ModifyInfo',
    component: ModifyInfo
  },
  {
    path: 'helper/preferentialpolicy',
    name: 'PreferentialPolicy',
    component: PreferentialPolicy
  },
  {
    path: 'helper/notice',
    name: 'Notice',
    component: Notice
  },
  {
    path: 'helper/contact',
    name: 'Contact',
    component: Contact
  },
  {
    path: '/user/history',
    name: 'History',
    component: History
  },
];
export {childrenUser}
