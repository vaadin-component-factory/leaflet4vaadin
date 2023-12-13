package com.vaadin.addon.leaflet4vaadin.layer.events;

import com.vaadin.addon.leaflet4vaadin.LeafletMap;
import com.vaadin.addon.leaflet4vaadin.layer.events.types.MapEventType;
import com.vaadin.flow.component.DomEvent;
import com.vaadin.flow.component.EventData;

@DomEvent("leaflet-viewreset")
public class ViewResetEvent extends LeafletEvent {

  private static final long serialVersionUID = -4889975038367377820L;

  public ViewResetEvent(LeafletMap source, boolean fromClient,
      @EventData("event.detail.target.options.uuid") String layerId) {
    super(source, fromClient, layerId, MapEventType.viewreset);
  }

}
