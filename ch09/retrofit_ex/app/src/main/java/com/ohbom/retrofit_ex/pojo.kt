package com.ohbom.retrofit_ex


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
//Dto 겸 pojo

data class hospitalResponse(
    @SerialName("hospitalInfo")
    val hospitalInfo:List<hospitalInfo>?
)

data class hospitalInfo(
    val head:List<Head>?,
    val data:List<Data>?
)

@Serializable
data class Head(
    @SerialName("currentCount")
    val currentCount: Int?,
    @SerialName("data")
    val `data`: List<Data>?, //아래 Data들이 들어있죠~
    @SerialName("matchCount")
    val matchCount: Int?,
    @SerialName("page")
    val page: Int?,
    @SerialName("perPage")
    val perPage: Int?,
    @SerialName("totalCount")
    val totalCount: Int?
)

@Serializable
data class Data(
    @SerialName("address")
    val address: String?,
    @SerialName("centerName")
    val centerName: String?,
    @SerialName("centerType")
    val centerType: String?,
    @SerialName("createdAt")
    val createdAt: String?,
    @SerialName("facilityName")
    val facilityName: String?,
    @SerialName("id")
    val id: Int?,
    @SerialName("lat")
    val lat: String?,
    @SerialName("lng")
    val lng: String?,
    @SerialName("org")
    val org: String?,
    @SerialName("phoneNumber")
    val phoneNumber: String?,
    @SerialName("sido")
    val sido: String?,
    @SerialName("sigungu")
    val sigungu: String?,
    @SerialName("updatedAt")
    val updatedAt: String?,
    @SerialName("zipCode")
    val zipCode: String?
)

