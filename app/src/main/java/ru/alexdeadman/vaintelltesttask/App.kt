package ru.alexdeadman.vaintelltesttask

import android.app.Application
import com.onesignal.OneSignal
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class App : Application() {

    override fun onCreate() {
        super.onCreate()

        if (BuildConfig.DEBUG) {
            OneSignal.setLogLevel(OneSignal.LOG_LEVEL.VERBOSE, OneSignal.LOG_LEVEL.NONE)
        }

        OneSignal.initWithContext(this)
        OneSignal.setAppId(BuildConfig.ONESIGNAL_APP_ID)
    }
}