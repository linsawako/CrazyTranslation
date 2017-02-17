package com.example.linsawako.crazytranslation.modules.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.example.linsawako.crazytranslation.R;
import com.example.linsawako.crazytranslation.bean.Word;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class ExplainActivity extends AppCompatActivity {

    @BindView(R.id.explain_text)
    TextView explainText;
    @BindView(R.id.fab)
    FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_explain);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ButterKnife.bind(this);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        Intent intent = getIntent();
        Word word = (Word)intent.getSerializableExtra("word_data");
        StringBuilder stringBuilder = new StringBuilder();
        List<String> explainString = word.getBasic().getExplains();

        for (String string: explainString) {
            stringBuilder.append(string + "\n");
        }

        explainText.setText(stringBuilder.toString());
    }
}
