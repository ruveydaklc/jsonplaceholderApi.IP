package com.example.internshipproject.api.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Address (
    var street: String? = null,
    var suite: String? = null,
    var city: String? = null,
    var zipcode: String? = null
): Parcelable