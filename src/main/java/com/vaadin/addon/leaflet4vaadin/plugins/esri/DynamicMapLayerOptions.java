package com.vaadin.addon.leaflet4vaadin.plugins.esri;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class DynamicMapLayerOptions implements Serializable {

  private static final long serialVersionUID = 1L;

  private final String url;
  private String format;
  private boolean transparent = true;
  private String f = "json";
  private String attribution;
  private int[] layers;
  private LayerDef[] layerDefs;
  private Double opacity;
  private String pane;
  private int zIndex;
  private String position;
  private Integer minZoom;
  private Integer maxZoom;
  private boolean disableCache = true;
  private String token;
  private String proxy;
  private boolean useCors = true;

  @AllArgsConstructor
  @Getter
  public static class LayerDef implements Serializable {

    private static final long serialVersionUID = 1L;

    private final int layer;
    private final String query;
  }

}
