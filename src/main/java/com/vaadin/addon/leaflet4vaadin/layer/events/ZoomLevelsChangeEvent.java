package com.vaadin.addon.leaflet4vaadin.layer.events;

import com.vaadin.addon.leaflet4vaadin.LeafletMap;
import com.vaadin.addon.leaflet4vaadin.layer.events.types.MapEventType;
import com.vaadin.flow.component.DomEvent;
import com.vaadin.flow.component.EventData;

@DomEvent("leaflet-zoomlevelschange")
public class ZoomLevelsChangeEvent extends LeafletEvent {

  private static final long serialVersionUID = 8461284901421281146L;

  public ZoomLevelsChangeEvent(LeafletMap source, boolean fromClient,
      @EventData("event.detail.target.options.uuid") String layerId) {
    super(source, fromClient, layerId, MapEventType.zoomlevelschange);
  }

}
