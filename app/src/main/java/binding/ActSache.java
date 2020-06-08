package binding;

import com.example.exemplo.databinding.ActSacheBinding;

import org.jetbrains.annotations.NotNull;

import base.ActBind;

import static custom.ExtFunKt.bindView;
import static custom.ExtFunKt.getKlass;

public class ActSache extends ActBind<ActSacheBinding> {

    @NotNull
    @Override
    public ActSacheBinding getBinding() {
        return bindView(this, getKlass(ActSacheBinding.class));
    }

    @Override
    public void onBoundView(@NotNull ActSacheBinding sacheBinding) {

    }
}
