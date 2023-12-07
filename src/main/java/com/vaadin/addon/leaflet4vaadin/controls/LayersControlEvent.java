package com.vaadin.addon.leaflet4vaadin.controls;

import com.vaadin.addon.leaflet4vaadin.LeafletMap;
import com.vaadin.addon.leaflet4vaadin.controls.LayersControl.LayerControlEventType;
import com.vaadin.addon.leaflet4vaadin.layer.Layer;
import com.vaadin.addon.leaflet4vaadin.layer.events.LeafletEvent;

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
