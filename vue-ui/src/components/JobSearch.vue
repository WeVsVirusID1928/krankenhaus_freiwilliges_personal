<template>
    <div class="job-search">
        <h2>Finde heraus wo in deinem Umkreis Hilfe benötigt wird:</h2>
        <div class="job-search__controls" v-if="!hideControls">
            <div class="layout layout--wrap">
                <div class="flex xs12 sm3">
                    <text-field
                            :label="'PLZ'"
                            :max-length="5"
                            v-model="zipCode"
                    />
                </div>
                <div class="flex xs12 sm2">
                    <text-field
                            :label="'Entfernung in km'"
                            :type="'number'"
                            :hint="'max. Entfernung'"
                            v-model="maxDistance"
                    />
                </div>
                <div class="flex xs12 sm3">
                    <btn :label="'Suchen'" @click="search()"/>
                </div>
                <div class="flex xs12 sm4">
                    <btn :label="'Alle aktiven Locations'" @click="getAllLocations()"/>
                </div>
            </div>
        </div>
        <div class="layout layout--wrap">
            <job-map :jobLocations="jobLocations" :zoomLevel="zoomLevel"></job-map>
            <div class="layout" v-if="zipCode.length < 4 || maxDistance < 1">
                <div class="flex xs12">
                    <p>
                        Bitte gebe deine Postleitzahl und die gewünschte maximale Entfernung ein.
                    </p>
                </div>
            </div>
            <template v-else>
                <div class="layout layout--wrap">
                    <search-result class="flex xs12 sm12 md6" v-for="job in jobs" :key="job.id" :job="job" :location="job.location" :teaserIcon="'map-marker-alt'" /> 
                </div>
            </template>
            <div class="layout layout--wrap">
                    <search-result class="flex xs12 sm12 md6" v-for="location in allLocations" :key="location.id" :location="location" :teaserIcon="'map-marker-alt'" /> 
            </div>
        </div>
    </div>
</template>

<script lang="ts">
    import Vue from 'vue';
    import { Component, Prop } from 'vue-property-decorator';
    import { ChipValue, Job, JobLocation } from '@/interfaces/types';
    import { getAvailableJobs, getJobLocations, getAllLocations } from '@/services/apiService';
    import SearchResult from '@/components/SearchResult.vue';
    import JobMap from '@/components/JobMap.vue';

    @Component({
        components: {
            SearchResult,
            JobMap
        }
    })
    export default class App extends Vue {
        @Prop({ default: false }) hideControls!: boolean;
        @Prop({ default: false }) initZipCode!: string;
        @Prop({ default: false }) initMaxDistance!: number;
        zipCode: string = '';
        maxDistance: number = 20;
        jobs: Job[] = [];
        jobLocations?: JobLocation[] = [];
        allLocations: JobLocation[] = [];
        zoomLevel: number = 12;

        getAllLocations() {
            getAllLocations().then(locations => {
                this.allLocations = locations;
                this.jobLocations = locations;
                this.zoomLevel = 5;
                });
        }

        created() {
            if (this.hideControls) {
                this.zipCode = this.initZipCode;
                this.maxDistance = this.initMaxDistance;

                this.search();
            }
        }

        search() {
            getAvailableJobs(this.zipCode, this.maxDistance).then(jobs => this.jobs = jobs);
            getJobLocations(this.zipCode, this.maxDistance).then(jobLocations => this.jobLocations = jobLocations);
        }
    }
</script>