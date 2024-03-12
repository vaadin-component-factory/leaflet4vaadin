package org.vaadin.addons.componentfactory.leaflet.plugins.markercluster;

import java.util.Collections;
import java.util.List;
import org.vaadin.addons.componentfactory.leaflet.layer.events.LeafletEvent;
import org.vaadin.addons.componentfactory.leaflet.layer.events.LeafletEventListener;
import org.vaadin.addons.componentfactory.leaflet.layer.groups.FeatureGroup;
import org.vaadin.addons.componentfactory.leaflet.layer.vectors.PathOptions;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.dependency.NpmPackage;

/**
 * <h2>Leaflet.markercluster</h2>
 * 
 * Web component: <a href=
 * "https://www.npmjs.com/package/leaflet.markercluster">https://www.npmjs.com/package/leaflet.markercluster</a><br>
 * <br>
 * 
 * Provides Beautiful Animated Marker Clustering functionality for
 * LeafletMap.<br>
 * <br>
 * 
 * 
 * @author <strong>Gabor Kokeny</strong> Email:
 *         <a href='mailto=kokeny19@gmail.com'>kokeny19@gmail.com</a>
 * @since 2020-05-26
 * @version 1.0
 */
@NpmPackage(value = "leaflet.markercluster", version = "1.5.3")
@JsModule("leaflet.markercluster/dist/leaflet.markercluster-src.js")
@CssImport(value = "leaflet.markercluster/dist/MarkerCluster.css", themeFor = "leaflet-map")
@CssImport(value = "leaflet.markercluster/dist/MarkerCluster.Default.css", themeFor = "leaflet-map")
public class MarkerClusterGroup extends FeatureGroup {

    private static final long serialVersionUID = -5115086977059013434L;
    
    @JsonIgnore
    private final MarkerClusterOptions options;

    public MarkerClusterGroup() {
        this(new MarkerClusterOptions());
    }

    public MarkerClusterGroup(MarkerClusterOptions options) {
        super();
        this.options = options;
        setPane(options.getClusterPane());
    }

    public MarkerClusterOptions getOptions() {
        return options;
    }

    /**
     * Fired when the user clicks (or taps) the marker cluster
     * 
     * @param listener
     *            the listener to call when the event occurs, not {@code null}
     */
    public void onClusterClick(LeafletEventListener<LeafletEvent> listener) {
        on(MarkerClusterEventType.clusterclick, listener);
    }
    
    /**
     * Fired when the mouse enters the marker cluster
     * 
     * @param listener
     *            the listener to call when the event occurs, not {@code null}
     */
    public void onClusterMouseOver(LeafletEventListener<LeafletEvent> listener) {
        on(MarkerClusterEventType.clustermouseover, listener);
    }
    
    /**
     * Fired when the mouse leaves the marker cluster
     * 
     * @param listener
     *            the listener to call when the event occurs, not {@code null}
     */
    public void onClusterMouseOut(LeafletEventListener<LeafletEvent> listener) {
        on(MarkerClusterEventType.clustermouseout, listener);
    }

    /**
     * Fires when marker clustering/unclustering animation has completed
     * 
     * @param listener
     *            the listener to call when the event occurs, not {@code null}
     */
    public void onAnimationEnd(LeafletEventListener<LeafletEvent> listener) {
        on(MarkerClusterEventType.animationend, listener);
    }
    

    /**
     * Fires when overlapping markers get spiderified (Contains cluster and markers attributes)
     * 
     * @param listener
     *            the listener to call when the event occurs, not {@code null}
     */
    public void onSpiderfied(LeafletEventListener<LeafletEvent> listener) {
        on(MarkerClusterEventType.spiderfied, listener);
    }
    
    /**
     * Fires when overlapping markers get unspiderified (Contains cluster and markers attributes)
     * 
     * @param listener
     *            the listener to call when the event occurs, not {@code null}
     */
    public void onUnspiderfied(LeafletEventListener<LeafletEvent> listener) {
        on(MarkerClusterEventType.unspiderfied, listener);
    }
    
    @Override
    public List<String> getConstructorArgumentNames() {
        return Collections.emptyList();
    }
    
    @Override
    public String getPane() {
        return getClusterPane();
    }

    public int getMaxClusterRadius() {
        return options.getMaxClusterRadius();
    }

    public String getClusterPane() {
        return options.getClusterPane();
    }

    public boolean isSpiderfyOnMaxZoom() {
        return options.isSpiderfyOnMaxZoom();
    }

    public boolean isShowCoverageOnHover() {
        return options.isShowCoverageOnHover();
    }

    public boolean isZoomToBoundsOnClick() {
        return options.isZoomToBoundsOnClick();
    }

    public boolean isSingleMarkerMode() {
        return options.isSingleMarkerMode();
    }

    public Integer getDisableClusteringAtZoom() {
        return options.getDisableClusteringAtZoom();
    }

    public boolean isRemoveOutsideVisibleBounds() {
        return options.isRemoveOutsideVisibleBounds();
    }

    public boolean isAnimate() {
        return options.isAnimate();
    }

    public boolean isAnimateAddingMarkers() {
        return options.isAnimateAddingMarkers();
    }

    public double getSpiderfyDistanceMultiplier() {
        return options.getSpiderfyDistanceMultiplier();
    }

    public PathOptions getSpiderLegPolylineOptions() {
        return options.getSpiderLegPolylineOptions();
    }

    public boolean isChunkedLoading() {
        return options.isChunkedLoading();
    }

    public int getChunkInterval() {
        return options.getChunkInterval();
    }

    public int getChunkDelay() {
        return options.getChunkDelay();
    }

    public PathOptions getPolygonOptions() {
        return options.getPolygonOptions();
    }
    
}
