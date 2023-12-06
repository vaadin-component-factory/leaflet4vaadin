package org.vaadin.addons.componentfactory.leaflet.plugins.esri;

import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.dependency.NpmPackage;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.vaadin.addons.componentfactory.leaflet.annotations.LeafletArgument;

@RequiredArgsConstructor
@Getter
@NpmPackage(value = "esri-leaflet-vector", version = "4.2.3")
@JsModule("esri-leaflet-vector/dist/esri-leaflet-vector.js")
@JsModule("./esri-vector-basemap-layer.js")
public class VectorBasemapLayer extends EsriLeafletLayer {

  private static final long serialVersionUID = 1L;

  /** 
   * key refers to a basemap style enumeration, or to the item ID of a custom basemap style.
   */  
  @LeafletArgument
  private final String key;
  
  @LeafletArgument
  private final VectorBasemapLayerOptions options;

}
