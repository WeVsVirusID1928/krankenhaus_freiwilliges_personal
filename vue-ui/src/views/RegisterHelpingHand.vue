<template>
    <div class="container">
        <div class="layout layout--wrap">
            <div class="flex xs6">
                <div class="layout layout--wrap">
                    <div class="flex xs12 margin-top">
                        <h1>Registriere dich als Helfer</h1>
                    </div>
                    <div class="flex xs12 margin-top">
                        <p>Bitte geben Sie Ihre Postleitzahl an:</p>
                        <text-field
                                :label="'PLZ'"
                                :max-length="5"
                                v-model="person.zipCode"
                        />
                    </div>
                    <div class="flex xs12 margin-top">
                        <p>Bitte wählen Sie aus, welche Tätigkeiten für Sie in Frage kommen:</p>
                        <chips-select
                                v-model="person.skillSet"
                                :chips="skillSet"
                        />
                    </div>

                    <div class="flex xs12 margin-top">
                        <text-field
                                :label="'Vorname'"
                                v-model="person.firstName"
                        />
                    </div>
                    <div class="flex xs12 margin-top">
                        <text-field
                                :label="'Nachname'"
                                v-model="person.lastName"
                        />
                    </div>
                    <div class="flex xs12 margin-top">
                        <text-field
                                :label="'Entfernung in km'"
                                :type="'number'"
                                v-model="person.maxDistance"
                        />
                    </div>
                    <div class="flex xs12 margin-top">
                        <btn :label="'Absenden'" @click="handleSubmit"/>
                    </div>
                </div>
            </div>
        </div>
    </div>
</template>

<script lang="ts">
    import Vue from 'vue';
    import { Component } from 'vue-property-decorator';
    import { ChipValue, HelpingHand } from '@/interfaces/types';
    import { registerHelpingHand } from '@/services/apiService';

    @Component({})
    export default class App extends Vue {
        person: HelpingHand = {
            firstName: '',
            lastName: '',
            zipCode: '',
            maxDistance: 20,
            skillSet: []
        };
        skillSet: ChipValue[] = [
            {label: 'Materialpflege', key: 'materialCare'},
            {label: 'Reinigung', key: 'cleaning'},
            {label: 'Verpflegung', key: 'foodSupply'},
            {label: 'Sonstiges', key: 'misc'},
        ];

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
