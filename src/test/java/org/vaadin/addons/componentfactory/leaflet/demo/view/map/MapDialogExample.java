package org.vaadin.addons.componentfactory.leaflet.demo.view.map;

import static org.vaadin.addons.componentfactory.leaflet.types.LatLng.latlng;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.vaadin.addons.componentfactory.leaflet.LeafletMap;
import org.vaadin.addons.componentfactory.leaflet.demo.LeafletDemoApp;
import org.vaadin.addons.componentfactory.leaflet.demo.components.ExampleContainer;
import org.vaadin.addons.componentfactory.leaflet.layer.map.options.DefaultMapOptions;
import org.vaadin.addons.componentfactory.leaflet.layer.map.options.MapOptions;

@PageTitle("Map in dialog")
@Route(value = "map/dialog", layout = LeafletDemoApp.class)
public class MapDialogExample extends ExampleContainer {

    @Override
    protected void initDemo() {
        Button openDialog = new Button("Open dialog");
        openDialog.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        openDialog.addClickListener((event) -> {
            
            MapOptions options = new DefaultMapOptions();
            options.setCenter(latlng(47.070121823, 19.2041015625));
            options.setZoom(7);
            options.setPreferCanvas(true);
            LeafletMap leafletMap = new LeafletMap(options);
            leafletMap.setBaseUrl("https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png");
            
            Dialog dialog = new Dialog();
            dialog.setResizable(true);
            dialog.setDraggable(true);
            dialog.setWidth("600px");
            dialog.setHeight("400px");
            dialog.addResizeListener((dialogResizeEvent)-> {
               leafletMap.invalidateSize();
            });

            dialog.add(leafletMap);
            
            dialog.open();
        });
        addToContent(openDialog);
    }

}
