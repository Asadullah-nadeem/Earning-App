package in.codeaxe.application.ads_activity;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.applovin.mediation.MaxAd;
import com.applovin.mediation.MaxAdListener;
import com.applovin.mediation.MaxError;
import com.applovin.mediation.ads.MaxAdView;
import com.applovin.mediation.ads.MaxInterstitialAd;
import com.applovin.sdk.AppLovinSdk;
import com.applovin.sdk.AppLovinSdkConfiguration;

import in.codeaxe.application.R;
import in.codeaxe.application.SecondActivity;

public class b extends AppCompatActivity
        implements MaxAdListener {
    Button SecondActivityb , buttonbb;
    MaxAdView adView;
    MaxInterstitialAd interstitialAd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b);
        SecondActivityb = findViewById(R.id.back_b);
        buttonbb = findViewById(R.id.bb_activity_button);


        interstitialAd = new MaxInterstitialAd( "YOUR_AD_UNIT_ID", this);
        interstitialAd.setListener( this );
        // Load the first ad
        interstitialAd.loadAd();
        AppLovinSdk.getInstance( this ).setMediationProvider( "max" );
        AppLovinSdk.initializeSdk( this, new AppLovinSdk.SdkInitializationListener() {
            @Override
            public void onSdkInitialized(final AppLovinSdkConfiguration configuration)  {
                // AppLovin SDK is initialized, start loading ads
            }
        } );
        adView = findViewById(R.id.maxAdView_b);
        adView.loadAd();




        // Open Another SecondActivity Activity
        SecondActivityb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(b.this, SecondActivity.class));

            }
        });
        // Open Another BB Activity
        buttonbb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ( interstitialAd.isReady() ) {
                    interstitialAd.showAd();
                    startActivity(new Intent(b.this, in.codeaxe.application.ads_activity.bb.class));
                }
            }
        });
    }
    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this).setIcon(android.R.drawable.ic_dialog_alert).setTitle("Exit")
                .setMessage("Are you sure you want to exit?")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                }).setNegativeButton("No", null).show();
    }


    @Override
    public void onAdLoaded(MaxAd maxAd) {

    }

    @Override
    public void onAdDisplayed(MaxAd maxAd) {

    }

    @Override
    public void onAdHidden(MaxAd maxAd) {

    }

    @Override
    public void onAdClicked(MaxAd maxAd) {

    }

    @Override
    public void onAdLoadFailed(String s, MaxError maxError) {

    }

    @Override
    public void onAdDisplayFailed(MaxAd maxAd, MaxError maxError) {

    }
}