package retrofit.modelsgeradas

import android.annotation.SuppressLint
import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@SuppressLint("ParcelCreator")
@Parcelize
data class Funcionarios(
    @SerializedName("data")
    val funcionarios: List<Funcionario> = listOf(),
    @SerializedName("status")
    val status: String = ""
) : Parcelable