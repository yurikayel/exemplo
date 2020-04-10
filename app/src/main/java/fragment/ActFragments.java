package fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.exemplo.R;

import org.jetbrains.annotations.NotNull;

public class ActFragments extends AppCompatActivity {

    Button vermelho, verde, azul;

    Bundle pacoteVermei, pacotePalmeirense, pacoteAzul;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        achaViews();
        configuraPacote();
        colocaClick();
    }

    private void achaViews() {
        setContentView(R.layout.act_fragments);
        vermelho = findViewById(R.id.button_vermelho);
        verde = findViewById(R.id.button_verde);
        azul = findViewById(R.id.button_azul);
    }

    private void configuraPacote() {
        pacoteVermei = new Bundle();
        pacotePalmeirense = new Bundle();
        pacoteAzul = new Bundle();

        pacoteVermei.putString("chave", "Não, aí eu coloco a variavel");
        pacotePalmeirense.putString("chave", "Não tem o quê? Melhor não comentar");
        pacoteAzul.putString("chave", "Caneta Azul, Azul Caneeeetaaaaaaaa");
    }

    private void colocaClick() {
        clickBotao(vermelho, FragVermelho.newInstance(pacoteVermei));
        clickBotao(azul, FragAzul.newInstance(pacoteAzul));
        clickBotao(verde, FragVerde.newInstance(pacotePalmeirense));
    }

    private void clickBotao(Button button, Fragment frag) {
        button.setOnClickListener(carregaFragmento(frag));
    }

    @NotNull
    private View.OnClickListener carregaFragmento(final Fragment fragment) {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.framelayout_amarelo, fragment);
                transaction.commit();
            }
        };
    }

}
