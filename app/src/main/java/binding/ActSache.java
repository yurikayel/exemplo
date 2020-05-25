package binding;

import com.example.exemplo.databinding.ActSacheBinding;

import org.jetbrains.annotations.NotNull;

import base.ActBind;

public class ActSache extends ActBind<ActSacheBinding> {

    @NotNull
    @Override
    public ActSacheBinding getBinding() {
        return bind(this, ActSacheBinding.class);
    }

    @Override
    public void onBoundView(@NotNull ActSacheBinding sacheBinding) {

    }
}
