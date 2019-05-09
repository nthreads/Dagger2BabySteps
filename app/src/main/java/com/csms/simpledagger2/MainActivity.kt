package com.csms.simpledagger2

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import dagger.Component
import dagger.Module
import dagger.Provides
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

    class Info (var text : String)

    @Component(modules = [InfoModule::class])
    interface InfoComponent {
        fun inject(activity: MainActivity)
    }

    @Module
    class InfoModule {
        @Provides
        fun provideInfo() : Info {
            return Info("Get info through constructor")
        }
    }
}
