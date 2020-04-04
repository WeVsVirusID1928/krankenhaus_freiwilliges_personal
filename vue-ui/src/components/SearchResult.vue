<template>
  <div class="job-search">
    <div class="job-search__result">
      <div class="job-search__result-header">
        <h2 class="job-search__result-title">{{location.name}}</h2>
        <div class="job-search__result-distance">
          <font-awesome-icon :icon="teaserIcon" :color="'#fff'" />
          {{location.city}}
        </div>
      </div>
      <p class="job-search__result-detail">
        <font-awesome-icon icon="clinic-medical" />
        {{location.street}}, {{location.zipCode}} {{location.city}}
      </p>
      <p class="job-search__result-detail">
        <font-awesome-icon icon="phone-alt" />
        {{location.phoneNumber}}
      </p>
    </div>
  </div>
</template>

<script lang="ts">
import Vue from "vue";
import { Component, Prop } from "vue-property-decorator";
import { JobLocation } from "../interfaces/types";
@Component
export default class SearchResult extends Vue {
  @Prop() location!: JobLocation;
  @Prop() teaserIcon?: string;
}
</script>

<style lang="scss">
</style>