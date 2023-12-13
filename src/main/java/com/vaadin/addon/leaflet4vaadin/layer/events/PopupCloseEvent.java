package com.vaadin.addon.leaflet4vaadin.layer.events;

import com.vaadin.addon.leaflet4vaadin.LeafletMap;
import com.vaadin.addon.leaflet4vaadin.layer.events.types.PopupEventType;
import com.vaadin.flow.component.DomEvent;
import com.vaadin.flow.component.EventData;

@DomEvent("popupclose")
public class PopupCloseEvent extends PopupEvent {

  private static final long serialVersionUID = 6639088812785544327L;

  public PopupCloseEvent(LeafletMap source, boolean fromClient,
      @EventData("event.detail.target.options.uuid") String layerId) {
    super(source, fromClient, layerId, PopupEventType.popupclose, null);
  }

}
