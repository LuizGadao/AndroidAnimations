package br.com.luizgadao.animation.fragment;


import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import br.com.luizgadao.animation.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ObjectAnimatorXmlFragment extends Fragment {

    ImageView ball;
    Button btnScale, btnRotate, btnTranslate, btnAlpha, btnSet;


    public ObjectAnimatorXmlFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_main, container, false);

        ball = (ImageView) v.findViewById(R.id.ball);
        btnAlpha = (Button) v.findViewById(R.id.btnAlpha);
        btnRotate = (Button) v.findViewById(R.id.btnRotate);
        btnTranslate = (Button) v.findViewById(R.id.btnTrans);
        btnScale = (Button) v.findViewById(R.id.btnScale);
        btnSet = (Button) v.findViewById(R.id.btnSet);

        btnAlpha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                animate(ball, R.animator.alpha);
            }
        });

        btnRotate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                animate(ball, R.animator.rotate);
            }
        });

        btnTranslate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                animate(ball, R.animator.translate);
            }
        });

        btnScale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                animate(ball, R.animator.scale);
            }
        });

        btnSet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                animate(ball, R.animator.set);
            }
        });

        return v;
    }

    private void animate(View view, int resId){
        Animator animator = AnimatorInflater.loadAnimator(getActivity(), resId);
        animator.setTarget(view);
        animator.start();
    }


}
