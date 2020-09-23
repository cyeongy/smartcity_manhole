package com.example.smartcity_manhole;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;
import androidx.navigation.ui.AppBarConfiguration;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;
import com.naver.maps.geometry.LatLng;
import com.naver.maps.map.CameraUpdate;
import com.naver.maps.map.LocationTrackingMode;
import com.naver.maps.map.MapFragment;
import com.naver.maps.map.NaverMap;
import com.naver.maps.map.OnMapReadyCallback;
import com.naver.maps.map.UiSettings;
import com.naver.maps.map.overlay.Marker;
import com.naver.maps.map.overlay.Overlay;
import com.naver.maps.map.util.FusedLocationSource;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import static android.widget.Toast.LENGTH_LONG;


public class MainActivity extends AppCompatActivity implements OnMapReadyCallback {

    private AppBarConfiguration mAppBarConfiguration;

    private NaverMap mMap;
    private FusedLocationSource locationSource;
    private static final int LOCATION_PERMISSION_REQUEST_CODE = 1000;
    Marker[] coordinate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // map code
        FragmentManager fm = getSupportFragmentManager();
        MapFragment mapFragment = (MapFragment) fm.findFragmentById(R.id.map);
        if (mapFragment == null) {
            mapFragment = MapFragment.newInstance();
            fm.beginTransaction().add(R.id.map, mapFragment).commit();
        }
        mapFragment.getMapAsync(this);
//        Intent intent = getPackageManager().getLaunchIntentForPackage("org.andresoviedo.dddmodel2");
//        startActivity(intent);

        locationSource = new FusedLocationSource(this, LOCATION_PERMISSION_REQUEST_CODE);


//         Navigation-Drawer Code
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_menu_manage);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_up, R.id.nav_down)
                .build();

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    // 1 2 4 5 7 8
                    case R.id.nav_home:
                        coordinate[0].setVisible(true);
                        coordinate[1].setVisible(true);
                        coordinate[2].setVisible(true);
                        coordinate[3].setVisible(true);
                        coordinate[4].setVisible(true);
                        coordinate[5].setVisible(true);
                        coordinate[6].setVisible(true);
                        coordinate[7].setVisible(true);
                        coordinate[8].setVisible(true);
                        coordinate[9].setVisible(true);
                        coordinate[10].setVisible(true);
                        break;
                    case R.id.nav_up:
                        coordinate[0].setVisible(false);
                        coordinate[1].setVisible(true);
                        coordinate[2].setVisible(true);
                        coordinate[3].setVisible(false);
                        coordinate[4].setVisible(true);
                        coordinate[5].setVisible(true);
                        coordinate[6].setVisible(false);
                        coordinate[7].setVisible(true);
                        coordinate[8].setVisible(true);
                        coordinate[9].setVisible(false);
                        coordinate[10].setVisible(false);
                        break;
                    case R.id.nav_down:
                        coordinate[0].setVisible(true);
                        coordinate[1].setVisible(false);
                        coordinate[2].setVisible(false);
                        coordinate[3].setVisible(true);
                        coordinate[4].setVisible(false);
                        coordinate[5].setVisible(false);
                        coordinate[6].setVisible(true);
                        coordinate[7].setVisible(false);
                        coordinate[8].setVisible(false);
                        coordinate[9].setVisible(true);
                        coordinate[10].setVisible(true);
                        break;
                }
                DrawerLayout drawer = findViewById(R.id.drawer_layout);
                drawer.closeDrawer(GravityCompat.START);
                return false;
            }
        });

        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);

        drawer.addDrawerListener(actionBarDrawerToggle);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (locationSource.onRequestPermissionsResult(
                requestCode, permissions, grantResults)) {
            if (!locationSource.isActivated()) { // 권한 거부됨
                mMap.setLocationTrackingMode(LocationTrackingMode.None);
            }
            return;
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
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
    public void onMapReady(NaverMap naverMap) {

        naverMap.setLocationSource(locationSource);

        UiSettings uiSettings = naverMap.getUiSettings();
        mMap = naverMap;
        uiSettings.setCompassEnabled(true);
        uiSettings.setLocationButtonEnabled(true);


        // Add a marker in Sydney and move the camera
//        LatLng sydney = new LatLng(-34, 151);
//        Marker marker = new Marker();
//        marker.setPosition(sydney);
//        marker.setTag("sex");
//        marker.setCaptionText("is game\n kim");
//        marker.setSubCaptionText("fuck you");
//        marker.setMap(mMap);

        coordinate = new Marker[11];


        for (int i = 0; i < 11; i++)
            coordinate[i] = new Marker();

        coordinate[0].setPosition(new LatLng(35.9399272, 128.8296897));
        coordinate[1].setPosition(new LatLng(35.93986248, 128.8298438));
        coordinate[2].setPosition(new LatLng(35.93993561, 128.8294992));
        coordinate[3].setPosition(new LatLng(35.93991262, 128.8303012));
        coordinate[4].setPosition(new LatLng(35.93985609, 128.830121));
        coordinate[5].setPosition(new LatLng(35.93984988, 128.8303977));
        coordinate[6].setPosition(new LatLng(35.94048168, 128.8297282));
        coordinate[7].setPosition(new LatLng(35.94053926, 128.829833));
        coordinate[8].setPosition(new LatLng(35.94053351, 128.8300881));
        coordinate[9].setPosition(new LatLng(35.94046404, 128.8304483));
        coordinate[10].setPosition(new LatLng(35.94052718, 128.8303422));

        coordinate[0].setCaptionText("실험 맨홀");
        for (int i = 1; i < 11; i++) {
            coordinate[i].setCaptionText(i + "번 맨홀");
        }

        // 1 2 4 5 7 8
        coordinate[0].setSubCaptionText(checkUpdown(false));
        coordinate[1].setSubCaptionText(checkUpdown(true));
        coordinate[2].setSubCaptionText(checkUpdown(true));
        coordinate[3].setSubCaptionText(checkUpdown(false));
        coordinate[4].setSubCaptionText(checkUpdown(true));
        coordinate[5].setSubCaptionText(checkUpdown(true));
        coordinate[6].setSubCaptionText(checkUpdown(false));
        coordinate[7].setSubCaptionText(checkUpdown(true));
        coordinate[8].setSubCaptionText(checkUpdown(true));
        coordinate[9].setSubCaptionText(checkUpdown(false));
        coordinate[10].setSubCaptionText(checkUpdown(false));

        for (int i = 0; i < 11; i++) {
            final int temp = i;
            coordinate[i].setSubCaptionColor(Color.BLUE);
            coordinate[i].setMap(mMap);
            coordinate[i].setOnClickListener(new Overlay.OnClickListener() {
                @Override
                public boolean onClick(@NonNull Overlay overlay) {
                    Intent intent = null;
                    intent = new Intent(getApplicationContext(), InfoActivity.class);
                    intent.putExtra("number", temp);
                    startActivity(intent);
                    return false;
                }
            });
        }

        CameraUpdate cameraUpdate = CameraUpdate.scrollAndZoomTo(new LatLng(35.9399272, 128.8296897), 17.5);
        mMap.moveCamera(cameraUpdate);
    }

    public String checkUpdown(boolean sw) {
        if (sw) {
            return "우수";
        }
        return "오수";
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawers();
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Toast.makeText(this, item.getItemId(), LENGTH_LONG).show();
        return super.onOptionsItemSelected(item);
    }
}