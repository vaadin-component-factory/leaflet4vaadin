package org.vaadin.addons.componentfactory.leaflet.plugins.esri;

import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.dependency.NpmPackage;
import org.vaadin.addons.componentfactory.leaflet.layer.Layer;

@NpmPackage(value = "esri-leaflet", version = "3.0.12")
@JsModule("esri-leaflet/dist/esri-leaflet.js")
public abstract class EsriLeafletLayer extends Layer {

}
