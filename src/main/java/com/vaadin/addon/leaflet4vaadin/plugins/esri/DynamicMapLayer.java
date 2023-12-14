package com.vaadin.addon.leaflet4vaadin.plugins.esri;

import com.vaadin.addon.leaflet4vaadin.annotations.LeafletArgument;
import com.vaadin.addon.leaflet4vaadin.layer.events.LeafletEvent;
import com.vaadin.addon.leaflet4vaadin.layer.events.LeafletEventListener;
import com.vaadin.addon.leaflet4vaadin.layer.events.types.EventTypeRegistry;
import com.vaadin.addon.leaflet4vaadin.layer.events.types.LeafletEventType;
import com.vaadin.flow.component.dependency.JsModule;
import lombok.Getter;

@JsModule("./esri-dynamic-map.js")
public class DynamicMapLayer extends EsriLeafletLayer {

  public static enum DynamicMapLayerEventType implements LeafletEventType {
    load;
  }

  static {
    EventTypeRegistry.register(DynamicMapLayerEventType.class);
  }

  @Getter
  @LeafletArgument
  private final DynamicMapLayerOptions options;

  public DynamicMapLayer(DynamicMapLayerOptions options) {
    this.options = options;
  }

  /**
   * Redraws the heatmap.
   */
  public void redraw() {
    executeJs("redraw");
  }

  public void onLoad(LeafletEventListener<LeafletEvent> listener) {
    on(DynamicMapLayerEventType.load, listener);
  }

}
