package com.invenium.thesilentcartographer.functionalities

import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import com.eegeo.mapapi.EegeoApi
import com.eegeo.mapapi.EegeoMap
import com.eegeo.mapapi.MapView
import com.eegeo.mapapi.services.mapscene.MapsceneRequestOptions
import com.eegeo.mapapi.services.mapscene.MapsceneRequestResponse
import com.eegeo.mapapi.services.mapscene.OnMapsceneRequestCompletedListener
import com.invenium.thesilentcartographer.R
import com.invenium.thesilentcartographer.databinding.FragmentReplyBinding


class ReplyFragment: BaseFragment<FragmentReplyBinding>(), OnMapsceneRequestCompletedListener {
    private var m_mapView: MapView? = null
    private var m_eegeoMap: EegeoMap? = null

    //region BaseFragment Overrides
    override fun inflateBinding(layoutInflater: LayoutInflater): FragmentReplyBinding {
        return FragmentReplyBinding.inflate(layoutInflater)
    }

    override fun observeViewModel() {
    }
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setHasOptionsMenu(true)
            m_mapView?.onCreate(savedInstanceState)

        }

    override fun initViews() {
        super.initViews()

        // You may wish to specify your API key as a string resource instead
        context?.let { EegeoApi.init(it, getString(R.string.eegeo_api_key)) }
        m_mapView = binding.mapView
        val listener: ReplyFragment = this

        m_mapView!!.getMapAsync { map ->
            m_eegeoMap = map
            val mapsceneService = map.createMapsceneService()
            mapsceneService.requestMapscene(
                MapsceneRequestOptions("https://wrld.mp/63fcc9b")
                    .onMapsceneRequestCompletedListener(listener)
            )
        }
    }

    override fun onResume() {
        super.onResume()
        m_mapView?.onResume()
    }

    override fun onPause() {
        super.onPause()
        m_mapView?.onPause()
    }

    override fun onDestroy() {
        super.onDestroy()
        m_mapView?.onDestroy()
    }

    override fun onMapsceneRequestCompleted(response: MapsceneRequestResponse?) {
        if (response!!.succeeded()) {
            val message = "Mapscene '" + response!!.mapscene.name.toString() + "' loaded"
        }
    }
}


