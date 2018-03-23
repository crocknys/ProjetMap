package fr.wcs.map;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MapStyleOptions;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.Map;

import static com.google.android.gms.maps.GoogleMap.MAP_TYPE_NONE;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(43.6014536, 1.4421452000000272), 17.0f));


        // Add a marker in Sydney and move the camera in hard way
        /*
        LatLng toulouse = new LatLng(43.6014536, 1.4421452000000272);
        mMap.addMarker(new MarkerOptions().position(toulouse).title("Wild Code School Toulouse"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(toulouse));
        */

        //Style of the map getting the Json config

        MapStyleOptions carte = MapStyleOptions.loadRawResourceStyle(this, R.raw.mapstyle);
        googleMap.setMapStyle(carte);

        //Trial of personnalised pictures



        LatLng toulouse = new LatLng(43.6014536, 1.4421452000000272);
        MarkerOptions markerOptions = new MarkerOptions().icon(BitmapDescriptorFactory.fromResource(R.drawable.poubelle));
        markerOptions.position(toulouse);
        mMap.addMarker(markerOptions);


        //Changing view button
        Button switcher = findViewById(R.id.button);

        switcher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent changeScreen = new Intent(MapsActivity.this, listView.class);
                MapsActivity.this.startActivity(changeScreen);
            }
        });
    }
}
