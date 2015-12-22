package br.com.luizgadao.animation.fragment;


import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.Fragment;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.BounceInterpolator;
import android.widget.Button;
import android.widget.ImageView;

import br.com.luizgadao.animation.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ObjectAnimatorXmlFragment extends Fragment {

    ImageView ball;
    Button btnScale, btnRotate, btnTranslate, btnAlpha, btnSet;
    View rootView;


    public ObjectAnimatorXmlFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View[] v = {inflater.inflate(R.layout.fragment_main, container, false)};

        //change background color
        rootView = v[0].findViewById(R.id.rootView);
        final int[] i = {0};
        rootView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ObjectAnimator animator;
                if (i[0] % 2 == 0) {
                    animator = ObjectAnimator.ofObject(rootView, "backgroundColor", new ArgbEvaluator(), Color.RED, Color.GREEN);
                }
                else
                    animator = ObjectAnimator.ofObject(rootView, "backgroundColor", new ArgbEvaluator(), Color.GREEN, Color.RED);

                i[0]++;
                animator.setDuration(1500);
                animator.start();
            }
        });

        ball = (ImageView) v[0].findViewById(R.id.ball);
        btnAlpha = (Button) v[0].findViewById(R.id.btnAlpha);
        btnRotate = (Button) v[0].findViewById(R.id.btnRotate);
        btnTranslate = (Button) v[0].findViewById(R.id.btnTrans);
        btnScale = (Button) v[0].findViewById(R.id.btnScale);
        btnSet = (Button) v[0].findViewById(R.id.btnSet);

        btnAlpha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //animate(ball, R.animator.alpha);
                ObjectAnimator animator = ObjectAnimator.ofFloat(ball, "alpha", 1.0f, 0.0f);
                animator.setDuration(1000);
                animator.start();
            }
        });

        btnRotate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //animate(ball, R.animator.rotate);
                ObjectAnimator animator = ObjectAnimator.ofFloat(ball, "rotationX", 0f, 360f);
                animator.setDuration(2000);
                animator.setInterpolator(new BounceInterpolator());
                animator.start();
            }
        });

        btnTranslate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //animate(ball, R.animator.translate);
                ObjectAnimator animator = ObjectAnimator.ofFloat(ball, "translationX", 0f, 150f);
                animator.setDuration(1000);
                animator.start();
            }
        });

        btnScale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //animate(ball, R.animator.scale);
                ObjectAnimator animator = ObjectAnimator.ofFloat(ball, "scaleX", 1f, 1.5f);
                animator.setDuration(1000);
                animator.start();
            }
        });

        btnSet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //animate(ball, R.animator.set);
                AnimatorSet set = new AnimatorSet();

                ObjectAnimator animator = ObjectAnimator.ofFloat(ball, "rotationX", 0f, 360f);
                animator.setDuration(2000);

                ObjectAnimator animator1 = ObjectAnimator.ofFloat(ball, "scaleX", 1f, 1.5f);
                animator.setDuration(1000);
                animator.setRepeatCount(3);
                animator.setRepeatMode(ValueAnimator.REVERSE);

                ObjectAnimator animator2 = ObjectAnimator.ofFloat(ball, "scaleY", 1f, 1.5f);
                animator2.setDuration(1000);
                //animator2.setRepeatCount(3);
                //animator2.setRepeatMode(ValueAnimator.REVERSE);

                AnimatorSet childSet = new AnimatorSet();
                childSet.setInterpolator(new BounceInterpolator());

                set.play(animator).before(childSet);
                childSet.play(animator1).with(animator2);

                set.start();
            }
        });

        return v[0];
    }

    private void animate(View view, int resId){
        Animator animator = AnimatorInflater.loadAnimator(getActivity(), resId);
        animator.setTarget(view);
        animator.start();
    }


}
