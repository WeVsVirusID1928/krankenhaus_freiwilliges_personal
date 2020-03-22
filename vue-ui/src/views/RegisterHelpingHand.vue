<template>
    <div class="container" :class="{'container__helperFlow' : step <= steps}">
        <div v-if="step" class="layout layout--wrap layout--center">
            <div class="flex xs6" v-if="step <= steps">
                <h1 class="layout__headline">Registriere dich als Helfer</h1>
                <div class="stepper">
                    <div class="stepper-container">
                        <div class="stepper__steps">
                            <div class="stepper__step" :class="stepperStepClasses(1)">
                                <h2>Hi! <br>Wer bist du?</h2>
                                <text-field :is-inverse="true" :label="'Dein Name'" v-model="person.firstName"/>
                            </div>
                            <div class="stepper__step" :class="stepperStepClasses(2)">
                                <h2 class="stepper_label">Wo bist du?</h2>
                                <text-field
                                        :is-inverse="true"
                                        :label="'Postleitzahl Aufenthaltsort'"
                                        :max-length="5"
                                        v-model="person.zipCode"
                                />
                            </div>
                            <div class="stepper__step" :class="stepperStepClasses(3)">
                                <h2>Welche Tätigkeiten kommen in Frage:</h2>
                                <chips-select v-model="person.skillSet" :chips="skillSet"/>
                            </div>
                            <div class="stepper__step" :class="stepperStepClasses(4)">
                                <h2>Hast du zusätzliche Ausbildungen oder Zertifikate?</h2>
                                <chips-select v-model="person.additionalSkills" :chips="additionalSkillSet"/>
                            </div>
                            <div class="stepper__step" :class="stepperStepClasses(5)">
                                <h2>In welchem Umkreis sollen wir suchen?</h2>
                                <text-field
                                        :label="'Entfernung in km'"
                                        :type="'number'"
                                        :is-inverse="true"
                                        v-model="person.maxDistance"
                                />
                            </div>
                        </div>
                        <div class="stepper__actions">
                            <!-- <div class="layout"> -->
                            <!-- <div class="flex xs6">
                                <btn
                                  :label="'Zurück'"
                                  :color="'secondary'"
                                  @click="stepBackward()"
                                  :disabled="step === 0"
                                />
                            </div>-->
                            <div class="flex xs6 next">
                                <btn :label="'Weiter'" @click="stepForward()"/>
                            </div>
                            <!-- </div> -->
                        </div>
                    </div>
                </div>
                <div class="stepper__progress">
                    <div class="stepper__progress-line"></div>
                    <div class="stepper__progress-item" :class="stepperProgressItemClasses(1)">1</div>
                    <div class="stepper__progress-item" :class="stepperProgressItemClasses(2)">2</div>
                    <div class="stepper__progress-item" :class="stepperProgressItemClasses(3)">3</div>
                    <div class="stepper__progress-item" :class="stepperProgressItemClasses(4)">4</div>
                    <div class="stepper__progress-item" :class="stepperProgressItemClasses(5)">5</div>
                </div>
            </div>
            <div class="flex xs12" v-else>
                <job-search :hideControls="true" :init-zip-code="person.zipCode" :init-max-distance="person.maxDistance"/>
            </div>
        </div>
    </div>
</template>

<script lang="ts">
    import Vue from 'vue';
    import { Component } from 'vue-property-decorator';
    import { ChipValue, HelpingHand } from '@/interfaces/types';
    import { registerHelpingHand } from '@/services/apiService';
    import JobSearch from '@/components/JobSearch.vue';

    @Component({
        components: { JobSearch }
    })
    export default class App extends Vue {
        step: number = 1;
        steps: number = 5;
        person: HelpingHand = {
            firstName: '',
            lastName: '',
            zipCode: '',
            maxDistance: 20,
            skillSet: [],
            additionalSkills: []
        };
        skillSet: ChipValue[] = [
            { label: 'Logistik', key: 'logistics' },
            { label: 'Desinfektion', key: 'desinfection' },
            { label: 'Sicherheit | Organisation', key: 'organisation' },
            { label: 'Verpflegung', key: 'catering' }
        ];
        additionalSkillSet: ChipValue[] = [
            { label: 'Führerschein', key: 'driversLicence' },
            { label: 'Pflege-Ausbildung', key: 'humanCare' },
            { label: 'Rettunssanitäter', key: 'medic' }
        ];

        stepperProgressItemClasses(step: number) {
            return {
                'stepper__progress-item--done': this.step > step,
                'stepper__progress-item--active': this.step === step
            };
        }

        stepperStepClasses(step: number) {
            return {
                'stepper__step--done': this.step > step,
                'stepper__step--active': this.step === step
            };
        }

        stepBackward() {
            if (this.step > 1) {
                this.step--;
            }
        }

        stepForward() {
            if (this.step <=this.steps) {
                this.step++;
            }
        }

        handleSubmit() {
            registerHelpingHand(this.person)
                .then(response => {
                })
                .catch(errors => {
                });
        }

        created() {
        }

        mounted() {
        }
    }
</script>
