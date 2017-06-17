package com.jaspal.impliciteintentsdemo;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button mDialButton, mMapButton, mWebButton, mPlayStoreButton,mEmailButton,mCalcuButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDialButton = (Button) findViewById(R.id.dailpad_button);
        mDialButton.setOnClickListener(this);
        mMapButton = (Button) findViewById(R.id.map_button);
        mMapButton.setOnClickListener(this);
        mWebButton = (Button) findViewById(R.id.web_button);
        mWebButton.setOnClickListener(this);
        mPlayStoreButton = (Button) findViewById(R.id.playstore);
        mPlayStoreButton.setOnClickListener(this);
        mEmailButton= (Button) findViewById(R.id.email_button);
        mEmailButton.setOnClickListener(this);
        mCalcuButton= (Button) findViewById(R.id.calulator_button);
        mCalcuButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.dailpad_button:
                Uri uri = Uri.parse("tel:959260370");
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_DIAL);
                intent.setData(uri);
                startActivity(intent);
                break;
            case R.id.map_button:
                Uri map_uri = Uri.parse("geo:31.1048,77.17?q=shimla");
                Intent map_intent = new Intent();
                map_intent.setAction(Intent.ACTION_VIEW);
                map_intent.setData(map_uri);
                startActivity(map_intent);
                break;
            case R.id.web_button:
                Uri web_uri = Uri.parse("http://www.sachtechsolution.com");
                Intent web_intent = new Intent();
                web_intent.setAction(Intent.ACTION_VIEW);
                web_intent.setData(web_uri);
                startActivity(web_intent);
                break;
            case R.id.playstore:
                Uri app_uri=Uri.parse("market://details?id=com.imo.android.imoim");
                Intent app_intent=new Intent();
                app_intent.setAction(Intent.ACTION_VIEW);
                app_intent.setData(app_uri);
                startActivity(app_intent);
                break;
            case R.id.email_button:

                String mails[]={"kapilsoni2013@gmail.com","gaba.rohit.111@gmail.com"};

                Uri mail_uri=Uri.parse("mailto:");
                Intent email_intent=new Intent();
                email_intent.setAction(Intent.ACTION_SEND);
                email_intent.setData(mail_uri);
                email_intent.setType("plain/text");

                email_intent.putExtra(Intent.EXTRA_SUBJECT,"My First mail from app");
                email_intent.putExtra(Intent.EXTRA_TEXT,"if you get this me.....send me reply.");
                email_intent.putExtra(Intent.EXTRA_EMAIL,mails);

                startActivity(email_intent);
                break;

            case R.id.calulator_button:
                Intent calcu_intent=new Intent(Intent.ACTION_MAIN);
                calcu_intent.addCategory(Intent.CATEGORY_APP_CALCULATOR);
                startActivity(calcu_intent);
                break;
        }
    }
}
