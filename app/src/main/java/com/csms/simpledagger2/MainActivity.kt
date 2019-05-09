package com.csms.simpledagger2

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import dagger.Component
import dagger.Module
import dagger.Provides
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject
import javax.inject.Named


class MainActivity : AppCompatActivity() {

    companion object {
        const val BASIC  = "Basic"
        const val CLASSIFIED  = "Classified"
    }

    @Inject
    @field:Named(BASIC)
    lateinit var basicInfo : Info

    @Inject
    @field:Named(CLASSIFIED)
    lateinit var classifiedInfo : Info

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        DaggerMainActivity_InfoComponent.create().inject(this)

        textView.text = "${basicInfo.text} \n ${classifiedInfo.text}"
    }

    class Info (var text : String)

    @Component(modules = [InfoModule::class])
    interface InfoComponent {
        fun inject(activity: MainActivity)
    }

    @Module
    class InfoModule {
        @Provides
        @Named(BASIC)
        fun provideBasicInfo() : Info {
            return Info("Get basic basicInfo through constructor")
        }

        @Provides
        @Named(CLASSIFIED)
        fun provideClassifiedInfo() : Info {
            return Info("Hey, i have some classified basicInfo")
        }
    }


}
