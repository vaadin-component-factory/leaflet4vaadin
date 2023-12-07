package com.vaadin.addon.leaflet4vaadin.layer.events;

import com.vaadin.addon.leaflet4vaadin.LeafletMap;
import com.vaadin.addon.leaflet4vaadin.layer.events.types.KeyboardEventType;
import com.vaadin.flow.component.DomEvent;
import com.vaadin.flow.component.EventData;

@DomEvent("leaflet-keydown")
public class KeyDownEvent extends KeyboardEvent {

  private static final long serialVersionUID = -8605292511930798889L;

  public KeyDownEvent(LeafletMap source, boolean fromClient,
      @EventData("event.detail.target.options.uuid") String layerId,
      @EventData("event.detail.originalEvent.key") String key,
      @EventData("event.detail.originalEvent.code") String code,
      @EventData("event.detail.originalEvent.keyCode") int keyCode,
      @EventData("event.detail.originalEvent.shiftKey") boolean shiftKey,
      @EventData("event.detail.originalEvent.altKey") boolean altKey,
      @EventData("event.detail.originalEvent.ctrlKey") boolean ctrlKey) {
    super(source, fromClient, layerId, KeyboardEventType.keydown, key, code, keyCode, ctrlKey,
        shiftKey, altKey);
  }

}
