import BuyCard from '@/views/VIP/buyCard.vue'
import VIPInfo from '@/views/VIP/VIPInfo.vue'
import VIPrights from '@/views/VIP/VIPrights.vue'

const childrenVIP = [
    {
        path: 'buyCard',
        name: 'BuyCard',
        component: BuyCard
      },
      {
        path: 'VIPInfo',
        name: 'VIPInfo',
        component: VIPInfo
      },
      {
        path: 'VIPrights',
        name: 'VIPrights',
        component: VIPrights
      },
];
export {childrenVIP}