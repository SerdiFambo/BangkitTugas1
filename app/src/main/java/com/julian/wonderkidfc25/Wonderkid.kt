package com.julian.wonderkidfc25

import android.os.Parcel
import android.os.Parcelable

data class Wonderkid(
    val imgWonderkid: Int,
    val nameWonderkid: String?,
    val descWonderkid: Array<String>
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString(),
        parcel.createStringArray() ?: arrayOf()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(imgWonderkid)
        parcel.writeString(nameWonderkid)
        parcel.writeStringArray(descWonderkid)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Wonderkid> {
        override fun createFromParcel(parcel: Parcel): Wonderkid {
            return Wonderkid(parcel)
        }

        override fun newArray(size: Int): Array<Wonderkid?> {
            return arrayOfNulls(size)
        }
    }
}
