package com.vaadin.addon.leaflet4vaadin.plugins.esri;

import java.io.Serializable;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class VectorBasemapLayerOptions implements Serializable {

  private static final long serialVersionUID = 1L;

  private final String apiKey;
  private final String url;

}
