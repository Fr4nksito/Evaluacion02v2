package com.example.evaluacion02v3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;

public class MainActivity extends AppCompatActivity {
EditText txtLLUNO,txtLLDOS,txtLLTRES;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtLLUNO= findViewById(R.id.txtLLUNO);
        txtLLDOS= findViewById(R.id.txtLLDOS);
        txtLLTRES= findViewById(R.id.txtLLTRES);



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