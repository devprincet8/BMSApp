package com.soarmorrow.bms.view.agent.listing.model

import android.os.Parcel
import android.os.Parcelable

data class AgentItem(
    var title: String?,
    var address: String?,
    var tele: String?,
    var mob: String?,
    var email: String?,
    var contact_person: String?,
    var commission: Int
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readInt()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(title)
        parcel.writeString(address)
        parcel.writeString(tele)
        parcel.writeString(mob)
        parcel.writeString(email)
        parcel.writeString(contact_person)
        parcel.writeInt(commission)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<AgentItem> {
        override fun createFromParcel(parcel: Parcel): AgentItem {
            return AgentItem(parcel)
        }

        override fun newArray(size: Int): Array<AgentItem?> {
            return arrayOfNulls(size)
        }
    }
}
