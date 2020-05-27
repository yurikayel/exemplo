package retrofit.modelsgeradas

import android.annotation.SuppressLint
import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@SuppressLint("ParcelCreator")
@Parcelize
data class Funcionario(
    @SerializedName("employee_age")
    val employeeAge: String = "",
    @SerializedName("employee_name")
    val employeeName: String = "",
    @SerializedName("employee_salary")
    val employeeSalary: String = "",
    @SerializedName("id")
    val id: String = "",
    @SerializedName("profile_image")
    val profileImage: String = ""
) : Parcelable