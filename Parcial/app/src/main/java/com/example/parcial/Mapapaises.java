package com.example.parcial;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.PolylineOptions;

public class Mapapaises extends AppCompatActivity implements OnMapReadyCallback {
     String npais, urlimagen;
     Double norte,sur,este,oeste;
     TextView nombre;

     GoogleMap mapa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mapapaises);

        npais = getIntent().getExtras().getString("pais");
        norte = Double.valueOf(getIntent().getExtras().getString("norte"));
        este = Double.valueOf(getIntent().getExtras().getString("este"));
        oeste = Double.valueOf(getIntent().getExtras().getString("oeste"));
        sur = Double.valueOf(getIntent().getExtras().getString("sur"));
        urlimagen = getIntent().getExtras().getString("urlimg");

        SupportMapFragment mapFragment = (SupportMapFragment)
                getSupportFragmentManager()
                        .findFragmentById(R.id.map);


        mapFragment.getMapAsync(this);


        nombre = (TextView)findViewById(R.id.txtNombre);
        nombre.setText(npais);
        ImageView imageView = (ImageView) findViewById(R.id.imagenpais);
        Glide.with(this)
                .load(urlimagen)
                .into(imageView);


    }

    @Override
    public void onMapReady(GoogleMap googleMap) {

        mapa = googleMap;
        mapa.getUiSettings().setZoomControlsEnabled(true);
        mapa.setMapType(GoogleMap.MAP_TYPE_NORMAL);

        CameraUpdate camUpd1 = CameraUpdateFactory.newLatLngZoom(new LatLng(norte, oeste), 4);
        mapa.moveCamera(camUpd1);

        PolylineOptions rectangulo = new PolylineOptions()
        .add(new LatLng(norte,oeste))
         .add(new LatLng(norte,este))
                .add(new LatLng(sur,este))
        .add(new LatLng(sur,oeste))
        .add(new LatLng(norte,oeste));

        rectangulo.width(10);
        rectangulo.color(Color.RED);
        mapa.addPolyline(rectangulo);
    }

}
