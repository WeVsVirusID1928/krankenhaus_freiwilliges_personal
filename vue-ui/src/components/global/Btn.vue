<template>
    <div class="btn" :class="colorClasses" @click="handleClick">
        {{label}}
    </div>
</template>

<script lang="ts">
    import Vue from 'vue';
    import { Component, Prop } from 'vue-property-decorator';

    @Component({})
    export default class Btn extends Vue {
        @Prop({ default: null }) label!: string | null;
        @Prop({ default: 'theme' }) color!: string;

        get colorClasses() {
            return {
              'btn--secondary': this.color === 'secondary'
            }
        }

        handleClick(event: Event) {
            this.$emit('click', event);
        }
    }
</script>