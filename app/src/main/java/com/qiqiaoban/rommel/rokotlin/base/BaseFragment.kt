package com.qiqiaoban.rommel.rokotlin.base

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * Created by 梁文硕 on 2017/5/10.
 */

abstract class BaseFragment : Fragment() {

    protected var isShow: Boolean = false

    private var isPrepared: Boolean = false

    private var isFirst = true

    internal var mView: View? = null

    override fun setUserVisibleHint(isVisibleToUser: Boolean) {
        super.setUserVisibleHint(isVisibleToUser)
        if (isVisibleToUser) {
            isShow = true
            onVisible()
        } else {
            isShow= false
            onInVisible()
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        if (mView == null) {
            mView = inflater!!.inflate(layout, container, false)
            initView((mView)!!)
        }
        return mView
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        isPrepared = true

    }

    override fun onResume() {
        super.onResume()
        if (userVisibleHint) {
            userVisibleHint = true
        }
    }

    protected fun onVisible() {

        if (!isPrepared || !isVisible || !isFirst) {
            return
        }
        loadData()
        isFirst = false
    }

    override fun onDestroyView() {
        super.onDestroyView()
    }

    /**
     * 初始化视图布局
     * @return 返回需要加载的视图
     */
    abstract val layout: Int

    /**
     * 初始化布局控件
     * @param view
     */
    abstract fun initView(view: View)

    /**
     * 视图不可见的时候调用
     */
    abstract fun onInVisible()

    /**
     * 加载数据
     */
    abstract fun loadData()

    companion object {
        protected val LOG_FRAGMENT = "LOG_FRAGMENT"
    }
}
