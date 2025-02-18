package com.example.realprojectandroidpertama

import android.os.Parcel
import android.os.Parcelable


data class Game(
    var logo: Int,
    var background: Int,
    var judul: String,
    var sinopsis: String,
    var scrolltext: String,
    var sharelink: String

) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readInt(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readString().toString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(logo)
        parcel.writeInt(background)
        parcel.writeString(judul)
        parcel.writeString(sinopsis)
        parcel.writeString(scrolltext)
        parcel.writeString(sharelink)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Game> {
        override fun createFromParcel(parcel: Parcel): Game {
            return Game(parcel)
        }

        override fun newArray(size: Int): Array<Game?> {
            return arrayOfNulls(size)
        }
    }
}