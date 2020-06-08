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

public class FragAzul extends Fragment {

    private EditText etAzul;
    private Button buttonAzul;
    private TextView textAzul;

    ActivityContract activity;

    public static FragAzul newInstance(Bundle bundle) {
        FragAzul frag = new FragAzul();
        frag.setArguments(bundle);
        return frag;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.frag_azul, container, false);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof ActivityContract) activity = (ActivityContract) context;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        etAzul = view.findViewById(R.id.et_azul);
        buttonAzul = view.findViewById(R.id.button_azul);
        textAzul = view.findViewById(R.id.texto_azul);

        buttonAzul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity.setTextVermelho(etAzul.getText().toString());
            }
        });
    }

    public void setTextAzul(String texto) {
        textAzul.setText(texto);
    }
}
