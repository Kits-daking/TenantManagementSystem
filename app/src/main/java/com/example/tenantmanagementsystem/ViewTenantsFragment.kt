package com.example.tenantmanagementsystem

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.tenantmanagementsystem.databinding.FragmentViewTenantsBinding

class ViewTenantsFragment : Fragment() {

    private var _binding: FragmentViewTenantsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        Log.d("Lifecycle", "ViewTenantsFragment: onCreateView")
        _binding = FragmentViewTenantsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val tenants = TenantRepository.getAllTenants()
        if (tenants.isEmpty()) {
            binding.tvTenantList.text = "No tenants found."
        } else {
            val builder = StringBuilder()
            tenants.forEach { t ->
                builder.append("ID: ${t.id}\nName: ${t.name}\nUnit: ${t.unitNumber}\nRent: \$${t.rentAmount}\n\n")
            }
            binding.tvTenantList.text = builder.toString()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.d("Lifecycle", "ViewTenantsFragment: onDestroyView")
        _binding = null
    }
}