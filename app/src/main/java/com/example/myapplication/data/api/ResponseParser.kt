package com.example.myapplication.data.api

import com.google.gson.annotations.SerializedName


data class ResponseParser(

    @SerializedName("total_count") var totalCount: Int? = null,
    @SerializedName("incomplete_results") var incompleteResults: Boolean? = null,
    @SerializedName("items") var items: ArrayList<Items> = arrayListOf()

)