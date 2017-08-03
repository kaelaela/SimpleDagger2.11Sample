package la.kaelae.qiitaclient.ui.main

import dagger.Module
import dagger.Provides
import la.kaelae.qiitaclient.data.api.QiitaService
import retrofit2.Retrofit

@Module
class MainModule {
    @Provides
    fun provideQiitaService(r: Retrofit): QiitaService = r.create(QiitaService::class.java)
}