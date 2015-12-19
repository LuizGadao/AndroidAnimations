package br.com.luizgadao.animation;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment implements Animation.AnimationListener {

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
                animApha = loadAnimation(R.anim.alpha);
                ball.startAnimation(animApha);
            }
        });

        btnRotate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                animRotate = loadAnimation(R.anim.rotate);
                ball.startAnimation(animRotate);
            }
        });

        btnTransform.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //animTrans = loadAnimation(R.anim.transform);
                //anim to x with "dp"
                TranslateAnimation translateAnimation = new TranslateAnimation(0, getResources().getDimension(R.dimen.toX), 0, 0);//(TranslateAnimation) animTrans;
                translateAnimation.setDuration(1500);

                animTrans = translateAnimation;
                animTrans.setAnimationListener(MainActivityFragment.this);
                ball.startAnimation(animTrans);
            }
        });

        btnScale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                animScale = loadAnimation(R.anim.scale);
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
