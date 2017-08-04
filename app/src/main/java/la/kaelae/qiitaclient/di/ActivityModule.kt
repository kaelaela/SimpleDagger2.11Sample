package la.kaelae.qiitaclient.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import la.kaelae.qiitaclient.di.scope.PerActivity
import la.kaelae.qiitaclient.ui.main.MainActivity
import la.kaelae.qiitaclient.ui.main.MainModule

@Module
abstract class ActivityModule {

    @PerActivity
    @ContributesAndroidInjector(modules = arrayOf(MainModule::class))
    abstract fun activityInjector(): MainActivity
}