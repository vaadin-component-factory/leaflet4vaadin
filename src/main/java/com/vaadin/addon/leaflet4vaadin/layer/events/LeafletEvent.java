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
import com.vaadin.addon.leaflet4vaadin.layer.events.types.LeafletEventType;
import com.vaadin.flow.component.ComponentEvent;

/**
 * The base event object. All other event objects contain these properties too.
 */
public class LeafletEvent extends ComponentEvent<LeafletMap> {

  private static final long serialVersionUID = 6704191942717631706L;

  private final String layerId;

  private final LeafletEventType type;

  public LeafletEvent(LeafletMap source, boolean fromClient, String layerId,
      LeafletEventType type) {
    super(source, fromClient);
    this.layerId = layerId;
    this.type = type;
  }

  /**
   * The object that fired the event. For propagated events, the last object in the propagation
   * chain that fired the event.
   * 
   * @return the layer id
   */
  public String getLayerId() {
    return layerId;
  }

  /**
   * The event type (e.g. 'click').
   * 
   * @return the event type
   */
  public LeafletEventType getType() {
    return type;
  }

  @Override
  public String toString() {
    return "LeafletEvent [type=" + type + "]";
  }

}
