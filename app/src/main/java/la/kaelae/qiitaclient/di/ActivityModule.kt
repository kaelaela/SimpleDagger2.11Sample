package la.kaelae.qiitaclient.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import la.kaelae.qiitaclient.ui.main.MainActivity
import la.kaelae.qiitaclient.ui.main.MainModule

@Module
abstract class ActivityModule {
    @ContributesAndroidInjector(modules = arrayOf(MainModule::class))
    abstract fun activityInjector(): MainActivity
}