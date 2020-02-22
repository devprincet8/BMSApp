package com.soarmorrow.bms.util

import android.content.Context
import android.graphics.Typeface
import android.os.Build
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.google.android.material.snackbar.Snackbar
import com.soarmorrow.bms.R
import java.text.SimpleDateFormat
import java.util.*

class Utils {
    companion object {
        fun getFormattedDate(calendar: Calendar): String {
            val myFormat = "MM/dd/yyyy" // mention the format you need
            val sdf = SimpleDateFormat(myFormat, Locale.US)
            return (sdf.format(calendar.time))
        }
        fun showSnackBar(msg:String,view: View)
        {
            Snackbar.make(view,msg, Snackbar.LENGTH_LONG).show()
        }

        fun initAdapter(context: Context, spinner: Spinner, items: ArrayList<String>) {
            val spinnerArrayAdapter = object : ArrayAdapter<String>(
                context, android.R.layout.simple_spinner_dropdown_item, items
            ) {
                override fun isEnabled(position: Int): Boolean {
                    return if (position == 0) {
                        // Disable the first item from Spinner
                        // First item will be use for hint
                        true
                    } else {
                        true
                    }
                }

                override fun getDropDownView(
                    position: Int, convertView: View?,
                    parent: ViewGroup
                ): View {
                    val view = super.getDropDownView(position, convertView, parent)
                    val tv = view as TextView
                    if (position == 0) {
                        // Set the hint text color gray
                        tv.setTextColor(getColor(getContext(), R.color.hint))
                    } else {
                        tv.setTextColor(getColor(getContext(), R.color.colorPrimary))
                    }
                    return view
                }
            }
            spinnerArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinner.adapter = spinnerArrayAdapter
        }


        fun getColor(context: Context, id: Int): Int {
            val version = Build.VERSION.SDK_INT
            return if (version >= 23) {
                ContextCompat.getColor(context, id)
            } else {
                context.resources.getColor(id)
            }
        }
    }

}