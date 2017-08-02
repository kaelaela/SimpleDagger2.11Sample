package la.kaelae.qiitaclient.di

import dagger.Component
import la.kaelae.qiitaclient.ui.main.MainActivity

@Component(modules = arrayOf(
        QiitaModule::class
))
interface AppComponent {
    fun inject(target: MainActivity)
}