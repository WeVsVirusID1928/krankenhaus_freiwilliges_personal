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
      <template v-if="job">
      <p class="job-search__result-detail">
        <font-awesome-icon icon="star" />
        {{job.title}}
      </p>
      <p class="job-search__result-detail">
        <font-awesome-icon icon="clipboard-check" />
        {{getSkillLabels(job.skillSet)}}
      </p>
      </template>
      <p class="job-search__result-detail">
        <font-awesome-icon icon="clinic-medical" />
        {{location.street}}, {{location.zipCode}} {{location.city}}
      </p>
      <p v-if="location.phoneNumber" class="job-search__result-detail">
        <font-awesome-icon icon="phone-alt" />
        {{location.phoneNumber}}
      </p>
    </div>
  </div>
</template>

<script lang="ts">
import Vue from "vue";
import { Component, Prop } from "vue-property-decorator";
import { JobLocation, Job, ChipValue } from "../interfaces/types";
@Component
export default class SearchResult extends Vue {
  @Prop() location!: JobLocation;
  @Prop() job?: Job;
  @Prop() teaserIcon?: string;

  skillSet: ChipValue[] = [
            { label: 'Logistik', key: 'logistics' },
            { label: 'Desinfektion', key: 'desinfection' },
            { label: 'Sicherheit | Organisation', key: 'organisation' },
            { label: 'Verpflegung', key: 'catering' }
        ];

  getSkillLabels(keys: string[]): string  {
            return this.skillSet.filter(skill => keys.includes(skill.key)).map(skill => skill.label).join(', ');
        }

}
</script>

<style lang="scss">
</style>