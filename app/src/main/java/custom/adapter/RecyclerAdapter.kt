package custom.adapter

import android.support.v7.widget.RecyclerView.Adapter
import android.view.ViewGroup

inline fun <reified Builder : RecyclerViewBuilder<*>> recyclerAdapter(collection: Collection<Any>) =
    object : Adapter<RecyclerViewHolder>() {

        override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int) =
            RecyclerViewHolder(Builder::class.java.newInstance().init(viewGroup, collection))

        override fun getItemCount() = collection.size

        override fun onBindViewHolder(viewHolder: RecyclerViewHolder, position: Int) =
            viewHolder.builder.bind(position)
    }
