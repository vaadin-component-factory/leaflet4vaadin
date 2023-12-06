package org.vaadin.addons.componentfactory.leaflet.plugins.fullscreen;

import org.vaadin.addons.componentfactory.leaflet.layer.events.LeafletEvent;
import org.vaadin.addons.componentfactory.leaflet.layer.events.LeafletEventListener;

public interface WithFullScreenControl {

    /**
     * Fired when map entered to full screen mode
     * 
     * @param listener
     *            the listener to call when the event occurs, not {@code null}
     */
    void onEnterFullscreen(LeafletEventListener<LeafletEvent> listener);

    /**
     * Fired when map exited from full screen mode
     * 
     * @param listener
     *            the listener to call when the event occurs, not {@code null}
     */
    void onExitFullscreen(LeafletEventListener<LeafletEvent> listener);

    void toggleFullscreen();

}
