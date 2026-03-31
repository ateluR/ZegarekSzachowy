package com.onaar.zegarekszachowy;

import android.os.CountDownTimer;
import android.widget.Button;

public class Gracz {
    private int ileSekund;
    private boolean czyAktywny;
    private CountDownTimer countDownTimer;
    private Button button;

    public Gracz(boolean czyAktywny, Button button) {
        this.czyAktywny = czyAktywny;
        this.button = button;
        ileSekund= 180;
        if(czyAktywny) {
            uruchomZegar();
        }
    }
    public void odwrocAktywnosc(){
        czyAktywny = !czyAktywny;
        if(czyAktywny){
            uruchomZegar();
        }
        else{
            zatrzymajZegar();
        }
    }
    private void uruchomZegar(){
        countDownTimer = new CountDownTimer(ileSekund*1000,1000) {
            @Override
            public void onTick(long l) {
            ileSekund= (int)l/1000;
            button.setText(String.valueOf(ileSekund));
            }
            @Override
            public void onFinish() {

            }


        };
        countDownTimer.start();
    }
    private void zatrzymajZegar(){
        countDownTimer.cancel();
    }
}
