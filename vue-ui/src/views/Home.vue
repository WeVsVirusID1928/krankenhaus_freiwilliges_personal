<template>
    <div class="container">
        <div class="layout layout--wrap">
            <div class="flex xs12 sm4 margin-top">
                <text-field
                        :label="'Vorname'"
                        v-model="person.firstName"
                />
            </div>
            <div class="flex xs12 sm4 margin-top">
                <text-field
                        :label="'Nachname'"
                        v-model="person.lastName"
                />
            </div>
            <div class="flex xs12 sm2 margin-top">
                <text-field
                        :label="'PLZ'"
                        :max-length="5"
                        v-model="person.zipCode"
                />
            </div>
            <div class="flex xs12 sm2 margin-top">
                <text-field
                        :label="'Entfernung in km'"
                        :type="'number'"
                        v-model="person.maxDistance"
                />
            </div>
            <div class="flex xs4 margin-top">
                <btn :label="'Absenden'" @click="handleSubmit"/>
            </div>
        </div>
    </div>
</template>

<script lang="ts">
    import Vue from 'vue';
    import { Component } from 'vue-property-decorator';
    import { HelpingHand } from '@/interfaces/types';
    import { registerHelpingHand } from '@/services/apiService';

    @Component({})
    export default class App extends Vue {
        person: HelpingHand = {
            firstName: '',
            lastName: '',
            zipCode: '',
            maxDistance: 20,
        };

        handleSubmit() {
            registerHelpingHand(this.person)
                .then(response => {
                })
                .catch(errors => {
                })
        }

        created() {

        }

        mounted() {

        }
    }
</script>
