/*-
 * #%L
 * Leaflet
 * %%
 * Copyright (C) 2023 Vaadin Ltd
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */
 
/* 
 * This file incorporates work licensed under the Apache License, Version 2.0
 * Copyright 2020 Gabor Kokeny and contributors
 */
package org.vaadin.addons.componentfactory.leaflet.layer.events;

import org.vaadin.addons.componentfactory.leaflet.LeafletMap;
import org.vaadin.addons.componentfactory.leaflet.layer.events.types.TileEventType;
import org.vaadin.addons.componentfactory.leaflet.types.Point;

public abstract class TileEvent extends LeafletEvent {

  private static final long serialVersionUID = 3783813732147214444L;
  private final Point coords;

  public TileEvent(LeafletMap source, boolean fromClient, String layerId, TileEventType eventType,
      Point coords) {
    super(source, fromClient, layerId, eventType);
    this.coords = coords;
  }

  /**
   * Point object with the tile's x, y, and z (zoom level) coordinates.
   * 
   * @return the coords
   */
  public Point getCoords() {
    return coords;
  }

  @Override
  public String toString() {
    return "TileEvent [type=" + super.getType() + ", coords=" + coords + "]";
  }

}
