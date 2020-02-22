package com.soarmorrow.bms.view.register

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.lifecycle.Observer
import androidx.viewpager.widget.ViewPager
import com.shuhart.stepview.StepView
import com.soarmorrow.bms.R
import com.soarmorrow.bms.api.request.RegisterRequest
import com.soarmorrow.bms.api.response.login.LoginResponse
import com.soarmorrow.bms.api.response.register.RegisterResponse
import com.soarmorrow.bms.base.BaseActivity
import com.soarmorrow.bms.constants.AppConstants.registerTitleArray
import com.soarmorrow.bms.constants.Config.SUCCESS
import com.soarmorrow.bms.constants.RegisterFragConst
import com.soarmorrow.bms.util.Utils
import com.soarmorrow.bms.view.home.HomeActivity
import com.soarmorrow.bms.view.intro_screen.CompanyRegisterFragment
import com.soarmorrow.bms.view.intro_screen.ThankYouFragment
import com.soarmorrow.bms.view.intro_screen.UserRegisterFragment
import com.soarmorrow.bms.viewmodel.RegisterViewModel
import kotlinx.android.synthetic.main.activity_register.*
import okhttp3.OkHttpClient
import org.koin.android.viewmodel.ext.android.viewModel
import retrofit2.http.HTTP


class RegisterActivity : BaseActivity() {
    val registerModel: RegisterViewModel by viewModel()
    var step = RegisterFragConst.COMPANY.ordinal
    lateinit var adapter: RegisterPagerAdapter

    private lateinit var registerRequest: RegisterRequest
    private var isCompanyRegisterSuccess = false


    companion object {
        fun newIntent(context: Context?): Intent {
            return Intent(context, RegisterActivity::class.java)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        showActionBar(true)
        viewpager.setSwipePagingEnabled(false)
        step_view.setSteps(registerTitleArray)
        registerRequest = RegisterRequest()
        next.setOnClickListener {
            when (step) {
                RegisterFragConst.COMPANY.ordinal -> {
                    isCompanyRegisterSuccess =
                        (adapter.getItem(0) as CompanyRegisterFragment).setRegisterDataToViewModel()
                    if (isCompanyRegisterSuccess) {
                        step++
                        step_view.go(step, false)
                        viewpager.currentItem = step
                    }

                }
                RegisterFragConst.USER.ordinal -> {
                    val isUserRegisterSuccess =
                        (adapter.getItem(1) as UserRegisterFragment).setRegisterDataToViewModel()
                    if (isUserRegisterSuccess) {
                        callRegisterApi()
                    }

                }
                RegisterFragConst.THANKYOU.ordinal -> {
                    //todo move to home
                    moveToActivity(HomeActivity.newIntent(this))
                }
            }
        }
        step_view.setOnStepClickListener(StepView.OnStepClickListener {
            /*if(isCompanyRegisterSuccess)
            {
                step = it
                step_view.go(step, false)
                viewpager.currentItem = step
            }
*/
        })
        setupViewPager()

        registerModel.registerResponse.observe(
            this,
            Observer(function = fun(resp: RegisterResponse) {

                resp.let {
                    if (resp.code == SUCCESS) {
                        hideProgress()
                        showMessage(resp.message?.text!!)
                        Handler().postDelayed({
                            step++
                            loadSuccessFragment()
                        }, 1000)


                    } else {
                        hideProgress()
                        showMessage(resp.message?.text!!)
                    }
                }
            })
        )
    }

    private fun setupViewPager() {
        adapter = RegisterPagerAdapter(supportFragmentManager)
        var companyRegFrag: CompanyRegisterFragment = CompanyRegisterFragment.newInstance()
        var userRegFrag: UserRegisterFragment = UserRegisterFragment.newInstance()
        var thankYouFragment: ThankYouFragment = ThankYouFragment.newInstance()

        adapter.addFragment(companyRegFrag)
        adapter.addFragment(userRegFrag)
        adapter.addFragment(thankYouFragment)
        viewpager?.adapter = adapter
        viewpager?.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {

            override fun onPageScrollStateChanged(state: Int) {
            }

            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {

            }

            override fun onPageSelected(position: Int) {
                when (position) {
                    RegisterFragConst.USER.ordinal -> next.text = getString(R.string.register)
                    RegisterFragConst.THANKYOU.ordinal -> next.text = getString(R.string.thank_you)
                    else -> next.text = getString(R.string.next)
                }
            }

        })
    }

    private fun callRegisterApi() {
        showProgress()
        registerModel.doRegister(registerModel.registerRequest)
    }

    private fun loadSuccessFragment() {
        step_view.done(true)
        viewpager.currentItem = RegisterFragConst.THANKYOU.ordinal
        step_view.isEnabled = false
    }

    override fun onBackPressed() {
        finish()
    }
}
