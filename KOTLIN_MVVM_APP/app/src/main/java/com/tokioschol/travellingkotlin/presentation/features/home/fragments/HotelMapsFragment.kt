package com.tokioschol.travellingkotlin.presentation.features.home.fragments

import android.Manifest
import android.graphics.Bitmap
import android.util.Log
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import com.bumptech.glide.Glide
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.GroundOverlayOptions
import com.google.android.gms.maps.model.LatLng
import com.google.android.material.snackbar.Snackbar
import com.tokioschol.travellingkotlin.R
import com.tokioschol.travellingkotlin.core.base.BaseFragmentDb
import com.tokioschol.travellingkotlin.core.extension.snack
import com.tokioschol.travellingkotlin.databinding.FragmentHotelMapsBinding
import com.tokioschol.travellingkotlin.domain.models.SnackbarMessage
import com.tokioschol.travellingkotlin.presentation.features.home.vm.HotelsMapsViewModel
import com.tokioschol.travellingkotlin.presentation.features.home.vm.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HotelMapsFragment : BaseFragmentDb<FragmentHotelMapsBinding, HotelsMapsViewModel>(), OnMapReadyCallback {
    val locationPermissionRequest = registerForActivityResult(ActivityResultContracts.RequestMultiplePermissions()) { permissions ->
        when {
            permissions.getOrDefault(Manifest.permission.ACCESS_FINE_LOCATION, false) -> {
                Log.e("manel", "tenemos permisos")
            }
            permissions.getOrDefault(Manifest.permission.ACCESS_COARSE_LOCATION, false) -> {
                Log.e("manel", "tenemos permisos")
            }
            else -> {
                Log.e("manel", "NOOOOOO tenemos permisos")
                snack(SnackbarMessage(R.string.error_permission_map))
                    .addCallback(object : Snackbar.Callback() {
                        override fun onDismissed(transientBottomBar: Snackbar?, event: Int) {
                            super.onDismissed(transientBottomBar, event)
                            navigateBack()
                        }
                    })
            }
        }
    }

    override val viewModel: HotelsMapsViewModel by viewModels()
    private val shareViewModel: MainViewModel by activityViewModels()
    override fun getLayout(): Int = R.layout.fragment_hotel_maps

    override fun eventListeners() {
        initPermissions()
        initMaps()
    }

    private fun initPermissions() {
        locationPermissionRequest.launch(arrayOf(
            Manifest.permission.ACCESS_FINE_LOCATION,
            Manifest.permission.ACCESS_COARSE_LOCATION))
    }

    private fun initMaps() {
        (childFragmentManager.findFragmentById(R.id.map) as SupportMapFragment).getMapAsync(this)
    }

    override fun onMapReady(map: GoogleMap) {
        shareViewModel.latLongMapHotel.observe(viewLifecycleOwner) { latLong ->
            Log.e("manel", "entramos en el mapa")
            map.addMarker(latLong.second)
            map.moveCamera(CameraUpdateFactory.newLatLngZoom(latLong.first, 18f))
        }
    }
}