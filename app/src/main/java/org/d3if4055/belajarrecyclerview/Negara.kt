package org.d3if4055.belajarrecyclerview

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Negara (
    val namaNegara: String,
    val ibuKota: String,
    val jumlahPenduduk: String,
    val mataUang: String,
    val gambar: String
) : Parcelable