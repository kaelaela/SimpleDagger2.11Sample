package la.kaelae.qiitaclient.ui.main

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import la.kaelae.qiitaclient.R
import la.kaelae.qiitaclient.data.model.QiitaArticle

class ArticleAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    var articles: List<QiitaArticle> = emptyList()
    var listener: OnItemClickListener? = null
    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): RecyclerView.ViewHolder {
        val i = LayoutInflater.from(parent?.context)
        return ArticleViewHolder(i.inflate(R.layout.item_qiita_article, parent, false))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder?, position: Int) {
        val viewHolder = holder as ArticleViewHolder
        viewHolder.bind(articles[position])
        viewHolder.itemView.setOnClickListener { _ -> listener?.onItemClick(articles[position]) }
    }

    override fun getItemCount(): Int = articles.size

    fun setOnItemClickListener(listener: OnItemClickListener) {
        this.listener = listener
    }

    interface OnItemClickListener {
        fun onItemClick(article: QiitaArticle)
    }
}