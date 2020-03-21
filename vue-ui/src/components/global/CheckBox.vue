<template>
  <label class="checkbox" :class="checkboxClasses">
    <span class="checkbox__box"></span>
    <input
        :id="inputId"
        type="checkbox"
        v-bind:value="value"
        v-on:input="$emit('input', !value)"
    >
    <span class="checkbox__label" :for="inputId">{{label}}</span>
  </label>
</template>

<script lang="ts">
  import Vue from 'vue';
  import {Component, Prop} from 'vue-property-decorator';

  @Component({})
  export default class TextField extends Vue {
    @Prop({default: ''}) value!: boolean;
    @Prop({default: null}) label!: string| null;
    @Prop({default: false}) disabled!: boolean;

    inputId: string = '';

    get checkboxClasses() {
      return {
        'checkbox--checked': this.value
      }
    }

    created() {
      let result = '';
      const characters = 'ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789';
      const charactersLength = characters.length;
      for (let i = 0; i < 32; i++) {
        result += characters.charAt(Math.floor(Math.random() * charactersLength));
      }
      this.inputId = result;
    }
  }
</script>