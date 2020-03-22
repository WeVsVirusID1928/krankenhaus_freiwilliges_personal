<template>
    <div class="job-search">
        <h1>Aktuelle Positionen</h1>
        <div class="job-search__controls" v-if="!hideControls">
            <div class="layout layout--wrap">
                <div class="flex xs12 sm4">
                    <text-field
                            :label="'PLZ'"
                            :max-length="5"
                            v-model="zipCode"
                    />
                </div>
                <div class="flex xs12 sm4">
                    <text-field
                            :label="'Entfernung in km'"
                            :type="'number'"
                            v-model="maxDistance"
                    />
                </div>
                <div class="flex xs12 sm4">
                    <btn :label="'Suchen'" @click="search()"/>
                </div>
            </div>
        </div>
        <div class="job-search__results">
            <div class="layout" v-if="zipCode.length < 4 || maxDistance < 1">
                <div class="flex xs12">
                    <p>
                        Bitte geben Sie zuerst eine Postleitzahl und die gewünschte maximale Entfernung ein.
                    </p>
                </div>
            </div>
            <template v-else>
                <div class="job-search__result"
                     v-for="job in jobs"
                >
                    <div class="job-search__result-header">
                        <h2 class="job-search__result-title">{{job.title}}</h2>
                        <div class="job-search__result-distance"><font-awesome-icon icon="route" :color="'#fff'"/>1,2 km</div>
                    </div>
                    <div class="job-search__result-skillset">
                        <font-awesome-icon icon="clipboard-check" :color="'#00c0ff'"/>{{job.skillSet.join(', ')}}
                    </div>
                    <div class="job-search__result-location">
                        <font-awesome-icon icon="clinic-medical" :color="'#00c0ff'" />{{job.location.name}} / {{job.location.city}}
                    </div>
                </div>
            </template>
        </div>
    </div>
</template>

<script lang="ts">
    import Vue from 'vue';
    import { Component, Prop } from 'vue-property-decorator';
    import { ChipValue, Job } from '@/interfaces/types';
    import { getAvailableJobs } from '@/services/apiService';

    @Component({})
    export default class App extends Vue {
        @Prop({ default: false }) hideControls!;
        @Prop({ default: false }) initZipCode!;
        @Prop({ default: false }) initMaxDistance!;
        zipCode: string = '';
        maxDistance: number = 20;
        jobs: Job[] = [];
        skillSet: ChipValue[] = [
            { label: 'Materialpflege', key: 'materialCare' },
            { label: 'Reinigung', key: 'cleaning' },
            { label: 'Verpflegung', key: 'foodSupply' },
            { label: 'Sonstiges', key: 'misc' },
        ];

        getSkillLabel(key: string): string  {
            return this.skillSet.find(skill => skill.key === key).label;
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
        }
    }
</script>
