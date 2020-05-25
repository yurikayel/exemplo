package base;

import android.os.Bundle;

import com.example.exemplo.databinding.ActSampleBinding;

import org.jetbrains.annotations.NotNull;

public class ActSampleJava extends ActBind<ActSampleBinding> {

    @NotNull
    @Override
    public ActSampleBinding getBinding() {
        return bind(this, ActSampleBinding.class);
    }

    @Override
    public void onExtras(@NotNull Bundle extras) {

    }

    @Override
    public void onBoundView(@NotNull ActSampleBinding binding) {
        binding.textViewTitulo.setText("qualquer coisa");
        binding.textViewSubTitulo.setText("qualquer coisa");
        binding.textViewMensagem.setText("qualquer coisa");
    }


}
