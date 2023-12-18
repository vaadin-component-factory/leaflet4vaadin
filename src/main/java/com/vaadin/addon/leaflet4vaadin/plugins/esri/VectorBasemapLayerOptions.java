package com.vaadin.addon.leaflet4vaadin.plugins.esri;

import java.io.Serializable;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class VectorBasemapLayerOptions implements Serializable {

  private static final long serialVersionUID = 1L;

  @NonNull
  private String apiKey;
  private String token;
  private String version;
  private String language;
  private String worldview;
  private String places;

}
