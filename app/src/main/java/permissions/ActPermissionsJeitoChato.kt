package permissions

import android.Manifest.permission.*
import android.content.pm.PackageManager.PERMISSION_GRANTED
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import base.ActBind
import com.example.exemplo.databinding.ActPermissionsBinding
import custom.onClick
import custom.toast
import custom.viewBind

private const val CODIGO = 19

class ActPermissionsJeitoChato : ActBind<ActPermissionsBinding>() {

    override val binding: ActPermissionsBinding by viewBind()

    @RequiresApi(Build.VERSION_CODES.P)
    override fun ActPermissionsBinding.onBoundView() {
        permissionExternalStorage.onClick { requestPermission(WRITE_EXTERNAL_STORAGE) }
        permissionWriteContacts.onClick { requestPermission(WRITE_CONTACTS) }
        permissionWriteCalendar.onClick { requestPermission(WRITE_CALENDAR) }
        permissionUseFingerprint.onClick { requestPermission(USE_BIOMETRIC) }
        permissionRecordAudio.onClick { requestPermission(RECORD_AUDIO) }
        permissionCamera.onClick { requestPermission(CAMERA) }
        permissionInternet.onClick { requestPermission(INTERNET) }
        permissionLocation.onClick { requestPermission(ACCESS_FINE_LOCATION) }
    }

    private fun requestPermission(permission: String) {
        if (ContextCompat.checkSelfPermission(this, permission) == PERMISSION_GRANTED)
            onPermissionGranted(permission) else onRequest(permission)
    }

    private fun onRequest(permission: String) {
        ActivityCompat.requestPermissions(this, arrayOf(permission), CODIGO)
        onPermissionRequested(permission)
    }

    override fun onRequestPermissionsResult(
        code: Int, permissions: Array<out String>, results: IntArray
    ) {
        super.onRequestPermissionsResult(code, permissions, results)
        if (code == CODIGO && results.isNotEmpty()) {
            if (results[0] == PERMISSION_GRANTED) {
                onPermissionGranted(permissions[0])
            } else {
                onPermissionDenied(permissions[0])
            }
        }
    }

    private fun onPermissionRequested(permission: String) {
        val requested = "Permissão $permission foi SOLICITADA!"
        binding.permissionResult.text = requested
        toast(requested)
    }

    private fun onPermissionGranted(permission: String) {
        val granted = "Permissão $permission foi CONCEDIDA!"
        binding.permissionResult.text = granted
        toast(granted)
    }

    private fun onPermissionDenied(permission: String) {
        val denied = "Permissão $permission foi NEGADA!"
        binding.permissionResult.text = denied
        toast(denied)
    }
}