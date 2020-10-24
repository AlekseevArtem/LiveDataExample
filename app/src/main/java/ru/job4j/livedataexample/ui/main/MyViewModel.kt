package ru.job4j.livedataexample.ui.main

import android.os.Handler
import android.os.Looper

import android.os.SystemClock.*
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.util.*


class MyViewModel : ViewModel() {
    private val initialTime: Long = elapsedRealtime()
    private val elapsedTimeLiveData = MutableLiveData<Long>()

    init {
        val timer = Timer()
        timer.scheduleAtFixedRate(object : TimerTask() {
            override fun run() {
                val newValue = (elapsedRealtime() - initialTime) / 1000
                Handler(Looper.getMainLooper()).post { elapsedTimeLiveData.setValue(newValue) }
            }
        }, 1000, 1000)
    }

    fun getElapsedTimeLiveData(): LiveData<Long> = elapsedTimeLiveData
}