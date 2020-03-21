<template>
  <div class="btn" @click="handleClick">
    {{label}}
  </div>
</template>

<script lang="ts">
  import Vue from 'vue';
  import {Component, Prop} from 'vue-property-decorator';

  @Component({})
  export default class Btn extends Vue {
    @Prop({default: null}) label!: string| null;

    handleClick(event: Event){
      this.$emit('click', event);
    }
  }
</script>