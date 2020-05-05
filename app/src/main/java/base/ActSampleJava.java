package base;

import android.arch.lifecycle.ViewModel;
import android.os.Bundle;

import com.example.exemplo.databinding.ActSampleBinding;

import org.jetbrains.annotations.NotNull;

public class ActSampleJava extends ActBind<ActSampleBinding> {

    public ActSampleJava() {
        super(ActSampleBinding.class);
        //setViewModel();
    }

    @Override
    public void onExtras(@NotNull Bundle extras) {

    }

    @Override
    public void onViewModel(@NotNull ViewModel viewModel) {

    }

    @Override
    public void onBoundView(@NotNull ActSampleBinding binding) {
        binding.textViewTitulo.setText("qualquer coisa");
        binding.textViewSubTitulo.setText("qualquer coisa");
        binding.textViewMensagem.setText("qualquer coisa");
    }
}
