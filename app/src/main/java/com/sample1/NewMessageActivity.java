package com.sample1;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.nfc.Tag;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by chowd on 08-02-2018.
 */

public class NewMessageActivity extends AppCompatActivity {

    private static final String TAG = "MyActivity";

    Button dummy_button;
    EditText mobile_number,message_editText;
    TextView mobileNumber_TextView,message_textView;
    public String mobile_text,message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mobile_number = (EditText)findViewById(R.id.mobileNumber);
        message_editText = (EditText)findViewById(R.id.message);

        mobileNumber_TextView = (TextView)findViewById(R.id.mobileNumberTextView);
        message_textView = (TextView)findViewById(R.id.messageTextView);

        dummy_button = (Button) findViewById(R.id.dummyButton);
        dummy_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mobile_text = mobile_number.getText().toString();
                message = message_editText.getText().toString();
                onClickWhatsApp(mobile_text,message);
                Toast.makeText(getApplicationContext(),mobile_text,Toast.LENGTH_SHORT).show();
            }
        });

    }


    public void onClickWhatsApp(String number,String messageto) {
        Toast.makeText(getApplicationContext(),messageto,Toast.LENGTH_SHORT).show();
        /*Uri uri = Uri.parse("smsto:" + number);
        Intent sendIntent = new Intent(Intent.ACTION_SENDTO, uri);
        sendIntent.putExtra(Intent.EXTRA_TEXT,messageto);
        sendIntent.setPackage("com.whatsapp");
        startActivity(sendIntent);*/

        Uri mUri = Uri.parse("https://api.whatsapp.com/send?phone=" + number + "&text=" + messageto);
        Intent mIntent = new Intent("android.intent.action.VIEW", mUri);
        mIntent.setPackage("com.whatsapp");
        startActivity(mIntent);
    }

    /*boolean isWhatsappInstalled = whatsappInstalledOrNot("com.whatsapp");
        if (isWhatsappInstalled) {
        Uri uri = Uri.parse("smsto:" + mobile_number);
        Intent sendIntent = new Intent(Intent.ACTION_SENDTO, uri);
        sendIntent.putExtra(Intent.EXTRA_TEXT, "Hai Good Morning");
        sendIntent.setType("text/plain");
        sendIntent.setPackage("com.whatsapp");
        startActivity(sendIntent);
    } else {
        Toast.makeText(this, "WhatsApp not Installed",
                Toast.LENGTH_SHORT).show();
        Uri uri = Uri.parse("market://details?id=com.whatsapp");
        Intent goToMarket = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(goToMarket);

    }

    private boolean whatsappInstalledOrNot(String uri) {
        PackageManager pm = getPackageManager();
        boolean app_installed = false;
        try {
            pm.getPackageInfo(uri, PackageManager.GET_ACTIVITIES);
            app_installed = true;
        } catch (PackageManager.NameNotFoundException e) {
            app_installed = false;
        }
        return app_installed;
    }*/
}

