package com.vaadin.addon.leaflet4vaadin.demo.view.plugins;

import com.vaadin.addon.leaflet4vaadin.LeafletMap;
import com.vaadin.addon.leaflet4vaadin.demo.LeafletDemoApp;
import com.vaadin.addon.leaflet4vaadin.demo.components.ExampleContainer;
import com.vaadin.addon.leaflet4vaadin.layer.map.options.DefaultMapOptions;
import com.vaadin.addon.leaflet4vaadin.layer.map.options.MapOptions;
import com.vaadin.addon.leaflet4vaadin.plugins.esri.TiledMapLayer;
import com.vaadin.addon.leaflet4vaadin.plugins.esri.TiledMapLayerOptions;
import com.vaadin.addon.leaflet4vaadin.types.LatLng;
import com.vaadin.flow.component.html.Anchor;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

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

    TiledMapLayerOptions layerOptions = new TiledMapLayerOptions();
    layerOptions.setUrl(
        "https://tiles.arcgis.com/tiles/nGt4QxSblgDfeJn9/arcgis/rest/services/New_York_Housing_Density/MapServer");

    tiledMapLayer = new TiledMapLayer(layerOptions);
    tiledMapLayer.addTo(leafletMap);

    Anchor pluginRepository = new Anchor();
    pluginRepository.setHref("https://github.com/Esri/esri-leaflet");
    pluginRepository.setText("Esri plugins: https://github.com/Esri/esri-leaflet");
    pluginRepository.setTarget("_blank");

    addToContent(pluginRepository, leafletMap);
  }

}
