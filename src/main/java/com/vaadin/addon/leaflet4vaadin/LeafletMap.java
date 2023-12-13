// Copyright 2020 Gabor Kokeny and contributors
// 
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
// 
//     http://www.apache.org/licenses/LICENSE-2.0
// 
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package com.vaadin.addon.leaflet4vaadin;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vaadin.addon.leaflet4vaadin.controls.LeafletControl;
import com.vaadin.addon.leaflet4vaadin.layer.Identifiable;
import com.vaadin.addon.leaflet4vaadin.layer.Layer;
import com.vaadin.addon.leaflet4vaadin.layer.events.BaseLayerChangeEvent;
import com.vaadin.addon.leaflet4vaadin.layer.events.DragEndEvent;
import com.vaadin.addon.leaflet4vaadin.layer.events.DragEvent;
import com.vaadin.addon.leaflet4vaadin.layer.events.ErrorEvent;
import com.vaadin.addon.leaflet4vaadin.layer.events.KeyDownEvent;
import com.vaadin.addon.leaflet4vaadin.layer.events.KeyPressEvent;
import com.vaadin.addon.leaflet4vaadin.layer.events.KeyUpEvent;
import com.vaadin.addon.leaflet4vaadin.layer.events.LayerAddEvent;
import com.vaadin.addon.leaflet4vaadin.layer.events.LayerRemoveEvent;
import com.vaadin.addon.leaflet4vaadin.layer.events.LeafletEvent;
import com.vaadin.addon.leaflet4vaadin.layer.events.LeafletEventListener;
import com.vaadin.addon.leaflet4vaadin.layer.events.LoadEvent;
import com.vaadin.addon.leaflet4vaadin.layer.events.LocationEvent;
import com.vaadin.addon.leaflet4vaadin.layer.events.MouseClickEvent;
import com.vaadin.addon.leaflet4vaadin.layer.events.MouseContextMenuEvent;
import com.vaadin.addon.leaflet4vaadin.layer.events.MouseDoubleClickEvent;
import com.vaadin.addon.leaflet4vaadin.layer.events.MouseDownEvent;
import com.vaadin.addon.leaflet4vaadin.layer.events.MouseMoveEvent;
import com.vaadin.addon.leaflet4vaadin.layer.events.MouseOutEvent;
import com.vaadin.addon.leaflet4vaadin.layer.events.MouseOverEvent;
import com.vaadin.addon.leaflet4vaadin.layer.events.MousePreClickEvent;
import com.vaadin.addon.leaflet4vaadin.layer.events.MouseUpEvent;
import com.vaadin.addon.leaflet4vaadin.layer.events.MoveEndEvent;
import com.vaadin.addon.leaflet4vaadin.layer.events.MoveStartEvent;
import com.vaadin.addon.leaflet4vaadin.layer.events.OverlayAddEvent;
import com.vaadin.addon.leaflet4vaadin.layer.events.OverlayRemoveEvent;
import com.vaadin.addon.leaflet4vaadin.layer.events.PopupCloseEvent;
import com.vaadin.addon.leaflet4vaadin.layer.events.PopupOpenEvent;
import com.vaadin.addon.leaflet4vaadin.layer.events.ResizeEvent;
import com.vaadin.addon.leaflet4vaadin.layer.events.TileErrorEvent;
import com.vaadin.addon.leaflet4vaadin.layer.events.TileLoadEvent;
import com.vaadin.addon.leaflet4vaadin.layer.events.TileLoadStartEvent;
import com.vaadin.addon.leaflet4vaadin.layer.events.TileUnloadEvent;
import com.vaadin.addon.leaflet4vaadin.layer.events.TooltipCloseEvent;
import com.vaadin.addon.leaflet4vaadin.layer.events.TooltipOpenEvent;
import com.vaadin.addon.leaflet4vaadin.layer.events.UnloadEvent;
import com.vaadin.addon.leaflet4vaadin.layer.events.ViewResetEvent;
import com.vaadin.addon.leaflet4vaadin.layer.events.ZoomAnimEvent;
import com.vaadin.addon.leaflet4vaadin.layer.events.ZoomEndEvent;
import com.vaadin.addon.leaflet4vaadin.layer.events.ZoomEvent;
import com.vaadin.addon.leaflet4vaadin.layer.events.ZoomLevelsChangeEvent;
import com.vaadin.addon.leaflet4vaadin.layer.events.ZoomStartEvent;
import com.vaadin.addon.leaflet4vaadin.layer.events.supports.SupportsKeyboardEvents;
import com.vaadin.addon.leaflet4vaadin.layer.events.supports.SupportsLayerEvents;
import com.vaadin.addon.leaflet4vaadin.layer.events.supports.SupportsLocationEvents;
import com.vaadin.addon.leaflet4vaadin.layer.events.supports.SupportsMapEvents;
import com.vaadin.addon.leaflet4vaadin.layer.events.supports.SupportsMouseEvents;
import com.vaadin.addon.leaflet4vaadin.layer.events.types.LeafletEventType;
import com.vaadin.addon.leaflet4vaadin.layer.groups.LayerGroup;
import com.vaadin.addon.leaflet4vaadin.layer.map.functions.GeolocationFunctions;
import com.vaadin.addon.leaflet4vaadin.layer.map.functions.MapConversionFunctions;
import com.vaadin.addon.leaflet4vaadin.layer.map.functions.MapGetStateFunctions;
import com.vaadin.addon.leaflet4vaadin.layer.map.functions.MapModifyStateFunctions;
import com.vaadin.addon.leaflet4vaadin.layer.map.options.DefaultMapOptions;
import com.vaadin.addon.leaflet4vaadin.layer.map.options.MapOptions;
import com.vaadin.addon.leaflet4vaadin.layer.raster.TileLayer;
import com.vaadin.addon.leaflet4vaadin.operations.LeafletOperation;
import com.vaadin.flow.component.AttachEvent;
import com.vaadin.flow.component.ClientCallable;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.ComponentEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.ComponentUtil;
import com.vaadin.flow.component.HasSize;
import com.vaadin.flow.component.HasStyle;
import com.vaadin.flow.component.HasTheme;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.dependency.NpmPackage;
import com.vaadin.flow.component.page.PendingJavaScriptResult;
import com.vaadin.flow.component.page.PendingJavaScriptResult.JavaScriptException;
import com.vaadin.flow.internal.JsonSerializer;
import com.vaadin.flow.shared.Registration;
import elemental.json.Json;
import elemental.json.JsonArray;
import elemental.json.JsonObject;
import elemental.json.JsonType;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Tag("leaflet-map")
@NpmPackage(value = "leaflet", version = "1.9.4")
@JsModule("./leaflet-map.js")
@JsModule("leaflet/dist/leaflet-src.js")
@CssImport(value = "leaflet/dist/leaflet.css", themeFor = "leaflet-map")
@CssImport(value = "./styles/leaflet-lumo-theme.css", themeFor = "leaflet-map")
public final class LeafletMap extends Component implements MapModifyStateFunctions, MapGetStateFunctions, GeolocationFunctions, MapConversionFunctions, SupportsMouseEvents,
        SupportsMapEvents, SupportsLocationEvents, SupportsKeyboardEvents, SupportsLayerEvents, HasSize, HasTheme, HasStyle {

    private static final long serialVersionUID = 3789693345308589828L;

    private final Logger logger = LoggerFactory.getLogger(LeafletMap.class);

    private static class MapLayer extends LayerGroup {
        private static final long serialVersionUID = -3205153902141978918L;
    }

    private final MapLayer mapLayer = new MapLayer();

    private boolean ready = false;

    private Class<? extends MapOptions> optionsClass;
    
    private List<LeafletEventType> events = new ArrayList<>(); 
    
    private List<Class<? extends LeafletEvent>> eventsClasses =
        Arrays.asList(BaseLayerChangeEvent.class, DragEndEvent.class, DragEvent.class,
            ErrorEvent.class, KeyDownEvent.class, KeyPressEvent.class, KeyUpEvent.class,
            LayerAddEvent.class, LayerRemoveEvent.class, LoadEvent.class, LocationEvent.class,
            MouseClickEvent.class, MouseContextMenuEvent.class, MouseDoubleClickEvent.class,
            MouseDownEvent.class, MouseMoveEvent.class, MouseOutEvent.class, MouseOverEvent.class,
            MousePreClickEvent.class, MouseUpEvent.class, MoveEndEvent.class, MoveStartEvent.class,
            OverlayAddEvent.class, OverlayRemoveEvent.class, PopupCloseEvent.class,
            PopupOpenEvent.class, ResizeEvent.class, TileErrorEvent.class, TileLoadEvent.class,
            TileUnloadEvent.class, TileLoadStartEvent.class, TooltipCloseEvent.class,
            TooltipOpenEvent.class, UnloadEvent.class, ViewResetEvent.class, ZoomAnimEvent.class,
            ZoomEndEvent.class, ZoomEvent.class, ZoomLevelsChangeEvent.class, ZoomStartEvent.class);

    public LeafletMap() {
        this(new DefaultMapOptions());
    }

    public LeafletMap(MapOptions mapOptions) {
        setId("template");
        optionsClass = mapOptions.getClass();
        getModel().setMapOptions(mapOptions);
        setSizeFull();
        registerListeners();
    }  
    
    private LeafletModel getModel() {
        return new LeafletModel() {

            ObjectMapper objectMapper = new ObjectMapper();            
                        
            @Override
            public MapOptions getMapOptions() {
                try {
                    String mapOptionsString = getElement().getProperty("mapOptions");
                    objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
                    return objectMapper.readValue(mapOptionsString, optionsClass);
                } catch (JsonProcessingException e) {
                    logger.error("Error retrieving map options", e);
                    return null;
                }
            }

            @Override
            public void setMapOptions(MapOptions mapOptions) {
                try {                    
                    getElement().setProperty("mapOptions", objectMapper.writeValueAsString(mapOptions));
                } catch (JsonProcessingException e) {
                    logger.error("Error serializing map options", e);
                }
            }
            
            @Override
            public List<LeafletEventType> getEvents() {
                return events;
            }            
        };
    }
    
    private void registerListeners() {
      eventsClasses.forEach(c -> {
        addListener(c, e -> {
          Layer layer = findLayer(e.getLayerId());
          this.fireEvent(layer, e);
        });
      });
    }
    
    @Override
    protected void onAttach(AttachEvent attachEvent) {
      super.onAttach(attachEvent);
        // set events to leaflet 
        JsonArray jsonArray = Json.createArray();
        for (int i = 0; i < events.size(); i++) {
          JsonObject js = Json.createObject();
          js.put("leafletEvent", events.get(i).name());
          jsonArray.set(i, js);
        }   
        this.getElement().setPropertyJson("events", jsonArray);        
    }

    /**
     * Fires the given leaflet event
     * 
     * @param layerId
     *            the layer where the event occurred
     * @param eventType
     *            the event object to be propagate
     * @see LeafletEvent
     */
    private void fireEvent(Layer layer, LeafletEvent event) {
        logger.info("Leaflet event fired on client side: {}", event.getType());
        logger.info("Event data: {}", event);
        layer.fireEvent(event);
    }

    /**
     * Returns the layer with the given internal ID.
     * 
     * @param layerId
     *            the id of the layer to be looking for
     * @return the layer with the given internal ID
     */
    public Layer getLayer(String layerId) {
        return this.mapLayer.getLayer(layerId).orElse(this.mapLayer);
    }

    public Layer findLayer(String layerId) {
        return this.mapLayer.findLayer(layerId).orElse(this.mapLayer);
    }

    /**
     * Adds the given layer to the map
     * 
     * @param layer
     *            the layer to add
     */
    public void addLayer(Layer layer) {
        logger.debug("add layer: {}", layer);
        this.mapLayer.addLayer(layer);
        executeJs("addLayer", layer);
    }

    /**
     * Removes the given layer from the map.
     * 
     * @param layer
     *            the layer to remove
     */
    public void removeLayer(Layer layer) {
        logger.debug("remove layer: {}", layer.getUuid());
        this.mapLayer.removeLayer(layer);
        executeJs("removeLayer", layer);
    }

    public void setBaseUrl(String baseUrl) {
        addLayer(new TileLayer(baseUrl));
    }

    /**
     * Adds the given control to the map
     * 
     * @param leafletControl
     *            the control to add
     */
    public void addControl(LeafletControl leafletControl) {
        executeJs("addControl", leafletControl);
    }

    /**
     * Removes the given control from the map
     * 
     * @param leafletControl
     *            the control to remove
     */
    public void removeControl(LeafletControl leafletControl) {
        executeJs("removeControl", leafletControl);
    }

    /**
     * Fired when the map gets initialized with a view (center and zoom) and at
     * least one layer, or immediately if it's already initialized.
     * 
     * @param listener
     *            the listener to call when the event occurs, not {@code null}
     * @return a handle that can be used for removing the listener
     */
    public Registration whenReady(ComponentEventListener<MapReadyEvent> listener) {
        return ComponentUtil.addListener(this, MapReadyEvent.class, listener);
    }

    /**
     * Fired when the map gets initialized on client side
     */
    @ClientCallable
    private void onMapReadyEventHandler() {
        logger.info("Leaflet map gets initialized on client side.");
        this.ready = true;
        fireEvent(new MapReadyEvent(this));
    }

    /**
     * Adds theme variants to the map component.
     *
     * @param variants
     *            theme variants to add
     */
    public void addThemeVariants(LeafletMapVariant... variants) {
        getThemeNames().addAll(Stream.of(variants).map(LeafletMapVariant::getVariantName).collect(Collectors.toList()));
    }

    @Override
    public void executeJs(Identifiable target, String functionName, Serializable... arguments) {
        logger.info("Execute leaflet function: {}", functionName);
        LeafletOperation leafletOperation = new LeafletOperation(target, functionName, arguments);
        getElement().callJsFunction("callLeafletFunction", JsonSerializer.toJson(leafletOperation));
    }

    @Override
    public <T extends Serializable> CompletableFuture<T> call(Identifiable target, String functionName, Class<T> resultType, Serializable... arguments) {
        if (ready) {
            logger.info("Call leaflet function: {}", functionName);
            LeafletOperation leafletOperation = new LeafletOperation(target, functionName, arguments);
            PendingJavaScriptResult javascriptResult = getElement().callJsFunction("callLeafletFunction", JsonSerializer.toJson(leafletOperation));

            CompletableFuture<T> completableFuture = new CompletableFuture<>();
            javascriptResult.then(value -> {
                try {
                    ObjectMapper objectMapper = new ObjectMapper();
                    T result;
                    // Detect object type for value to be handled correctly (ex: getZoom)
                    JsonType type = value.getType();
                    if (type.equals(JsonType.OBJECT)) {
                        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
                        result = objectMapper.readValue(value.toString(), resultType);
                    }
                    else {
                        result = objectMapper.readValue(value.asString(), resultType);
                    }
                    completableFuture.complete(result);
                } catch (IOException e) {
                    throw new RuntimeException("Failed to parse javascript result", e);
                }
            }, errorValue -> {
                JavaScriptException exception = new JavaScriptException(errorValue);
                completableFuture.completeExceptionally(exception);
            });
            return completableFuture;
        } else {
            return null;
        }
    }

    @Override
    public <T extends LeafletEvent> void addEventListener(LeafletEventType eventType, LeafletEventListener<T> listener) {
        this.mapLayer.addEventListener(eventType, listener);
        this.getModel().getEvents().add(eventType);
    }

    @Override
    public String getUuid() {
        return getModel().getMapOptions().getUuid();
    }

    @Override
    public void removeEventListener(LeafletEventType eventType) {
        this.mapLayer.removeEventListener(eventType);
        executeJs("removeEventListener", eventType.getLeafletEvent());
    }

    @Override
    public void clearAllEventListeners() {
        this.mapLayer.clearAllEventListeners();
        executeJs("clearAllEventListeners");
    }

    @Override
    public boolean hasEventListeners(LeafletEventType eventType) {
        return this.mapLayer.hasEventListeners(eventType);
    }

    /**
     * @return the ready
     */
    public boolean isReady() {
        return ready;
    }

    /**
     * Map event which fired when map gets initialized on client side
     * 
     * @author <strong>Gabor Kokeny</strong> Email:
     *         <a href='mailto=kokeny19@gmail.com'>kokeny19@gmail.com</a>
     * @since 2020-03-16
     * @version 1.0
     */
    public static final class MapReadyEvent extends ComponentEvent<LeafletMap> {

        private static final long serialVersionUID = 412791990495078838L;

        public MapReadyEvent(LeafletMap source) {
            super(source, true);
        }

    }
}