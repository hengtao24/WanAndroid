package com.wanandroid.mvp.ui.activity.start;

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
import com.wanandroid.mvp.ui.activity.base.BaseMVPActivity;
import com.wanandroid.mvp.ui.view.ToastUtil;
import com.wanandroid.util.Constants;
import com.wanandroid.util.WALog;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * register activity
 *
 * @author hengtao
 * @since 2019-10-25
 */
public class RegisterActivity extends BaseMVPActivity<LoginPresenter> implements LoginContract.View {
	private static final String TAG = "RegisterActivity";

	@BindView(R.id.et_username)
	EditText mEtUsername;

	@BindView(R.id.et_password)
	EditText mEtPassword;

	@BindView(R.id.et_password_again)
	EditText mEtPasswordAgain;

	@BindView(R.id.register_clear)
	ImageView mRegisterClearView;

	@BindView(R.id.pw_is_display)
	CheckBox mCheckBox;

	@BindView(R.id.pw_is_display_again)
	CheckBox mPwAgainCheckBox;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	@Override
	public int initLayoutId() {
		return R.layout.activity_register;
	}

	@Override
	public void initData() {
		mToolbar.setTitle(getString(R.string.register));
		mToolbar.setNavigationOnClickListener(c -> finish());

		mEtUsername.addTextChangedListener(new TextWatcher() {
			@Override
			public void beforeTextChanged(CharSequence s, int start, int count, int after) {
			}

			@Override
			public void onTextChanged(CharSequence s, int start, int before, int count) {
				if (!TextUtils.isEmpty(s)) {
					mRegisterClearView.setVisibility(View.VISIBLE);
				} else {
					mRegisterClearView.setVisibility(View.INVISIBLE);
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

		mEtPasswordAgain.addTextChangedListener(new TextWatcher() {
			@Override
			public void beforeTextChanged(CharSequence s, int start, int count, int after) {

			}

			@Override
			public void onTextChanged(CharSequence s, int start, int before, int count) {
				if (!TextUtils.isEmpty(s)) {
					mPwAgainCheckBox.setVisibility(View.VISIBLE);
				} else {
					mPwAgainCheckBox.setVisibility(View.INVISIBLE);
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

		mPwAgainCheckBox.setOnCheckedChangeListener( (view, isChecked) -> {
			if (isChecked) {
				mEtPasswordAgain.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
			} else {
				mEtPasswordAgain.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
			}
			mEtPasswordAgain.setSelection(mEtPasswordAgain.getText().toString().length());
		});
	}

	@OnClick({R.id.register_clear, R.id.bt_register})
	public void onViewClick(View view) {
		switch (view.getId()) {
			case R.id.register_clear:
				mEtUsername.setText(Constants.EMPTY_STRING);
				break;
			case R.id.bt_register:
				handleRegister();
				break;
			default:
				WALog.logE(TAG, "no view id match");
				break;
		}
	}

	/**
	 * handle login
	 */
	private void handleRegister() {
		if (TextUtils.isEmpty(mEtUsername.getText().toString())) {
			showMessage(getString(R.string.no_username));
			WALog.logI(TAG, "no username");
		} else if(TextUtils.isEmpty(mEtPassword.getText().toString())) {
			showMessage(getString(R.string.no_password));
		} else if (TextUtils.isEmpty(mEtPasswordAgain.getText().toString())) {
			showMessage(getString(R.string.no_password_again));
		} else {
			mPresenter.register(mEtUsername.getText().toString(), mEtPassword.getText().toString(),
			    mEtPasswordAgain.getText().toString());
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
			ToastUtil.getInstance().showShort(getString(R.string.register_success));
		} else {
			ToastUtil.getInstance().showShort(getString(R.string.register_failed));
		}
	}
}
