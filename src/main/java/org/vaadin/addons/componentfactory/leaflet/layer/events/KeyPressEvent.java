package org.vaadin.addons.componentfactory.leaflet.layer.events;

import com.vaadin.flow.component.DomEvent;
import com.vaadin.flow.component.EventData;
import org.vaadin.addons.componentfactory.leaflet.LeafletMap;
import org.vaadin.addons.componentfactory.leaflet.layer.events.types.KeyboardEventType;

@DomEvent("leaflet-keypress")
public class KeyPressEvent extends KeyboardEvent {

  private static final long serialVersionUID = -1535067164066312401L;

  public KeyPressEvent(LeafletMap source, boolean fromClient,
      @EventData("event.detail.target.options.uuid") String layerId,
      @EventData("event.detail.originalEvent.key") String key,
      @EventData("event.detail.originalEvent.code") String code,
      @EventData("event.detail.originalEvent.keyCode") int keyCode,
      @EventData("event.detail.originalEvent.shiftKey") boolean shiftKey,
      @EventData("event.detail.originalEvent.altKey") boolean altKey,
      @EventData("event.detail.originalEvent.ctrlKey") boolean ctrlKey) {
    super(source, fromClient, layerId, KeyboardEventType.keypress, key, code, keyCode, ctrlKey,
        shiftKey, altKey);
  }

}
