package intent;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.exemplo.R;

import fragment.ActFragments;
import fragment.ActFragmentsKotlin;

public class ActHome extends AppCompatActivity {

    Button vermelho, verde, azul, frags;

    Bundle pacoteVermei, pacotePalmeirense, pacoteAzul;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        achaViews();
        configuraPacote();
        colocaClick();
    }

    private void achaViews() {
        setContentView(R.layout.act_splash);
        vermelho = findViewById(R.id.button_vermelho);
        verde = findViewById(R.id.button_verde);
        azul = findViewById(R.id.button_azul);
        frags = findViewById(R.id.button_fragments);
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
        vermelho.setOnClickListener(vaPara(ActVermelha.class, pacoteVermei));
        verde.setOnClickListener(vaPara(ActVerde.class, pacotePalmeirense));
        azul.setOnClickListener(vaPara(ActAzul.class, pacoteAzul));
        frags.setOnClickListener(vaPara(ActFragmentsKotlin.class, new Bundle()));
    }

    private View.OnClickListener vaPara(final Class umaClasse, final Bundle pacote) {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Activity activity = (Activity) view.getContext();
                activity.startActivity(new Intent(activity, umaClasse).putExtras(pacote));
            }
        };
    }
}
