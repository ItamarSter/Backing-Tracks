package itamar.stern.backingtracks

import android.app.Application
import itamar.stern.backingtracks.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class BtApplication:Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@BtApplication)
            modules(appModule)
        }
    }
}