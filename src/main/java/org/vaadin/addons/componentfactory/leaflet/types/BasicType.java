package org.vaadin.addons.componentfactory.leaflet.types;

import java.io.Serializable;

public interface BasicType extends Serializable {

    default String getLeafletType() {
        return getClass().getSimpleName();
    }

}
