import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../views/Home.vue'
import LocationDetail from '../views/LocationDetail.vue'

Vue.use(VueRouter);

const routes = [
  {
    path: '/',
    name: 'Home',
    component: Home
  },
  
  {
    path: '/register-helping-hand',
    name: 'RegisterHelpingHand',
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () => import(/* webpackChunkName: "about" */ '../views/RegisterHelpingHand.vue')
  },

  {
    path: '/location/:id',
    name: 'Location',
    component: LocationDetail,
  }
];

const router = new VueRouter({
  routes
});

export default router
