package com.example.tenantmanagementsystem

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.tenantmanagementsystem.databinding.FragmentAddTenantBinding

class AddTenantFragment : Fragment() {

    private var _binding: FragmentAddTenantBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        Log.d("Lifecycle", "AddTenantFragment: onCreateView")
        _binding = FragmentAddTenantBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnSaveTenant.setOnClickListener {
            val id = binding.etTenantId.text.toString()
            val name = binding.etTenantName.text.toString()
            val unit = binding.etUnitNumber.text.toString()
            val rent = binding.etRentAmount.text.toString().toDoubleOrNull() ?: 0.0

            if (id.isNotBlank() && name.isNotBlank()) {
                val tenant = Tenant(id, name, unit, rent)
                TenantRepository.addTenant(tenant)
                Toast.makeText(context, "Tenant Saved!", Toast.LENGTH_SHORT).show()
                findNavController().popBackStack()
            } else {
                Toast.makeText(context, "Please fill in required fields", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.d("Lifecycle", "AddTenantFragment: onDestroyView")
        _binding = null
    }
}