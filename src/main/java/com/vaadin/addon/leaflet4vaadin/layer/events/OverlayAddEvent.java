package com.vaadin.addon.leaflet4vaadin.layer.events;

import com.vaadin.addon.leaflet4vaadin.LeafletMap;
import com.vaadin.addon.leaflet4vaadin.controls.LayersControl.LayerControlEventType;
import com.vaadin.addon.leaflet4vaadin.controls.LayersControlEvent;
import com.vaadin.flow.component.DomEvent;
import com.vaadin.flow.component.EventData;

@DomEvent("overlayadd")
public class OverlayAddEvent extends LayersControlEvent {

  private static final long serialVersionUID = 3295607427378773699L;

  public OverlayAddEvent(LeafletMap source, boolean fromClient,
      @EventData("event.detail.target.options.uuid") String layerId,
      @EventData("event.detail.name") String name) {
    super(source, fromClient, layerId, LayerControlEventType.overlayadd, name);
  }

}
