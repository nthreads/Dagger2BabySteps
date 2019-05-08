package com.csms.simpledagger2

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import dagger.Component
import dagger.Module
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    val info : Info = Info()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textView.text = info.text
    }

    class Info {
        val text = "I have some info"
    }


}
