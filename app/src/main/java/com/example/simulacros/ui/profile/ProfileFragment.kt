package com.example.simulacros.ui.profile

import androidx.fragment.app.viewModels
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.example.simulacros.R
import com.example.simulacros.databinding.FragmentProfileBinding
import com.example.simulacros.databinding.FragmentSearchBinding
import com.example.simulacros.ui.search.FragmentSearchDirections
import com.example.simulacros.ui.search.SearchViewModel
import com.google.android.material.textfield.TextInputEditText

class ProfileFragment : Fragment() {

    private var _binding: FragmentProfileBinding? = null
    private val binding get() = _binding!!

    companion object {
        fun newInstance() = ProfileFragment()
    }

    private val viewModel: ProfileViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val searchViewModel = ViewModelProvider(this).get(SearchViewModel::class.java)
        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        val root: View = binding.root
        viewModel.descriptionText.observe(viewLifecycleOwner) { text ->
            binding.textViewDesc.text = text
        }
        viewModel.subtitleText.observe(viewLifecycleOwner) { text ->
            binding.srdSubtitle.text = text
            binding.srdSubtitleEdit.setText(text)
        }
        val btnEdit: Button = binding.editButton
        btnEdit.setOnClickListener {
            toggleEditMode()
        }

        return root
    }
    private fun toggleEditMode() {

        val isEditing = binding.textInputEditTextDesc.visibility == View.VISIBLE

        // Description fields
        binding.textViewDesc.visibility = if (isEditing) View.VISIBLE else View.INVISIBLE
        binding.textInputEditTextDesc.visibility = if (isEditing) View.INVISIBLE else View.VISIBLE

        // Subtitle fields
        binding.srdSubtitle.visibility = if (isEditing) View.VISIBLE else View.INVISIBLE
        binding.srdSubtitleEdit.visibility = if (isEditing) View.INVISIBLE else View.VISIBLE

        if (isEditing) {
            // Save text from EditTexts to LiveData
            viewModel.setDescription(binding.textInputEditTextDesc.text.toString())
            viewModel.setSubtitle(binding.srdSubtitleEdit.text.toString())
        }

    }


}