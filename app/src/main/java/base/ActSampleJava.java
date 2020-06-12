package base;

import android.os.Bundle;

import com.example.exemplo.R;
import com.example.exemplo.databinding.ActSampleBinding;

import org.jetbrains.annotations.NotNull;

import static custom.ExtFunKt.getKlass;
import static custom.ExtFunKt.viewBind;

public class ActSampleJava extends ActBind<ActSampleBinding> {

    @NotNull
    @Override
    public ActSampleBinding getBinding() {
        return viewBind(this, getKlass(ActSampleBinding.class));
    }

    @Override
    public void onExtras(@NotNull Bundle extras) {

    }

    @Override
    public void onBoundView(@NotNull ActSampleBinding binding) {
        binding.textViewTitulo.setText(getString(R.string.whiskas_sache));
        binding.textViewSubTitulo.setText(getString(R.string.whiskas_sache));
        binding.textViewMensagem.setText(getString(R.string.whiskas_sache));
    }


}
