package com.soarmorrow.bms.view.splash

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import com.soarmorrow.bms.R
import com.soarmorrow.bms.base.BaseActivity
import com.soarmorrow.bms.constants.FragmentConstants.FRAG_SPLASH
import kotlinx.android.synthetic.main.activity_main.*

class SplashActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        showActionBar(false)
        loadSplashFragment()
    }

    private fun loadSplashFragment() {
        val splashFragment = SplashFragment.newInstance()
        loadFragment(splashFragment, R.id.container, FRAG_SPLASH)
    }
}
