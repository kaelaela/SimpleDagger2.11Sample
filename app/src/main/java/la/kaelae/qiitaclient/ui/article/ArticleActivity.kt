package la.kaelae.qiitaclient.ui.article

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.webkit.WebView
import la.kaelae.qiitaclient.R
import la.kaelae.qiitaclient.data.model.QiitaArticle
import la.kaelae.qiitaclient.util.ext.intent

class ArticleActivity : AppCompatActivity() {
    companion object {
        private const val ARTICLE: String = "ArticleActivity.article"
        fun getIntent(c: Context, article: QiitaArticle): Intent =
                c.intent<ArticleActivity>().putExtra(ARTICLE, article)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_article)
        findViewById<Toolbar>(R.id.tool_bar).setNavigationOnClickListener { finish() }
        val web = findViewById<WebView>(R.id.web_view)
        val article: QiitaArticle = intent.getParcelableExtra(ARTICLE)
        web.loadUrl(article.url)
    }
}