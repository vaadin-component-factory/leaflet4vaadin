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
import com.vaadin.addon.leaflet4vaadin.layer.events.types.TileEventType;
import com.vaadin.addon.leaflet4vaadin.types.Point;
import com.vaadin.flow.component.DomEvent;
import com.vaadin.flow.component.EventData;

@DomEvent("tileload")
public class TileLoadEvent extends TileEvent {

  private static final long serialVersionUID = -7210188172575877007L;

  public TileLoadEvent(LeafletMap source, boolean fromClient,
      @EventData("event.detail.target.options.uuid") String layerId,
      @EventData("event.detail.coords.x") double coordsX,
      @EventData("event.detail.coords.y") double coordsY) {
    super(source, fromClient, layerId, TileEventType.tileload, Point.of(coordsX, coordsY));
  }

}
