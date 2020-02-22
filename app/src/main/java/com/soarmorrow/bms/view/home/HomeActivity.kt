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
            val intent = Intent(context, HomeActivity::class.java)
            intent.addFlags(
                Intent.FLAG_ACTIVITY_NEW_TASK
                        or Intent.FLAG_ACTIVITY_CLEAR_TASK
            )
            return intent
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
