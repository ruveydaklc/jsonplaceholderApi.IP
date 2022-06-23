package com.example.internshipproject.api.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Company (
    var name: String? = null,
    var catchPchrase: String? = null,
    var bs: String? = null
): Parcelable