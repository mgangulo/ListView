package com.coderbyte.listview.pojo

import android.os.Parcel
import android.os.Parcelable

class Address(val street: String, val zipcode: String, val city: String, val geo: Geo, val suite:String) :Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readParcelable(Geo::class.java.classLoader)!!,
        parcel.readString()!!
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(street)
        parcel.writeString(zipcode)
        parcel.writeString(city)
        parcel.writeParcelable(geo, flags)
        parcel.writeString(suite)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Address> {
        override fun createFromParcel(parcel: Parcel): Address {
            return Address(parcel)
        }

        override fun newArray(size: Int): Array<Address?> {
            return arrayOfNulls(size)
        }
    }
}