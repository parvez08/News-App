package com.droid.smart_staff.newsapp.utils

import android.os.Handler
import android.os.Looper

class DeBouncer(private val delayMillis: Long, private val action: Runnable) {
    private val handler = Handler(Looper.getMainLooper())
    private var runnable: Runnable = Runnable { }

    fun debounce() {
        handler.removeCallbacks(runnable)
        handler.postDelayed(action, delayMillis)
    }
}

