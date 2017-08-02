package la.kaelae.qiitaclient.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import la.kaelae.qiitaclient.ui.main.MainActivity

@Module
abstract class ActivityModule {
    @ContributesAndroidInjector(modules = arrayOf(QiitaModule::class))
    abstract fun activityInjector(): MainActivity
}