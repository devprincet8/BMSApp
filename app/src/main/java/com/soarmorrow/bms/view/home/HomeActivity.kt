package com.soarmorrow.bms.view.home

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.soarmorrow.bms.R
import com.soarmorrow.bms.base.BaseActivity
import com.soarmorrow.bms.constants.FragmentConstants
import com.soarmorrow.bms.view.intro_screen.HomeFragment

class HomeActivity : BaseActivity() {
    companion object {
        fun newIntent(context: Context?): Intent {
            return Intent(context, HomeActivity::class.java)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        showActionBar(false)
        loadHomeFragment()
    }

    private fun loadHomeFragment() {
        val homeFragment = HomeFragment.newInstance()
        loadFragment(homeFragment, R.id.container, FragmentConstants.FRAG_HOME)
    }

    override fun onBackPressed() {
        finish()
    }
}
