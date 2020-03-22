<template>
    <div class="container">
        <div class="layout layout--wrap layout--center">
            <div class="flex xs6">
                <h1>Registriere dich als Helfer</h1>
                <div class="stepper">
                    <div class="stepper__progress">
                        <div class="stepper__progress-line"></div>
                        <div class="stepper__progress-item" :class="stepperProgressItemClasses(1)">1</div>
                        <div class="stepper__progress-item" :class="stepperProgressItemClasses(2)">2</div>
                        <div class="stepper__progress-item" :class="stepperProgressItemClasses(3)">3</div>
                        <div class="stepper__progress-item" :class="stepperProgressItemClasses(4)">4</div>
                        <div class="stepper__progress-item" :class="stepperProgressItemClasses(5)">5</div>
                    </div>
                    <div class="stepper__steps">
                        <div class="stepper__step" :class="stepperStepClasses(1)">
                            <p>Bitte geben Sie Ihre Postleitzahl an:</p>
                            <text-field
                                    :label="'PLZ'"
                                    :max-length="5"
                                    v-model="person.zipCode"
                            />
                        </div>
                        <div class="stepper__step" :class="stepperStepClasses(2)">
                            <p>Bitte wählen Sie aus, welche Tätigkeiten für Sie in Frage kommen:</p>
                            <chips-select
                                    v-model="person.skillSet"
                                    :chips="skillSet"
                            />
                        </div>
                        <div class="stepper__step" :class="stepperStepClasses(3)">
                            <p>Besitzen Sie zusätzliche Ausbildungen / Zertifikate / Bescheinigungen?</p>
                            <chips-select
                                    v-model="person.additionalSkills"
                                    :chips="additionalSkillSet"
                            />
                        </div>
                        <div class="stepper__step" :class="stepperStepClasses(4)">
                            <p>Wie heißen Sie?</p>
                            <text-field
                                    :label="'Vorname'"
                                    v-model="person.firstName"
                            />
                            <text-field
                                    :label="'Nachname'"
                                    v-model="person.lastName"
                            />
                        </div>
                        <div class="stepper__step" :class="stepperStepClasses(5)">
                            <p>In welchem Umkreis wollen Sie suchen?</p>
                            <text-field
                                    :label="'Entfernung in km'"
                                    :type="'number'"
                                    v-model="person.maxDistance"
                            />
                        </div>
                    </div>
                    <div class="stepper__actions">
                        <div class="layout">
                            <div class="flex xs6">
                                <btn :label="'Zurück'" :color="'secondary'" @click="stepBackward()" :disabled="step === 0"/>
                            </div>
                            <div class="flex xs6">
                                <btn :label="'Weiter'" @click="stepForward()"/>
                            </div>
                        </div>
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
        step: number = 1;
        steps: number = 6;
        person: HelpingHand = {
            firstName: '',
            lastName: '',
            zipCode: '',
            maxDistance: 20,
            skillSet: [],
            additionalSkills: []
        };
        skillSet: ChipValue[] = [
            { label: 'Materialpflege', key: 'materialCare' },
            { label: 'Reinigung', key: 'cleaning' },
            { label: 'Verpflegung', key: 'foodSupply' },
            { label: 'Sonstiges', key: 'misc' },
        ];
        additionalSkillSet: ChipValue[] = [
            { label: 'Führerschein', key: 'driversLicence' },
            { label: 'Pflege-Ausbildung', key: 'humanCare' },
            { label: 'Rettunssanitäter', key: 'medic' },
        ];

        stepperProgressItemClasses(step) {
            return {
                'stepper__progress-item--done': this.step > step,
                'stepper__progress-item--active': this.step === step,
            }
        }

        stepperStepClasses(step) {
            return {
                'stepper__step--done': this.step > step,
                'stepper__step--active': this.step === step,
            }
        }

        stepBackward() {
            if(this.step > 1) {
                this.step--;
            }
        }

        stepForward() {
            if(this.step < this.steps) {
                this.step++;
            }
        }

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
