package org.vaadin.addons.componentfactory.leaflet.layer.events;

import com.vaadin.flow.component.DomEvent;
import com.vaadin.flow.component.EventData;
import org.vaadin.addons.componentfactory.leaflet.LeafletMap;
import org.vaadin.addons.componentfactory.leaflet.layer.events.types.PopupEventType;

@DomEvent("popupopen")
public class PopupOpenEvent extends PopupEvent {

  private static final long serialVersionUID = 7868462790937722918L;

  public PopupOpenEvent(LeafletMap source, boolean fromClient,
      @EventData("event.detail.target.options.uuid") String layerId) {
    super(source, fromClient, layerId, PopupEventType.popupopen, null);
  }

}
