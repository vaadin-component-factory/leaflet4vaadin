package com.vaadin.addon.leaflet4vaadin.plugins.esri;

import com.vaadin.addon.leaflet4vaadin.layer.Layer;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.dependency.NpmPackage;

@NpmPackage(value = "esri-leaflet", version = "3.0.12")
@JsModule("esri-leaflet/dist/esri-leaflet.js")
public abstract class EsriLeafletLayer extends Layer {

}
