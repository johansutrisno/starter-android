package id.example.android.core.extensions

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

/**
 * @Author by Johan Sutrisno
 * Bandung, on 27/04/2020
 */

inline fun <reified T> String.fromJson(): T {
    val type = object : TypeToken<T>() {}.type
    return Gson().fromJson(this, type)
}

inline fun <reified T> T.toJson(): String {
    val type = object : TypeToken<T>() {}.type
    return Gson().toJson(this, type)
}