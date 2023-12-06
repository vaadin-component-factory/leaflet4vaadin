package org.vaadin.addons.componentfactory.leaflet.demo.view.plugins;

import com.vaadin.flow.component.html.Anchor;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.vaadin.addons.componentfactory.leaflet.LeafletMap;
import org.vaadin.addons.componentfactory.leaflet.demo.LeafletDemoApp;
import org.vaadin.addons.componentfactory.leaflet.demo.components.ExampleContainer;
import org.vaadin.addons.componentfactory.leaflet.layer.map.options.DefaultMapOptions;
import org.vaadin.addons.componentfactory.leaflet.layer.map.options.MapOptions;
import org.vaadin.addons.componentfactory.leaflet.plugins.esri.TiledMapLayer;
import org.vaadin.addons.componentfactory.leaflet.plugins.esri.TiledMapLayerOptions;
import org.vaadin.addons.componentfactory.leaflet.types.LatLng;

@PageTitle("Esri Tiled map layer example")
@Route(value = "plugins/esri-tiled-layer", layout = LeafletDemoApp.class)
public class TiledMapLayerPluginExample extends ExampleContainer {

  private static final long serialVersionUID = -4226647949244898897L;
  private TiledMapLayer tiledMapLayer;

  @Override
  protected void initDemo() {
    MapOptions options = new DefaultMapOptions();
    options.setCenter(new LatLng(40.672827, -73.957901));
    options.setZoom(8);

    LeafletMap leafletMap = new LeafletMap(options);
    leafletMap.setBaseUrl("https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png");

    TiledMapLayerOptions layerOptions = new TiledMapLayerOptions(
        "https://tiles.arcgis.com/tiles/nGt4QxSblgDfeJn9/arcgis/rest/services/New_York_Housing_Density/MapServer");

    tiledMapLayer = new TiledMapLayer(layerOptions);
    tiledMapLayer.addTo(leafletMap);

    Anchor pluginRepository = new Anchor();
    pluginRepository.setHref("https://github.com/Esri/esri-leaflet");
    pluginRepository.setText("Esri plugins");
    pluginRepository.setTarget("_blank");

    addToContent(pluginRepository, leafletMap);
  }

}
