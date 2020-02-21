package com.soarmorrow.bms.base


import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.soarmorrow.bms.R
import com.soarmorrow.bms.data.DataManager
import java.util.*


open class BaseFragment : Fragment() {
    lateinit var mCallback: ItemSelectedListener
    lateinit var dataManager: DataManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dataManager = DataManager(context!!)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return TextView(activity).apply {
            setText(R.string.blank_fragment)
        }
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
            BaseFragment().apply {
            }
    }
    interface ItemSelectedListener {
        fun onFragmentSelected(item: Any?,tag:String)
        fun onReportSelected(type:Int)
    }
    fun setOnItemClickedListener(callback: ItemSelectedListener) {
        this.mCallback = callback
    }
    fun moveToActivity(intent: Intent) {
        startActivity(intent)
    }

    fun showProgress()
    {
        (activity as BaseActivity).showProgress()
    }
    fun hideProgress()
    {
        (activity as BaseActivity).hideProgress()
    }
}
