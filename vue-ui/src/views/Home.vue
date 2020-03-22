<template>
    <div class="container">
        <div class="layout layout--wrap">
            <div class="flex xs4 margin-top">
                    <btn :label="'Helfen'" @click="navigate('JobSearch')"/>
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

        navigate(route: string) {
            this.$router.push({name: route});
        }

        created() {

        }

        mounted() {

        }
    }
</script>
