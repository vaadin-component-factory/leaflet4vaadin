package com.vaadin.addon.leaflet4vaadin.plugins.esri;

import com.vaadin.addon.leaflet4vaadin.annotations.LeafletArgument;
import com.vaadin.flow.component.dependency.JsModule;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * <a href="https://github.com/Esri/esri-leaflet">Esri</a>
 * <a href="https://developers.arcgis.com/esri-leaflet/api-reference/layers/tiled-map-layer/">Tiled
 * map layer</a> plugin.  Access tiles from ArcGIS Online and ArcGIS Server.
 */
@JsModule("./esri-tiled-map-layer.js")
@AllArgsConstructor
public class TiledMapLayer extends EsriLeafletLayer {

  private static final long serialVersionUID = -7906787297109085580L;
  
  @Getter
  @LeafletArgument
  private final TiledMapLayerOptions options;
  
}
