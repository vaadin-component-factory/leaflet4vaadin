package org.vaadin.addons.componentfactory.leaflet.layer.events;

import com.vaadin.flow.component.DomEvent;
import com.vaadin.flow.component.EventData;
import org.vaadin.addons.componentfactory.leaflet.LeafletMap;
import org.vaadin.addons.componentfactory.leaflet.layer.events.types.PopupEventType;

@DomEvent("popupclose")
public class PopupCloseEvent extends PopupEvent {

  private static final long serialVersionUID = 6639088812785544327L;

  public PopupCloseEvent(LeafletMap source, boolean fromClient,
      @EventData("event.detail.target.options.uuid") String layerId) {
    super(source, fromClient, layerId, PopupEventType.popupclose, null);
  }

}
