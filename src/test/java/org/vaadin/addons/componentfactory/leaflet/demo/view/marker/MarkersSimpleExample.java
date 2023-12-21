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

package org.vaadin.addons.componentfactory.leaflet.demo.view.marker;

import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.notification.Notification.Position;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.vaadin.addons.componentfactory.leaflet.LeafletMap;
import org.vaadin.addons.componentfactory.leaflet.demo.LeafletDemoApp;
import org.vaadin.addons.componentfactory.leaflet.demo.components.ExampleContainer;
import org.vaadin.addons.componentfactory.leaflet.layer.map.options.DefaultMapOptions;
import org.vaadin.addons.componentfactory.leaflet.layer.map.options.MapOptions;
import org.vaadin.addons.componentfactory.leaflet.layer.ui.marker.Marker;
import org.vaadin.addons.componentfactory.leaflet.types.LatLng;

@PageTitle("Markers simple")
@Route(value = "marker/simple", layout = LeafletDemoApp.class)
public class MarkersSimpleExample extends ExampleContainer {

	@Override
	protected void initDemo() {

		FormLayout form = new FormLayout();
		TextField latitude = new TextField();
		TextField longitude = new TextField();
		longitude.setWidthFull();
		latitude.setWidthFull();

		form.addFormItem(latitude, "Latitude");
		form.addFormItem(longitude, "Longitude");
		addToSidebar(form);

		MapOptions options = new DefaultMapOptions();
		options.setCenter(new LatLng(47.070121823, 19.2041015625));
		options.setZoom(7);
		LeafletMap leafletMap = new LeafletMap(options);
		leafletMap.setBaseUrl("https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png");

		Marker marker = new Marker(options.getCenter());
		marker.setDraggable(true);
		marker.bindPopup("Hey, drag me if you want");
		marker.onClick((e) -> {
			Notification.show("You click the marker.", 3000, Position.TOP_CENTER);
		});

		latitude.setValue(marker.getLatLng().getLat().toString());
		longitude.setValue(marker.getLatLng().getLng().toString());
		marker.onMove((event) -> {
			LatLng newPosition = event.getLatLng();
            latitude.setValue(newPosition.getLat().toString());
            longitude.setValue(newPosition.getLng().toString());
		});

		marker.addTo(leafletMap);

		addToContent(leafletMap);
	}
}