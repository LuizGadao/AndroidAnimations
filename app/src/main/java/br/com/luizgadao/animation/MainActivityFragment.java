package br.com.luizgadao.animation;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment implements Animation.AnimationListener {

    private static final int DEFAULT_DURATION = 2000;

    ImageView ball;
    Button btnScale, btnRotate, btnTransform, btnAlpha;
    Animation animApha, animRotate, animTrans, animScale;

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_main, container, false);

        ball = (ImageView) v.findViewById(R.id.ball);
        btnAlpha = (Button) v.findViewById(R.id.btnAlpha);
        btnRotate = (Button) v.findViewById(R.id.btnRotate);
        btnTransform = (Button) v.findViewById(R.id.btnTrans);
        btnScale = (Button) v.findViewById(R.id.btnScale);

        btnAlpha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //animApha = loadAnimation(R.anim.alpha);
                AlphaAnimation alphaAnimation = new AlphaAnimation(1, 0);
                alphaAnimation.setDuration(DEFAULT_DURATION);
                animApha = alphaAnimation;
                animApha.setAnimationListener(MainActivityFragment.this);
                ball.startAnimation(animApha);
            }
        });

        btnRotate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //animRotate = loadAnimation(R.anim.rotate);
                //RotateAnimation rotateAnim = new RotateAnimation(0, 360);
                RotateAnimation rotateAnim = new RotateAnimation(0, 360,
                        Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
                rotateAnim.setDuration(DEFAULT_DURATION);
                rotateAnim.setRepeatCount(2);
                rotateAnim.setRepeatMode(Animation.REVERSE);
                animRotate = rotateAnim;
                animRotate.setAnimationListener(MainActivityFragment.this);

                ball.startAnimation(animRotate);
            }
        });

        btnTransform.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //animTrans = loadAnimation(R.anim.transform);
                //anim to x with "dp"
                TranslateAnimation translateAnimation = new TranslateAnimation(0, getResources().getDimension(R.dimen.toX), 0, 0);
                translateAnimation.setDuration(DEFAULT_DURATION);
                animTrans = translateAnimation;
                animTrans.setAnimationListener(MainActivityFragment.this);
                ball.startAnimation(animTrans);
            }
        });

        btnScale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //animScale = loadAnimation(R.anim.scale);

                ScaleAnimation scaleAnimation = new ScaleAnimation(1, 2, 1, 2,
                        Animation.RELATIVE_TO_SELF, 0.5f,
                        Animation.RELATIVE_TO_SELF, 0.5f);
                scaleAnimation.setDuration(DEFAULT_DURATION);
                animScale = scaleAnimation;
                animScale.setAnimationListener(MainActivityFragment.this);
                ball.startAnimation(animScale);
            }
        });

        return v;
    }

    private Animation loadAnimation(int resAnim){
        Animation animation = AnimationUtils.loadAnimation(getContext(), resAnim);
        animation.setAnimationListener(this);
        return animation;
    }

    private void showToast(String text){
        Toast.makeText(getContext(), text, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onAnimationStart(Animation animation) {
        StringBuilder text = new StringBuilder();
        text.append("start-animation-");

        if (animation == animApha)
            text.append("alpha");
        else if (animation == animScale)
            text.append("scale");
        else if (animation == animRotate)
            text.append("rotate");
        else if (animation == animTrans)
            text.append("translate");

        showToast(text.toString());
    }

    @Override
    public void onAnimationEnd(Animation animation) {
        showToast("animation-end");
    }

    @Override
    public void onAnimationRepeat(Animation animation) {
        showToast("animation-repeat");
    }
}
