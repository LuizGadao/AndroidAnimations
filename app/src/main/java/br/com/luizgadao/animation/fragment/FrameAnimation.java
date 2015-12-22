package br.com.luizgadao.animation.fragment;


import android.app.Fragment;
import android.graphics.drawable.AnimationDrawable;
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
public class FrameAnimation extends Fragment {

    ImageView imageView;

    public FrameAnimation() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_frame_animation, container, false);

        Button btn = (Button) v.findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AnimationDrawable animationDrawable = (AnimationDrawable) imageView.getBackground();

                if (animationDrawable.isRunning())
                    animationDrawable.stop();
                else{
                    animationDrawable.stop();
                    animationDrawable.start();
                }
            }
        });

        imageView = (ImageView) v.findViewById(R.id.imvAnimation);
        imageView.setBackgroundResource(R.drawable.frame);

        return v;
    }


}
