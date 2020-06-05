package permissions

import android.Manifest.permission.*
import base.ActBind
import base.IPermissionRequest
import com.example.exemplo.databinding.ActPermissionsBinding
import custom.onClick
import custom.toast

class ActPermissions : ActBind<ActPermissionsBinding>(), IPermissionRequest {

    override val binding: ActPermissionsBinding by viewBind()

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

    override fun onPermissionRequested(permission: String) {
        val requested = "Permissão $permission foi SOLICITADA!"
        binding.permissionResult.text = requested
        toast(requested)
    }

    override fun onPermissionGranted(permission: String) {
        val granted = "Permissão $permission foi CONCEDIDA!"
        binding.permissionResult.text = granted
        toast(granted)
    }

    override fun onPermissionDenied(permission: String) {
        val denied = "Permissão $permission foi NEGADA!"
        binding.permissionResult.text = denied
        toast(denied)
    }
}