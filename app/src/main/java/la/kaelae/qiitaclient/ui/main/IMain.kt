package la.kaelae.qiitaclient.ui.main

import la.kaelae.qiitaclient.data.model.QiitaArticle

interface IMain {
    fun onLoadData(lists: List<QiitaArticle>)

    fun onError()
}