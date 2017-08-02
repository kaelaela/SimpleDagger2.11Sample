package la.kaelae.qiitaclient

import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication
import la.kaelae.qiitaclient.di.DaggerAppComponent

class App : DaggerApplication() {
    override fun applicationInjector(): AndroidInjector<out DaggerApplication> = DaggerAppComponent.builder().app(this).build()
}