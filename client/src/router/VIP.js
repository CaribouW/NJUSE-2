import BuyCard from '@/views/VIP/buyCard.vue'
import VIPInfo from '@/views/VIP/VIPInfo.vue'
import VIPrights from '@/views/VIP/VIPrights.vue'

const childrenVIP = [
    {
        path: '/VIP/buyCard',
        name: 'BuyCard',
        component: BuyCard
      },
      {
        path: '/VIP/VIPInfo',
        name: 'VIPInfo',
        component: VIPInfo
      },
      {
        path: '/VIP/VIPrights',
        name: 'VIPrights',
        component: VIPrights
      },
];
export {childrenVIP}