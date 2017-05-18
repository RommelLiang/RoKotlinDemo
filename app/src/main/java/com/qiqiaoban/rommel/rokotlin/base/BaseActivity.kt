package com.qiqiaoban.rommel.rokotlin.base

import android.content.pm.ActivityInfo
import android.os.Bundle
import android.support.annotation.LayoutRes
import android.support.v7.app.AppCompatActivity
import android.view.View

/**
 * 所有Activity的基类(无toolbar)
 * Created by Reinhard Tristan Eugen Heydrich on 2016/10/28.
 */
abstract class BaseActivity : AppCompatActivity() {
    protected var mActivity: AppCompatActivity = this
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initDatas()
    }

    override fun setContentView(@LayoutRes layoutResID: Int) {

        super.setContentView(layoutResID)
        initView()
    }

    override fun setContentView(view: View) {
        super.setContentView(view)
        initView()
    }

    override fun onResume() {
        if (requestedOrientation != ActivityInfo.SCREEN_ORIENTATION_PORTRAIT) {
            requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        }
        super.onResume()

    }

    private fun initView() {
        //ButterKnife.bind(this);
    }

    protected abstract fun initDatas()
    override fun onDestroy() {
        super.onDestroy()
    }
}
