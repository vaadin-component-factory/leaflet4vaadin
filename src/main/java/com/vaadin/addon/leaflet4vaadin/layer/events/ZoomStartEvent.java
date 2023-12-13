package com.vaadin.addon.leaflet4vaadin.layer.events;

import com.vaadin.addon.leaflet4vaadin.LeafletMap;
import com.vaadin.addon.leaflet4vaadin.layer.events.types.MapEventType;
import com.vaadin.flow.component.DomEvent;
import com.vaadin.flow.component.EventData;

@DomEvent("leaflet-zoomstart")
public class ZoomStartEvent extends LeafletEvent {

  private static final long serialVersionUID = 7917603350686483193L;

  public ZoomStartEvent(LeafletMap source, boolean fromClient,
      @EventData("event.detail.target.options.uuid") String layerId) {
    super(source, fromClient, layerId, MapEventType.zoomstart);
  }

}
