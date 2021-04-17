import Sobre from './components/sobre/Sobre.vue'
import Home from '@/components/Home.vue'

export const routes = [
    {path : '', component: Home, titulo: 'Home'},
    {path : '/sobre', component: Sobre, titulo: 'Sobre'}
];