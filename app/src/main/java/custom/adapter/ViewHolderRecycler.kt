package custom.adapter

import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.viewbinding.ViewBinding

open class RecyclerViewHolder(val builder: RecyclerViewBuilder<*, *>) :
    RecyclerView.ViewHolder(builder.build())

abstract class RecyclerViewBuilder<Data, Binding : ViewBinding> {

    abstract val bindClass: Class<Binding>
    private lateinit var binding : Binding
    lateinit var collection: Collection<Data>

    private lateinit var viewGroup: ViewGroup

    @Suppress("UNCHECKED_CAST")
    fun init(viewGroup: ViewGroup, collection: Collection<*>): RecyclerViewBuilder<Data, Binding> {
        this.viewGroup = viewGroup
        this.collection = collection as Collection<Data>
        return this
    }

    fun build() : View {
        binding = inflate()
        return binding.root
    }

    @Suppress("UNCHECKED_CAST")
    fun inflate() =
        bindClass.getMethod("inflate", LayoutInflater::class.java).invoke(
            null, ((viewGroup.context) as AppCompatActivity).layoutInflater
        ) as Binding


    fun bind(position: Int) = binding.onBind(position)

    abstract fun Binding.onBind(position: Int)
}