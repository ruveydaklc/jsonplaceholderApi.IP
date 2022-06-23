package com.example.internshipproject.api.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class User (
    var id: Int,
    var name: String,
    var username: String,
    var email: String,
    var phone: String,
    var website: String,
    var address: Address,
    var company: Company
): Parcelable