package com.invenium.thesilentcartographer.functionalities

import android.os.Bundle
import android.view.LayoutInflater
import com.eegeo.mapapi.EegeoApi
import com.eegeo.mapapi.MapView
import com.invenium.thesilentcartographer.databinding.FragmentReplyBinding


class ReplyFragment: BaseFragment<FragmentReplyBinding>() {
    private var m_mapView: MapView? = null

    //region BaseFragment Overrides
    override fun inflateBinding(layoutInflater: LayoutInflater): FragmentReplyBinding {
        return FragmentReplyBinding.inflate(layoutInflater)
    }

    override fun observeViewModel() {
    }
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)

            // You may wish to specify your API key as a string resource instead
            context?.let { EegeoApi.init(it, "bdca9c353d2a0d4779fc7362e8ad6492") }
            m_mapView?.onCreate(savedInstanceState)
            m_mapView?.getMapAsync { println("working") }

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
}
