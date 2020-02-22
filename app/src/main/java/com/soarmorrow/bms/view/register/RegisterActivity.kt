package com.soarmorrow.bms.view.register

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.viewpager.widget.ViewPager
import com.shuhart.stepview.StepView
import com.soarmorrow.bms.R
import com.soarmorrow.bms.api.request.RegisterRequest
import com.soarmorrow.bms.base.BaseActivity
import com.soarmorrow.bms.constants.AppConstants.registerTitleArray
import com.soarmorrow.bms.constants.RegisterFragConst
import com.soarmorrow.bms.view.intro_screen.CompanyRegisterFragment
import com.soarmorrow.bms.view.intro_screen.ThankYouFragment
import com.soarmorrow.bms.view.intro_screen.UserRegisterFragment
import kotlinx.android.synthetic.main.activity_register.*


class RegisterActivity : BaseActivity() {
    var step = RegisterFragConst.COMPANY.ordinal

    private lateinit var registerRequest:RegisterRequest

    companion object {
        fun newIntent(context: Context?): Intent {
            return Intent(context, RegisterActivity::class.java)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.soarmorrow.bms.R.layout.activity_register)
        showActionBar(true)
        viewpager.setSwipePagingEnabled(false)
        step_view.setSteps(registerTitleArray)
        registerRequest=RegisterRequest()
        next.setOnClickListener {
            when (step) {
                RegisterFragConst.COMPANY.ordinal -> {
                    step++
                    step_view.go(step, false)
                    viewpager.currentItem = step
                }
                RegisterFragConst.USER.ordinal -> {
                    step++
                    loadSuccessFragment()
                }
                RegisterFragConst.THANKYOU.ordinal -> {
                    //todo move to home
                    finish()
                }
            }
        }
        step_view.setOnStepClickListener(StepView.OnStepClickListener {
            step = it
            step_view.go(step, false)
            viewpager.currentItem = step
        })
        setupViewPager()
    }

    private fun setupViewPager() {
        val adapter = RegisterPagerAdapter(supportFragmentManager)
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

    private fun loadSuccessFragment() {
        step_view.done(true)
        viewpager.currentItem = RegisterFragConst.THANKYOU.ordinal
        step_view.isEnabled = false
    }
    override fun onBackPressed() {
        finish()
    }
}
