package com.ternence.gradient.view;

import com.ternence.gradient.R;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.AnimationDrawable;
import android.util.AttributeSet;
import android.view.View;

public class GradientView extends View {
    private int duration;
    private int draw;

    public GradientView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    public GradientView(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray a = getContext().obtainStyledAttributes(attrs, R.styleable.gradient, 0, 0);

        draw = a.getResourceId(R.styleable.gradient_transition_drawable, R.drawable.translate);
        duration = a.getInt(R.styleable.gradient_transition_duration, 3000);
        init();
    }

    public GradientView(Context context) {
        super(context);
        init();
    }

    private void init() {
        setBackgroundResource(draw);
        final AnimationDrawable frameAnimation = (AnimationDrawable) getBackground();
        frameAnimation.setEnterFadeDuration(duration);
        frameAnimation.setExitFadeDuration(duration);
        post(new Runnable() {
            public void run() {
                frameAnimation.start();
            }
        });
    }
}
