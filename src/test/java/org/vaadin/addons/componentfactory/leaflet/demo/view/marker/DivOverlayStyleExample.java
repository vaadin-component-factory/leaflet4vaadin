package org.vaadin.addons.componentfactory.leaflet.demo.view.marker;

import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.vaadin.addons.componentfactory.leaflet.LeafletMap;
import org.vaadin.addons.componentfactory.leaflet.demo.LeafletDemoApp;
import org.vaadin.addons.componentfactory.leaflet.demo.components.ExampleContainer;
import org.vaadin.addons.componentfactory.leaflet.layer.map.options.DefaultMapOptions;
import org.vaadin.addons.componentfactory.leaflet.layer.map.options.MapOptions;
import org.vaadin.addons.componentfactory.leaflet.layer.ui.marker.Marker;
import org.vaadin.addons.componentfactory.leaflet.layer.ui.popup.Popup;
import org.vaadin.addons.componentfactory.leaflet.layer.ui.tooltip.Tooltip;
import org.vaadin.addons.componentfactory.leaflet.types.DivIcon;
import static java.util.stream.IntStream.range;
import static org.vaadin.addons.componentfactory.leaflet.types.LatLng.latlng;


@PageTitle("DivOverlay styling")
@Route(value = "marker/div-overlay-styling", layout = LeafletDemoApp.class)
public class DivOverlayStyleExample extends ExampleContainer {

    @Override
    protected void initDemo() {

        MapOptions options = new DefaultMapOptions();
        options.setCenter(latlng(47.070121823, 19.2041015625));
        options.setZoom(7);
        LeafletMap leafletMap = new LeafletMap(options);
        leafletMap.setBaseUrl("https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png");

        Marker marker = new Marker(options.getCenter());
        Popup popup = new Popup("Hi, I have custom CSS class, just press F12 and inspect the DOM to make sure.");
        popup.setClassName("custom-popup-css");
        popup.setCloseOnClick(true);
        popup.setCloseOnEscapeKey(true);
        marker.bindPopup(popup);

        marker.addTo(leafletMap);

        addToContent(leafletMap);
    }
}
