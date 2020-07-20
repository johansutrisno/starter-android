package id.example.android.core.extensions

import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

/**
 * @Author by Johan Sutrisno
 * Bandung, on 27/04/2020
 */

inline fun <reified T : ViewModel> AppCompatActivity.activityViewModel() = lazy {
    ViewModelProvider(this).get(T::class.java)
}