package com.qiqiaoban.rommel.rokotlin.utils


import com.orhanobut.logger.Logger
import com.qiqiaoban.rommel.rokotlin.BuildConfig

/**
 * Log统一管理类
 * Created by Reinhard Tristan Eugen Heydrich on 2016/10/28.
 */
class LogUtils private constructor() {
    init {
        /* cannot be instantiated */
        throw UnsupportedOperationException("cannot be instantiated")
    }

    companion object {
        private val TAG = "sys"

        // 下面四个是默认tag的函数
        fun i(msg: String) {
            if (BuildConfig.LOG_DEBUG)
                Logger.i(msg)
        }

        fun d(msg: String) {
            if (BuildConfig.LOG_DEBUG)
                Logger.d(msg)
        }

        fun e(msg: String) {
            if (BuildConfig.LOG_DEBUG)
                Logger.e(msg)
        }

        fun v(msg: String) {
            if (BuildConfig.LOG_DEBUG)
                Logger.v(msg)
        }

        fun json(msg: String) {
            if (BuildConfig.LOG_DEBUG)
                Logger.json(msg)
        }
    }
}
