package com.example.maps_final2


import android.annotation.SuppressLint
import android.content.pm.PackageManager
import android.location.Location
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.maps_final2.databinding.ActivityMainBinding
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.model.LatLng
import com.google.android.material.snackbar.Snackbar
import android.Manifest
import android.util.Log
import androidx.activity.result.contract.ActivityResultContracts
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.google.android.gms.maps.SupportMapFragment

class MainActivity : AppCompatActivity() , OnMapReadyCallback {

    lateinit var binding: ActivityMainBinding
    private lateinit var map:GoogleMap

    private lateinit var fusedLocationClient: FusedLocationProviderClient



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        fusedLocationClient = LocationServices.getFusedLocationProviderClient(binding.root.context)


        // Queremos cargar el mapa de google en el fragment
        val mapFragment = supportFragmentManager.findFragmentById(R.id.fragmentMaps) as SupportMapFragment
        mapFragment.getMapAsync(this)


        binding.bLocalizacion.setOnClickListener {
            if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
                // Permiso ya concedido
                supportFragmentManager.findFragmentById(R.id.fragmentMaps)?.let { fragment ->
                    enableMyLocation()
                    getDeviceLocation()
                }
            } else {
                // Solicitar el permiso
                requestPermissionLauncher.launch(Manifest.permission.ACCESS_FINE_LOCATION)
            }
        }

        binding.bRuta.setOnClickListener {
            // Aquí se debería de abrir el fragmento con el mapa
        }

    }

    @SuppressLint("MissingPermission")
    private fun getDeviceLocation() {
        if (ContextCompat.checkSelfPermission(binding.root.context, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            fusedLocationClient.lastLocation.addOnSuccessListener { location: Location? ->
                location?.let {
                    //val currentLatLng = LatLng(it.latitude, it.longitude)
                    val currentLatLng = LatLng(40.4165000, -3.7025600)
                    map.animateCamera(CameraUpdateFactory.newLatLngZoom(currentLatLng, 15f))
                    Log.d("depurando", "Localización obtenida, movida la cámara al punto actual")
                } ?: run {
                    Snackbar.make(binding.bRuta, "Unable to get current location", Snackbar.LENGTH_LONG).show()
                }
            }
        }
    }

    override fun onMapReady(mapa: GoogleMap) {
        map = mapa
        //map.uiSettings.isZoomControlsEnabled = true
        enableMyLocation()
    }

    public fun enableMyLocation() {
        if (ContextCompat.checkSelfPermission(binding.root.context, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            map.isMyLocationEnabled = true
            map.uiSettings.isMyLocationButtonEnabled = true
        }
    }

    private val requestPermissionLauncher = registerForActivityResult(
        ActivityResultContracts.RequestPermission()
    ) { isGranted: Boolean ->
        if (isGranted) {
            // Permiso concedido
            supportFragmentManager.findFragmentById(R.id.fragmentMaps)?.let { fragment ->
                enableMyLocation()
            }
        } else {
            // Permiso denegado
            // Maneja la negación del permiso aquí
        }
    }
}