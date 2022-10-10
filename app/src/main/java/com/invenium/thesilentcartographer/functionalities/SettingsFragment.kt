package com.invenium.thesilentcartographer.functionalities

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.invenium.thesilentcartographer.R
import com.invenium.thesilentcartographer.databinding.FragmentSettingsBinding
import kotlinx.android.synthetic.main.fragment_settings.*
import java.util.*

class SettingsFragment : Fragment() {
    private lateinit var binding: FragmentSettingsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(layoutInflater, R.layout.fragment_settings, container, false)
        binding.lifecycleOwner = viewLifecycleOwner
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeUiInteractions()
        tv_current_language.text = Locale.getDefault().displayLanguage

    }

    private fun observeUiInteractions() {
        ll_language.setOnClickListener {
            openDeviceLanguageSettings()
        }
    }

    private fun openDeviceLanguageSettings() {
        val intent = Intent(Intent.ACTION_MAIN)
        intent.setClassName("com.android.settings", "com.android.settings.LanguageSettings")
        startActivity(intent)
    }
}