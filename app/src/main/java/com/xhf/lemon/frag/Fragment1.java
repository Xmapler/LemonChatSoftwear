package com.xhf.lemon.frag;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.xhf.lemon.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.rong.imkit.RongIM;

/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment1 extends Fragment {

    @BindView(R.id.f1_click)
    Button f1Click;
    private View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = View.inflate(getActivity(), R.layout.fragment_fragment1, null);

        ButterKnife.bind(this, view);
        return view;
    }

    @OnClick(R.id.f1_click)
    public void onClick() {
        if (RongIM.getInstance() != null) {
            RongIM.getInstance().startPrivateChat(getActivity(), "24", "hello");
        }
    }
}
