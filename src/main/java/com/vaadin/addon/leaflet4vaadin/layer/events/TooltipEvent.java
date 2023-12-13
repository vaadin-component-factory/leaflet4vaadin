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
import com.vaadin.addon.leaflet4vaadin.layer.events.types.TooltipEventType;
import com.vaadin.addon.leaflet4vaadin.layer.ui.tooltip.Tooltip;

public abstract class TooltipEvent extends LeafletEvent {

  private static final long serialVersionUID = -2605670162913154205L;
  private Tooltip tooltip;

  public TooltipEvent(LeafletMap source, boolean fromClient, String layerId,
      TooltipEventType eventType, Tooltip tooltip) {
    super(source, fromClient, layerId, eventType);
    this.tooltip = tooltip;
  }

  /**
   * @return the tooltip
   */
  public Tooltip getTooltip() {
    return tooltip;
  }

  @Override
  public String toString() {
    return "TooltipEvent [type=" + super.getType() + ", tooltip=" + tooltip + "]";
  }

}
