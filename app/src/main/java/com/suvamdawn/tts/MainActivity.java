package com.suvamdawn.tts;

import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    TextView usText,bnText,hindiText;
    ImageView usSpeaker,bnSpeaker,hindiSpeaker;
    private TextToSpeech us_ttp,bn_ttp,hindi_ttp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        usText=findViewById(R.id.usText);
        usSpeaker=findViewById(R.id.usSpeaker);
        bnText=findViewById(R.id.bnText);
        bnSpeaker=findViewById(R.id.bnSpeaker);
        hindiText=findViewById(R.id.hindiText);
        hindiSpeaker=findViewById(R.id.hindiSpeaker);

        us_ttp=new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if(status != TextToSpeech.ERROR) {
                    us_ttp.setLanguage(Locale.UK);
                }
            }
        });
        bn_ttp=new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if(status != TextToSpeech.ERROR) {
                    bn_ttp.setLanguage(new Locale("bn"));
                }
            }
        });
        hindi_ttp=new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if(status != TextToSpeech.ERROR) {
                    hindi_ttp.setLanguage(new Locale("hindi"));
                }
            }
        });

        usSpeaker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String toSpeak = usText.getText().toString();
                us_ttp.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null);
            }
        });
        bnSpeaker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String toSpeak = bnText.getText().toString();
                bn_ttp.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null);
            }
        });
        hindiSpeaker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String toSpeak = hindiText.getText().toString();
                hindi_ttp.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null);
            }
        });
    }

    @Override
    public void onBackPressed() {
        if(us_ttp !=null){
            us_ttp.stop();
            us_ttp.shutdown();
        }
        if(bn_ttp !=null){
            bn_ttp.stop();
            bn_ttp.shutdown();
        }
        if(hindi_ttp !=null){
            hindi_ttp.stop();
            hindi_ttp.shutdown();
        }
        super.onBackPressed();
    }
    @Override
    public void onPause(){
        if(us_ttp !=null){
            us_ttp.stop();
            us_ttp.shutdown();
        }
        if(bn_ttp !=null){
            bn_ttp.stop();
            bn_ttp.shutdown();
        }
        if(hindi_ttp !=null){
            hindi_ttp.stop();
            hindi_ttp.shutdown();
        }
        super.onPause();
    }

}
