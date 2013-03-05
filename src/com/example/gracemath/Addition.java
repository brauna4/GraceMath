package com.example.gracemath;

import java.util.Random;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

public class Addition extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.addition);
		
		ListView AdView = (ListView) findViewById(R.id.addList);
		
		String[] problem = new String[10];
		int[] corrections = new int[10];
		int[] input = new int[10];
		for(int i = 0; i<10; i++){
			Random num = new Random();
			int num1 = num.nextInt(20);
			int num2 = num.nextInt(20);
			problem[i] = Integer.toString(num1) + " + " + Integer.toString(num2) + " = ";
			corrections[i] = num1 + num2;
		}
		
		ArrayAdapter<String> aa = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, problem);
		AdView.setAdapter(aa);
		
		AdView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				// TODO Auto-generated method stub
				Intent addDiag = new Intent(Addition.this, AdditionDiaglogFrag.class);
				startActivityForResult(addDiag, 0);
			}
		} );
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);
	}
	
	

}
