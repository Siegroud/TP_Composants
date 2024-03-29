import { createRouter, createWebHashHistory } from 'vue-router'
import HomeView from '../views/HomeView.vue'
import NewMemeView from '../views/NewMemeView.vue'
import MemeView from '../views/MemeView.vue'

const routes = [
  {
    path: '/',
    name: 'home',
    component: HomeView
  },
  {
    path: '/new',
    name: 'newMeme',
    component: NewMemeView
  },
  {
    path: '/update:id',
    name: 'update',
    component: NewMemeView
  },
  {
    path: '/meme:id',
    name: 'memeView',
    component: MemeView
  },
  {
    path: '/about',
    name: 'about',
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () => import(/* webpackChunkName: "about" */ '../views/AboutView.vue')
  }
]

const router = createRouter({
  history: createWebHashHistory(),
  routes
})

export default router
