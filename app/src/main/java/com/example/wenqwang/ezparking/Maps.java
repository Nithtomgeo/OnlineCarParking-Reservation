package com.example.wenqwang.ezparking;


import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class Maps extends FragmentActivity implements OnMapReadyCallback, GoogleMap.OnMarkerClickListener, GoogleApiClient.ConnectionCallbacks,
        GoogleApiClient.OnConnectionFailedListener, LocationListener {

    private GoogleMap mMap;
    GoogleApiClient mGoogleApiClient;
    LocationRequest mLocationRequest;
    Location mLastLocation;
    Location loc;
    private String TAG = "Latitude";
    public Marker m1, m2, m3;
    LatLng latLng,latLng2,latLng3,latLng4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
/*changes*/
        /*if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            checkLocationPermission();
        }*/
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        Log.v("latitude", "Latitude is ");
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
        mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);

        //Initialize Google Play Services
        /*change*/
        //if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
          /*  if (ContextCompat.checkSelfPermission(this,
                    Manifest.permission.ACCESS_FINE_LOCATION)
                    == PackageManager.PERMISSION_GRANTED) {
                buildGoogleApiClient();
                mMap.setMyLocationEnabled(true);
            }*/
        //}
        //else {
        buildGoogleApiClient();
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED || ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            mMap.setMyLocationEnabled(true);
            //  return;
        }
        //  mMap.setMyLocationEnabled(true);
        //}
    }

    @Override
    public void onConnected(@Nullable Bundle bundle) {
        mLocationRequest = new LocationRequest();
        mLocationRequest.setInterval(1000);
        mLocationRequest.setFastestInterval(1000);
        //Toast.makeText(this, "here1", Toast.LENGTH_LONG).show();
        /*changes*/
        mLocationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_FINE_LOCATION)
                == PackageManager.PERMISSION_GRANTED) {
           LocationServices.FusedLocationApi.requestLocationUpdates(mGoogleApiClient, mLocationRequest, this);
           /* LocationServices.FusedLocationApi.requestLocationUpdates(mGoogleApiClient, mLocationRequest, new LocationCallback() {
                @Override
                public void onLocationResult(LocationResult result) {
                    //DebugUtils.log("onLocationResult");
                }

                @Override
                public void onLocationAvailability(LocationAvailability locationAvailability) {
                    //DebugUtils.log("onLocationAvailability: isLocationAvailable =  " + locationAvailability.isLocationAvailable());
                }
            }, null);*/


        }

    }

    @Override
    public void onConnectionSuspended(int i) {

    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }

    @Override
    public void onLocationChanged(Location location) {

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

        }
        //location = LocationServices.FusedLocationApi.getLastLocation(mGoogleApiClient);
        mLastLocation = location;
        Marker mCurrLocationMarker = null;
        if (mCurrLocationMarker != null) {
                mCurrLocationMarker.remove();
          }

        //Place current location marker
        latLng = new LatLng(location.getLatitude(), location.getLongitude());
        latLng2 = new LatLng(location.getLatitude()-0.0005, location.getLongitude()-0.0002);
        latLng3 = new LatLng(location.getLatitude()+0.0004, location.getLongitude()-0.0003);
        latLng4 = new LatLng(location.getLatitude()-0.0002, location.getLongitude()+0.0001);
        //  Log.v(TAG, "Latitude is "+location.getLatitude());
        //  Log.d("latitude", "Longitude is "+location.getLongitude());
        MarkerOptions markerOptions = new MarkerOptions();
        markerOptions.position(latLng);
        markerOptions.title("Current Position");
        markerOptions.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_MAGENTA));
        mCurrLocationMarker = mMap.addMarker(markerOptions);

        //move map camera
        mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));
        mMap.animateCamera(CameraUpdateFactory.zoomTo(18));

        m1 = mMap.addMarker(new MarkerOptions()
                .position(latLng2)
                .anchor(0.5f, 0.5f)
                .title("Parking Spot 1")
                .snippet("")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW)));
        //mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng2));
        //mMap.animateCamera(CameraUpdateFactory.zoomTo(18));

        m2 = mMap.addMarker(new MarkerOptions()
                .position(latLng3)
                .anchor(0.5f, 0.5f)
                .title("Parking Spot 2")
                .snippet("")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW)));
        //mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng3));
        //mMap.animateCamera(CameraUpdateFactory.zoomTo(18));

        m3 = mMap.addMarker(new MarkerOptions()
                .position(latLng4)
                .anchor(0.5f, 0.5f)
                .title("Parking Spot 3")
                .snippet("")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW)));
        // mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng4));
        // mMap.animateCamera(CameraUpdateFactory.zoomTo(18));
        //stop location updates

        mMap.setOnMarkerClickListener(this);
        /*mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener(){

            @Override
            public boolean onMarkerClick(Marker marker) {
                if(marker.equals(m1.getTitle())) {
                    //registerUser();
                    finish();
                    startActivity(new Intent(String.valueOf(Booking.class)));
                }
                if(marker.equals(m2.getTitle())) {
                    //registerUser();
                    finish();
                    startActivity(new Intent(String.valueOf(Booking.class)));
                }
                if(marker.equals(m3.getTitle())) {
                    //registerUser();
                    finish();
                    startActivity(new Intent(String.valueOf(Booking.class)));
                }
                return false;
            }
        });*/
        if (mGoogleApiClient != null) {
               LocationServices.FusedLocationApi.removeLocationUpdates(mGoogleApiClient, this);
        }
    }

    protected synchronized void buildGoogleApiClient() {
        mGoogleApiClient = new GoogleApiClient.Builder(this)
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .addApi(LocationServices.API)
                .build();
        mGoogleApiClient.connect();
    }

    public static final int MY_PERMISSIONS_REQUEST_LOCATION = 99;
    public boolean checkLocationPermission(){
        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {

            // Asking user if explanation is needed
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.ACCESS_FINE_LOCATION)) {

                // Show an expanation to the user *asynchronously* -- don't block
                // this thread waiting for the user's response! After the user
                // sees the explanation, try again to request the permission.

                //Prompt the user once explanation has been shown
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                        MY_PERMISSIONS_REQUEST_LOCATION);


            } else {
                // No explanation needed, we can request the permission.
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                        MY_PERMISSIONS_REQUEST_LOCATION);
            }
            return false;
        } else {
            return true;
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        switch (requestCode) {
            case MY_PERMISSIONS_REQUEST_LOCATION: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                    // Permission was granted.
                    if (ContextCompat.checkSelfPermission(this,
                            Manifest.permission.ACCESS_FINE_LOCATION)
                            == PackageManager.PERMISSION_GRANTED) {

                        if (mGoogleApiClient == null) {
                            buildGoogleApiClient();
                        }
                        mMap.setMyLocationEnabled(true);
                    }

                } else {

                    // Permission denied, Disable the functionality that depends on this permission.
                    Toast.makeText(this, "permission denied", Toast.LENGTH_LONG).show();
                }
                return;
            }

            // other 'case' lines to check for other permissions this app might request.
            //You can add here other case statements according to your requirement.
        }
    }

    @Override
    public boolean onMarkerClick(Marker marker) {
        Intent i = null,inti = null;
        //  Toast.makeText(this,marker.getTitle().toString(),Toast.LENGTH_SHORT).show();
        Bundle bundle = new Bundle();
        float mindist;String close=null;

        if(m1.getTitle().toString().equals(marker.getTitle().toString())) {
            //registerUser();
            finish();
            i = new Intent(this,Booking.class);
          //  inti = new Intent(this,Confirmation.class);

            bundle.putString("P",m1.getTitle().toString());

                float[] distance = new float[1];
                Location.distanceBetween(Double.valueOf(latLng2.latitude),Double.valueOf(latLng2.longitude),Double.valueOf(latLng3.latitude),Double.valueOf(latLng3.longitude),distance);
                mindist = distance[0];
                close = m2.getTitle();
                Location.distanceBetween(Double.valueOf(latLng2.latitude),Double.valueOf(latLng2.longitude),Double.valueOf(latLng4.latitude),Double.valueOf(latLng4.longitude),distance);
                if(mindist>distance[0]) {
                    mindist = distance[0];
                    close = m2.getTitle();
                }
              /*  Location.distanceBetween(Double.valueOf(latLng2.latitude),Double.valueOf(latLng2.longitude),Double.valueOf(latLng3.latitude),Double.valueOf(latLng3.longitude),distance);
                if(mindist>distance[0])
                mindist = distance[0];*/



        }
        if(m2.getTitle().toString().equals(marker.getTitle().toString())) {
            //registerUser();
            finish();
            i = new Intent(this,Booking.class);
            //inti = new Intent(this,Confirmation.class);

            bundle.putString("P",m2.getTitle().toString());

            float[] distance = new float[1];
            Location.distanceBetween(Double.valueOf(latLng3.latitude),Double.valueOf(latLng3.longitude),Double.valueOf(latLng4.latitude),Double.valueOf(latLng4.longitude),distance);
            mindist = distance[0];
            close = m3.getTitle();
            Location.distanceBetween(Double.valueOf(latLng3.latitude),Double.valueOf(latLng3.longitude),Double.valueOf(latLng2.latitude),Double.valueOf(latLng2.longitude),distance);
            if(mindist>distance[0]) {
                mindist = distance[0];
                close = m1.getTitle();
            }
        }
        if(m3.getTitle().toString().equals(marker.getTitle().toString())) {
            //registerUser();
            finish();
            i = new Intent(this,Booking.class);
            //inti = new Intent(this,Confirmation.class);

            bundle.putString("P",m3.getTitle().toString());

            float[] distance = new float[1];
            Location.distanceBetween(Double.valueOf(latLng4.latitude),Double.valueOf(latLng4.longitude),Double.valueOf(latLng2.latitude),Double.valueOf(latLng2.longitude),distance);
            mindist = distance[0];
            close = m1.getTitle();
            Location.distanceBetween(Double.valueOf(latLng4.latitude),Double.valueOf(latLng4.longitude),Double.valueOf(latLng3.latitude),Double.valueOf(latLng3.longitude),distance);
            if(mindist>distance[0]) {
                mindist = distance[0];
                close = m2.getTitle();
            }

        }
        bundle.putString("closest",close);

        i.putExtras(bundle);
        //inti.putExtras(bundle);
        startActivity(i);

        return false;
    }
}
