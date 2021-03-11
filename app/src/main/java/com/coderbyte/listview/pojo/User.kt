package com.coderbyte.listview.pojo

import android.os.Parcel
import android.os.Parcelable

class User(
    val id: Long,
    val name: String,
    val username: String,
    val address: Address,
    val phone: String,
    val website: String,
    val company: Company,
    val email: String
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readLong(),
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readParcelable(Address::class.java.classLoader)!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readParcelable(Company::class.java.classLoader)!!,
        parcel.readString()!!,
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeLong(id)
        parcel.writeString(name)
        parcel.writeString(username)
        parcel.writeParcelable(address, flags)
        parcel.writeString(phone)
        parcel.writeString(website)
        parcel.writeParcelable(company, flags)
        parcel.writeString(email)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<User> {
        override fun createFromParcel(parcel: Parcel): User {
            return User(parcel)
        }

        override fun newArray(size: Int): Array<User?> {
            return arrayOfNulls(size)
        }
    }

}