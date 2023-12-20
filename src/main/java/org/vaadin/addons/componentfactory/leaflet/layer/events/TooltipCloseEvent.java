package org.vaadin.addons.componentfactory.leaflet.layer.events;

import com.vaadin.flow.component.DomEvent;
import com.vaadin.flow.component.EventData;
import org.vaadin.addons.componentfactory.leaflet.LeafletMap;
import org.vaadin.addons.componentfactory.leaflet.layer.events.types.TooltipEventType;

@DomEvent("tooltipclose")
public class TooltipCloseEvent extends TooltipEvent {

  private static final long serialVersionUID = -1262999904025094098L;

  public TooltipCloseEvent(LeafletMap source, boolean fromClient, 
      @EventData("event.detail.target.options.uuid") String layerId) {
    super(source, fromClient, layerId, TooltipEventType.tooltipclose, null);
  }

}
