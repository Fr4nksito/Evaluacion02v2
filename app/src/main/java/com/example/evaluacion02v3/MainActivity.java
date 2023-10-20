package com.example.evaluacion02v3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;

import android.widget.EditText;


import android.Manifest;


public class MainActivity extends AppCompatActivity {
    private EditText txtLLUNO, txtLLDOS, txtLLTRES;
    private static final int REQUEST_CODE_LOCATION_PERMISSION = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtLLUNO = findViewById(R.id.txtLLUNO);
        txtLLDOS = findViewById(R.id.txtLLDOS);
        txtLLTRES = findViewById(R.id.txtLLTRES);

        // Verifica si se tienen los permisos de ubicación y solicítalos si es necesario.
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, REQUEST_CODE_LOCATION_PERMISSION);
        }
    }
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == REQUEST_CODE_LOCATION_PERMISSION) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // Permiso de ubicación concedido, ahora puedes obtener y mostrar la ubicación actual en el mapa.
            } else {
                // Permiso de ubicación denegado, puedes manejar esto de acuerdo a tus necesidades.
            }
        }
    }
    public void onMostrarEnMapaClick(View view) {
        String latLong1 = txtLLUNO.getText().toString();
        String latLong2 = txtLLDOS.getText().toString();
        String latLong3 = txtLLTRES.getText().toString();

        Intent intent = new Intent(this, MapitaLindo.class);
        intent.putExtra("latLong1", latLong1);
        intent.putExtra("latLong2", latLong2);
        intent.putExtra("latLong3", latLong3);

        startActivity(intent);
    }


}