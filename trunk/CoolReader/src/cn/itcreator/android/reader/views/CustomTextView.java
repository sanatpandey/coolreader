package cn.itcreator.android.reader.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.PaintDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.text.TextPaint;
import android.view.View;

/**
 * 
 * Copyright mawei.81@gmail.com Blog: http://www.maweis.com
 * 
 * @author peter CustomTextView is a main View component for a reader which will
 *         be used to enjoy mobile read life
 * 
 */
public class CustomTextView extends View {

//	private String text;
	private String[] textArray;
	private int fontSize = 12;
	private int fontColor = Color.BLACK;
	private int lineHeight = 0;

	private int bgColor = Color.WHITE;

	private PaintDrawable paintDrawable;
	
	private TextPaint customPainter;

	private int alignTop = 70;
	private int alignLeft = 15;
	private int textHeight = 20;

	public CustomTextView(Context context) {
		super(context);
		// TODO Auto-generated constructor stub

		paintDrawable = new PaintDrawable();
		paintDrawable.getPaint().setColor(this.bgColor);
		this.customPainter = (TextPaint) paintDrawable.getPaint();

	}

	@Override
	protected void onDraw(Canvas canvas) {
		// TODO Auto-generated method stub
		for (int i = 0; i < this.textArray.length; i++) {
			canvas.drawText(this.textArray[i], this.alignLeft, this.alignTop
					+ this.textHeight * i, this.customPainter);
		}

		paintDrawable.draw(canvas);

	}

	public void setTextColor(int colorIntValue) {
		// TODO Auto-generated method stub
		this.fontColor = colorIntValue;
	}

	public int getLineHeight() {
		// TODO Auto-generated method stub
		return this.lineHeight;

	}

	public TextPaint getPaint() {
		// TODO Auto-generated method stub
		return this.customPainter;
	}

	public void setTextSize(int fontSize) {
		// TODO Auto-generated method stub
		this.fontSize = fontSize;

	}	

	public int getFontSize() {
		return fontSize;
	}

	public void setFontSize(int fontSize) {
		this.fontSize = fontSize;
	}

	public int getFontColor() {
		return fontColor;
	}

	public void setFontColor(int fontColor) {
		this.fontColor = fontColor;
	}

	

	public String[] getTextArray() {
		return textArray;
	}

	public void setTextArray(String[] textArray) {
		this.textArray = textArray;
	}

	public int getBgColor() {
		return bgColor;
	}

	public void setBgColor(int bgColor) {
		this.bgColor = bgColor;
	}

	public PaintDrawable getPaintDrawable() {
		return paintDrawable;
	}

	public void setPaintDrawable(PaintDrawable paintDrawable) {
		this.paintDrawable = paintDrawable;
	}

	public void setLineHeight(int lineHeight) {
		this.lineHeight = lineHeight;
	}

	public TextPaint getCustomPainter() {
		return customPainter;
	}

	public void setCustomPainter(TextPaint customPainter) {
		this.customPainter = customPainter;
	}

	public int getAlignTop() {
		return alignTop;
	}

	public void setAlignTop(int alignTop) {
		this.alignTop = alignTop;
	}

	public int getAlignLeft() {
		return alignLeft;
	}

	public void setAlignLeft(int alignLeft) {
		this.alignLeft = alignLeft;
	}

	public int getTextHeight() {
		return textHeight;
	}

	public void setTextHeight(int textHeight) {
		this.textHeight = textHeight;
	}

}
