package la.kaelae.qiitaclient.data.model

import android.os.Parcel
import android.os.Parcelable

data class QiitaUser(val id: String,
                     val name: String,
                     val description: String,
                     val profile_image_url: String) : Parcelable {
    constructor(parcel: Parcel) : this(
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString())

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.run {
            writeString(id)
            writeString(name)
            writeString(description)
            writeString(profile_image_url)
        }
    }

    override fun describeContents(): Int = 0

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<QiitaUser> = object : Parcelable.Creator<QiitaUser> {
            override fun createFromParcel(parcel: Parcel): QiitaUser = QiitaUser(parcel)
            override fun newArray(size: Int): Array<QiitaUser?> = arrayOfNulls(size)
        }
    }
}