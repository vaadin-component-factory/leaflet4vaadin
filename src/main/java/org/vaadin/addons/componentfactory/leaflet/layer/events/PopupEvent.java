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

package org.vaadin.addons.componentfactory.leaflet.layer.events;

import org.vaadin.addons.componentfactory.leaflet.LeafletMap;
import org.vaadin.addons.componentfactory.leaflet.layer.events.types.PopupEventType;
import org.vaadin.addons.componentfactory.leaflet.layer.ui.popup.Popup;

public abstract class PopupEvent extends LeafletEvent {

  private static final long serialVersionUID = 4647459118161849579L;
  private Popup popup;

  public PopupEvent(LeafletMap source, boolean fromClient, String layerId, PopupEventType eventType,
      Popup popup) {
    super(source, fromClient, layerId, eventType);
    this.popup = popup;
  }

  /**
   * @return the popup
   */
  public Popup getPopup() {
    return popup;
  }

  @Override
  public String toString() {
    return "PopupEvent [type=" + super.getType() + ", popup=" + popup + "]";
  }

}
