package com.example.lenovo.luanvantotnghiep.CustomView;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
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
public class PasswordEditText extends EditText {

    Drawable eye, eyeStrike;

    Boolean visible = false;
    Boolean useStrike = false;
    Drawable drawable;
    int ALPHA = (int) (255 * .55f);

    public PasswordEditText(Context context) {
        super(context);
        khoiTao(null);
    }

    public PasswordEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        khoiTao(attrs);
    }

    public PasswordEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        khoiTao(attrs);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public PasswordEditText(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        khoiTao(attrs);
    }

    private void khoiTao(AttributeSet attrs){
        if(attrs!=null){
            TypedArray typedArray = getContext().getTheme().obtainStyledAttributes(attrs,R.styleable.PasswordEditText,0,0);
            this.useStrike = typedArray.getBoolean(R.styleable.PasswordEditText_useStrike, false);
        }
        eye = ContextCompat.getDrawable(getContext(), R.drawable.ic_visibility_black_24dp).mutate();
        eyeStrike = ContextCompat.getDrawable(getContext(),R.drawable.ic_visibility_off_black_24dp).mutate();
        caiDat();
    }

    private void caiDat(){
        setInputType(InputType.TYPE_CLASS_TEXT | (visible? InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD:InputType.TYPE_TEXT_VARIATION_PASSWORD));
        Drawable[] drawables = getCompoundDrawables();
        drawable = useStrike && !visible? eyeStrike : eye;
        drawable.setAlpha(ALPHA);
        setCompoundDrawablesWithIntrinsicBounds(drawables[0], drawables[1],drawable ,drawables[3]);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if(event.getAction() == MotionEvent.ACTION_UP && event.getX() >= (getRight() - drawable.getBounds().width())){
            visible = !visible;
            caiDat();
            invalidate();
        }
        return super.onTouchEvent(event);
    }
}
