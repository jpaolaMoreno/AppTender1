package com.example.apptender1.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.apptender1.model.compras
import com.example.apptender1.repositorio.repo

class ComprasViewModel: ViewModel() {
    val repo=repo()
    fun fetchComprasData():LiveData<MutableList<compras>>{
        val mutableData=MutableLiveData<MutableList<compras>>()
        repo.getComprasData().observeForever {
            mutableData.value=it
        }
        return mutableData
    }
}