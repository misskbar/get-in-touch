package com.codesign.karenbarreto.getintouch.adapters

import android.os.Parcel
import com.karenbarreto.core.helpers.KParcelable
import com.karenbarreto.core.helpers.parcelableCreator

data class RepositoryView(val repositoryName: String, val repositoryDescription: String,val repositoryForks: String,val repositoryStars: String) :
        KParcelable {
    companion object {
        @JvmField val CREATOR = parcelableCreator(
                ::RepositoryView)
    }

    constructor(parcel: Parcel) : this(parcel.readString(), parcel.readString(),parcel.readString(),parcel.readString())

    override fun writeToParcel(dest: Parcel, flags: Int) {
        with(dest) {
            writeString(repositoryName)
            writeString(repositoryDescription)
            writeString(repositoryForks)
            writeString(repositoryStars)
        }
    }
}