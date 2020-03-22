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
        <div class="job-search__results layout layout--wrap">
            <l-map style="height: 400px; width: 100%;"
                :zoom="zoom"
                :center="center"
                ref="myMap">
                <l-tile-layer
                        :url="url"
                        :attribution="attribution"
                />
                <l-marker :lat-lng="latLng(jobLocation.lat, jobLocation.lng)" v-for="jobLocation in jobLocations">
<!--                    <l-popup>-->
<!--                        <div @click="innerClick">-->
<!--                            I am a popup-->
<!--                            <p v-show="showParagraph">-->
<!--                                Lorem ipsum dolor sit amet, consectetur adipiscing elit. Quisque-->
<!--                                sed pretium nisl, ut sagittis sapien. Sed vel sollicitudin nisi.-->
<!--                                Donec finibus semper metus id malesuada.-->
<!--                            </p>-->
<!--                        </div>-->
<!--                    </l-popup>-->
                </l-marker>
            </l-map>
            <div class="layout" v-if="zipCode.length < 4 || maxDistance < 1">
                <div class="flex xs12">
                    <p>
                        Bitte geben Sie zuerst eine Postleitzahl und die gewünschte maximale Entfernung ein.
                    </p>
                </div>
            </div>
            <template v-else>
                <div class="layout layout--wrap">
                    <div class="flex xs12 sm12 md6"v-for="job in jobs">
                        <div class="job-search__result">
                            <div class="job-search__result-header">
                                <h2 class="job-search__result-title">{{job.title}}</h2>
                                <div class="job-search__result-distance"><font-awesome-icon icon="route" :color="'#fff'"/>{{job.location.distance}}</div>
                            </div>
                            <div class="job-search__result-skillset">
                                <font-awesome-icon icon="clipboard-check" :color="'#00c0ff'"/>{{getSkillLabels(job.skillSet)}}
                            </div>
                            <div class="job-search__result-location">
                                <font-awesome-icon icon="clinic-medical" :color="'#00c0ff'" />{{job.location.name}} / {{job.location.city}}
                            </div>
                        </div>
                    </div>
                </div>
            </template>
        </div>
    </div>
</template>

<script lang="ts">
    import Vue from 'vue';
    import { Component, Prop } from 'vue-property-decorator';
    import { latLng, latLngBounds } from "leaflet";
    import { LMap, LTileLayer, LMarker } from 'vue2-leaflet';
    import { ChipValue, Job, JobLocation } from '@/interfaces/types';
    import { getAvailableJobs, getJobLocations } from '@/services/apiService';
    import { Icon } from 'leaflet';

    type D = Icon.Default & {
        _getIconUrl: string;
    };

    delete (Icon.Default.prototype as D)._getIconUrl;
    Icon.Default.mergeOptions({
        iconRetinaUrl: require('leaflet/dist/images/marker-icon-2x.png'),
        iconUrl: require('leaflet/dist/images/marker-icon.png'),
        shadowUrl: require('leaflet/dist/images/marker-shadow.png'),
    });

    @Component({
        components: {
            LMap,
            LTileLayer,
            LMarker,
        }
    })
    export default class App extends Vue {
        @Prop({ default: false }) hideControls!: boolean;
        @Prop({ default: false }) initZipCode!: string;
        @Prop({ default: false }) initMaxDistance!: number;
        zoom: number = 12;
        center: any = latLng(52.5172576,13.4050284);
        url: string = 'https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png';
        attribution: string = '&copy; <a href="http://osm.org/copyright">OpenStreetMap</a> contributors';
        zipCode: string = '';
        maxDistance: number = 20;
        jobs: Job[] = [];
        jobLocations: JobLocation[] = [];
        skillSet: ChipValue[] = [
            { label: 'Materialpflege', key: 'materialCare' },
            { label: 'Reinigung', key: 'cleaning' },
            { label: 'Verpflegung', key: 'foodSupply' },
            { label: 'Sonstiges', key: 'misc' },
        ];
        map: any;

        latLng(lat: number, lng: number) {
            return latLng(lat,lng);
        }

        getSkillLabels(keys: string[]): string  {
            return this.skillSet.filter(skill => keys.includes(skill.key)).map(skill => skill.label).join(', ');
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

<style lang="scss">
    @import '../../node_modules/leaflet/dist/leaflet.css';
</style>
