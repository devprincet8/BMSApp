package com.soarmorrow.bms.base

import android.os.Bundle
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import com.soarmorrow.bms.R
import com.wang.avi.AVLoadingIndicatorView


open class BaseActivity : AppCompatActivity() {

    private var avi: AVLoadingIndicatorView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN)
        avi= (findViewById(R.id.progress)) as AVLoadingIndicatorView
    }

    fun loadFragment(fragment: BaseFragment, id: Int, tag: String) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(id, fragment, tag)
        transaction.addToBackStack(fragment.tag)
        transaction.commit()
    }

    fun showActionBar(boolean: Boolean) {
        if (boolean) {
            supportActionBar?.show()
            supportActionBar?.setDisplayHomeAsUpEnabled(true)
            supportActionBar?.setDisplayShowHomeEnabled(true)
        } else
            supportActionBar?.hide()
    }

    fun showProgress() {
        avi?.show()
    }

    fun hideProgress() {
        avi?.hide()
    }
}
