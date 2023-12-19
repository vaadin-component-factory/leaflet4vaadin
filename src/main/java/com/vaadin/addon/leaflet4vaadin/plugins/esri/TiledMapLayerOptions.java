package com.vaadin.addon.leaflet4vaadin.plugins.esri;

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
