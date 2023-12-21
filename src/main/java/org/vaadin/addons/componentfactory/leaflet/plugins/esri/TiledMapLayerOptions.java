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
package org.vaadin.addons.componentfactory.leaflet.plugins.esri;

import java.io.Serializable;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

/**
 * Options for Esri Tiled Map Layer.
 */
@Getter
@Setter
@RequiredArgsConstructor
public class TiledMapLayerOptions implements Serializable {

  private static final long serialVersionUID = -2455564076745072074L;
  private final String url;
  private double zoomOffsetAllowance = 0.1;
  private String proxy;
  private boolean useCors = true;
  private String token;
 
}
