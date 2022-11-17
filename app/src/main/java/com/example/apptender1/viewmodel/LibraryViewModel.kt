package com.example.apptender1.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.apptender1.model.frutas
import com.example.apptender1.repositorio.repo

class LibraryViewModel: ViewModel() {

        val repo=repo()
    fun libraryData(): LiveData<MutableList<frutas>>{
        val mutabledata= MutableLiveData<MutableList<frutas>>()
        repo.getlibraryData().observeForever { result ->
            mutabledata.value= result
        }
        return mutabledata
    }
}