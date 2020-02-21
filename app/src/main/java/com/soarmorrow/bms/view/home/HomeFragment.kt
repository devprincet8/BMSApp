package com.soarmorrow.bms.view.intro_screen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager

import com.soarmorrow.bms.R
import com.soarmorrow.bms.base.BaseFragment
import com.soarmorrow.bms.repository.HomeRepository.Companion.generateMenuData
import com.soarmorrow.bms.view.home.HomeMenuAdapter
import com.soarmorrow.bms.view.home.HomeMenuDetailsActivity
import com.soarmorrow.bms.view.home.MenuClickListener
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : BaseFragment(), MenuClickListener {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setHomeMenu()
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            HomeFragment().apply {
                arguments = Bundle().apply {
                }
            }
    }

    private fun setHomeMenu() {
        rv_menu.layoutManager = GridLayoutManager(context, 2)
        val menuAdapter = HomeMenuAdapter(context!!, this)
        rv_menu.adapter = menuAdapter
        menuAdapter.setMenuList(generateMenuData(HomeMenuAdapter.TYPE_GRID))
    }

    override fun onMenuSelected(int: Int) {
        val bundle = Bundle()
        bundle.putInt(HomeMenuDetailsActivity.MENU_ITEM, int)
        moveToActivity(HomeMenuDetailsActivity.newIntent(context, bundle))
    }

}
