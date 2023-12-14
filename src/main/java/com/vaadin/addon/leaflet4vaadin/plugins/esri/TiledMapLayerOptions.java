package com.vaadin.addon.leaflet4vaadin.plugins.esri;

import java.io.Serializable;

/**
 * Options for Esri Tiled Map Layer.
 */
public class TiledMapLayerOptions implements Serializable {

  private static final long serialVersionUID = -2455564076745072074L;
  private String url;
  private double zoomOffsetAllowance = 0.1;
  private String proxy;
  private boolean useCors = true;
  private String token;

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public Double getZoomOffsetAllowance() {
    return zoomOffsetAllowance;
  }

  public void setZoomOffsetAllowance(Double zoomOffsetAllowance) {
    this.zoomOffsetAllowance = zoomOffsetAllowance;
  }

  public String getProxy() {
    return proxy;
  }

  public void setProxy(String proxy) {
    this.proxy = proxy;
  }

  public Boolean getUseCors() {
    return useCors;
  }

  public void setUseCors(Boolean useCors) {
    this.useCors = useCors;
  }

  public String getToken() {
    return token;
  }

  public void setToken(String token) {
    this.token = token;
  }

}
