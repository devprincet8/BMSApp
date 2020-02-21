package com.soarmorrow.bms.view.offer.details

import android.app.DatePickerDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.soarmorrow.bms.R
import com.soarmorrow.bms.base.BaseFragment
import com.soarmorrow.bms.util.Utils
import kotlinx.android.synthetic.main.fragment_add_offer.*
import java.util.*

class OfferAddFragment : BaseFragment() {
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
        return inflater.inflate(R.layout.fragment_add_offer, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setListeners()
    }

    private fun setListeners() {
        btn_add_offer.setOnClickListener { activity?.finish() }
        cal = Calendar.getInstance()
        et_start.setOnClickListener {
            DatePickerDialog(
                context!!,
                DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->
                    val newCalendar = Calendar.getInstance()
                    newCalendar.set(Calendar.YEAR, year)
                    newCalendar.set(Calendar.MONTH, monthOfYear)
                    newCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth)
                    et_start.setText(Utils.getFormattedDate(newCalendar))
                },
                cal.get(Calendar.YEAR),
                cal.get(Calendar.MONTH),
                cal.get(Calendar.DAY_OF_MONTH)
            ).show()
        }
        et_end.setOnClickListener {
            DatePickerDialog(
                context!!,
                DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->
                    val newCalendar = Calendar.getInstance()
                    newCalendar.set(Calendar.YEAR, year)
                    newCalendar.set(Calendar.MONTH, monthOfYear)
                    newCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth)
                    et_end.setText(Utils.getFormattedDate(newCalendar))
                },
                cal.get(Calendar.YEAR),
                cal.get(Calendar.MONTH),
                cal.get(Calendar.DAY_OF_MONTH)
            ).show()
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            OfferAddFragment().apply {
                arguments = Bundle().apply {
                }
            }

        private const val KEY_AGENT = "AgentData"
    }
}
