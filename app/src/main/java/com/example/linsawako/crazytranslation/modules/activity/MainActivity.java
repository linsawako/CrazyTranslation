package com.example.linsawako.crazytranslation.modules.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.linsawako.crazytranslation.R;
import com.example.linsawako.crazytranslation.base.mvpbase.BaseActivity;
import com.example.linsawako.crazytranslation.bean.Word;
import com.example.linsawako.crazytranslation.modules.contract.TranslateContract;
import com.example.linsawako.crazytranslation.modules.presenter.MainPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity<MainActivity, MainPresenter> implements TranslateContract.View {

    @BindView(R.id.commit)
    Button btn;
    @BindView(R.id.query_editText)
    EditText query_editText;

    private static final String TAG = "MainActivity";

    @Override
    protected MainPresenter createPresenter() {
        return new MainPresenter();
    }

    @Override
    protected void initView() {
        Log.d(TAG, "initView: ");
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @OnClick(R.id.commit)
    void translate() {
        Log.d(TAG, "translate: ");
        String word = query_editText.getText().toString();
        mPresenter.getExplain(word);
    }

    @Override
    public void showExplain(Word word) {
        Intent intent = new Intent(MainActivity.this, ExplainActivity.class);
        intent.putExtra("word_data", word);
        startActivity(intent);
    }
}
