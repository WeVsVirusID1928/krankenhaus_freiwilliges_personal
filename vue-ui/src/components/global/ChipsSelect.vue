<template>
    <div class="chips-select">
        <div class="chips-select__selected">
            <div class="chips-select__selected-chip"
                 v-for="key in value"
                 @click="handleDeselect(key)">
                {{getChipLabel(key)}}
            </div>
        </div>
        <div class="chips-select__available">
            <div class="chips-select__available-item"
                 v-for="chip in availableChipValues"
                 @click="handleSelect(chip)">{{chip.label}}
            </div>
        </div>
    </div>
</template>

<script lang="ts">
    import Vue from 'vue';
    import { Component, Prop } from 'vue-property-decorator';
    import { ChipValue } from '@/interfaces/types';

    @Component({})
    export default class Btn extends Vue {
        @Prop({ default: null }) value!: string[];
        @Prop({ default: () => [] }) chips!: ChipValue[];

        get availableChipValues() {
            return this.chips.filter(chip => {
                return !this.value.includes(chip.key);
            })
        }

        getChipLabel(key: string): string {
            const chip = this.chips.find(chip => chip.key && chip.key === key);
            return chip ? chip.label : "";
        }

        handleSelect(chip: ChipValue) {
            const updatedValue = [...this.value, chip.key];
            this.$emit('input', updatedValue);
        }

        handleDeselect(key: string) {
            const index = this.value.findIndex(selectedKey => selectedKey === key);
            if (index > -1) {
                const updatedValue = [...this.value];
                updatedValue.splice(index, 1);
                this.$emit('input', updatedValue);
            }
        }

        handleClick(event: Event) {
            this.$emit('click', event);
        }
    }
</script>