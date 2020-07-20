package id.example.android.core.extensions

import android.os.Bundle
import android.os.Parcelable
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

/**
 * @Author by Johan Sutrisno
 * Bandung, on 27/04/2020
 */

inline fun <reified T : ViewModel> Fragment.fragmentViewModel() = lazy {
    ViewModelProvider(this).get(T::class.java)
}

fun <T : Parcelable> Fragment.args() = lazy {
    arguments?.getParcelable<T>("args") ?: throw Exception("Should be not null")
}

fun Fragment.putArgs(data: Parcelable) {
    this.arguments = Bundle().apply {
        putParcelable("args", data)
    }
}