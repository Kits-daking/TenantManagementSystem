package com.example.tenantmanagementsystem

import java.io.Serializable

data class Tenant(
    val id: String,
    val name: String,
    val unitNumber: String,
    val rentAmount: Double
) : Serializable