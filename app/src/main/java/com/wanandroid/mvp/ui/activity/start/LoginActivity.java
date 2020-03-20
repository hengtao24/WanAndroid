package com.wanandroid.mvp.ui.activity.start;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputType;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;

import com.wanandroid.R;
import com.wanandroid.mvp.contract.start.LoginContract;
import com.wanandroid.mvp.model.entity.UserInfo;
import com.wanandroid.mvp.presenter.start.LoginPresenter;
import com.wanandroid.mvp.ui.activity.base.BaseActivity;
import com.wanandroid.mvp.ui.activity.base.BaseMVPActivity;
import com.wanandroid.mvp.ui.view.ToastUtil;
import com.wanandroid.util.WALog;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * login activity
 *
 * @author hengtao
 * @since 2019-10-19
 */
public class LoginActivity extends BaseMVPActivity<LoginPresenter> implements LoginContract.View {
	private static final String TAG = "LoginActivity";

	@BindView(R.id.et_username)
	EditText mEtUserName;

	@BindView(R.id.et_password)
	EditText mEtPassword;

	@BindView(R.id.login_clear)
	ImageView mLoginClearView;

	@BindView(R.id.pw_is_display)
	CheckBox mCheckBox;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	@Override
	public int initLayoutId() {
		return R.layout.activity_login;
	}

	@Override
	public void initData() {
		mToolbar.setTitle(getString(R.string.login));
		mToolbar.setNavigationOnClickListener(c -> finish());

		mEtUserName.addTextChangedListener(new TextWatcher() {
			@Override
			public void beforeTextChanged(CharSequence s, int start, int count, int after) {
			}

			@Override
			public void onTextChanged(CharSequence s, int start, int before, int count) {
				if (!TextUtils.isEmpty(s)) {
					mLoginClearView.setVisibility(View.VISIBLE);
				} else {
					mLoginClearView.setVisibility(View.INVISIBLE);
				}
			}

			@Override
			public void afterTextChanged(Editable s) {
			}
		});

		mEtPassword.addTextChangedListener(new TextWatcher() {
			@Override
			public void beforeTextChanged(CharSequence s, int start, int count, int after) {
			}

			@Override
			public void onTextChanged(CharSequence s, int start, int before, int count) {
				if (!TextUtils.isEmpty(s)) {
					mCheckBox.setVisibility(View.VISIBLE);
				} else {
					mCheckBox.setVisibility(View.INVISIBLE);
				}
			}

			@Override
			public void afterTextChanged(Editable s) {
			}
		});

		mCheckBox.setOnCheckedChangeListener( (view, isChecked) -> {
			if (isChecked) {
				mEtPassword.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
			} else {
				mEtPassword.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
			}
			mEtPassword.setSelection(mEtPassword.getText().toString().length());
		});
	}

	@OnClick({R.id.login_clear, R.id.bt_login, R.id.register})
	public void onViewClick(View view) {
		switch (view.getId()) {
			case R.id.login_clear:
				mEtUserName.setText("");
				break;
			case R.id.bt_login:
				handleLogin();
				break;
			case R.id.register:
				Intent intent = new Intent(this, RegisterActivity.class);
				startActivity(intent);
				break;
			default:
				WALog.logE(TAG, "no view id match");
				break;
		}
	}

	/**
	 * handle login
	 */
	private void handleLogin() {
		WALog.logI(TAG, "username :" + mEtUserName.getText().toString());
		WALog.logI(TAG, "password :" + mEtPassword.getText().toString());
		if (TextUtils.isEmpty(mEtUserName.getText().toString())) {
			showMessage(getString(R.string.no_username));
			WALog.logI(TAG, "no username");
		} else if(TextUtils.isEmpty(mEtPassword.getText().toString())) {
			showMessage(getString(R.string.no_password));
		} else {
			WALog.logI(TAG, mEtUserName.getText().toString() + " " + mEtPassword.getText().toString());
			mPresenter.login(mEtUserName.getText().toString(), mEtPassword.getText().toString());
		}
	}

	@Override
	protected LoginPresenter createPresenter() {
		return new LoginPresenter();
	}

	@Override
	public void onSuccess(UserInfo userInfo) {
		if (userInfo != null) {
			WALog.logI(TAG, userInfo.toString());
			ToastUtil.getInstance().showShort(getString(R.string.login_success));
		} else {
			ToastUtil.getInstance().showShort(getString(R.string.login_failed));
		}
	}
}
