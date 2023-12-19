// Copyright 2020 Gabor Kokeny and contributors
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
// http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package com.vaadin.addon.leaflet4vaadin.demo.view.plugins;

import com.vaadin.addon.leaflet4vaadin.LeafletMap;
import com.vaadin.addon.leaflet4vaadin.demo.LeafletDemoApp;
import com.vaadin.addon.leaflet4vaadin.demo.components.ExampleContainer;
import com.vaadin.addon.leaflet4vaadin.layer.map.options.DefaultMapOptions;
import com.vaadin.addon.leaflet4vaadin.layer.map.options.MapOptions;
import com.vaadin.addon.leaflet4vaadin.plugins.esri.DynamicMapLayer;
import com.vaadin.addon.leaflet4vaadin.plugins.esri.DynamicMapLayerOptions;
import com.vaadin.addon.leaflet4vaadin.types.LatLng;
import com.vaadin.flow.component.html.Anchor;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@PageTitle("Esri Leaflet Dynamic Map Layer example")
@Route(value = "plugins/esri/dynamicmap", layout = LeafletDemoApp.class)
public class DynamicMapLayerPluginExample extends ExampleContainer {

  private static final long serialVersionUID = 7554022663956386641L;

  @Override
  protected void initDemo() {
    MapOptions options = new DefaultMapOptions();
    options.setCenter(new LatLng(37.71, -99.88));
    options.setZoom(4);

    LeafletMap leafletMap = new LeafletMap(options);
    leafletMap.setBaseUrl("https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png");

    DynamicMapLayerOptions hurricanesLayerOptions = new DynamicMapLayerOptions(
        "https://sampleserver6.arcgisonline.com/arcgis/rest/services/Hurricanes/MapServer/");
    hurricanesLayerOptions.setOpacity(0.6);
    DynamicMapLayer hurricanesLayer = new DynamicMapLayer(hurricanesLayerOptions);
    hurricanesLayer.addTo(leafletMap);

    DynamicMapLayerOptions censusLayerOptions = new DynamicMapLayerOptions(
        "https://sampleserver6.arcgisonline.com/arcgis/rest/services/Census/MapServer");
    censusLayerOptions.setOpacity(0.5);
    DynamicMapLayer censusLayer = new DynamicMapLayer(censusLayerOptions);
    censusLayer.addTo(leafletMap);

    Anchor pluginRepository = new Anchor();
    pluginRepository.setHref("https://developers.arcgis.com/esri-leaflet");
    pluginRepository.setText("Esri Leaflet plugin");
    pluginRepository.setTarget("_blank");

    addToContent(pluginRepository, leafletMap);
  }


}
