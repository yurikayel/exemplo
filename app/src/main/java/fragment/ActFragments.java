package fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.Toast;

import com.example.exemplo.R;

import static android.widget.Toast.makeText;

public class ActFragments extends AppCompatActivity implements ActivityContract {

    Button vermelho, verde, azul;

    Bundle pacoteVermei, pacotePalmeirense, pacoteAzul;

    FragmentManager manager = getSupportFragmentManager();

    Toast toast;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        achaViews();
        configuraPacote();
        colocaClick();
    }

    @SuppressLint("ShowToast")
    private void achaViews() {
        setContentView(R.layout.act_fragments);
        vermelho = findViewById(R.id.button_vermelho);
        verde = findViewById(R.id.button_verde);
        azul = findViewById(R.id.button_azul);
        toast = makeText(this, "Ver ActComunicaFrags", Toast.LENGTH_SHORT);
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
        clickBotao(verde, FragVerde.newInstance(pacotePalmeirense));
        clickBotao(azul, FragAzul.newInstance(pacoteAzul));
    }

    private void clickBotao(Button button, final Fragment fragment) {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View viewClicada) {
                carregaFrag(fragment);
            }
        });
    }

    private Void carregaFrag(Fragment fragment) {
        boolean fragVoltou = voltaSeTiver(fragment.getClass().getName());

        if (!fragVoltou) manager
                .beginTransaction()
                .replace(R.id.framelayout_amarelo, fragment)
                .addToBackStack(fragment.getClass().getName())
                .commit();
        return null;
    }

    private boolean voltaSeTiver(String fragName) {
        return manager.popBackStackImmediate(fragName, 0);
    }

    @Override
    public void setTextVermelho(String texto) {
        toast.show();
        hideSoftKeyBoard();
    }

    @Override
    public void setTextVerde(String texto) {
        toast.show();
        hideSoftKeyBoard();
    }

    @Override
    public void setTextAzul(String texto) {
        toast.show();
        hideSoftKeyBoard();
    }

    private void hideSoftKeyBoard() {
        InputMethodManager imm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);

        if (imm != null && getCurrentFocus() != null && imm.isAcceptingText()) { // verify if the soft keyboard is open
            imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
        }
    }
}
