package la.kaelae.qiitaclient.di

import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import la.kaelae.qiitaclient.App
import la.kaelae.qiitaclient.di.scope.PerApp

@PerApp
@Component(
        modules = arrayOf(
                AppModule::class,
                AndroidSupportInjectionModule::class,
                DataModule::class,
                ActivityModule::class
        ))
interface AppComponent : AndroidInjector<App> {
    @Component.Builder
    interface Builder {
        @BindsInstance fun app(app: App): Builder
        fun appModule(module: AppModule): Builder
        fun dataModule(module: DataModule): Builder
        fun build(): AppComponent
    }
}