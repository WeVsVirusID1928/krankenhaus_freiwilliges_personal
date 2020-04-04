<template>
  <l-map style="height: 400px; width: 100%;" :zoom="zoomLevel" :center="center" ref="myMap">
    <l-tile-layer :url="url" :attribution="attribution" />
    <l-marker
      v-for="(jobLocation, index) in jobLocations"
      :key="index"
      :lat-lng="getLatLong(jobLocation.latitude, jobLocation.longitude)"
    >
      <!--                    <l-popup>-->
      <!--                        <div @click="innerClick">-->
      <!--                            I am a popup-->
      <!--                            <p v-show="showParagraph">-->
      <!--                                Lorem ipsum dolor sit amet, consectetur adipiscing elit. Quisque-->
      <!--                                sed pretium nisl, ut sagittis sapien. Sed vel sollicitudin nisi.-->
      <!--                                Donec finibus semper metus id malesuada.-->
      <!--                            </p>-->
      <!--                        </div>-->
      <!--                    </l-popup>-->
    </l-marker>
  </l-map>
</template>

<script lang="ts">
import Vue from "vue";
import { Component, Prop } from "vue-property-decorator";
import { LMap, LTileLayer, LMarker } from "vue2-leaflet";
import { latLng, LatLng, Icon } from "leaflet";
import { JobLocation } from "../interfaces/types";

type D = Icon.Default & {
  _getIconUrl: string;
};

delete (Icon.Default.prototype as D)._getIconUrl;
Icon.Default.mergeOptions({
  iconRetinaUrl: require("leaflet/dist/images/marker-icon-2x.png"),
  iconUrl: require("leaflet/dist/images/marker-icon.png"),
  shadowUrl: require("leaflet/dist/images/marker-shadow.png")
});

@Component({
  components: {
    LMap,
    LTileLayer,
    LMarker
  }
})
export default class JobMap extends Vue {
  @Prop({ default: 12 }) zoomLevel?: number;
  @Prop() jobLocations?: JobLocation[];
  @Prop({ default: () => latLng(52.5172576, 13.4050284) })
  center: LatLng;

  url: string = "https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png";
  attribution: string =
    '&copy; <a href="http://osm.org/copyright">OpenStreetMap</a> contributors';

  getLatLong(lat: number, long: number): LatLng {
    return latLng(lat, long);
  }
}
</script>

<style lang="scss">
@import "../../node_modules/leaflet/dist/leaflet.css";
</style>
