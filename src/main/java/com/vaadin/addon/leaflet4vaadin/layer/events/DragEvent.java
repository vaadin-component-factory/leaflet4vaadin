// Copyright 2020 Gabor Kokeny and contributors
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
// http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package com.vaadin.addon.leaflet4vaadin.layer.events;

import com.vaadin.addon.leaflet4vaadin.LeafletMap;
import com.vaadin.addon.leaflet4vaadin.layer.events.types.DragEventType;
import com.vaadin.addon.leaflet4vaadin.types.LatLng;
import com.vaadin.flow.component.DomEvent;
import com.vaadin.flow.component.EventData;

@DomEvent("drag")
public class DragEvent extends BaseMoveEvent {

  private static final long serialVersionUID = -4474984908398448720L;

  public DragEvent(LeafletMap source, boolean fromClient,
      @EventData("event.target.options.uuid") String layerId,
      @EventData("event.latlng.lat") Double newLat, @EventData("event.latlng.lng") Double newLng,
      @EventData("event.oldLatLng.lat") double oldLat,
      @EventData("event.oldLatLng.lng") double oldLng) {
    super(source, fromClient, layerId, DragEventType.drag, new LatLng(oldLat, oldLng),
        new LatLng(newLat, newLng));
  }

  @Override
  public String toString() {
    return "DragEvent [type=" + super.getType() + ",latLng=" + getLatLng() + ", oldLatLng="
        + getOldLatLng() + "]";
  }

}
