package la.kaelae.qiitaclient.ui.main

import dagger.Module
import dagger.Provides
import la.kaelae.qiitaclient.data.api.QiitaService
import la.kaelae.qiitaclient.di.scope.PerActivity
import retrofit2.Retrofit

@Module
class MainModule {

    @Provides @PerActivity
    fun providePresenter(service: QiitaService, view: MainActivity) = MainPresenter<IMain>(service, view)

    @Provides @PerActivity
    fun provideQiitaService(r: Retrofit): QiitaService = r.create(QiitaService::class.java)
}