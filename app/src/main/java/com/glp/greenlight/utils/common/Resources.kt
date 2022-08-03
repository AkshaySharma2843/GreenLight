package com.glp.greenlight.utils.common

/**
 * Created by Akshay Sharma on 03-08-2022.
 */
data class Resource<out T> private constructor(val status: Status, val data: T?) {

    companion object {
        fun <T> success(data: T? = null): Resource<T> = Resource(Status.SUCCESS, data)

        fun <T> error(data: T? = null): Resource<T> = Resource(Status.ERROR, data)

        fun <T> loading(): Resource<T> = Resource(Status.LOADING, null)

        fun <T> unknown(data: T? = null): Resource<T> = Resource(Status.UNKNOWN, data)
    }
}
