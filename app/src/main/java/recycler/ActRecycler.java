package recycler;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.exemplo.R;

import java.util.List;

import static java.util.Arrays.asList;

public class ActRecycler extends AppCompatActivity {

    RecyclerView recycler;
    RecyclerView.LayoutManager layoutManager;
    AdapterChamada adapter;
    List<String> chamada = asList(
            "Rafinha",
            "Henrique",
            "Xandão",
            "Daniel",
            "Peter Henry",
            "404",
            "Giulia",
            "Lucas",
            "Eduardo",
            "Sandro",
            "Felipe",
            "Gabriel");

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_recycler);
        recycler = findViewById(R.id.recycler);
        layoutManager = new LinearLayoutManager(
                this, LinearLayoutManager.VERTICAL, false);
        adapter = new AdapterChamada(chamada);

        recycler.setLayoutManager(layoutManager);
        recycler.setAdapter(adapter);

    }
}
