package cn.itcreator.android.reader;

import cn.itcreator.android.reader.paramter.CR;
import cn.itcreator.android.reader.paramter.Constant;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class FontSetActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.fontset);
		
		final TextView viewfont = (TextView) findViewById(R.id.viewfont);
		viewfont.setTextSize(CR.textSize);
		
		
		//字体大小设置开始
		final Spinner fontsizespinner = (Spinner) findViewById(R.id.fontsizespinner);
		ArrayAdapter<CharSequence> fontsize = ArrayAdapter.createFromResource(
				getApplicationContext(), R.array.fontsize,
				android.R.layout.simple_spinner_item);
		
		fontsizespinner.setAdapter(fontsize);
		fontsizespinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){

			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long loation) {
				CR.textSize =Integer.parseInt(fontsizespinner.getSelectedItem().toString());
				viewfont.setTextSize(CR.textSize);
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
			}
			
		});
		
		
		//文字颜色设置开始
		final Spinner fontcolorspinner = (Spinner) findViewById(R.id.fontcolorspinner);
		
		ArrayAdapter<CharSequence> fontcolor = ArrayAdapter.createFromResource(
				getApplicationContext(), R.array.colors,
				android.R.layout.simple_spinner_item);
		
		fontcolorspinner.setAdapter(fontcolor);
		
		fontcolorspinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){

			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				CR.textColor = fontcolorspinner.getSelectedItem().toString();
				if (Constant.RED.equals(CR.textColor)) {
					viewfont.setTextColor(Color.RED);
				}
				if (Constant.GRAY.equals(CR.textColor)) {
					viewfont.setTextColor(Color.GRAY);
				}
				if (Constant.YELLOW.equals(CR.textColor)) {
					viewfont.setTextColor(Color.YELLOW);
				}
				if (Constant.GREEN.equals(CR.textColor)) {
					viewfont.setTextColor(Color.GREEN);
				}
				if (Constant.BLUE.equals(CR.textColor)) {
					viewfont.setTextColor(Color.BLUE);
				}
				if (Constant.BLACK.equals(CR.textColor)) {
					viewfont.setTextColor(Color.BLACK);
				}
				if (Constant.WHITE.equals(CR.textColor)) {
					viewfont.setTextColor(Color.WHITE);
				}
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				
			}
			
		});
		
		
		//按钮返回事件开始
		Button go = (Button) findViewById(R.id.gotoreader);
		
		go.setOnClickListener(new View.OnClickListener(){

			@Override
			public void onClick(View v) {
				Intent mIntent = new Intent(getApplicationContext(),
						CopyOfReaderCanvas.class);
				CR.textColor = fontcolorspinner.getSelectedItem().toString();
				CR.textSize =Integer.parseInt(fontsizespinner.getSelectedItem().toString());
				setResult(RESULT_OK, mIntent);
				finish();
			}
			
		});
	}
}
