package com.soarmorrow.bms.view.intro_screen

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.soarmorrow.bms.R
import com.soarmorrow.bms.base.BaseActivity
import com.soarmorrow.bms.constants.FragmentConstants
import kotlinx.android.synthetic.main.activity_main.*

class IntroActivity : BaseActivity() {
    companion object {
        fun newIntent(context: Context?): Intent {
            return Intent(context, IntroActivity::class.java)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        showActionBar(false)
        loadIntroFragment()
    }
    private fun loadIntroFragment() {
        val introFragment = IntroFragment.newInstance()
        loadFragment(introFragment, R.id.container, FragmentConstants.FRAG_INTRO)
    }
}
