package recycler;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.exemplo.R;

public class ChamadaViewHolder extends RecyclerView.ViewHolder {

    public TextView textViewTexticulo;
    public CardView cardView;

    public ChamadaViewHolder(View layout) {
        super(layout);
        textViewTexticulo = layout.findViewById(R.id.texticulo);
        cardView = layout.findViewById(R.id.cardView);
    }
}
