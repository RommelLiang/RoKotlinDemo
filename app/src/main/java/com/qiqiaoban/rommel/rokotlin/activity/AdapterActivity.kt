package com.qiqiaoban.rommel.rokotlin.activity

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import com.qiqiaoban.rommel.rokotlin.R
import com.qiqiaoban.rommel.rokotlin.adapter.TestAdapter
import com.qiqiaoban.rommel.rokotlin.base.ToolBarActivity
import com.qiqiaoban.rommel.rokotlin.bean.BaseDate
import kotlinx.android.synthetic.main.activity_adapter.*
import java.util.*

class AdapterActivity : ToolBarActivity() {
    internal var mDatas = ArrayList<BaseDate>()
    var testAdapter :TestAdapter? = null
    override fun initDatas() {

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_adapter)
        val json = "{Code:1,Msg:OK,Data:userCCInfoList}"
        mDatas.add(BaseDate.objectFromData(json))
        mDatas.add(BaseDate.objectFromData(json))
        mDatas.add(BaseDate.objectFromData(json))
        mDatas.add(BaseDate.objectFromData(json))
        testAdapter = TestAdapter(test_listview, mDatas, R.layout.test_adapter)
        test_listview.adapter = testAdapter

    }
    companion object {
        fun launch(activity: Activity) {
            activity.startActivity(Intent(activity, AdapterActivity::class.java))
        }
    }
}
