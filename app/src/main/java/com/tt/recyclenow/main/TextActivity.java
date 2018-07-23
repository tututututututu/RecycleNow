package com.tt.recyclenow.main;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.tt.recyclenow.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TextActivity extends AppCompatActivity {

    @BindView(R.id.tv_titel)
    TextView tvTitel;
    @BindView(R.id.tv)
    TextView tv;
    @BindView(R.id.ll_back)
    LinearLayout llBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text);
        ButterKnife.bind(this);

        llBack.setOnClickListener(view -> finish());

        tvTitel.setText("联系客服");

        String string = getIntent().getStringExtra("text");

        tv.setText(string);
    }
}
