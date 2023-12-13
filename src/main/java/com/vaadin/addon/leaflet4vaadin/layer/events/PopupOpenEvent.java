package com.vaadin.addon.leaflet4vaadin.layer.events;

import com.vaadin.addon.leaflet4vaadin.LeafletMap;
import com.vaadin.addon.leaflet4vaadin.layer.events.types.PopupEventType;
import com.vaadin.flow.component.DomEvent;
import com.vaadin.flow.component.EventData;

@DomEvent("popupopen")
public class PopupOpenEvent extends PopupEvent {

  private static final long serialVersionUID = 7868462790937722918L;

  public PopupOpenEvent(LeafletMap source, boolean fromClient,
      @EventData("event.detail.target.options.uuid") String layerId) {
    super(source, fromClient, layerId, PopupEventType.popupopen, null);
  }

}
