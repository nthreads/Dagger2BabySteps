package com.csms.simpledagger2

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import dagger.Component
import dagger.Module
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject lateinit var info : Info

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        DaggerMainActivity_InfoComponent.create().inject(this)
        textView.text = info.text
    }

    class Info @Inject constructor(){
        val text = "I have some info"
    }

    @Component
    interface InfoComponent {
        fun inject(activity: MainActivity)
    }
}
