package com.vaadin.addon.leaflet4vaadin.layer.events;

import com.vaadin.addon.leaflet4vaadin.LeafletMap;
import com.vaadin.addon.leaflet4vaadin.layer.events.types.LayerEventType;
import com.vaadin.flow.component.DomEvent;
import com.vaadin.flow.component.EventData;

@DomEvent("layerremove")
public class LayerRemoveEvent extends LayerEvent {

  private static final long serialVersionUID = 1335834304448706455L;

  public LayerRemoveEvent(LeafletMap source, boolean fromClient,
      @EventData("event.detail.target.options.uuid") String layerId) {
    super(source, fromClient, layerId, LayerEventType.layerremove, null);
  }

}
