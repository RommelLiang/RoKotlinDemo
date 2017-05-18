package com.qiqiaoban.rommel.rokotlin.activity

import android.os.Bundle
import com.qiqiaoban.rommel.rokotlin.R
import com.qiqiaoban.rommel.rokotlin.base.BaseActivity
import com.qiqiaoban.rommel.rokotlin.utils.LogUtils
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {
    var ma:Int=0
    val m = 15
    override fun initDatas() {
        LogUtils.e("initDatas")
        val message: String
        if (ma>0) {
            message = "Success"
        }
        else {
            message = "Failed"
        }
        LogUtils.e(message)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        LogUtils.e("before setContentView")
        setContentView(R.layout.activity_main)
        LogUtils.e("after setContentView")
        activity_main_button.setOnClickListener { AdapterActivity.launch(this) }
        ma = 15
        activity_main_button.text = sum(ma,ma)
    }

    private fun sum(a:Int, b:Int):String{
        return (b + a).toString()
    }
}
