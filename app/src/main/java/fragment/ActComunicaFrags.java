package fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.inputmethod.InputMethodManager;

import com.example.exemplo.R;

public class ActComunicaFrags extends AppCompatActivity implements ActivityContract {

    FragVermelho fragVermelho;
    FragVerde fragVerde;
    FragAzul fragAzul;

    FragmentManager fragManager = getSupportFragmentManager();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_comunica_frags);
        fragVermelho = (FragVermelho) fragManager.findFragmentById(R.id.frag_vermelho);
        fragVerde = (FragVerde) fragManager.findFragmentById(R.id.frag_verde);
        fragAzul = (FragAzul) fragManager.findFragmentById(R.id.frag_azul);
    }

    @Override
    public void setTextVermelho(String texto) {
        fragVermelho.setTextVermelho(texto);
        hideSoftKeyBoard();
    }

    @Override
    public void setTextVerde(String texto) {
        fragVerde.setTextVerde(texto);
        hideSoftKeyBoard();
    }

    @Override
    public void setTextAzul(String texto) {
        fragAzul.setTextAzul(texto);
        hideSoftKeyBoard();
    }


    private void hideSoftKeyBoard() {
        InputMethodManager imm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);

        if (imm != null && getCurrentFocus() != null && imm.isAcceptingText()) { // verify if the soft keyboard is open
            imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
        }
    }
}
