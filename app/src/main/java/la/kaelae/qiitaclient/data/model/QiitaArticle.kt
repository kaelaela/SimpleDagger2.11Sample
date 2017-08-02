package la.kaelae.qiitaclient.data.model

import android.os.Parcel
import android.os.Parcelable

data class QiitaArticle(val id: String,
                        val title: String,
                        val url: String,
                        val user: QiitaUser) : Parcelable {
    constructor(parcel: Parcel) : this(
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readParcelable(QiitaUser::class.java.classLoader)) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.run {
            writeString(id)
            writeString(title)
            writeString(url)
            writeParcelable(user, flags)
        }
    }

    override fun describeContents(): Int = 0

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<QiitaArticle> = object : Parcelable.Creator<QiitaArticle> {
            override fun createFromParcel(parcel: Parcel): QiitaArticle = QiitaArticle(parcel)

            override fun newArray(size: Int): Array<QiitaArticle?> = arrayOfNulls(size)
        }
    }

}