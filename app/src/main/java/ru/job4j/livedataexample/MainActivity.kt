package ru.job4j.livedataexample

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.main_activity.*
import ru.job4j.livedataexample.ui.main.MyViewModel


class MainActivity : AppCompatActivity() {
    private val elapsedTimeObserver: Observer<Long> = Observer<Long> { newValue ->
        txtTimer.text = newValue.toString()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        val viewModel = ViewModelProvider(this).get(MyViewModel::class.java)
        viewModel.getElapsedTimeLiveData().observe(this, elapsedTimeObserver)
    }
}