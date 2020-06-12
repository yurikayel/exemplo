package binding;

import com.example.exemplo.databinding.ActSacheBinding;

import org.jetbrains.annotations.NotNull;

import base.ActBind;

import static custom.ExtFunKt.getKlass;
import static custom.ExtFunKt.viewBind;

public class ActSache extends ActBind<ActSacheBinding> {

    @NotNull
    @Override
    public ActSacheBinding getBinding() {
        return viewBind(this, getKlass(ActSacheBinding.class));
    }

    @Override
    public void onBoundView(@NotNull ActSacheBinding sacheBinding) {

    }
}
