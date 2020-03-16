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

package com.vaadin.addon.leaflet4vaadin.demo.view.marker;

import com.github.appreciated.app.layout.annotations.Caption;
import com.vaadin.addon.leaflet4vaadin.LeafletMap;
import com.vaadin.addon.leaflet4vaadin.demo.LeafletDemoApp;
import com.vaadin.addon.leaflet4vaadin.demo.components.ExampleContainer;
import com.vaadin.addon.leaflet4vaadin.layer.groups.LayerGroup;
import com.vaadin.addon.leaflet4vaadin.layer.map.options.DefaultMapOptions;
import com.vaadin.addon.leaflet4vaadin.layer.map.options.MapOptions;
import com.vaadin.addon.leaflet4vaadin.layer.ui.marker.Marker;
import com.vaadin.addon.leaflet4vaadin.types.LatLng;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.router.Route;

@Caption("Marker group")
@Route(value = "marker/group", layout = LeafletDemoApp.class)
public class MarkersGroupExample extends ExampleContainer {

    /**
     *
     */
    private static final long serialVersionUID = -3686513404441062815L;
    private LeafletMap leafletMap;
    private LayerGroup defaultGroup;
    private LayerGroup customGroup;

    @Override
    protected void initMap(Div mapContainer) {
        HorizontalLayout layout = new HorizontalLayout();
        layout.setSizeFull();

        FormLayout sidebar = new FormLayout();
        sidebar.setHeightFull();
        sidebar.setWidth("400px");
        Button defaultGroup = new Button("Default markers");
        defaultGroup.addClickListener((event) -> {
            if (this.defaultGroup == null) {
                this.defaultGroup = createDefaultMarkerGroup();
            } else {
                this.leafletMap.removeLayer(this.defaultGroup);
                this.defaultGroup = null;
            }
        });
        sidebar.add(defaultGroup);
        Button customGroup = new Button("Custom markers");
        customGroup.addClickListener((event) -> {
            if (this.customGroup == null) {
                this.customGroup = createCustomMarkerGroup();
            } else {
                this.leafletMap.removeLayer(this.customGroup);
                this.customGroup = null;
            }
        });
        sidebar.add(customGroup);

        MapOptions options = new DefaultMapOptions();
        options.setCenter(new LatLng(47.070121823, 19.2041015625));
        options.setZoom(7);
        leafletMap = new LeafletMap(options);
        leafletMap.setBaseUrl("https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png");

        this.customGroup = createCustomMarkerGroup();
        this.defaultGroup = createDefaultMarkerGroup();

        layout.add(leafletMap, sidebar);
        mapContainer.add(layout);
    }

    public LayerGroup createDefaultMarkerGroup() {
        Marker m1 = new Marker(new LatLng(46.470121823, 18.3041015625));
        Marker m2 = new Marker(new LatLng(46.320121823, 18.0041015625));
        LayerGroup group = new LayerGroup(m1, m2);
        group.setName("Default markers");
        group.addTo(leafletMap);
        return group;
    }

    public LayerGroup createCustomMarkerGroup() {
        com.vaadin.addon.leaflet4vaadin.types.Icon icon = new com.vaadin.addon.leaflet4vaadin.types.Icon(
                "images/marker-icon-demo.png", 41);
        Marker m3 = new Marker(new LatLng(46.270121823, 18.8041015625));
        m3.setIcon(icon);
        Marker m4 = new Marker(new LatLng(46.320121823, 19.2041015625));
        m4.setIcon(icon);
        LayerGroup group = new LayerGroup(m3, m4);
        group.setName("Custom markers");
        group.addTo(leafletMap);
        return group;
    }

}
