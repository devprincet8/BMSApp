package com.soarmorrow.bms.view.splash

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders

import com.soarmorrow.bms.R
import com.soarmorrow.bms.base.BaseFragment
import com.soarmorrow.bms.constants.AppUserStatus
import com.soarmorrow.bms.view.home.HomeActivity
import com.soarmorrow.bms.view.intro_screen.IntroActivity
import com.soarmorrow.bms.view.home.HomeMenuDetailsActivity
import com.soarmorrow.bms.view.login.LoginActivity


class SplashFragment : BaseFragment(), SplashNavigator {
    private lateinit var model: SplashViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_splash, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        model = ViewModelProviders.of(this).get(SplashViewModel::class.java)
        val nameObserver = Observer<Int> { status ->
            decideNextActivity(status)
        }
        model.loginStatus.observe(this, nameObserver)
        model.startTimer(dataManager)
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            SplashFragment().apply {
                arguments = Bundle().apply {
                }
            }
    }

    private fun decideNextActivity(status: Int) {
        when (status) {
            AppUserStatus.FIRST_INSTALL.ordinal -> moveToActivity(IntroActivity.newIntent(context))
            AppUserStatus.LOGGED_IN_MODE.ordinal -> moveToActivity(HomeActivity.newIntent(context))
            AppUserStatus.LOGGED_OUT_MODE.ordinal -> moveToActivity(LoginActivity.newIntent(context))
        }
        activity?.finish()
    }

    override fun openLoginActivity() {
    }

    override fun openIntroActivity() {
        moveToActivity(IntroActivity.newIntent(context))
    }

    override fun openMainActivity() {

    }
}
