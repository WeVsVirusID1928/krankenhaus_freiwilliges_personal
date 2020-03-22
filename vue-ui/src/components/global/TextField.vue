<template>
  <div class="text-field" :class="textFieldClasses">
    <input
        :id="inputId"
        :type="type"
        :maxlength="maxLength"
        :min="min"
        :max="max"
        :readonly="readonly"
        v-bind:value="value"
        v-on:input="$emit('input', $event.target.value)"
        v-bind:class="{ 'inverse': isInverse }"
        @focus="handleFocus"
        @blur="focused = false"
        @keyup.enter="emitKeyupEnter"
        :placeholder="label"
    >
    <!-- <label :for="inputId">{{label}}</label> -->
    <div class="text-field__prepend-icon" v-if="prependIcon">
      <icon :icon="prependIcon"/>
    </div>
    <div class="text-field__append-icon" v-if="processedAppendIcon" @click="emitClickAppend">
      <icon :icon="processedAppendIcon"/>
    </div>
    <div class="text-field__info">
      <div class="text-field__hint">{{hint}}</div>
      <div class="text-field__error-messages">{{joinedErrorMessages}}</div>
      <div class="text-field__counter" v-bind:class="{ 'text-field__counter--inverse': isInverse }" v-if="type !== 'number'">{{ value ? value.length : 0}}/{{maxLength}}</div>
    </div>
  </div>
</template>

<script lang="ts">
  import Vue from 'vue';
  import {Component, Prop} from 'vue-property-decorator';

  @Component({})
  export default class TextField extends Vue {
    @Prop({default: ''}) value!: any;
    @Prop({default: 'text'}) type!: string;
    @Prop({default: null}) label!: string| null;
    @Prop({default: 255}) maxLength!: number;
    @Prop({default: null}) hint!: string| null;
    @Prop({default: () => []}) errors!: string[];
    @Prop({default: null}) prependIcon!: string | null;
    @Prop({default: null}) appendIcon!: string | null;
    @Prop({default: false}) hideDetails!: boolean;
    @Prop({default: null}) min!: number | null;
    @Prop({default: null}) max!: number | null;
    @Prop({default: false}) clearable!: boolean;
    @Prop({default: false}) readonly!: boolean;
    @Prop({default: false}) disabled!: boolean;
    @Prop() isInverse?: boolean;

    inputId: string = '';
    focused: boolean = false;

    get processedAppendIcon() {
      if(this.clearable) {
        if(this.value && this.value.length > 0) {
          return 'cross';
        }else {
          return null;
        }
      }
      return this.appendIcon;
    }

    get textFieldClasses() {
      return {
        'text-field--focused': this.focused,
        'text-field--error': this.errors.length > 0,
        'text-field--prepend-icon': this.prependIcon !== null,
        'text-field--append-icon': this.appendIcon !== null,
        'text-field--hide-details': this.hideDetails
      }
    }

    get joinedErrorMessages() {
      return this.errors.join('<br/>');
    }

    handleFocus(event: Event) {
      this.focused = true;
      if(event.target) {
        const target = event.target as any;
        target.select();
      }
    }

    emitClickAppend(event: Event) {
      if(this.clearable) {
        this.$emit('input', '');
        this.$emit('click:clear', event);
      } else {
        this.$emit('click:append', event);
      }
    }

    emitKeyupEnter(event: Event) {
      event.preventDefault();
      this.$emit('keyup:enter', event);
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