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
import com.vaadin.flow.component.DomEvent;
import com.vaadin.flow.component.EventData;

/**
 * The base event object. All other event objects contain these properties too.
 */
@DomEvent("dragend")
public class DragEndEvent extends LeafletEvent {

  private static final long serialVersionUID = -850212458361911478L;
  private final double distance;

  public DragEndEvent(LeafletMap source, boolean fromClient,
      @EventData("event.detail.target.options.uuid") String layerId,
      @EventData("event.detail.distance") double distance) {
    super(source, fromClient, layerId, DragEventType.dragend);
    this.distance = distance;
  }

  /**
   * The distance in pixels the draggable element was moved by.
   * 
   * @return the distance in pixels.
   */
  public double getDistance() {
    return distance;
  }

  @Override
  public String toString() {
    return "DragEndEvent [type=" + super.getType() + ",distance=" + distance + "]";
  }

}
