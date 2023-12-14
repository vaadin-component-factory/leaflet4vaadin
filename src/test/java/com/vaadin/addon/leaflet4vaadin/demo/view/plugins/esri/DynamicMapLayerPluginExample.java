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

package com.vaadin.addon.leaflet4vaadin.demo.view.plugins.esri;

import com.vaadin.addon.leaflet4vaadin.LeafletMap;
import com.vaadin.addon.leaflet4vaadin.demo.LeafletDemoApp;
import com.vaadin.addon.leaflet4vaadin.demo.components.ExampleContainer;
import com.vaadin.addon.leaflet4vaadin.layer.map.options.DefaultMapOptions;
import com.vaadin.addon.leaflet4vaadin.layer.map.options.MapOptions;
import com.vaadin.addon.leaflet4vaadin.plugins.esri.DynamicMapLayer;
import com.vaadin.addon.leaflet4vaadin.plugins.esri.DynamicMapLayerOptions;
import com.vaadin.addon.leaflet4vaadin.types.LatLng;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.Anchor;
import com.vaadin.flow.component.textfield.IntegerField;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@PageTitle("Esri Leaflet Dynamic Map Layer example")
@Route(value = "plugins/esri/dynamicmap", layout = LeafletDemoApp.class)
public class DynamicMapLayerPluginExample extends ExampleContainer {

  private static final long serialVersionUID = 7554022663956386641L;

  private static final String ESRI_URL =
      "https://sampleserver6.arcgisonline.com/arcgis/rest/services/Census/MapServer";

  private Binder<DynamicMapLayerOptions> binder;
  private DynamicMapLayer dynamicMapLayer;

  @Override
  protected void initDemo() {
    MapOptions options = new DefaultMapOptions();
    options.setCenter(new LatLng(37.71, -99.88));
    options.setZoom(4);

    LeafletMap leafletMap = new LeafletMap(options);
    leafletMap.setBaseUrl("https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png");

    DynamicMapLayerOptions dynamicMapLayerOptions = new DynamicMapLayerOptions(ESRI_URL);
    dynamicMapLayerOptions.setOpacity(0.6);
    dynamicMapLayer = new DynamicMapLayer(dynamicMapLayerOptions);
    dynamicMapLayer.addTo(leafletMap);

    Anchor pluginRepository = new Anchor();
    pluginRepository.setHref("https://developers.arcgis.com/esri-leaflet");
    pluginRepository.setText("Esri Leaflet plugin");
    pluginRepository.setTarget("_blank");

    addToContent(pluginRepository, leafletMap);

    binder = new Binder<>(DynamicMapLayerOptions.class);
    createFormControls();
    binder.setBean(new DynamicMapLayerOptions(ESRI_URL));

    // binder.addValueChangeListener((event) -> dynamicMapLayer.setOptions(binder.getBean()));
    // binder.addStatusChangeListener((event) -> dynamicMapLayer.setOptions(binder.getBean()));
  }

  private void createFormControls() {
    // Stroke control
    FormLayout form = new FormLayout();

    // the minimum opacity the heat will start at
    NumberField opacity = new NumberField();
    opacity.setHasControls(true);
    opacity.setMin(0);
    opacity.setMax(1);
    opacity.setStep(0.1);
    opacity.setWidthFull();
    opacity.setValueChangeMode(ValueChangeMode.EAGER);
    form.addFormItem(opacity, "Opacity");
    binder.forField(opacity).bind("opacity");

    // maximum point intensity,
    IntegerField minZoom = new IntegerField();
    minZoom.setHasControls(true);
    minZoom.setMin(0);
    minZoom.setMax(99);
    minZoom.setWidthFull();
    minZoom.setValueChangeMode(ValueChangeMode.EAGER);
    form.addFormItem(minZoom, "Minimum zoom");
    binder.forField(minZoom).bind("minZoom");

    // zoom level where the points reach maximum intensity
    IntegerField maxZoom = new IntegerField();
    maxZoom.setHasControls(true);
    minZoom.setMin(0);
    minZoom.setMax(99);
    maxZoom.setWidthFull();
    maxZoom.setValueChangeMode(ValueChangeMode.EAGER);
    form.addFormItem(maxZoom, "Maximum zoom");
    binder.forField(maxZoom).bind("maxZoom");

    Button reset = new Button("Reset to defaults");
    reset.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
    reset.addClickListener(event -> binder.setBean(new DynamicMapLayerOptions(ESRI_URL)));
    form.add(reset);

    Button clear = new Button("Clear the map");
    clear.addThemeVariants(ButtonVariant.LUMO_ERROR);
    form.add(clear);

    addToSidebar(form);
  }

}
