package la.kaelae.qiitaclient.ui.article

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import la.kaelae.qiitaclient.R
import la.kaelae.qiitaclient.data.model.QiitaArticle
import la.kaelae.qiitaclient.util.ext.findView

class ArticleViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {

    val thumbnail: ImageView by itemView?.findView(R.id.user_thumbnail)
    val title: TextView by itemView?.findView(R.id.article_title)
    val userName: TextView by itemView?.findView(R.id.user_name)

    fun bind(article: QiitaArticle) {
        Glide.with(itemView.context).load(article.user.profile_image_url).into(thumbnail)
        title.text = article.title
        userName.text = article.user.name
    }
}