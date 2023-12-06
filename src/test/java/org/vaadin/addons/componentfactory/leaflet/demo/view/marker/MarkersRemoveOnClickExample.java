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

import static java.util.stream.IntStream.range;
import static org.vaadin.addons.componentfactory.leaflet.types.LatLng.latlng;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.notification.Notification.Position;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.vaadin.addons.componentfactory.leaflet.LeafletMap;
import org.vaadin.addons.componentfactory.leaflet.demo.LeafletDemoApp;
import org.vaadin.addons.componentfactory.leaflet.demo.components.ExampleContainer;
import org.vaadin.addons.componentfactory.leaflet.layer.Layer;
import org.vaadin.addons.componentfactory.leaflet.layer.map.options.DefaultMapOptions;
import org.vaadin.addons.componentfactory.leaflet.layer.map.options.MapOptions;
import org.vaadin.addons.componentfactory.leaflet.layer.ui.marker.Marker;

@PageTitle("Remove on click")
@Route(value = "marker/remove-on-click", layout = LeafletDemoApp.class)
public class MarkersRemoveOnClickExample extends ExampleContainer {

	@Override
	protected void initDemo() {

		MapOptions options = new DefaultMapOptions();
		options.setCenter(latlng(47.070121823, 19.2041015625));
		options.setZoom(7);
		LeafletMap leafletMap = new LeafletMap(options);
		leafletMap.setBaseUrl("https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png");

		range(0, 10).forEach((i) -> {
			double lat = (Math.random() * 4) + 45;
			double lon = (Math.random() * 7) + 16;
			Marker marker = new Marker(latlng(lat, lon));
			marker.bindTooltip("Click me to remove from map");
			marker.onClick((e) -> {
			    Layer layer = e.getSource().getLayer(e.getLayerId());
				layer.remove();
				Notification.show("Marker removed successfully", 1000, Position.TOP_CENTER);
			});
			marker.addTo(leafletMap);
		});

		addToContent(leafletMap);
	}
}
