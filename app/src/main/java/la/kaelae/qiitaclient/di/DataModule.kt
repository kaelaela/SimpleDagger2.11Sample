package la.kaelae.qiitaclient.di

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import com.squareup.moshi.KotlinJsonAdapterFactory
import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import la.kaelae.qiitaclient.di.scope.PerApp
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Singleton
@Module
class DataModule {
    @Provides @PerApp
    fun provideMoshi(): Moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()

    @Provides @PerApp
    fun provideRetrofit(m: Moshi): Retrofit = Retrofit.Builder().baseUrl("https://qiita.com")
            .addConverterFactory(MoshiConverterFactory.create(m))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
}