package com.example.gracemath;

import java.io.ObjectOutputStream.PutField;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.webkit.WebView.FindListener;
import android.widget.EditText;
import android.widget.FrameLayout;

public class AdditionDiaglogFrag extends DialogFragment  {

	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		return super.onCreateDialog(savedInstanceState);
		
		//Create an object of the alert dialog class
		AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
		//Get the activity and the intent that instantuated the AlertDialog
		//Get the string from extras
		Bundle extras = getActivity().getIntent().getExtras();
		String Smessage = extras.getString("question");
		
		AlertDialog alert = builder.create();
		LayoutInflater inflater = getLayoutInflater();
		FrameLayout fl = (FrameLayout)alert.findViewById(android.R.id.body);
		fl.addView(inflater.inflate(R.layout.add_dial_layout, fl, false));
		
		
		
		
		builder.setTitle(R.string.dialogtitle);
		builder.setMessage(Smessage);
		
		EditText input = (EditText)alert.findViewById(R.id.ADDinput);
		builder.setView(input);
		
		//Positive Button Clicked
		builder.setPositiveButton("Enter", new DialogInterface.OnClickListener() {
			
			//Takes the text from EditText and puts into the Intent to be extracted in the
			//On Activity Result
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				String answer = input.getText().toString();
				Intent data = new Intent();
				data.putExtra("answer", answer);
				getActivity().setResult(-1, data);
				dialog.cancel();
			}
		});
		
		//Negative Button Clicked 
		builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
			
			//Cancel the Dialog and return to the Addition view
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				dialog.cancel();
			}
		});
		
		return builder.create();
	}
	
	

}
