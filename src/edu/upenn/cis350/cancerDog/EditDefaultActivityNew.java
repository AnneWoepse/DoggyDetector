package edu.upenn.cis350.cancerDog;

import java.lang.reflect.Field;

import android.app.Activity;
import android.graphics.Paint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.NumberPicker.OnValueChangeListener;

public class EditDefaultActivityNew extends Activity implements NumberPicker.OnValueChangeListener {
	
	public static final int ButtonClickActivity_ID = 1;

	NumberPicker settingsControlNumberPicker;
	NumberPicker settingsBenignNumberPicker;
	NumberPicker settingsMalignantNumberPicker;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_editdefaults_new);
		settingsControlNumberPicker = (NumberPicker) findViewById(R.id.settingsControlNumberPicker);
		settingsControlNumberPicker.setMinValue(1);
		settingsControlNumberPicker.setMaxValue(12);
		settingsControlNumberPicker.setValue(1);
		settingsControlNumberPicker.setOnValueChangedListener(this);
		// -16777216 is the number for black
		setNumberPickerTextColor(settingsControlNumberPicker, -16777216);
		
		settingsBenignNumberPicker = (NumberPicker) findViewById(R.id.settingsBenignNumberPicker);
		settingsBenignNumberPicker.setMinValue(1);
		settingsBenignNumberPicker.setMaxValue(12);
		settingsBenignNumberPicker.setValue(1);
		settingsBenignNumberPicker.setOnValueChangedListener(this);
		// -16777216 is the number for black
		setNumberPickerTextColor(settingsBenignNumberPicker, -16777216);
		
		settingsMalignantNumberPicker = (NumberPicker) findViewById(R.id.settingsMalignantNumberPicker);
		settingsMalignantNumberPicker.setMinValue(1);
		settingsMalignantNumberPicker.setMaxValue(12);
		settingsMalignantNumberPicker.setValue(1);
		settingsMalignantNumberPicker.setOnValueChangedListener(this);
		// -16777216 is the number for black
		setNumberPickerTextColor(settingsMalignantNumberPicker, -16777216);
	}

	@Override
	public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * Credit to StackOverflow
	 * @param numberPicker
	 * @param color
	 * @return
	 */
	public static boolean setNumberPickerTextColor(NumberPicker numberPicker, int color)
	{
	    final int count = numberPicker.getChildCount();
	    for(int i = 0; i < count; i++){
	        View child = numberPicker.getChildAt(i);
	        if(child instanceof EditText){
	            try{
	                Field selectorWheelPaintField = numberPicker.getClass()
	                    .getDeclaredField("mSelectorWheelPaint");
	                selectorWheelPaintField.setAccessible(true);
	                ((Paint)selectorWheelPaintField.get(numberPicker)).setColor(color);
	                ((EditText)child).setTextColor(color);
	                numberPicker.invalidate();
	                return true;
	            }
	            catch(NoSuchFieldException e){
	                Log.w("setNumberPickerTextColor", e);
	            }
	            catch(IllegalAccessException e){
	                Log.w("setNumberPickerTextColor", e);
	            }
	            catch(IllegalArgumentException e){
	                Log.w("setNumberPickerTextColor", e);
	            }
	        }
	    }
	    return false;
	}

}
