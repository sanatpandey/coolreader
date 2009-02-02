/**
 * Copyright (C) 2009 Android OS Community Inc (http://androidos.cc/bbs).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
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
/**
 * This class for file browser
 * 
 * @author Wang XinFeng
 * @version 1.0
 */
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
