package com.example.tenantmanagementsystem

object TenantRepository {
    private val tenants = mutableListOf<Tenant>()

    fun addTenant(tenant: Tenant) {
        tenants.add(tenant)
    }

    fun getAllTenants(): List<Tenant> {
        return tenants.toList()
    }
}