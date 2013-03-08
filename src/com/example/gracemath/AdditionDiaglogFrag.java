package com.example.gracemath;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.EditText;

public class AdditionDiaglogFrag extends DialogFragment  {
	
	EditText input;
	AlertDialog.Builder builder;

	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		
		//Create an object of the alert dialog class
		builder = new AlertDialog.Builder(getActivity());
		
		//Get the activity and the intent that instantuated the AlertDialog
		//Get the string from extras
		Bundle extras = getActivity().getIntent().getExtras();
		String Smessage = extras.getString("question");
		
		builder.setTitle(Smessage);
		//builder.setMessage(Smessage);
		input = (EditText) getActivity().findViewById(R.id.ADDinput);
		
		//
		LayoutInflater inflater = getActivity().getLayoutInflater();
		builder.setView(inflater.inflate(R.layout.add_dial_layout, null))
		
				//Positive Button Clicked
		       .setPositiveButton("Enter", new DialogInterface.OnClickListener() {
			
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
		})
		
		       //Negative Button Clicked 
		      .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
			
			//Cancel the Dialog and return to the Addition view
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				dialog.cancel();
			}
		});
		
		
		
		return builder.create();
	}

	@Override
	public void onAttach(Activity activity) {
		// TODO Auto-generated method stub
		super.onAttach(activity);
	}
	
	

}
