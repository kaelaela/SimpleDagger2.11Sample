package la.kaelae.qiitaclient.ui.main

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.EditText
import android.widget.ImageButton
import android.widget.ProgressBar
import dagger.android.support.DaggerAppCompatActivity
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import la.kaelae.qiitaclient.R
import la.kaelae.qiitaclient.data.api.QiitaService
import la.kaelae.qiitaclient.data.model.QiitaArticle
import la.kaelae.qiitaclient.ui.article.ArticleActivity
import la.kaelae.qiitaclient.ui.article.ArticleAdapter
import la.kaelae.qiitaclient.util.ext.snackBar
import javax.inject.Inject

class MainActivity : DaggerAppCompatActivity() {

    @Inject lateinit var qiitaService: QiitaService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val recyclerView = findViewById<RecyclerView>(R.id.article_list)
        val adapter = ArticleAdapter()
        adapter.setOnItemClickListener(
                object : ArticleAdapter.OnItemClickListener {
                    override fun onItemClick(article: QiitaArticle) =
                            startActivity(ArticleActivity.getIntent(applicationContext, article))
                })
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter
        val progress = findViewById<ProgressBar>(R.id.progress_bar)
        val queryEditor = findViewById<EditText>(R.id.search_text)
        queryEditor.setSelection(queryEditor.length())
        val searchButton = findViewById<ImageButton>(R.id.search_button)
        searchButton.setOnClickListener {
            progress.visibility = View.VISIBLE
            adapter.articles = emptyList()
            adapter.notifyDataSetChanged()
            qiitaService.searchRepos(queryEditor.text.toString())
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .doAfterTerminate {
                        progress.visibility = View.GONE
                    }
                    .subscribe({
                        queryEditor.text.clear()
                        queryEditor.text.insert(0, "user:")
                        queryEditor.setSelection(queryEditor.length())
                        adapter.articles = it
                        adapter.notifyDataSetChanged()
                    }, {
                        snackBar("読み込み失敗")
                    })
        }
    }
}
