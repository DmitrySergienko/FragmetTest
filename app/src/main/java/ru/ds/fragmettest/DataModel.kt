package ru.ds.fragmettest

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

//этот клас создаем для обмена сообщениями LiveData
open class DataModel: ViewModel() {
    val messageForFrag1: MutableLiveData<String> by lazy { //by lazy для того чтобы не пересоздавать каждый раз MutableLiveData
        MutableLiveData<String>()
    }

    val messageForFrag2: MutableLiveData<String> by lazy { //by lazy для того чтобы не пересоздавать каждый раз MutableLiveData
        MutableLiveData<String>()
    }
    val messageForActivity: MutableLiveData<String> by lazy { //by lazy для того чтобы не пересоздавать каждый раз MutableLiveData
        MutableLiveData<String>()
    }
}