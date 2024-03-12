package com.trycatch_ragini.practice_papers;

import android.os.Bundle;

import androidx.activity.OnBackPressedCallback;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.trycatch_ragini.pratice_paper.R;


public class Aboutus_Fragment extends Fragment {

    LinearLayout headerlayout;
    TextView headername;




    public Aboutus_Fragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_aboutus_, container, false);
        setupOnBackPressed();
        return view;

    }

    private void setupOnBackPressed() {
        requireActivity().getOnBackPressedDispatcher().addCallback(new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                if (isEnabled()) {
                    FragmentTransaction fr = getFragmentManager().beginTransaction();
                    fr.replace(R.id.container, new Home_Fragment());
                    fr.commit();
                    setEnabled(false);

                }
            }
        });

    }
}