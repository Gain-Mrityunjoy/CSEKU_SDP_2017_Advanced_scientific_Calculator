package com.example.gain.advance_scientific_calculator;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.TextView;

public class DisplayResultActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		if (Main3Activity.row == 2) {
			setContentView(R.layout.activity_display_result_2);
		}
		else if (Main3Activity.row == 3) {
			setContentView(R.layout.activity_display_result_3);
		}
		else {
			setContentView(R.layout.activity_display_result_4);
		}

		// Show the Up button in the action bar.
		setupActionBar();
		setTitle("Answer");

		Intent intent = getIntent();

		if (Main3Activity.rational(this)) {
			MatrixRational resultParcelable = intent.getParcelableExtra(Main3Activity.RESULT);
			String[][] result = resultParcelable.getMatrix();
			ViewGroup displayResult = (ViewGroup) findViewById(R.id.result);

			for (int i=0; i<Main3Activity.row; i++) {
				ViewGroup row = (ViewGroup) displayResult.getChildAt(i);
				for (int j=0; j<Main3Activity.column; j++) {
					TextView element = (TextView) row.getChildAt(j);
					element.setText(result[i][j]);
				}
			}
		}

		else {
			Matrix resultParcelable = intent.getParcelableExtra(Main3Activity.RESULT);
			double[][] result = resultParcelable.getMatrix();
			ViewGroup displayResult = (ViewGroup) findViewById(R.id.result);

			for (int i=0; i<Main3Activity.row; i++) {
				ViewGroup row = (ViewGroup) displayResult.getChildAt(i);
				for (int j=0; j<Main3Activity.column; j++) {
					TextView element = (TextView) row.getChildAt(j);
					element.setText(result[i][j] + "");
				}
			}
		}
	}


	private void setupActionBar() {

		getActionBar().setDisplayHomeAsUpEnabled(true);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.display_result, menu);
		return true;
	}

	@Override
	public boolean  onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
			case android.R.id.home:
				// This ID represents the Home or Up button. In the case of this
				// activity, the Up button is shown. Use NavUtils to allow users
				// to navigate up one level in the application structure. For
				// more details, see the Navigation pattern on Android Design:

				NavUtils.navigateUpFromSameTask(this);
				return true;
		}
		return super.onOptionsItemSelected(item);
	}

}
