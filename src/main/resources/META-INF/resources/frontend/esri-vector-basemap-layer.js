import * as vector from 'esri-leaflet-vector';

L.vectorBasemapLayer = function (options) {
   return vector.vectorBasemapLayer(options.url, {
        apikey: options.apiKey,
      });
};