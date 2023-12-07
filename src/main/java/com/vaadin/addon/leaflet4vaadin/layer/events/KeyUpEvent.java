package com.vaadin.addon.leaflet4vaadin.layer.events;

import com.vaadin.addon.leaflet4vaadin.LeafletMap;
import com.vaadin.addon.leaflet4vaadin.layer.events.types.KeyboardEventType;
import com.vaadin.flow.component.DomEvent;
import com.vaadin.flow.component.EventData;

@DomEvent("leaflet-keyup")
public class KeyUpEvent extends KeyboardEvent {

  private static final long serialVersionUID = -7626762301905298636L;

  public KeyUpEvent(LeafletMap source, boolean fromClient,
      @EventData("event.detail.target.options.uuid") String layerId,
      @EventData("event.detail.originalEvent.key") String key,
      @EventData("event.detail.originalEvent.code") String code,
      @EventData("event.detail.originalEvent.keyCode") int keyCode,
      @EventData("event.detail.originalEvent.shiftKey") boolean shiftKey,
      @EventData("event.detail.originalEvent.altKey") boolean altKey,
      @EventData("event.detail.originalEvent.ctrlKey") boolean ctrlKey) {
    super(source, fromClient, layerId, KeyboardEventType.keyup, key, code, keyCode, ctrlKey,
        shiftKey, altKey);
  }

}
