package dbroomkt;

import android.view.View;

import com.example.exemplo.databinding.ActChamadaBinding;

import org.jetbrains.annotations.NotNull;

import base.ActBind;
import dbsqlite.DataAccessPessoa;
import dbsqlite.Pessoa;

public class ActivityChamadaRoom extends ActBind<ActChamadaBinding> {

    DataAccessPessoa accessPessoa;

    public ActivityChamadaRoom() {
        super(ActChamadaBinding.class);
    }

    @Override
    public void onBoundView(@NotNull final ActChamadaBinding binding) {
        accessPessoa = DatabaseBuilder.getAppDatabase(this).accessUsuario();

        binding.chamadaCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                accessPessoa.create(new Pessoa(0, "John", "Phillip", 18));
            }
        });

        binding.chamadaDestroy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                accessPessoa.delete(new Usuario((Integer.parseInt(binding.chamadaId.getText().toString()), "", "", 0));
            }
        });
    }
}
