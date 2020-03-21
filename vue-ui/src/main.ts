import Vue from 'vue'
import App from './App.vue'
import './registerServiceWorker'
import router from './router'
import store from './store'
import TextField from "@/components/global/TextField.vue";
import Btn from "@/components/global/Btn.vue";
import CheckBox from '@/components/global/CheckBox.vue';
import ChipsSelect from '@/components/global/ChipsSelect.vue';

Vue.config.productionTip = false;

Vue.component('btn', Btn);
Vue.component('checkbox', CheckBox);
Vue.component('chips-select', ChipsSelect);
Vue.component('text-field', TextField);

new Vue({
  router,
  store,
  render: h => h(App)
}).$mount('#app');
