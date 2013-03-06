package com.example.gracemath;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;

public class AdditionDiaglogFrag extends DialogFragment {

	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		return super.onCreateDialog(savedInstanceState);
		AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
		builder.setTitle(R.string.dialogtitle);
		
		Bundle extras = getIntent().getExtras();
		
		String Smessage = extras.getString("question");
		builder.setMessage(Smessage);
		final EditText input = new EditText(this);
		builder.setView(input);
		builder.setPositiveButton("Enter", new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				String answer = input.getText().toString();
				
			}
		});
	}
	
	

}
