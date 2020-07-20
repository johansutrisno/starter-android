package id.example.android.core

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

sealed class Load<out T> {
    object Uninitialized : Load<Nothing>()
    object Loading : Load<Nothing>()
    data class Fail<T>(val error: Throwable) : Load<T>() {
        private var consumed: Boolean = false
        fun oneShoot(block: () -> Unit) {
            if (!consumed) {
                block()
                consumed = true
            }
        }
    }

    data class Success<T : Any?>(val data: T) : Load<T>()
}

fun <T : Any?> load(block: suspend () -> T): Flow<Load<T>> = flow {
    emit(Load.Loading)
    try {
        val data = block()
        emit(Load.Success(data))
    } catch (e: Exception) {
        emit(Load.Fail(e))
    }
}