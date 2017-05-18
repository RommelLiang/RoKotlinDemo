package com.qiqiaoban.rommel.rokotlin.adapter;

import android.widget.AbsListView;

import com.qiqiaoban.rommel.rokotlin.R;
import com.qiqiaoban.rommel.rokotlin.bean.BaseDate;

import java.util.ArrayList;

/**
 * Created by 梁文硕 on 2017/5/18.
 */

public class TestAdapter extends RoAdpater<BaseDate> {
	public TestAdapter(AbsListView view, ArrayList<BaseDate> mDatas, int itemLayoutId) {
		super(view, mDatas, itemLayoutId);
	}

	@Override
	public void convert(AdapterHolder helper, BaseDate item, boolean isScrolling) {
		super.convert(helper, item, isScrolling);
		if (isScrolling) {

		} else {

		}
		helper.setText(R.id.tv,item.getMsg());
	}
}
