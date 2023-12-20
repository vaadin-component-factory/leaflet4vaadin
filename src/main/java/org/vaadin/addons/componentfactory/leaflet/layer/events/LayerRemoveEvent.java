package org.vaadin.addons.componentfactory.leaflet.layer.events;

import com.vaadin.flow.component.DomEvent;
import com.vaadin.flow.component.EventData;
import org.vaadin.addons.componentfactory.leaflet.LeafletMap;
import org.vaadin.addons.componentfactory.leaflet.layer.events.types.LayerEventType;

@DomEvent("layerremove")
public class LayerRemoveEvent extends LayerEvent {

  private static final long serialVersionUID = 1335834304448706455L;

  public LayerRemoveEvent(LeafletMap source, boolean fromClient,
      @EventData("event.detail.target.options.uuid") String layerId) {
    super(source, fromClient, layerId, LayerEventType.layerremove, null);
  }

}
