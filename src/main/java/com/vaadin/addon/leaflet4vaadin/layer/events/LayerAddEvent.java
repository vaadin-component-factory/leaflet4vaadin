package com.vaadin.addon.leaflet4vaadin.layer.events;

import com.vaadin.addon.leaflet4vaadin.LeafletMap;
import com.vaadin.addon.leaflet4vaadin.layer.events.types.LayerEventType;
import com.vaadin.flow.component.DomEvent;
import com.vaadin.flow.component.EventData;

@DomEvent("layeradd")
public class LayerAddEvent extends LayerEvent {

  private static final long serialVersionUID = 1541515694999130479L;

  public LayerAddEvent(LeafletMap source, boolean fromClient,
      @EventData("event.detail.target.options.uuid") String layerId) {
    super(source, fromClient, layerId, LayerEventType.layeradd, null);
  }

}
