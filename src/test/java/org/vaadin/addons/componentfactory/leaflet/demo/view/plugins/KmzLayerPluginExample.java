// Copyright 2020 Gabor Kokeny and contributors
// 
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
// 
//     http://www.apache.org/licenses/LICENSE-2.0
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
import org.vaadin.addons.componentfactory.leaflet.LeafletMap;
import org.vaadin.addons.componentfactory.leaflet.controls.LayersControl;
import org.vaadin.addons.componentfactory.leaflet.demo.LeafletDemoApp;
import org.vaadin.addons.componentfactory.leaflet.demo.components.ExampleContainer;
import org.vaadin.addons.componentfactory.leaflet.layer.Layer;
import org.vaadin.addons.componentfactory.leaflet.layer.map.options.DefaultMapOptions;
import org.vaadin.addons.componentfactory.leaflet.layer.map.options.MapOptions;
import org.vaadin.addons.componentfactory.leaflet.plugins.kmz.KmzLayer;
import org.vaadin.addons.componentfactory.leaflet.types.LatLng;

@PageTitle("KMZ example")
@Route(value = "plugins/kmz", layout = LeafletDemoApp.class)
public class KmzLayerPluginExample extends ExampleContainer {

    @Override
    protected void initDemo() {
        MapOptions options = new DefaultMapOptions();
        options.setCenter(new LatLng(47.070121823, 19.204101562500004));
        options.setPreferCanvas(true);
        options.setZoom(4);

        LeafletMap leafletMap = new LeafletMap(options);
        leafletMap.setBaseUrl("https://{s}.tile.opentopomap.org/{z}/{x}/{y}.png");
        
        LayersControl layersControl = new LayersControl();
        layersControl.addTo(leafletMap);

        KmzLayer kmz = new KmzLayer("kmz/capitals.kmz");
        kmz.onLoad((event) -> {
          Layer layer = event.getSource().getLayer(event.getLayerId());
          layersControl.addOverlay(layer, "Capitals");
        });
        kmz.addTo(leafletMap);

        addToContent(leafletMap);

        Anchor pluginRepository = new Anchor();
        pluginRepository.setHref("https://github.com/Raruto/leaflet-kmz");
        pluginRepository.setText("leaflet-kmz plugin: https://github.com/Raruto/leaflet-kmz");
        pluginRepository.setTarget("_blank");
        addToContent(pluginRepository);
    }

}
