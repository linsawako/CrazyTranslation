package com.example.linsawako.crazytranslation.modules.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.example.linsawako.crazytranslation.R;
import com.example.linsawako.crazytranslation.bean.Word;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ExplainActivity extends AppCompatActivity {

    @BindView(R.id.phonetic_cardView)
    CardView phonetic_cardVew;

    @BindView(R.id.toolbar_layout)
    CollapsingToolbarLayout collapsingToolbarLayout;
    @BindView(R.id.phonetic)
    TextView phoneticText;
    @BindView(R.id.explains)
    TextView explainText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_explain);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ButterKnife.bind(this);

        Intent intent = getIntent();
        Word word = (Word)intent.getSerializableExtra("word_data");
        String response;

        collapsingToolbarLayout.setTitle(word.getQuery());

        if (word.getBasic() != null){
            StringBuilder stringBuilder = new StringBuilder();
            List<String> explainString = word.getBasic().getExplains();

            for (String string: explainString) {
                stringBuilder.append(string + "\n");
            }
            response = stringBuilder.toString();
            explainText.setText(response);

            String phonetic = "US;" + word.getBasic().getUsphonetic() + " UK:" + word.getBasic().getUkphonetic();
            phoneticText.setText(phonetic);
        }else{
            response = word.getTranslation().get(0);
            phonetic_cardVew.setVisibility(View.INVISIBLE);
        }
    }
}
