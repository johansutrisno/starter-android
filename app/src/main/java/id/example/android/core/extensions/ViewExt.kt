package id.example.android.core.extensions

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.annotation.LayoutRes
import com.bumptech.glide.Glide
import com.google.android.material.snackbar.Snackbar

/**
 * @Author by Johan Sutrisno
 * Bandung, on 27/04/2020
 */

fun View.visible(isVisible: Boolean) {
    visibility = if (isVisible) View.VISIBLE else View.GONE
}

fun ViewGroup.inflate(@LayoutRes layoutId: Int, attachToRoot: Boolean = false): View {
    return LayoutInflater.from(context).inflate(layoutId, this, attachToRoot)
}

fun ImageView.loadImage(context: Context, url: String) {
    Glide.with(context)
        .load(url)
        .centerCrop()
        .into(this)
}

fun View.showSnackBarDefault(message: String, duration: Int = 5000) {
    Snackbar.make(this, message, duration)
        .setAction("OK") {}
        .setActionTextColor(Color.WHITE)
        .show()
}

fun View.showSnackBarWithColor(
    message: String,
    textColor: Int,
    backgroundColor: Int,
    duration: Int = 5000
) {
    val snackView = Snackbar.make(this, message, duration)
    snackView.apply {
        setActionTextColor(textColor)
        setBackgroundColor(backgroundColor)
        setAction("OK") {}
        setActionTextColor(textColor)
        show()
    }
}