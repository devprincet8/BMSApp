package com.soarmorrow.bms.view.home

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import com.soarmorrow.bms.base.BaseActivity
import com.soarmorrow.bms.base.BaseFragment
import com.soarmorrow.bms.constants.FragmentConstants
import com.soarmorrow.bms.repository.HomeRepository
import com.soarmorrow.bms.view.account.AccountFragment
import com.soarmorrow.bms.view.account.ReportFragment
import com.soarmorrow.bms.view.agent.details.AgentAddFragment
import com.soarmorrow.bms.view.agent.details.AgentDetailsFragment
import com.soarmorrow.bms.view.agent.listing.AgentListingFragment
import com.soarmorrow.bms.view.agent.listing.model.AgentItem
import com.soarmorrow.bms.view.booking.BookingFragment
import com.soarmorrow.bms.view.offer.details.OfferAddFragment
import com.soarmorrow.bms.view.offer.listing.OfferListingFragment
import com.soarmorrow.bms.view.profile.ProfileFragmentFragment
import com.soarmorrow.bms.view.property.details.PropertyDetailsFragment
import com.soarmorrow.bms.view.property.listing.PropertyListingFragment
import kotlinx.android.synthetic.main.activity_property_management.*
import android.widget.Toast
import androidx.core.app.ComponentActivity.ExtraData
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T


class HomeMenuDetailsActivity : BaseActivity(), BaseFragment.ItemSelectedListener,
    MenuClickListener {


    companion object {
        fun newIntent(context: Context?, bundle: Bundle): Intent {
            val intent = Intent(context, HomeMenuDetailsActivity::class.java)
            intent.putExtras(bundle)
            return intent
        }

        const val MENU_ITEM = "menuItem"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.soarmorrow.bms.R.layout.activity_property_management)
        showActionBar(true)
        setHorizontalMenu()
        // loadPropertyListFragment()
        val pos = intent.extras?.getInt(MENU_ITEM)
        if (pos != null) {
            onMenuSelected(pos)
        } else {
            onMenuSelected(0)
        }

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> finish()
        }
        return true
    }

    override fun onFragmentSelected(item: Any?, tag: String) {
        when (tag) {
            FragmentConstants.FRAG_PROPERTY_ADD -> {
                loadPropertyDetailsFragment(false)
            }
            FragmentConstants.FRAG_PROPERTY_DETAILS -> {
                loadPropertyDetailsFragment(true)
            }
            FragmentConstants.FRAG_AGENT_ADD -> {
                loadAgentAddFragment()
            }
            FragmentConstants.FRAG_AGENT_DETAILS -> {
                loadAgentDetailsFragment(item as AgentItem)
            }
            FragmentConstants.FRAG_OFFER_DETAILS -> {
                loadOfferAddFragment()
            }
            FragmentConstants.FRAG_OFFER_ADD -> {
                loadOfferAddFragment()
            }
        }

    }

    override fun onReportSelected(type: Int) {
        loadReportFragment(type)
    }

    private fun setHorizontalMenu() {
        rv_horizontal_menu.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        val menuAdapter = HomeMenuAdapter(this, this)
        rv_horizontal_menu.adapter = menuAdapter
        menuAdapter.setMenuList(HomeRepository.generateMenuData(HomeMenuAdapter.TYPE_HORIZONTAL))
    }

    override fun onMenuSelected(int: Int) {
        when (int) {
            0 -> loadPropertyListFragment()
            1 -> loadProfileFragment()
            2 -> loadAgentListFragment()
            3 -> loadBookingFragment()
            4 -> loadOfferListFragment()
            5 -> loadAccountFragment()
        }
    }

    private fun loadBookingFragment() {
        val frag =
            BookingFragment.newInstance()
        loadFragment(frag, com.soarmorrow.bms.R.id.container, FragmentConstants.FRAG_BOOKING)
    }

    private fun loadAccountFragment() {
        val frag =
            AccountFragment.newInstance()
        frag.setOnItemClickedListener(this)
        loadFragment(frag, com.soarmorrow.bms.R.id.container, FragmentConstants.FRAG_ACCOUNT)
    }

    private fun loadReportFragment(type: Int) {
        val frag =
            ReportFragment.newInstance(type)
        loadFragment(frag, com.soarmorrow.bms.R.id.container, FragmentConstants.FRAG_REPORT)
    }

    private fun loadProfileFragment() {
        val frag =
            ProfileFragmentFragment.newInstance()
        loadFragment(frag, com.soarmorrow.bms.R.id.container, FragmentConstants.FRAG_PROFILE)
    }

    private fun loadOfferListFragment() {
        val frag =
            OfferListingFragment.newInstance()
        frag.setOnItemClickedListener(this)
        loadFragment(frag, com.soarmorrow.bms.R.id.container, FragmentConstants.FRAG_OFFER_LISTING)
    }

    private fun loadOfferAddFragment() {
        val frag =
            OfferAddFragment.newInstance()
        loadFragment(frag, com.soarmorrow.bms.R.id.container, FragmentConstants.FRAG_OFFER_ADD)
    }

    private fun loadAgentAddFragment() {
        val frag =
            AgentAddFragment.newInstance()
        loadFragment(frag, com.soarmorrow.bms.R.id.container, FragmentConstants.FRAG_AGENT_ADD)
    }

    private fun loadPropertyListFragment() {
        val frag =
            PropertyListingFragment.newInstance()
        frag.setOnItemClickedListener(this)
        loadFragment(
            frag,
            com.soarmorrow.bms.R.id.container,
            FragmentConstants.FRAG_PROPERTY_LISTING
        )
    }

    private fun loadAgentListFragment() {
        val frag =
            AgentListingFragment.newInstance()
        frag.setOnItemClickedListener(this)
        loadFragment(frag, com.soarmorrow.bms.R.id.container, FragmentConstants.FRAG_AGENT_LISTING)
    }

    private fun loadPropertyDetailsFragment(isDetails: Boolean) {
        val frag =
            PropertyDetailsFragment.newInstance()
        loadFragment(
            frag,
            com.soarmorrow.bms.R.id.container,
            FragmentConstants.FRAG_PROPERTY_DETAILS
        )
    }

    private fun loadAgentDetailsFragment(item: AgentItem) {
        val frag =
            AgentDetailsFragment.newInstance(item)
        loadFragment(
            frag,
            com.soarmorrow.bms.R.id.container,
            FragmentConstants.FRAG_PROPERTY_DETAILS
        )
    }

    override fun onBackPressed() {
        finish()
    }
}
