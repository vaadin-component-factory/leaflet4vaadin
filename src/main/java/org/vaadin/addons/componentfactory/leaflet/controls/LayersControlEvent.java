package org.vaadin.addons.componentfactory.leaflet.controls;

import org.vaadin.addons.componentfactory.leaflet.LeafletMap;
import org.vaadin.addons.componentfactory.leaflet.controls.LayersControl.LayerControlEventType;
import org.vaadin.addons.componentfactory.leaflet.layer.Layer;
import org.vaadin.addons.componentfactory.leaflet.layer.events.LeafletEvent;

public abstract class LayersControlEvent extends LeafletEvent {

    private static final long serialVersionUID = -4047072025354646461L;
    private String name;

    public LayersControlEvent(LeafletMap source, boolean fromClient, String layerId, LayerControlEventType type, String name) {
        super(source, fromClient, layerId, type);
        this.name = name;
    }

    /**
     * The name of the layer that was added or removed.
     * 
     * @return name of the layer that was added or removed.
     */
    public String getName() {
        return name;
    }

}
