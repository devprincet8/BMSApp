package com.soarmorrow.bms.view.account


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.soarmorrow.bms.R
import com.soarmorrow.bms.base.BaseFragment
import com.soarmorrow.bms.repository.AgentRepository
import com.soarmorrow.bms.repository.ReportRepository
import com.soarmorrow.bms.view.common_listing.CommonListAdapter
import com.soarmorrow.bms.view.common_listing.CommonListClickListener
import kotlinx.android.synthetic.main.fragment_account.*
import kotlinx.android.synthetic.main.fragment_agent_listing.*
import kotlinx.android.synthetic.main.fragment_report.*


class ReportFragment : BaseFragment(), CommonListClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_report, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loadReportList()
    }

    companion object {
        @JvmStatic
        fun newInstance(type: Int) =
            ReportFragment().apply {
                arguments = Bundle().apply {
                    putInt(REPORT_TYPE, type)
                }
            }

        private const val REPORT_TYPE = "type"
    }

    private fun loadReportList() {
        report_total_amount.text = "${getString(R.string.Rs)}1,75,567"
        val type = arguments?.getInt(REPORT_TYPE, CommonListAdapter.TYPE_REPORT_TOTAL)

        rv_report.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        val menuAdapter = CommonListAdapter(
            type!!,
            context!!,
            this
        )
        rv_report.adapter = menuAdapter
        menuAdapter.setItemList(ReportRepository.getData(type))
    }

    override fun onItemSelected(item: Any?) {
    }

}
