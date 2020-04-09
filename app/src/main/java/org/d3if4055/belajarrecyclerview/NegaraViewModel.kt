package org.d3if4055.belajarrecyclerview

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class NegaraViewModel : ViewModel() {

    private val _data = MutableLiveData<List<Negara>>()
    val data : LiveData<List<Negara>>
        get() = _data

    private val _response = MutableLiveData<String>()
    val response : LiveData<String>
        get() = _response

    private var job = Job()
    private val uiScope = CoroutineScope(job + Dispatchers.Main)

    init {
        _response.value = ""
        initData()
    }

    private fun initData() {
        uiScope.launch {
            try {
                val result = ApiNegara.retrofitService.showList()

                if (result.isNotEmpty()) {
                    _data.value = result
                    _response.value = "Berhasil fetch data!"
                } else {
                    _response.value = "Data negara kosong!"
                }
            } catch (t: Throwable){
                _response.value = "Tidak ada koneksi internet!"
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        job.cancel()
    }
}