package com.vaadin.addon.leaflet4vaadin.layer.events;

import com.vaadin.addon.leaflet4vaadin.LeafletMap;
import com.vaadin.addon.leaflet4vaadin.layer.events.types.MouseEventType;
import com.vaadin.addon.leaflet4vaadin.types.LatLng;
import com.vaadin.addon.leaflet4vaadin.types.Point;
import com.vaadin.flow.component.DomEvent;
import com.vaadin.flow.component.EventData;

@DomEvent("leaflet-dblclick")
public class MouseDoubleClickEvent extends MouseEvent {

  private static final long serialVersionUID = -1528322343678097859L;

  public MouseDoubleClickEvent(LeafletMap source, boolean fromClient,
      @EventData("event.detail.target.options.uuid") String layerId,
      @EventData("event.detail.latlng.lat") double latitude,
      @EventData("event.detail.latlng.lng") double longitude,
      @EventData("event.detail.layerPoint.x") int layerPointX,
      @EventData("event.detail.layerPoint.y") int layerPointY,
      @EventData("event.detail.containerPoint.x") int containerPointX,
      @EventData("event.detail.containerPoint.y") int containerPointY) {
    super(source, fromClient, layerId, MouseEventType.dblclick, new LatLng(latitude, longitude),
        Point.of(layerPointX, layerPointY), Point.of(containerPointX, containerPointY));
  }

}
