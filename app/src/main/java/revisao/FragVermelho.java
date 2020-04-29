package revisao;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.exemplo.R;

public class FragVermelho extends Fragment {

    private EditText etVermelho;
    private Button buttonVermelho;
    private TextView textVermelho;

    ActivityContract activity;

    public static FragVermelho newInstance(Bundle bundle) {
        FragVermelho frag = new FragVermelho();
        frag.setArguments(bundle);
        return frag;
    }

    // Cria o fragmento. SOMENTE!
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.frag_vermelho, container, false);
    }

    // Captura referência à Activity, que é um contexto, e trata como Contrato.
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        activity = (ActivityContract) context;
    }

    // Faz operações no fragmento APÓS ele já ter sido criado.
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        etVermelho = view.findViewById(R.id.et_vermelho);
        textVermelho = view.findViewById(R.id.texto_vermelho);

        buttonVermelho = view.findViewById(R.id.button_vermelho);
        buttonVermelho.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity.setTextVerde(etVermelho.getText().toString());
            }
        });
    }

    public void setTextVermelho(String texto) {
        textVermelho.setText(texto);
    }
}
