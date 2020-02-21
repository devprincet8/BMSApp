package com.soarmorrow.bms.view.login

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.soarmorrow.bms.R
import com.soarmorrow.bms.base.BaseActivity
import com.soarmorrow.bms.constants.FragmentConstants
import com.soarmorrow.bms.view.intro_screen.LoginFragment
import kotlinx.android.synthetic.main.activity_main.*

class LoginActivity : BaseActivity() {
    companion object {
        fun newIntent(context: Context?): Intent {
            return Intent(context, LoginActivity::class.java)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        showActionBar(false)
        loadLoginFragment()
    }
    private fun loadLoginFragment() {
        val loginFragment = LoginFragment.newInstance()
        loadFragment(loginFragment, R.id.container, FragmentConstants.FRAG_LOGIN)
    }
    override fun onBackPressed() {
        finish()
    }
}
