import Vue from 'vue'
import App from './App.vue'
import { library } from '@fortawesome/fontawesome-svg-core'
import { faHospital, faClipboardList, faClipboardCheck, faClinicMedical, faRoute } from '@fortawesome/free-solid-svg-icons'
import { FontAwesomeIcon } from '@fortawesome/vue-fontawesome'
import './registerServiceWorker'
import router from './router'
import store from './store'
import TextField from "@/components/global/TextField.vue";
import Btn from "@/components/global/Btn.vue";
import CheckBox from '@/components/global/CheckBox.vue';
import ChipsSelect from '@/components/global/ChipsSelect.vue';

Vue.config.productionTip = false;

library.add(faHospital, faClipboardList, faClipboardCheck, faClinicMedical, faRoute);
Vue.component('font-awesome-icon', FontAwesomeIcon);

Vue.component('btn', Btn);
Vue.component('checkbox', CheckBox);
Vue.component('chips-select', ChipsSelect);
Vue.component('text-field', TextField);

new Vue({
  router,
  store,
  render: h => h(App)
}).$mount('#app');
