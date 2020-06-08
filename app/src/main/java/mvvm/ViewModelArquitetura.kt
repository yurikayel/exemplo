package mvvm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import custom.isDigit
import custom.isOdd

class ViewModelArquitetura : ViewModel() {

    //region propriedades
    private val _text = MutableLiveData<String>().apply { value = "" }
    val text: LiveData<String> = _text

    private val _digit = MutableLiveData<Boolean>().apply { value = false }
    val digit: LiveData<Boolean> = _digit

    private val _impar = MutableLiveData<Boolean>().apply { value = false }
    val impar: LiveData<Boolean> = _impar
    //endregion

    fun validaDigito(texto: String) {
        var ehDigitu = false
        val retorno = when {
            texto.isEmpty() -> "Tá vazio"
            texto.isBlank() -> "Tá cheio de espaço"
            !texto.isDigit() -> "$texto né número não"
            texto.length > 3 -> "Máximo 3 dígitos"
            texto.isDigit() -> {
                ehDigitu = true
                texto
            }
            else -> ""
        }
        _text.value = retorno
        _digit.value = ehDigitu
        _impar.value = if (ehDigitu) retorno.toInt().isOdd else false
    }
}
