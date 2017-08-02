package la.kaelae.qiitaclient.data.api

import io.reactivex.Flowable
import la.kaelae.qiitaclient.data.model.QiitaArticle
import retrofit2.http.GET
import retrofit2.http.Query

interface QiitaService {
    @GET("/api/v2/items")
    fun searchRepos(@Query("query") query: String): Flowable<List<QiitaArticle>>
}