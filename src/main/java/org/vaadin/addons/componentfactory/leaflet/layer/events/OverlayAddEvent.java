package org.vaadin.addons.componentfactory.leaflet.layer.events;

import com.vaadin.flow.component.DomEvent;
import com.vaadin.flow.component.EventData;
import org.vaadin.addons.componentfactory.leaflet.LeafletMap;
import org.vaadin.addons.componentfactory.leaflet.controls.LayersControlEvent;
import org.vaadin.addons.componentfactory.leaflet.controls.LayersControl.LayerControlEventType;

@DomEvent("overlayadd")
public class OverlayAddEvent extends LayersControlEvent {

  private static final long serialVersionUID = 3295607427378773699L;

  public OverlayAddEvent(LeafletMap source, boolean fromClient,
      @EventData("event.detail.target.options.uuid") String layerId,
      @EventData("event.detail.name") String name) {
    super(source, fromClient, layerId, LayerControlEventType.overlayadd, name);
  }

}
