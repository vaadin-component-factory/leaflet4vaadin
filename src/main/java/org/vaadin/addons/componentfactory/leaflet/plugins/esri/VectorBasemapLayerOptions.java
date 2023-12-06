package org.vaadin.addons.componentfactory.leaflet.plugins.esri;

import java.io.Serializable;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class VectorBasemapLayerOptions implements Serializable {

  private static final long serialVersionUID = 1L;

  private final String apiKey;
  private String token;
  private String version;
  private String language;
  private String worldview;
  private String places;

}
