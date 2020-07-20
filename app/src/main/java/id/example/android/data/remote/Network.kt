package id.example.android.data.remote

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import kotlin.reflect.KClass

/**
 * @Author by Johan Sutrisno
 * Bandung, on 27/04/2020
 */

object Network {
    private const val BASE_URL = ""

    fun <T : Any> create(service: KClass<T>): T {
        val mLoggingInterceptor = HttpLoggingInterceptor()
        mLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY

        val client = OkHttpClient.Builder()
            .addNetworkInterceptor(mLoggingInterceptor)
            .build()

        val retrofit = Retrofit.Builder()
            .client(client)
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        return retrofit.create(service.java)
    }
}