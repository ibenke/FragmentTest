package com.example.fragmenttest;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class SveFragment extends Fragment {
    private SharedViewModel sharedViewModel;

    private TextView tvImeStudenta;
    private TextView tvImePredmeta;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sharedViewModel = new ViewModelProvider(requireActivity()).get(SharedViewModel.class);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_sve, container, false);

        tvImeStudenta = view.findViewById(R.id.tvSveStudent);
        tvImePredmeta = view.findViewById(R.id.tvSvePredmet);

        tvImeStudenta.setText("");
        sharedViewModel.dohvatiPodatak().observe(getViewLifecycleOwner(), novoIme -> tvImeStudenta.setText(novoIme));

        tvImePredmeta.setText("");
        sharedViewModel.dohvatiNazivPredmeta().observe(getViewLifecycleOwner(), novoIme -> tvImePredmeta.setText(novoIme));

        return view;
    }
}