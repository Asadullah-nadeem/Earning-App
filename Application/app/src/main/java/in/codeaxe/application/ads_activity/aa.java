package in.codeaxe.application.ads_activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.applovin.mediation.ads.MaxAdView;
import com.applovin.sdk.AppLovinSdk;
import com.applovin.sdk.AppLovinSdkConfiguration;

import in.codeaxe.application.R;
import in.codeaxe.application.SecondActivity;

public class aa extends AppCompatActivity {
    Button SecondActivitya;
    MaxAdView adView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aa);
        SecondActivitya = findViewById(R.id.button_aa);
        AppLovinSdk.getInstance( this ).setMediationProvider( "max" );
        AppLovinSdk.initializeSdk( this, new AppLovinSdk.SdkInitializationListener() {
            @Override
            public void onSdkInitialized(final AppLovinSdkConfiguration configuration)  {
                // AppLovin SDK is initialized, start loading ads
            }
        } );
        adView = findViewById(R.id.maxAdView_aa);
        adView.loadAd();


        // Open Another SecondActivity Activity
        SecondActivitya.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(aa.this, SecondActivity.class));

            }
        });

    }
}