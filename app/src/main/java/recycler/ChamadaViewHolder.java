package recycler;

import android.view.View;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

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
