package com.soarmorrow.bms.view.account


import android.app.DatePickerDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.DatePicker
import androidx.core.content.ContextCompat
import com.bumptech.glide.util.Util
import com.soarmorrow.bms.R
import com.soarmorrow.bms.base.BaseFragment
import com.soarmorrow.bms.repository.AgentRepository
import com.soarmorrow.bms.repository.PropertyRepository
import com.soarmorrow.bms.util.Utils.Companion.getFormattedDate
import com.soarmorrow.bms.view.account.model.ItemTotalSales
import com.soarmorrow.bms.view.common_listing.CommonListAdapter
import kotlinx.android.synthetic.main.fragment_account.*
import kotlinx.android.synthetic.main.fragment_agent_details.*
import java.text.SimpleDateFormat
import java.util.*
import javax.xml.datatype.DatatypeConstants.MONTHS


class AccountFragment : BaseFragment() {
    private lateinit var cal: Calendar
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
        return inflater.inflate(R.layout.fragment_account, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setProgressValues()
        setListeners()
        setSpinnerData()
    }

    private fun setListeners() {
        cal = Calendar.getInstance()
        et_start_total.setOnClickListener {
            DatePickerDialog(
                context!!,
                DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->
                    val newCalendar = Calendar.getInstance()
                    newCalendar.set(Calendar.YEAR, year)
                    newCalendar.set(Calendar.MONTH, monthOfYear)
                    newCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth)
                    et_start_total.setText(getFormattedDate(newCalendar))
                },
                cal.get(Calendar.YEAR),
                cal.get(Calendar.MONTH),
                cal.get(Calendar.DAY_OF_MONTH)
            ).show()
        }
        et_end_total.setOnClickListener {
            DatePickerDialog(
                context!!,
                DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->
                    val newCalendar = Calendar.getInstance()
                    newCalendar.set(Calendar.YEAR, year)
                    newCalendar.set(Calendar.MONTH, monthOfYear)
                    newCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth)
                    et_end_total.setText(getFormattedDate(newCalendar))
                },
                cal.get(Calendar.YEAR),
                cal.get(Calendar.MONTH),
                cal.get(Calendar.DAY_OF_MONTH)
            ).show()
        }
        et_start_agent.setOnClickListener {
            DatePickerDialog(
                context!!,
                DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->
                    val newCalendar = Calendar.getInstance()
                    newCalendar.set(Calendar.YEAR, year)
                    newCalendar.set(Calendar.MONTH, monthOfYear)
                    newCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth)
                    et_start_agent.setText(getFormattedDate(newCalendar))
                },
                cal.get(Calendar.YEAR),
                cal.get(Calendar.MONTH),
                cal.get(Calendar.DAY_OF_MONTH)
            ).show()
        }
        et_end_agent.setOnClickListener {
            DatePickerDialog(
                context!!,
                DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->
                    val newCalendar = Calendar.getInstance()
                    newCalendar.set(Calendar.YEAR, year)
                    newCalendar.set(Calendar.MONTH, monthOfYear)
                    newCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth)
                    et_end_agent.setText(getFormattedDate(newCalendar))
                },
                cal.get(Calendar.YEAR),
                cal.get(Calendar.MONTH),
                cal.get(Calendar.DAY_OF_MONTH)
            ).show()
        }
        et_start_agent_commission.setOnClickListener {
            DatePickerDialog(
                context!!,
                DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->
                    val newCalendar = Calendar.getInstance()
                    newCalendar.set(Calendar.YEAR, year)
                    newCalendar.set(Calendar.MONTH, monthOfYear)
                    newCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth)
                    et_start_agent_commission.setText(getFormattedDate(newCalendar))
                },
                cal.get(Calendar.YEAR),
                cal.get(Calendar.MONTH),
                cal.get(Calendar.DAY_OF_MONTH)
            ).show()
        }
        et_end_agent_commission.setOnClickListener {
            DatePickerDialog(
                context!!,
                DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->
                    val newCalendar = Calendar.getInstance()
                    newCalendar.set(Calendar.YEAR, year)
                    newCalendar.set(Calendar.MONTH, monthOfYear)
                    newCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth)
                    et_end_agent_commission.setText(getFormattedDate(newCalendar))
                },
                cal.get(Calendar.YEAR),
                cal.get(Calendar.MONTH),
                cal.get(Calendar.DAY_OF_MONTH)
            ).show()
        }
        btn_report_total.setOnClickListener {
            mCallback.onReportSelected(CommonListAdapter.TYPE_REPORT_TOTAL)
        }
        btn_report_agent.setOnClickListener {
            mCallback.onReportSelected(CommonListAdapter.TYPE_REPORT_AGENT_WISE)
        }
        btn_report_agent_commission.setOnClickListener {
            mCallback.onReportSelected(CommonListAdapter.TYPE_REPORT_AGENT_COMMISSION)
        }

    }

    private fun setProgressValues() {
        progress_total.progress = 30f
        progress_agent.progress = 50f
        context?.let {
            progress_total.finishedStrokeColor =
                ContextCompat.getColor(it, R.color.bms_progress_red)
        }
        context?.let {
            progress_agent.finishedStrokeColor =
                ContextCompat.getColor(it, R.color.bms_progress_yellow)
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            AccountFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }

    private fun setSpinnerData() {
        val countryAdapter = ArrayAdapter<String>(
            activity!!,
            android.R.layout.simple_spinner_dropdown_item, AgentRepository.getAgentName()
        )
        sp_agent.adapter = countryAdapter

    }
}
