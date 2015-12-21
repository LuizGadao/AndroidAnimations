package br.com.luizgadao.animation;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;


/**
 * A simple {@link Fragment} subclass.
 */
public class InterpolatorFragment extends Fragment {


    public InterpolatorFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_interpolator, container, false);
        Button btn = (Button) v.findViewById(R.id.btn);
        final ImageView ball = (ImageView) v.findViewById(R.id.ball);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ball.startAnimation(AnimationUtils.loadAnimation(getActivity(), R.anim.interpolator));
            }
        });

        return v;
    }


}
