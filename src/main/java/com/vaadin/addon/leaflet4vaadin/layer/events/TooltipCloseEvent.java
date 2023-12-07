package com.vaadin.addon.leaflet4vaadin.layer.events;

import com.vaadin.addon.leaflet4vaadin.LeafletMap;
import com.vaadin.addon.leaflet4vaadin.layer.events.types.TooltipEventType;
import com.vaadin.flow.component.DomEvent;
import com.vaadin.flow.component.EventData;

@DomEvent("tooltipclose")
public class TooltipCloseEvent extends TooltipEvent {

  private static final long serialVersionUID = -1262999904025094098L;

  public TooltipCloseEvent(LeafletMap source, boolean fromClient, 
      @EventData("event.detail.target.options.uuid") String layerId) {
    super(source, fromClient, layerId, TooltipEventType.tooltipclose, null);
  }

}
