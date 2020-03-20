package com.wanandroid.mvp.ui.activity.main;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.wanandroid.R;
import com.wanandroid.mvp.contract.main.MainContract;
import com.wanandroid.mvp.presenter.main.MainPresenter;
import com.wanandroid.mvp.ui.activity.base.BaseFragment;
import com.wanandroid.mvp.ui.activity.main.home.HomeFragment;
import com.wanandroid.util.WALog;

import java.util.ArrayList;
import java.util.List;

import androidx.fragment.app.Fragment;
import butterknife.BindView;
import me.yokeyword.fragmentation.SupportFragment;

/**
 * main fragment
 *
 * @author hengtao
 * @since 2019-11-05
 */
public class MainFragment extends BaseFragment<MainPresenter> implements MainContract.View {
	private static final String TAG = "MainFragment";

	private List<SupportFragment> mFragments = new ArrayList<>(5);

	@BindView(R.id.navigation)
	BottomNavigationView mBottomNavigationView;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		WALog.logI(TAG, " onCreate");
	}

	@Override
	public int initLayoutId() {
		return R.layout.fragment_main;
	}

	@Override
	public View initView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		return inflater.inflate(initLayoutId(), container, false);
	}

	@Override
	public void initData(Bundle savedInstanceState) {
		Fragment homeFragment = findChildFragment(HomeFragment.class);
		if (homeFragment == null) {
			mFragments.add(0, new HomeFragment());
		}
		mBottomNavigationView.setOnNavigationItemSelectedListener( view -> {
			switch (view.getItemId()) {
				case R.id.home:
					break;
				default:
					break;
			}
			return true;
		});
	}

	@Override
	protected MainPresenter createPresenter() {
		return new MainPresenter();
	}
}
