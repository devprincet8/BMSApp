package com.soarmorrow.bms.view.property.listing.model

import android.os.Parcel
import android.os.Parcelable
import com.soarmorrow.bms.view.property.details.model.ImagePickerItem

data class PropertyItem(
    var title: String?,
    var address: String?,
    var distance: String?,
    var imageList: List<ImagePickerItem>
):Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        TODO("imageList")
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(title)
        parcel.writeString(address)
        parcel.writeString(distance)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<PropertyItem> {
        override fun createFromParcel(parcel: Parcel): PropertyItem {
            return PropertyItem(parcel)
        }

        override fun newArray(size: Int): Array<PropertyItem?> {
            return arrayOfNulls(size)
        }
    }
}