package custom

import com.example.exemplo.databinding.ItemMusicBinding
import custom.adapter.ItemViewBuilder

data class Music(
    val name: String,
    val album: String,
    val composer: String,
    val duration: Int
)

fun main() {
    val evidencias = Music("Evidencias", "Evidente", "X&C", 150)
    val playList =
        listOf(evidencias, evidencias, evidencias, evidencias, evidencias, evidencias)
    val adapter = recyclerAdapter<MusicItemView>(playList)
}

class MusicItemView : ItemViewBuilder<Music, ItemMusicBinding>() {

    override val binding: ItemMusicBinding by viewBind()

    override fun ItemMusicBinding.onBind(position: Int) {
        val item = collection[position]
        musicName.text = item.name
        musicAlbum.text = item.album
        musicComposer.text = item.composer
        musicDuration.text = item.duration.toString()
    }
}