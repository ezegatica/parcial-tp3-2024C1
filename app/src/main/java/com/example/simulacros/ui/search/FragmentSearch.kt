package com.example.simulacros.ui.search

import android.app.DatePickerDialog
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Button
import android.widget.EditText
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
import com.google.android.material.textfield.TextInputEditText
import java.util.Calendar


class FragmentSearch : Fragment(), OnOfferItemClickedListener {
    private var _binding: FragmentSearchBinding? = null
    private val binding get() = _binding!!
    private val viewModel: SearchViewModel by viewModels()

    private lateinit var linearLayoutManagerOffer: LinearLayoutManager
    lateinit var recyclerOffers: RecyclerView
    private lateinit var offerHorizontalAdapter: OfferHorizontalAdapter

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
            view?.findNavController()?.navigate(FragmentSearchDirections.actionFragmentSearchToNavigationHome())
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

        val textDeparture: EditText = binding.textFrom.editText!!
        val textArrival: EditText = binding.textTo.editText!!
        val textDate: EditText = binding.selectDate
        val selectDate: TextInputEditText = binding.selectDate

        selectDate.setOnClickListener {
            showDatePickerDialog()
        }

        setupTextInput(textDeparture, "Select Departure")
        setupTextInput(textArrival, "Select Arrival")
        setupTextInput(textDate, "Select Date")

        val passengers = listOf("1 Adult", "2 Adults", "3 Adults", "4 Adults")
        val adapterPassengers = ArrayAdapter(requireContext(), android.R.layout.simple_dropdown_item_1line, passengers)
        val autoCompletePassengers: AutoCompleteTextView = view.findViewById(R.id.autoCompletePassengers)
        autoCompletePassengers.setAdapter(adapterPassengers)

        val classes = listOf("Economy", "Business", "First")
        val adapterClasses = ArrayAdapter(requireContext(), android.R.layout.simple_dropdown_item_1line, classes)
        val autoCompleteClasses: AutoCompleteTextView = view.findViewById(R.id.autoCompleteClasses)
        autoCompleteClasses.setAdapter(adapterClasses)

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