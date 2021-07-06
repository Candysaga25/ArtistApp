package eu.artistdemoapp.networkutils

import android.util.Log
import eu.artistdemoapp.BuildConfig

/**
 * Created by srshe on 03-July-2021
 */
object Logger {
    private val TAG = Logger::class.java.simpleName
    private const val isDebugEnabled = true
    fun info(msg: String?) {
        if (isDebugEnabled && BuildConfig.DEBUG) {
            Log.i(TAG, msg!!)
        }
    }

    fun error(msg: String?) {
        if (isDebugEnabled && BuildConfig.DEBUG) {
            Log.e(TAG, msg!!)
        }
    }

    fun debug(msg: String) {
        if (isDebugEnabled && BuildConfig.DEBUG) {
            logLargeString(msg)
        }
    }

    fun info(tag: String?, msg: String?) {
        if (isDebugEnabled && BuildConfig.DEBUG) {
            Log.i(tag, msg!!)
        }
    }

    fun error(tag: String?, msg: String?, e: Exception?) {
        if (isDebugEnabled && BuildConfig.DEBUG) {
            Log.e(tag, msg, e)
        }
    }

    fun debug(tag: String?, msg: String?) {
        if (isDebugEnabled && BuildConfig.DEBUG) {
            Log.d(tag, msg!!)
        }
    }

    private fun logLargeString(str: String) {
        if (str.length > 1024) {
            Log.i(TAG, str.substring(0, 1024))
            logLargeString(str.substring(1024))
        } else {
            Log.i(TAG, str) // continuation
        }
    }
}