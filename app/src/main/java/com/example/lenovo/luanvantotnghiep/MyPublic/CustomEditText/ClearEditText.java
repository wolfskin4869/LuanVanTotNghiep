package com.example.lenovo.luanvantotnghiep.MyPublic.CustomEditText;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v4.content.ContextCompat;
import android.text.InputType;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.EditText;

import com.example.lenovo.luanvantotnghiep.R;

/**
 * Created by Lenovo on 6/11/2017.
 */

@SuppressLint("AppCompatCustomView")
public class ClearEditText extends EditText {

    Drawable crossX, nonCrossX;
    Boolean visible = false;
    Drawable drawable;

    public ClearEditText(Context context) {
        super(context);
        khoiTao();
    }

    public ClearEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        khoiTao();
    }

    public ClearEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        khoiTao();
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public ClearEditText(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        khoiTao();
    }

    private void khoiTao(){
        crossX = ContextCompat.getDrawable(getContext(), R.drawable.ic_clear_black_24dp).mutate();
        nonCrossX = ContextCompat.getDrawable(getContext(), android.R.drawable.screen_background_light_transparent).mutate();
        caiDat();
    }

    private void caiDat(){
        setInputType(InputType.TYPE_CLASS_TEXT);
        Drawable[] drawables = getCompoundDrawables();
        drawable = visible? crossX: nonCrossX;
        setCompoundDrawablesWithIntrinsicBounds(drawables[0],drawables[1],drawable,drawables[3]);
    }

    @Override
    protected void onTextChanged(CharSequence text, int start, int lengthBefore, int lengthAfter) {
        super.onTextChanged(text, start, lengthBefore, lengthAfter);
        if(lengthAfter==0 && start == 0){
            visible = false;
            caiDat();
        }else {
            visible = true;
            caiDat();
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if(MotionEvent.ACTION_DOWN == event.getAction() && event.getX() >= (getRight() - drawable.getBounds().width())){
            setText("");
        }
        return super.onTouchEvent(event);
    }
}
