package com.book.skysearch.utilities;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.book.skysearch.R;

/**
 * Created by Farina Ali
 * utility class used in xml layout for showing blue buttons
 */
public class AppButton extends RelativeLayout {
    private String button_text;

    public AppButton(Context context) {
        super(context);
        setBackgroundColor(getResources().getColor(R.color.sky_blue));
    }

    public AppButton(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public TextView getTv() {
        return tv;
    }

    public void setTv(TextView tv) {
        this.tv = tv;
    }

    private TextView tv;

    public AppButton(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);

        setBackgroundColor(getResources().getColor(R.color.sky_blue));

        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.AppButton, defStyle, 0);
        button_text = a.getString(R.styleable.AppButton_text);

        LayoutParams params = new LayoutParams(LayoutParams.WRAP_CONTENT
                , LayoutParams.WRAP_CONTENT);
        params.addRule(CENTER_IN_PARENT);


        tv = new TextView(context);
        tv.setTextColor(getResources().getColor(R.color.white));
        tv.setLayoutParams(params);
        tv.setText(button_text);

        this.addView(tv);
    }
}
