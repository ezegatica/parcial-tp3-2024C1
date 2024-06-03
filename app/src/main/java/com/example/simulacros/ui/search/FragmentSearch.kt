package com.example.simulacros.ui.search

import android.app.DatePickerDialog
import android.os.Bundle
import android.text.Editable
import android.text.InputType
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.simulacros.R
import com.example.simulacros.adapters.OfferHorizontalAdapter
import com.example.simulacros.databinding.FragmentSearchBinding
import com.example.simulacros.domain.model.Offer
import com.example.simulacros.listener.OnOfferItemClickedListener
import com.google.android.material.internal.ViewUtils.hideKeyboard
import com.google.android.material.textfield.TextInputEditText
import java.util.Calendar


class FragmentSearch : Fragment(), OnOfferItemClickedListener {
    private var _binding: FragmentSearchBinding? = null
    private val binding get() = _binding!!
    private val viewModel: SearchViewModel by viewModels()

    private lateinit var linearLayoutManagerOffer: LinearLayoutManager
    lateinit var recyclerOffers: RecyclerView
    private lateinit var offerHorizontalAdapter: OfferHorizontalAdapter

    private lateinit var textDeparture : EditText
    private lateinit var textArrival : EditText
    private lateinit var textDate : EditText
    private lateinit var selectDate : TextInputEditText

    private var selectedPassenger : String = "1 Adult"
    private var selectedClass : String = "Economy"

    companion object {
        fun newInstance() = FragmentSearch()
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val searchViewModel = ViewModelProvider(this).get(SearchViewModel::class.java)
        _binding = FragmentSearchBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val btnSearch: Button = binding.searchButton
        btnSearch.setOnClickListener() {
            if (textDeparture.text.isNullOrEmpty()) {
                Toast.makeText(context, "Por favor complete el campo From", Toast.LENGTH_SHORT).show()
            }else if(textArrival.text.isNullOrEmpty()){
                Toast.makeText(context, "Por favor complete el campo To", Toast.LENGTH_SHORT).show()
            }else if(textDate.text.isNullOrEmpty() ) {
                Toast.makeText(context, "Por favor complete el la fecha del vuelo", Toast.LENGTH_SHORT).show()
            }else if(selectedPassenger.isEmpty()) {
                Toast.makeText(context, "Por favor complete el numero de pasajeros", Toast.LENGTH_SHORT).show()
            }else if(selectedClass.isEmpty()) {
                Toast.makeText(context, "Por favor complete la clase del vuelo", Toast.LENGTH_SHORT).show()
            }else{
                view?.findNavController()?.navigate(FragmentSearchDirections.actionFragmentSearchToNavigationHome(
                    textDeparture.text.toString(),
                    textArrival.toString(),
                    textDate.toString(),
                    selectedPassenger,
                    selectedClass))
            }
        }

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        linearLayoutManagerOffer = LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)

        recyclerOffers = binding.recyclerOffers
        recyclerOffers.setHasFixedSize(true)
        recyclerOffers.layoutManager = linearLayoutManagerOffer

        viewModel.offers.observe(viewLifecycleOwner, Observer { offers ->
            offerHorizontalAdapter = OfferHorizontalAdapter(offers, this)
            recyclerOffers.adapter = offerHorizontalAdapter
        })

        textDeparture = binding.textFrom.editText!!
        textArrival = binding.textTo.editText!!
        textDate = binding.selectDate
        selectDate = binding.selectDate

        selectDate.inputType = InputType.TYPE_NULL
        selectDate.setOnClickListener {
            showDatePickerDialog()
        }

        setupTextInput(textDeparture, "Select Departure")
        setupTextInput(textArrival, "Select Arrival")
        setupTextInput(textDate, "Select Date")

        viewModel.passengers.observe(viewLifecycleOwner, Observer { passengers -> passengers?.let {
            val adapterPassengers = ArrayAdapter(requireContext(), android.R.layout.simple_dropdown_item_1line, passengers)
            val autoCompletePassengers: AutoCompleteTextView = view.findViewById(R.id.autoCompletePassengers)
            autoCompletePassengers.setAdapter(adapterPassengers)
            autoCompletePassengers.setOnItemClickListener { parent, view, position, id ->
                selectedPassenger = parent.getItemAtPosition(position) as String
            }
        }

        })

        viewModel.classes.observe(viewLifecycleOwner, Observer { classes -> classes?.let {
            val adapterClasses = ArrayAdapter(requireContext(), android.R.layout.simple_dropdown_item_1line, classes)
            val autoCompleteClasses: AutoCompleteTextView = view.findViewById(R.id.autoCompleteClasses)
            autoCompleteClasses.setAdapter(adapterClasses)
            autoCompleteClasses.setOnItemClickListener { parent, view, position, id ->
                selectedClass = parent.getItemAtPosition(position) as String
            }
            }
        })

    }

    private fun showDatePickerDialog() {
        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH)

        val datePickerDialog = DatePickerDialog(requireContext(), { _, selectedYear, selectedMonth, dayOfMonth ->
            val selectedDate = "$selectedYear-${selectedMonth + 1}-$dayOfMonth"
            binding.selectDate.setText(selectedDate)
        }, year, month, dayOfMonth)

        datePickerDialog.show()
    }

    private fun setupTextInput(textInput: EditText, hint: String) {
        textInput.setOnFocusChangeListener { _, hasFocus ->
            if (hasFocus && textInput.text.toString() == hint) {
                textInput.setText("")
            }
        }

        textInput.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                // No hacer nada
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                // No hacer nada
            }

            override fun afterTextChanged(s: Editable?) {
                if (!textInput.hasFocus() && s.isNullOrEmpty()) {
                    textInput.setText(hint)
                }
            }
        })
    }

    override fun onOfferItemDetail(offer: Offer) {
    }


}