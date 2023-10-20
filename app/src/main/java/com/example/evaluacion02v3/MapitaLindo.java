package com.example.evaluacion02v3;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;

import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.example.evaluacion02v3.databinding.ActivityMapitaLindoBinding;

public class MapitaLindo extends FragmentActivity implements OnMapReadyCallback {


    GoogleMap mMap; // Declara una variable para el objeto GoogleMap que se utiliza para interactuar con el mapa.
    ActivityMapitaLindoBinding binding; // Declara una variable para el enlace de la actividad, que se utiliza para acceder a los elementos de diseño.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMapitaLindoBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        // Infla el diseño de la actividad y configura la vista raíz.

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        // Configura el fragmento de mapa y asocia la implementación de "OnMapReadyCallback" para recibir notificaciones cuando el mapa esté listo.
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        // Método llamado cuando el mapa está listo para ser utilizado. Asigna el objeto GoogleMap a la variable mMap.

        // Obtén los datos pasados desde MainActivity
        Intent intent = getIntent();
        String latLong1 = intent.getStringExtra("latLong1");
        String latLong2 = intent.getStringExtra("latLong2");
        String latLong3 = intent.getStringExtra("latLong3");
        // Obtiene las coordenadas de latitud y longitud pasadas desde la actividad MainActivity.

        // Agrega marcadores a partir de las coordenadas de latitud y longitud
        addMarkerToMap(latLong1, "Punto 1");
        addMarkerToMap(latLong2, "Punto 2");
        addMarkerToMap(latLong3, "Punto 3");
        // Llama a un método para agregar marcadores al mapa con las coordenadas y los títulos correspondientes.
    }

    private void addMarkerToMap(String latLong, String title) {
        String[] coordinates = latLong.split(",");
        if (coordinates.length == 2) {
            double lat = Double.parseDouble(coordinates[0]);
            double lon = Double.parseDouble(coordinates[1]);
            LatLng location = new LatLng(lat, lon);
            // Divide las coordenadas de latitud y longitud y crea un objeto LatLng para la ubicación.

            mMap.addMarker(new MarkerOptions().position(location).title(title));
            // Agrega un marcador al mapa con la ubicación y el título especificados.

            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(location, 15));
            // Mueve la cámara del mapa a la ubicación del marcador y establece el nivel de zoom.
        }
    }

}
