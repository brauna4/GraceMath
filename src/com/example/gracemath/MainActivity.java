package com.example.gracemath;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends Activity {
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// Inflate the view
		setContentView(R.layout.mylist);
		
		//Create List View Object graceMenue
		final ListView graceMenu = (ListView) findViewById(R.id.mylistView);
		
		//Define and fill a string array with the subjects to chose from
		final String[] myString = new String[] {"Addition", "Subtraction", "Multiplication"};
		
		//Create an ArrayAdapter object 'aa'
		final ArrayAdapter<String> aa;
		
		//Define the ArrayAdapter Object (Context Context, int, String array)
		aa = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,
				myString);
		
		//Populates the listView graceMenu with the subjects
		graceMenu.setAdapter(aa);
		
		//Liten for a click of a list view item
		graceMenu.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				// TODO Auto-generated method stub
				Object o = graceMenu.getItemAtPosition(arg2);
				if(arg2 == 0){
					//Start Addition Activity
					Intent Add = new Intent(MainActivity.this, Addition.class);
					startActivity(Add);
				}
				if(arg2 == 1){
					//start Subtraction Activity
					Intent Sub = new Intent(MainActivity.this, Subtraction.class);
					startActivity(Sub);
				}
				if(arg2 == 2){
					//Start Multiplication Activity
					Intent Mult = new Intent(MainActivity.this, Multiplication.class);
					startActivity(Mult);  
				}
			}
			
		});
		
		
	}  

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	

}
