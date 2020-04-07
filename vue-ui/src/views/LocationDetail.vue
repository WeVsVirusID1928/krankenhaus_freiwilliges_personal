<template>
  <div class="location-detail container">
    <div class="layout layout--wrap">
      <img class="logo" src="@/assets/klinikhero.png" />
    </div>
    <h2>{{location.name}}</h2>
    <p class="location-detail__address">
      <font-awesome-icon icon="clinic-medical" />
      {{location.street}}, {{location.zipCode}} {{location.city}}
    </p>
    <p v-if="location.phoneNumber" class="location-detail__address">
      <font-awesome-icon icon="phone-alt" />
      {{location.phoneNumber}}
    </p>
    <course-iframe :course="getCourseSrc()"></course-iframe>
  </div>
</template>

<script lang="ts">
import Vue from "vue";
import { Component, Prop } from "vue-property-decorator";
import { getLocationById } from "@/services/apiService";
import { JobLocation } from "@/interfaces/types";
import CourseIframe from "@/components/CourseIframe.vue";

@Component({
  components: {
    CourseIframe
  }
})
export default class LocationDetail extends Vue {
  location?: JobLocation | {} = {};

  getCourseSrc() {
    return 'https://helferhaende.it-servicehost.de/mod/hvp/embed.php?id=86';
  }

  mounted() {
    getLocationById(this.$route.params.id).then(
      location => (this.location = location as JobLocation)
    );
  }
}
</script>

<style lang="scss">
.location-detail {
  &__address {
    padding: 0.25rem 1rem;
    font-size: 0.75rem;
    line-height: 1.2rem;
    margin: 0;

    .svg-inline--fa {
      margin-right: 0.5rem;
      width: 1rem;
    }
  }
}
</style>