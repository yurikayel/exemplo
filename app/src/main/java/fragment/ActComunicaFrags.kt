package fragment;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import com.example.exemplo.R;

import static custom.ExtFunKt.hideKeyBoard;

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
        hideKeyBoard(this);
    }

    @Override
    public void setTextVerde(String texto) {
        fragVerde.setTextVerde(texto);
        hideKeyBoard(this);
    }

    @Override
    public void setTextAzul(String texto) {
        fragAzul.setTextAzul(texto);
        hideKeyBoard(this);
    }
}
