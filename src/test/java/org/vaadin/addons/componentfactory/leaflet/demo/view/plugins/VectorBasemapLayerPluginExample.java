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

package org.vaadin.addons.componentfactory.leaflet.demo.view.plugins;

import com.vaadin.flow.component.html.Anchor;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import java.util.Objects;
import org.vaadin.addons.componentfactory.leaflet.LeafletMap;
import org.vaadin.addons.componentfactory.leaflet.controls.LayersControl;
import org.vaadin.addons.componentfactory.leaflet.controls.LayersControlOptions;
import org.vaadin.addons.componentfactory.leaflet.demo.LeafletDemoApp;
import org.vaadin.addons.componentfactory.leaflet.demo.components.ExampleContainer;
import org.vaadin.addons.componentfactory.leaflet.layer.map.options.DefaultMapOptions;
import org.vaadin.addons.componentfactory.leaflet.layer.map.options.MapOptions;
import org.vaadin.addons.componentfactory.leaflet.plugins.esri.VectorBasemapLayer;
import org.vaadin.addons.componentfactory.leaflet.plugins.esri.VectorBasemapLayerOptions;
import org.vaadin.addons.componentfactory.leaflet.types.LatLng;

@PageTitle("Esri Leaflet Vector Basemap Layer example")
@Route(value = "plugins/esri/vector-layer", layout = LeafletDemoApp.class)
public class VectorBasemapLayerPluginExample extends ExampleContainer {

  private static final long serialVersionUID = 7554022663956386641L;

  @Override
  protected void initDemo() {
    String esriApiKey = System.getProperty("esri.api.key");
    Objects.requireNonNull(esriApiKey, "Esri API Key not provided");

    MapOptions options = new DefaultMapOptions();
    options.setCenter(new LatLng(34.02, -118.805));
    options.setZoom(7);

    LeafletMap leafletMap = new LeafletMap(options);

    VectorBasemapLayer streetsLayer =
        new VectorBasemapLayer("ArcGIS:Streets", new VectorBasemapLayerOptions(esriApiKey));
    streetsLayer.addTo(leafletMap);
    
    VectorBasemapLayer navigationLayer =
        new VectorBasemapLayer("ArcGIS:Navigation", new VectorBasemapLayerOptions(esriApiKey));
    
    VectorBasemapLayer imageryLayer =
        new VectorBasemapLayer("ArcGIS:Imagery", new VectorBasemapLayerOptions(esriApiKey));

    VectorBasemapLayer topographicLayer =
        new VectorBasemapLayer("ArcGIS:Topographic", new VectorBasemapLayerOptions(esriApiKey));
 
    Anchor pluginRepository = new Anchor();
    pluginRepository.setHref("https://developers.arcgis.com/esri-leaflet");
    pluginRepository.setText("Esri Leaflet plugin");
    pluginRepository.setTarget("_blank");

    LayersControlOptions layersControlOptions = new LayersControlOptions();
    layersControlOptions.setAutoZIndex(true);
    LayersControl layersControl = new LayersControl(layersControlOptions);
    layersControl.addTo(leafletMap);

    layersControl.addBaseLayer(streetsLayer, "ArcGIS Streets");
    layersControl.addBaseLayer(navigationLayer, "ArcGIS Navigation");
    layersControl.addBaseLayer(topographicLayer, "ArcGIS Topographic");
    layersControl.addBaseLayer(imageryLayer, "ArcGIS Imagery");
    
    addToContent(pluginRepository, leafletMap);
  }

}
