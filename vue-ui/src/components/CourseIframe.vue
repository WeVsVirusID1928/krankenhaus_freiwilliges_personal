<template>
  <div class="course-iframe">
    <iframe :src="course"></iframe>
  </div>
</template>

<script lang="ts">
import Vue from "vue";
import { Component, Prop } from "vue-property-decorator";

@Component
export default class CourseIframe extends Vue {
  @Prop({default: ''}) course: string;
}
</script>

<style lang="scss">
iframe {
  width: 100%;
  height: 65vh;
  margin: 1.5rem 0;
}
</style>