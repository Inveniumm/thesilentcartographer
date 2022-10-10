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


class ReplyFragment: BaseFragment<FragmentReplyBinding>(){


    //region BaseFragment Overrides
    override fun inflateBinding(layoutInflater: LayoutInflater): FragmentReplyBinding {
        return FragmentReplyBinding.inflate(layoutInflater)
    }

    override fun observeViewModel() {
    }
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setHasOptionsMenu(true)

        }

    override fun initViews() {
        super.initViews()


    }


}


