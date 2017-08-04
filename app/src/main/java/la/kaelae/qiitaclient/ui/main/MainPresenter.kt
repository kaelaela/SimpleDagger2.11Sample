package la.kaelae.qiitaclient.ui.main

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import la.kaelae.qiitaclient.data.api.QiitaService
import la.kaelae.qiitaclient.di.scope.PerActivity
import javax.inject.Inject

@PerActivity
class MainPresenter<T : IMain> @Inject constructor(private val qiitaService: QiitaService,
                                                   private val view: T) {
    fun loadArticle(query: String) {
        qiitaService.searchRepos(query)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    view.onLoadData(it)
                }, {
                    view.onError()
                })
    }
}