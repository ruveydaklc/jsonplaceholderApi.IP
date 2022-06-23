package com.example.internshipproject.api.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


@Parcelize
data class Geo (
    var lat: Double = 0.toDouble(),
    var lng: Double = 0.toDouble()

): Parcelable