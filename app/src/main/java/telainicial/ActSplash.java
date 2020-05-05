package telainicial;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import base.ActBase;
import custom.ActHost;
import debugging.ExceptionHandler;

public class ActSplash extends ActBase {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        startActivity(new Intent(this, ActHost.class));
        finish();
    }
}
