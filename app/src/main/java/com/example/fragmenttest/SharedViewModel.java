package com.example.fragmenttest;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class SharedViewModel extends ViewModel {
    private MutableLiveData<String> podatak = new MutableLiveData<>();
    private MutableLiveData<String> nazivPredmeta = new MutableLiveData<>();

    public void postaviPodatak(String noviPodatak) {
        podatak.setValue(noviPodatak);
    }

    public void postaviNazivPredmeta(String noviPodatak) {
        nazivPredmeta.setValue(noviPodatak);
    }

    public LiveData<String> dohvatiPodatak() {
        return podatak;
    }
    public LiveData<String> dohvatiNazivPredmeta() {
        return nazivPredmeta;
    }
}