package com.booster.codetestapp.data.provider

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory

class MoshiProvider {

    companion object {
        fun build(): Moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
    }
}