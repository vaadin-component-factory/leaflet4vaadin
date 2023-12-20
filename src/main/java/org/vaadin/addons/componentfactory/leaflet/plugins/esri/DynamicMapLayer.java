package org.vaadin.addons.componentfactory.leaflet.plugins.esri;

import com.vaadin.flow.component.dependency.JsModule;
import lombok.Getter;
import org.vaadin.addons.componentfactory.leaflet.annotations.LeafletArgument;

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
