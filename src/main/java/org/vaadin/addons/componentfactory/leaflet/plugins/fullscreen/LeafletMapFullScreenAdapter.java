package org.vaadin.addons.componentfactory.leaflet.plugins.fullscreen;

import org.vaadin.addons.componentfactory.leaflet.LeafletMap;
import org.vaadin.addons.componentfactory.leaflet.layer.events.LeafletEvent;
import org.vaadin.addons.componentfactory.leaflet.layer.events.LeafletEventListener;

class LeafletMapFullScreenAdapter implements WithFullScreenControl {

    private final LeafletMap leafletMap;

    LeafletMapFullScreenAdapter(LeafletMap leafletMap) {
        this.leafletMap = leafletMap;
    }

    @Override
    public void onEnterFullscreen(LeafletEventListener<LeafletEvent> listener) {
        leafletMap.on(FullScreenControl.FullScreenEventType.enterFullscreen, listener);
    }

    @Override
    public void onExitFullscreen(LeafletEventListener<LeafletEvent> listener) {
        leafletMap.on(FullScreenControl.FullScreenEventType.exitFullscreen, listener);
    }

    @Override
    public void toggleFullscreen() {
        leafletMap.executeJs("toggleFullscreen");
    }

}
