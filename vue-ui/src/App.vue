<template>
  <div id="app">
    <router-view/>
  </div>
</template>

<script lang="ts">
  import Vue from 'vue';
  import { Component } from 'vue-property-decorator';

  @Component({})
  export default class App extends Vue {
    created() {

    }
    mounted() {

    }
  }
</script>

<style lang="scss">
  @import "scss/index";
</style>
