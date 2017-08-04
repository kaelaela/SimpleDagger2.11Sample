package la.kaelae.qiitaclient.ui.main

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.EditText
import android.widget.ImageButton
import android.widget.ProgressBar
import dagger.android.support.DaggerAppCompatActivity
import la.kaelae.qiitaclient.R
import la.kaelae.qiitaclient.data.model.QiitaArticle
import la.kaelae.qiitaclient.ui.article.ArticleActivity
import la.kaelae.qiitaclient.ui.article.ArticleAdapter
import la.kaelae.qiitaclient.util.ext.snackBar
import javax.inject.Inject

class MainActivity : DaggerAppCompatActivity(), IMain {

    val queryEditor by lazy { findViewById<EditText>(R.id.search_text) }
    val adapter = ArticleAdapter()
    @Inject lateinit var presenter: MainPresenter<IMain>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val recyclerView = findViewById<RecyclerView>(R.id.article_list)
        adapter.setOnItemClickListener(
                object : ArticleAdapter.OnItemClickListener {
                    override fun onItemClick(article: QiitaArticle) =
                            startActivity(ArticleActivity.getIntent(applicationContext, article))
                })
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter
        val progress = findViewById<ProgressBar>(R.id.progress_bar)
        queryEditor.setSelection(queryEditor.length())
        val searchButton = findViewById<ImageButton>(R.id.search_button)
        searchButton.setOnClickListener {
            progress.visibility = View.VISIBLE
            adapter.articles = emptyList()
            adapter.notifyDataSetChanged()
            presenter.loadArticle(queryEditor.text.toString())
            queryEditor.text.clear()
            queryEditor.text.insert(0, "user:")
            queryEditor.setSelection(queryEditor.length())
            progress.visibility = View.GONE
        }
    }

    override fun onLoadData(lists: List<QiitaArticle>) {
        adapter.articles = lists
        adapter.notifyDataSetChanged()
    }

    override fun onError() {
        snackBar("読み込み失敗")
    }
}
