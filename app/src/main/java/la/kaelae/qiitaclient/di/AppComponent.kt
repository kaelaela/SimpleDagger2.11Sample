package la.kaelae.qiitaclient.di

import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import la.kaelae.qiitaclient.App
import la.kaelae.qiitaclient.di.scope.PerApp
import la.kaelae.qiitaclient.ui.main.MainActivity
import la.kaelae.qiitaclient.ui.main.MainModule

@Component(modules = arrayOf(
        AndroidSupportInjectionModule::class,
        DataModule::class,
        MainModule::class,
        ActivityModule::class
))
@PerApp
interface AppComponent : AndroidInjector<App> {
    @Component.Builder
    interface Builder {
        @BindsInstance fun app(app: App): Builder
        fun build(): AppComponent
    }

    fun inject(target: MainActivity)
}