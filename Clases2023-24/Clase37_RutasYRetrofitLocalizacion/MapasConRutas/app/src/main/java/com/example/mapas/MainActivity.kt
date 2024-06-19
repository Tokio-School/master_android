package com.example.mapas

import android.content.pm.PackageManager
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.mapas.databinding.ActivityMainBinding
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.Polyline
import com.google.android.gms.maps.model.PolylineOptions
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

import android.Manifest
import android.annotation.SuppressLint
import android.graphics.Color
import android.location.Location
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.app.ActivityCompat
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.model.MarkerOptions
import com.google.android.material.snackbar.Snackbar
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var binding: ActivityMainBinding
    private lateinit var map: GoogleMap
    private var firstPoint: LatLng? = null
    private var secondPoint: LatLng? = null
    private val apiKey = "5b3ce3597851110001cf6248cb0b6276c3764bae9b026f8aadbe7466"

    private lateinit var fusedLocationClient: FusedLocationProviderClient

    companion object {
        private const val LOCATION_PERMISSION_REQUEST_CODE = 1
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val mapFragment = supportFragmentManager.findFragmentById(R.id.fragmentMaps) as SupportMapFragment
        mapFragment.getMapAsync(this)


        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this)


        binding.bRuta.setOnClickListener {
            map.setOnMapClickListener { latLng ->
                if (firstPoint == null) {
                    firstPoint = latLng
                    map.addMarker(MarkerOptions().position(latLng).title("Start Point"))
                } else if (secondPoint == null) {
                    secondPoint = latLng
                    map.addMarker(MarkerOptions().position(latLng).title("End Point"))
                    fetchRoute()
                }
            }
        }

        binding.bLocalizacion.setOnClickListener {
            getCurrentLocation()
        }
    }

    override fun onMapReady(googleMap: GoogleMap) {
        map = googleMap
    }

    private fun fetchRoute() {
        val start = firstPoint ?: return
        val end = secondPoint ?: return

        RetrofitInstance.api.getRoute(
            "${start.longitude},${start.latitude}",
            "${end.longitude},${end.latitude}",
            apiKey = apiKey
        ).enqueue(object : Callback<RouteResponse> {
            override fun onResponse(call: Call<RouteResponse>, response: Response<RouteResponse>) {
                if (response.isSuccessful) {
                    val routeResponse = response.body()
                    Log.d("MainActivity", "Respuesta: $routeResponse")
                    routeResponse?.features?.firstOrNull()?.geometry?.coordinates?.let { coordinates ->
                        Log.d("depurando", "MainActivity: Coordenadas: $coordinates")
                        drawRouteOnMap(coordinates)
                    } ?: run {
                        Toast.makeText(this@MainActivity, "No route found", Toast.LENGTH_SHORT).show()
                    }
                } else {
                    Toast.makeText(this@MainActivity, "Failed to retrieve route", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<RouteResponse>, t: Throwable) {
                Toast.makeText(this@MainActivity, "Error: ${t.message}", Toast.LENGTH_SHORT).show()
            }
        })
    }

    private fun drawRouteOnMap(coordinates: List<List<Double>>) {
        val polylineOptions = PolylineOptions().apply {
            coordinates.forEach { coord ->
                Log.d("depurando","drawRouteOnMap: $coord")
                add(LatLng(coord[1], coord[0]))
            }
        }
        map.addPolyline(polylineOptions)
    }



    private fun getCurrentLocation() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            fusedLocationClient.lastLocation
                .addOnSuccessListener { location ->
                    location?.let {
                        val currentLatLng = LatLng(location.latitude, location.longitude)
                        map.animateCamera(CameraUpdateFactory.newLatLngZoom(currentLatLng, 15f))
                        map.addMarker(MarkerOptions().position(currentLatLng).title("My Location"))
                    } ?: run {
                        Toast.makeText(this, "Unable to get current location", Toast.LENGTH_SHORT).show()
                    }
                }
        } else {
            ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.ACCESS_FINE_LOCATION), LOCATION_PERMISSION_REQUEST_CODE)
        }
    }
}