package la.kaelae.qiitaclient

import android.app.Application
import la.kaelae.qiitaclient.di.AppComponent
import la.kaelae.qiitaclient.di.DaggerAppComponent

class App : Application() {
    val appComponent: AppComponent by lazy {
        DaggerAppComponent.create()
    }
}