package in.codeaxe.application;

import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.applovin.mediation.MaxAd;
import com.applovin.mediation.MaxAdListener;
import com.applovin.mediation.MaxError;
import com.applovin.mediation.ads.MaxInterstitialAd;
import com.facebook.ads.Ad;
import com.facebook.ads.AdError;
import com.facebook.ads.AudienceNetworkAds;
import com.facebook.ads.InterstitialAd;
import com.facebook.ads.InterstitialAdListener;

import in.codeaxe.application.ads_activity.a;

public class SecondActivity extends AppCompatActivity
        implements MaxAdListener {
    MaxInterstitialAd interstitialAd;

    Button buttona, buttonb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        buttona = findViewById(R.id.a_activity_button);
        buttonb = findViewById(R.id.b_activity_button);
        interstitialAd = new MaxInterstitialAd( "YOUR_AD_UNIT_ID", this);
        interstitialAd.setListener( this );
        // Load the first ad
        interstitialAd.loadAd();




        // Open Another A Activity
        buttona.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                if ( interstitialAd.isReady() ) {
                    interstitialAd.showAd();
                    startActivity(new Intent(SecondActivity.this, in.codeaxe.application.ads_activity.a.class));
                }
            }
        });
        // Open Another B Activity
        buttonb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                load ads
                if ( interstitialAd.isReady() ) {
                    interstitialAd.showAd();
                    startActivity(new Intent(SecondActivity.this, in.codeaxe.application.ads_activity.b.class));
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