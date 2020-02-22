package com.soarmorrow.bms.view.intro_screen

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import androidx.lifecycle.Observer
import com.soarmorrow.bms.R
import com.soarmorrow.bms.api.response.city.City
import com.soarmorrow.bms.api.response.country.Country
import com.soarmorrow.bms.api.response.state.State
import com.soarmorrow.bms.base.BaseFragment
import com.soarmorrow.bms.util.Utils
import com.soarmorrow.bms.util.Validator
import com.soarmorrow.bms.view.custom_views.CustomSpinnerAdapter
import com.soarmorrow.bms.view.register.RegisterActivity
import com.soarmorrow.bms.viewmodel.RegisterViewModel
import kotlinx.android.synthetic.main.fragment_reg_company.*
import org.koin.android.viewmodel.ext.android.viewModel


class CompanyRegisterFragment : BaseFragment() {

    private lateinit var countryList: List<Country>
    private lateinit var stateList: List<State>
    private lateinit var cityList: List<City>

    private lateinit var countryAdapter: CustomSpinnerAdapter
    private lateinit var stateAdapter: CustomSpinnerAdapter
    private lateinit var cityAdapter: CustomSpinnerAdapter

    private lateinit var registerModel: RegisterViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_reg_company, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        registerModel = (activity as RegisterActivity).registerModel
        initList()
        registerModel.getCountry()

        registerModel.countryResponse.observe(
            this,
            Observer(function = fun(list: List<Country>) {
                hideProgress()
                list.let {
                    countryList = list
                    countryAdapter.setItems(countryList)
                }
            })
        )
        registerModel.stateResponse.observe(
            this,
            Observer(function = fun(list: List<State>) {
                hideProgress()
                list.let {
                    stateList = list
                    stateAdapter.setItems(stateList)
                }
            })
        )
        registerModel.cityResponse.observe(
            this,
            Observer(function = fun(list: List<City>) {
                hideProgress()
                list.let {
                    cityList = list
                    cityAdapter.setItems(cityList)
                }
            })
        )

    }

    private fun initList() {
        countryList = mutableListOf(Country("Select Country"))
        countryAdapter = CustomSpinnerAdapter(context!!, countryList)
        sp_country?.adapter = countryAdapter


        stateList = mutableListOf(State("Select State"))
        stateAdapter = CustomSpinnerAdapter(context!!, stateList)
        sp_state?.adapter = stateAdapter

        cityList = mutableListOf(City("Select City"))
        cityAdapter = CustomSpinnerAdapter(context!!, cityList)
        sp_city?.adapter = cityAdapter

        sp_country.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>,
                view: View,
                position: Int,
                id: Long
            ) {
                if (position != 0) {
                    registerModel.getState(countryList[position].id.toString())
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>) {
                // Another interface callback
            }
        }
        sp_state.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>,
                view: View,
                position: Int,
                id: Long
            ) {
                if (position != 0) {
                    registerModel.getCity(stateList[position].id.toString())
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>) {
                // Another interface callback
            }
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
            CompanyRegisterFragment().apply {
                arguments = Bundle().apply {
                }
            }
    }

    fun setRegisterDataToViewModel(): Boolean {
        var allFieldValidated = false
        if (Validator.validRegisterCompanyInput(
                et_name_business.text.toString(),
                et_address1.text.toString(),
                et_address2.text.toString(),
                et_pincode.text.toString(),
                et_telephone.text.toString(),
                et_booking_manager_mob.text.toString(),
                et_contact_person_mob.text.toString()
            )
        ) {
            if (sp_country.selectedItemPosition != 0 && sp_state.selectedItemPosition != 0 && sp_city.selectedItemPosition != 0) {
                registerModel.registerRequest.business = et_name_business.text.toString()
                registerModel.registerRequest.address =
                    et_address1.text.toString() + " ," + et_address2.text.toString()
                registerModel.registerRequest.pincode = et_pincode.text.toString()
                registerModel.registerRequest.land_phone = et_telephone.text.toString()
                registerModel.registerRequest.phone = et_booking_manager_mob.text.toString()
                registerModel.registerRequest.country_id =
                    countryList[sp_country.selectedItemPosition].id.toString()
                registerModel.registerRequest.state_id =
                    stateList[sp_state.selectedItemPosition].id.toString()
                registerModel.registerRequest.city_id =
                    cityList[sp_city.selectedItemPosition].id.toString()
                allFieldValidated = true
            } else {
                showMessage(getString(R.string.empty_country))
            }

        } else {
            showMessage(getString(R.string.empty_filed))
        }
        return allFieldValidated

    }
}
