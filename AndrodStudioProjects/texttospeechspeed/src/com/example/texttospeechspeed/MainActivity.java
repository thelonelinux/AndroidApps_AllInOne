package com.example.texttospeechspeed;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import android.speech.tts.TextToSpeech;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
public class MainActivity extends Activity implements
TextToSpeech.OnInitListener,OnItemSelectedListener {
/** Called when the activity is first created. */

private TextToSpeech tts;
private Button buttonSpeak;
private EditText editText;
private Spinner speedSpinner,pitchSpinner;

private static String speed="Normal";
@Override
public void onCreate(Bundle savedInstanceState) {
super.onCreate(savedInstanceState);
setContentView(R.layout.activity_main);

tts = new TextToSpeech(this, this);
buttonSpeak = (Button) findViewById(R.id.button1);
editText = (EditText) findViewById(R.id.editText1);
speedSpinner = (Spinner) findViewById(R.id.spinner1);

//load data in spinner
loadSpinnerData();
speedSpinner.setOnItemSelectedListener(this);

//button click event
buttonSpeak.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View arg0) {
    	setSpeed();
        speakOut();
    }

});
}


@Override
public void onInit(int status) {

if (status == TextToSpeech.SUCCESS) {

    int result = tts.setLanguage(Locale.US);

    if (result == TextToSpeech.LANG_MISSING_DATA
            || result == TextToSpeech.LANG_NOT_SUPPORTED) {
        Log.e("TTS", "This Language is not supported");
    } else {
    	buttonSpeak.setEnabled(true);
        speakOut();
    }

} else { Log.e("TTS", "Initilization Failed!");}

}

@Override
public void onDestroy() {
// Don't forget to shutdown tts!
if (tts != null) {
    tts.stop();
    tts.shutdown();
}
super.onDestroy();
}

private void setSpeed(){
	if(speed.equals("Very Slow")){
		tts.setSpeechRate(0.1f);
	}
	if(speed.equals("Slow")){
		tts.setSpeechRate(0.5f);
	}
	if(speed.equals("Normal")){
		tts.setSpeechRate(1.0f);//default 1.0
	}
	if(speed.equals("Fast")){
		tts.setSpeechRate(1.5f);
	}
	if(speed.equals("Very Fast")){
		tts.setSpeechRate(2.0f);
	}
	//for setting pitch you may call 
	//tts.setPitch(1.0f);//default 1.0
}

private void speakOut() {
String text = editText.getText().toString();
tts.speak(text, TextToSpeech.QUEUE_FLUSH, null);
}

private void loadSpinnerData() {
	//Data for speed Spinner
    List<String> lables = new ArrayList<String>();
    lables.add("Very Slow");
    lables.add("Slow");
    lables.add("Normal");
    lables.add("Fast");
    lables.add("Very Fast");
    
    // Creating adapter for spinner
    ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, lables);

    // Drop down layout style - list view with radio button
    dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

    // attaching data adapter to spinner
    speedSpinner.setAdapter(dataAdapter);
    
  }

@Override
public void onItemSelected(AdapterView<?> parent, View view, int position,
        long id) {
    // On selecting a spinner item
    speed = parent.getItemAtPosition(position).toString();

    Toast.makeText(parent.getContext(), "You selected: " + speed,
            Toast.LENGTH_LONG).show();
}

@Override
public void onNothingSelected(AdapterView<?> arg0) {
   
}


@Override
public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
}

}
