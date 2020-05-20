package binding;

import com.example.exemplo.databinding.ActSacheBinding;

import org.jetbrains.annotations.NotNull;

import base.ActBind;

public class ActSache extends ActBind<ActSacheBinding> {

    @NotNull
    @Override
    public Class<ActSacheBinding> getBindClass() {
        return ActSacheBinding.class;
    }

    @Override
    public void onBoundView(@NotNull ActSacheBinding sacheBinding) {

    }
}
