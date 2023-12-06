package org.vaadin.addons.componentfactory.leaflet.layer.events;

import com.vaadin.flow.component.DomEvent;
import com.vaadin.flow.component.EventData;
import org.vaadin.addons.componentfactory.leaflet.LeafletMap;
import org.vaadin.addons.componentfactory.leaflet.layer.events.types.TooltipEventType;

@DomEvent("tooltipopen")
public class TooltipOpenEvent extends TooltipEvent {

  private static final long serialVersionUID = -2970239803057635578L;

  public TooltipOpenEvent(LeafletMap source, boolean fromClient,
      @EventData("event.detail.target.options.uuid") String layerId) {
    super(source, fromClient, layerId, TooltipEventType.tooltipopen, null);
  }

}
