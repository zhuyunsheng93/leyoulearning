//使用js的模块
import Vue from "../node_modules/vue/dist/vue"
import VueRouter from "../node_modules/vue-router/dist/vue-router"
import loginForm from "./js/login"
import registerForm from "./js/register"
import './css/main.css'
Vue.use(VueRouter)
const router = new VueRouter({
    routes: [{path: "/login", component: loginForm}, {path: "/register", component: registerForm}]
});
var vm = new Vue({
    el:"#app",
    components:{
        loginForm,
        registerForm
    },
    router
})