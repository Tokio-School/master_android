package com.example.mapsapi

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mapsapi.databinding.ActivityMainBinding
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var binding: ActivityMainBinding
    private lateinit var locationAdapter: LocationAdapter
    private lateinit var map: GoogleMap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recyclerView.layoutManager = LinearLayoutManager(this)

        // Inicializar mapa
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)

        // Cargar ubicaciones desde la API
        fetchLocations()
    }

    override fun onMapReady(googleMap: GoogleMap) {
        map = googleMap
    }

    private fun fetchLocations() {
        RetrofitInstance.api.getLocations().enqueue(object : Callback<GeoDbResponse> {
            override fun onResponse(call: Call<GeoDbResponse>, response: Response<GeoDbResponse>) {
                if (response.isSuccessful) {
                    val locationData = response.body()?.data ?: emptyList()
                    val locations = locationData.map { Location(it.city, it.latitude, it.longitude) }
                    locationAdapter = LocationAdapter(locations) { location ->
                        updateMapLocation(location)
                        Log.d("Location", "Selected location: $location")
                    }
                    binding.recyclerView.adapter = locationAdapter
                } else {
                    Toast.makeText(this@MainActivity, "Failed to retrieve locations", Toast.LENGTH_SHORT).show()
                    Log.d("Depurando", "Error: ${response.errorBody()}")
                    //URL generada
                    Log.d("Depurando", "URL: ${call.request().url()}")
                }
            }

            override fun onFailure(call: Call<GeoDbResponse>, t: Throwable) {
                Toast.makeText(this@MainActivity, "Error: ${t.message}", Toast.LENGTH_SHORT).show()
            }
        })
    }

    private fun updateMapLocation(location: Location) {
        val latLng = LatLng(location.latitude, location.longitude)
        map.clear()
        map.addMarker(MarkerOptions().position(latLng).title(location.name))
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, 10f))
    }
}
