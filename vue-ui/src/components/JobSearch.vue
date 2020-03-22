<template>
  <div class="container">
    <h1>Aktuelle Positionen</h1>
    <div class="job-search">
      <div class="job-search__controls">
        <div class="layout layout--wrap">
          <div class="flex xs12 sm4">
            <text-field :label="'PLZ'" :max-length="5" v-model="zipCode" />
          </div>
          <div class="flex xs12 sm4">
            <text-field :label="'Entfernung in km'" :type="'number'" v-model="maxDistance" />
          </div>
          <div class="flex xs12 sm4">
            <btn :label="'Suchen'" @click="search()" />
          </div>
        </div>
      </div>
      <div class="job-search__results">
        <p
          v-if="zipCode.length < 4 || maxDistance < 1"
        >Bitte geben Sie zuerst eine Postleitzahl und die gewünschte maximale Entfernung ein.</p>
        <template v-else>
          <div class="job-search__result" v-for="job in jobs">
            <h2>{{job.title}}</h2>
            <div>
              <div class="job-search__result-skill" v-for="skill in job.skillSet">{{skill}}</div>
            </div>
            <div>{{job.location.name}} / {{job.location.city}}</div>
          </div>
        </template>
      </div>
    </div>
  </div>
</template>

<script lang="ts">
import Vue from "vue";
import { Component } from "vue-property-decorator";
import { Job } from "@/interfaces/types";
import { getAvailableJobs } from "@/services/apiService";

@Component({
  name: "job-search"
})
export default class JobSearch extends Vue {
  zipCode: string = "";
  maxDistance: number = 20;
  jobs: Job[] = [];

  search() {
    getAvailableJobs(this.zipCode, this.maxDistance).then(
      jobs => (this.jobs = jobs)
    );
  }

  created() {}

  mounted() {}
}
</script>
