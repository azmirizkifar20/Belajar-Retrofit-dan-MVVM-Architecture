package org.d3if4055.belajarrecyclerview

import android.view.View

interface RecyclerViewClickListener {

    // method yang akan dipanggil di MainActivity
    fun onItemClicked(view: View, negara: Negara)

}