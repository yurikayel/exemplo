package fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

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

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.frag_vermelho, container, false);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof ActivityContract) activity = (ActivityContract) context;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        etVermelho = view.findViewById(R.id.et_vermelho);
        buttonVermelho = view.findViewById(R.id.button_vermelho);
        textVermelho = view.findViewById(R.id.texto_vermelho);

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
