package com.vaadin.addon.leaflet4vaadin.layer.events;

import com.vaadin.addon.leaflet4vaadin.LeafletMap;
import com.vaadin.addon.leaflet4vaadin.layer.events.types.TooltipEventType;
import com.vaadin.flow.component.DomEvent;
import com.vaadin.flow.component.EventData;

@DomEvent("tooltipopen")
public class TooltipOpenEvent extends TooltipEvent {

  private static final long serialVersionUID = -2970239803057635578L;

  public TooltipOpenEvent(LeafletMap source, boolean fromClient,
      @EventData("event.detail.target.options.uuid") String layerId) {
    super(source, fromClient, layerId, TooltipEventType.tooltipopen, null);
  }

}
