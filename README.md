# am2_group2017_2
Curso de Aplicaciones Móviles 2 - Grupo 2017 02

## Semana 12 

- Android Runtime Permissions

	- Solicitar permisos en tiempo de ejecución

- Geolocalización y Mapas

	- Location Manager

	- Google  console API

	- Google Maps API V2

- Multimedia

	- Cámara y galería de imágenes usando intents

##

## Geolocalización y Mapas

  Google Maps API

- Configuración

   1. Crear un proyecto en Google Console API https://console.developers.google.com/

   <img src="./images/gm1.png" height="480">

   2. Agregamos el API de Google Maps Android API V2.

   <img src="./images/gm2.png" height="480">

   3. Luego creamos las credenciales para nuestro proyecto Android.

   <img src="./images/gm3.png" height="480">

   4. Agregamos una clave de API de Android y lo guardamos.
       	
   <img src="./images/gm4.png" height="480">

- Proyecto Android

   1. Agregamos la dependencia de Google Play services

	```
	dependencies {
	        compile fileTree(dir: 'libs', include: ['*.jar'])
	        compile 'com.android.support:appcompat-v7:22.2.0'
	        compile 'com.google.android.gms:play-services:6.1.71'
	}
	```

   2. Configuración del AndroidManifest

   	* Permisos requeridos

   	* Habilitar OpenGL

   	* Metadata requerida para google play services y google maps

    ```
        <permission
        android:name="com.emedinaa.am2googlemaps.permission.MAPS_RECEIVE"
        android:protectionLevel="signature" >
        </permission>
        <uses-permission android:name="com.emedinaa.am2googlemaps.permission.MAPS_RECEIVE" />
        <uses-permission android:name="android.permission.INTERNET" />
        <uses-permission android:name="android.permission.ACCESS_NETWORK_STATE" />
        <uses-permission android:name="android.permission.ACCESS_COARSE_LOCATION" />
        <uses-permission android:name="android.permission.ACCESS_FINE_LOCATION" />
        <uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE" />
    ```

    ```
        <uses-feature
        android:glEsVersion="0x00020000"
        android:required="true" />
    ```

    ```
        <meta-data
            android:name="com.google.android.gms.version"
            android:value="@integer/google_play_services_version" />
        <meta-data
            android:name="com.google.android.geo.API_KEY"
            android:value="@string/gmaps_key" />
    ```

   3. Agregar al XML del activity el fragment de Google Maps

    ```
        <fragment
        android:layout_width="fill_parent"
        android:layout_height="fill_parent"
        android:name="com.google.android.gms.maps.SupportMapFragment"
        class="com.google.android.gms.maps.SupportMapFragment"
        android:id="@+id/map"/>
    ```

   4. Iniciamos el Map en la Activity

	```
	         private void initMap() {
	        try {
	            if (map == null)
	            {
	                // above API 11
	                map = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map)).getMap();
	                map.getUiSettings().setAllGesturesEnabled(true);
	                map.setMapType(GoogleMap.MAP_TYPE_NORMAL);
	                map.setMyLocationEnabled(true);
	                map.getUiSettings().setZoomControlsEnabled(false);
	                map.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(defaultLat, defaultLng), ZOOM));
	                map.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
	                    @Override
	                    public void onMapClick(LatLng point)
	                    {
	                        selected=true;
	                        if (marker != null) {
	                            marker.remove();
	                        }
	                        marker = map.addMarker(new MarkerOptions()
	                                .position(point)
	                                .title("Mi ubicación")
	                                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));
	                        marker.showInfoWindow();
	                        userLat=point.latitude;
	                        userLng = point.longitude;
	                        Toast.makeText(MainActivity.this,"Lat & Lng "+userLat+" "+userLng,Toast.LENGTH_LONG).show();
	                    }
	                });
	            }
	        }catch (Exception e){
	            e.printStackTrace();
	        }
	    }
	```

  5. Agreguemos ubicaciones de prueba en el mapa

  - Vamos a google maps https://www.google.com.pe/maps/@-12.0936177,-77.052195,15z?hl=es

  - Escogamos una dirección. Ejemplo Isil https://www.google.com.pe/maps/place/ISIL+San+Isidro/@-12.0936177,-77.052195,15z/data=!4m5!3m4!1s0x0:0x55c71153c8c3bda4!8m2!3d-12.0935552!4d-77.052902?hl=es

  - Latitud y longitud -12.0936177,-77.052195

  - Mostremos este punto en el mapa

- Resultado

  <img src="./images/gm5.png" height="480">

## Referencias 

- Working with system permissions https://developer.android.com/training/permissions/index.html

- Google Maps API Android https://developers.google.com/maps/documentation/android-api/

- Taking photos simply https://developer.android.com/training/camera/photobasics.html

- Capturing Photos https://developer.android.com/training/camera/index.html

- Android Camera2 Basic Sample https://github.com/googlesamples/android-Camera2Basic

- Android Transitions https://github.com/googlesamples/android-ActivitySceneTransitionBasic

- Android Universal Music Player https://github.com/googlesamples/android-UniversalMusicPlayer

- Google Maps API Samples https://github.com/googlemaps/android-samples

---- Viernes 03 de Noviembre ----

