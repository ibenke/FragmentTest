package com.example.fragmenttest;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

public class PredmetFragment extends Fragment {
    private SharedViewModel sharedViewModel;
    private TextView textViewImeStudenta;
    private EditText editTextPredmet;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sharedViewModel = new ViewModelProvider(requireActivity()).get(SharedViewModel.class);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_predmet, container, false);

        editTextPredmet = view.findViewById(R.id.etPredmet);

        editTextPredmet.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                sharedViewModel.postaviNazivPredmeta(editable.toString());
            }
        });

        textViewImeStudenta = view.findViewById(R.id.tvIme);
        textViewImeStudenta.setText("");
        sharedViewModel.dohvatiPodatak().observe(getViewLifecycleOwner(), novoIme -> textViewImeStudenta.setText(novoIme));

        return view;
    }
}