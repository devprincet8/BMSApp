package com.soarmorrow.bms.view.intro_screen

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.soarmorrow.bms.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_intro.*
import android.widget.TextView
import androidx.viewpager.widget.ViewPager
import com.soarmorrow.bms.R
import com.soarmorrow.bms.view.home.HomeMenuDetailsActivity
import com.soarmorrow.bms.view.login.LoginActivity

class IntroFragment : BaseFragment() {

    private var dots = ArrayList<TextView>(4)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewpager.adapter = CustomPagerAdapter(context!!)
        worm_dots_indicator.setViewPager(viewpager)
        addListner()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(com.soarmorrow.bms.R.layout.fragment_intro, container, false)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
    }

    override fun onDetach() {
        super.onDetach()
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            IntroFragment().apply {
                arguments = Bundle().apply {
                }
            }
    }

    private fun addListner() {
        skip.setOnClickListener {
            dataManager.setInstallStatus(false)
            moveToActivity(LoginActivity.newIntent(context))
            activity?.finish()
        }
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
                    3 -> skip.text = getString(R.string.done)
                    else -> skip.text = getString(R.string.skip)
                }
            }

        })
    }
}
