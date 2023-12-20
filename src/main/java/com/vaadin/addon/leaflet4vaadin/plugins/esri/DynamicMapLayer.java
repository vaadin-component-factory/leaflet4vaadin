package com.vaadin.addon.leaflet4vaadin.plugins.esri;

import com.vaadin.addon.leaflet4vaadin.annotations.LeafletArgument;
import com.vaadin.flow.component.dependency.JsModule;
import lombok.Getter;

@JsModule("./esri-dynamic-map.js")
public class DynamicMapLayer extends EsriLeafletLayer {

  private static final long serialVersionUID = 1L;

  @Getter
  @LeafletArgument
  private final DynamicMapLayerOptions options;

  public DynamicMapLayer(DynamicMapLayerOptions options) {
    this.options = options;
  }

}
