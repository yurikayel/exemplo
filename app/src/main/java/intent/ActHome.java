package intent;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.exemplo.R;

import custom.LazyDialog;
import custom.LazyDialogKt;
import drawer.ActDrawer;
import fragment.ActComunicaFrags;
import fragment.ActFragments;
import navdrawer.ActNavDrawer;
import recycler.ActRecycler;
import revisao.ActCadastro;

import static custom.LazyDialogKt.lazyDialog;

public class ActHome extends AppCompatActivity {

    Button vermelho, verde, azul, frags, comunicaFrags, revisaoFrags, navDrawerA, navDrawerB, recycler, dialog;

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
        comunicaFrags = findViewById(R.id.button_comunica_frags);
        revisaoFrags = findViewById(R.id.button_revisao_frags);
        navDrawerA = findViewById(R.id.button_nav_a);
        navDrawerB = findViewById(R.id.button_nav_b);
        recycler = findViewById(R.id.button_comunica_recycler);
        dialog = findViewById(R.id.button_dialog);
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
        frags.setOnClickListener(vaPara(ActFragments.class, new Bundle()));
        comunicaFrags.setOnClickListener(vaPara(ActComunicaFrags.class, new Bundle()));
        revisaoFrags.setOnClickListener(vaPara(ActCadastro.class, new Bundle()));
        navDrawerA.setOnClickListener(vaPara(ActDrawer.class, new Bundle()));
        navDrawerB.setOnClickListener(vaPara(ActNavDrawer.class, new Bundle()));
        recycler.setOnClickListener(vaPara(ActRecycler.class, new Bundle()));
        dialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LazyDialog lazyDialog = lazyDialog(view.getContext(),"Título","Mensagem");
                lazyDialog.setOnPositive(new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                lazyDialog.setOnNeutral(new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                lazyDialog.setOnNegative(new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                lazyDialog.show();
            }
        });
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
