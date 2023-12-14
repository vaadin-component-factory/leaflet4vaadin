package com.vaadin.addon.leaflet4vaadin.plugins.esri;

import com.vaadin.addon.leaflet4vaadin.annotations.LeafletArgument;
import com.vaadin.addon.leaflet4vaadin.layer.Layer;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.dependency.NpmPackage;

/**
 * <a href="https://github.com/Esri/esri-leaflet">Esri</a>
 * <a href="https://developers.arcgis.com/esri-leaflet/api-reference/layers/tiled-map-layer/">Tiled
 * map layer</a> plugin.  Access tiles from ArcGIS Online and ArcGIS Server.
 */
@NpmPackage(value = "esri-leaflet", version = "3.0.12")
@JsModule("esri-leaflet/dist/esri-leaflet.js")
@JsModule("./esri-tiled-map-layer.js")
public class TiledMapLayer extends Layer {

  private static final long serialVersionUID = -7906787297109085580L;
  
  @LeafletArgument
  private TiledMapLayerOptions options;

  public TiledMapLayer(TiledMapLayerOptions options) {
    this.options = options;
  }
  
  public void setOptions(TiledMapLayerOptions options) {
    this.options = options;
  }
  
  public TiledMapLayerOptions getOptions() {
    return options;
  }
  
}
