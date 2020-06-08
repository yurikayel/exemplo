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

public class FragVerde extends Fragment {

    private EditText etVerde;
    private Button buttonVerde;
    private TextView textVerde;

    ActivityContract activity;

    public static FragVerde newInstance(Bundle bundle) {
        FragVerde frag = new FragVerde();
        frag.setArguments(bundle);
        return frag;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.frag_verde, container, false);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof ActivityContract) activity = (ActivityContract) context;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        etVerde = view.findViewById(R.id.et_verde);
        buttonVerde = view.findViewById(R.id.button_verde);
        textVerde = view.findViewById(R.id.texto_verde);

        buttonVerde.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity.setTextAzul(etVerde.getText().toString());
            }
        });
    }

    public void setTextVerde(String texto) {
        textVerde.setText(texto);
    }
}
