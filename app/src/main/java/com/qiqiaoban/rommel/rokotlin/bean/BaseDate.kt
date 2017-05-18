package com.qiqiaoban.rommel.rokotlin.bean

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import org.json.JSONException
import org.json.JSONObject
import java.util.*

/**
 * Created by 梁文硕 on 2017/5/18.
 */
class BaseDate {

    /**
     * Code : 1
     * Msg : OK
     * Data : {}
     */

    var code: Int = 0
    var msg: String? = null
    var data: Any? = null

    companion object {

        fun objectFromData(str: String): BaseDate {

            return Gson().fromJson(str, BaseDate::class.java)
        }

        fun objectFromData(str: String, key: String): BaseDate? {

            try {
                val jsonObject = JSONObject(str)

                return Gson().fromJson(jsonObject.getString(str), BaseDate::class.java)
            } catch (e: JSONException) {
                e.printStackTrace()
            }

            return null
        }

        fun arrayBaseDateFromData(str: String): List<BaseDate> {

            val listType = object : TypeToken<ArrayList<BaseDate>>() {

            }.type

            return Gson().fromJson<List<BaseDate>>(str, listType)
        }

        fun arrayBaseDateFromData(str: String, key: String): List<BaseDate> {

            try {
                val jsonObject = JSONObject(str)
                val listType = object : TypeToken<ArrayList<BaseDate>>() {

                }.type

                return Gson().fromJson<List<BaseDate>>(jsonObject.getString(str), listType)

            } catch (e: JSONException) {
                e.printStackTrace()
            }

            return ArrayList()


        }
    }
}
