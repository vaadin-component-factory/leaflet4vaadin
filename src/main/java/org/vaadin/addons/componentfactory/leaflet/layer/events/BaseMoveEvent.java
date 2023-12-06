package org.vaadin.addons.componentfactory.leaflet.layer.events;

import org.vaadin.addons.componentfactory.leaflet.LeafletMap;
import org.vaadin.addons.componentfactory.leaflet.layer.events.types.DragEventType;
import org.vaadin.addons.componentfactory.leaflet.types.LatLng;

public abstract class BaseMoveEvent extends LeafletEvent {

  private static final long serialVersionUID = -7059868738932322793L;
  private final LatLng oldLatLng;
  private final LatLng latLng;

  public BaseMoveEvent(LeafletMap source, boolean fromClient, String layerId,
      DragEventType eventType, LatLng oldLatLng, LatLng latLng) {
    super(source, fromClient, layerId, eventType);
    this.oldLatLng = oldLatLng;
    this.latLng = latLng;
  }

  /**
   * @return the new coordinates
   */
  public LatLng getLatLng() {
    return latLng;
  }

  /**
   * @return the old coordinates
   */
  public LatLng getOldLatLng() {
    return oldLatLng;
  }

  @Override
  public String toString() {
    return "MoveEvent [type=" + super.getType() + ",latLng=" + latLng + ", oldLatLng=" + oldLatLng
        + "]";
  }



}
