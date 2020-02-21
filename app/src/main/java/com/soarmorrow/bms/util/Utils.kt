package com.soarmorrow.bms.util

import android.view.View
import com.google.android.material.snackbar.Snackbar
import java.text.SimpleDateFormat
import java.util.*

class Utils {
    companion object {
        fun getFormattedDate(calendar: Calendar): String {
            val myFormat = "MM/dd/yyyy" // mention the format you need
            val sdf = SimpleDateFormat(myFormat, Locale.US)
            return (sdf.format(calendar.time))
        }
        fun showMessage(msg:String,view: View)
        {
            Snackbar.make(view,msg, Snackbar.LENGTH_LONG).show()
        }
    }

}