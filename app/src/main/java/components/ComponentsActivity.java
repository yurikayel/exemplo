package components;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.example.exemplo.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

public class ComponentsActivity extends AppCompatActivity {

    EditText nome, email;

    ConstraintLayout layout;

    FloatingActionButton fabio;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_components);

        nome = findViewById(R.id.et_nome);
        email = findViewById(R.id.et_email);
        layout = findViewById(R.id.constraint_layout);
        fabio = findViewById(R.id.fabio);

        fabio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(nome.getText().toString().isEmpty() || email.getText().toString().isEmpty()){
                    Snackbar.make(layout, "Favor preencher ambos campos", Snackbar.LENGTH_LONG).show();
                } else {
                    Snackbar.make(layout, "Adicionado com sucesso!", Snackbar.LENGTH_LONG).show();
                }
            }
        });
    }
}
