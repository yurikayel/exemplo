package firebase.storage

import android.content.Intent
import android.net.Uri
import android.os.Handler
import android.webkit.MimeTypeMap
import base.ActBind
import com.example.exemplo.databinding.ActFirebaseStorageBinding
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import com.google.firebase.storage.StorageTask
import com.google.firebase.storage.UploadTask
import custom.onClick
import custom.setImageFromURL
import custom.string
import custom.toast
import java.lang.System.currentTimeMillis

private const val PICK_IMAGE_REQUEST = 333

class ActFirebaseStorage : ActBind<ActFirebaseStorageBinding>() {

    private val storage = FirebaseStorage.getInstance().getReference("uploads")
    private var uploadTask: StorageTask<UploadTask.TaskSnapshot>? = null
    private var imageURI: Uri? = null

    override val binding: ActFirebaseStorageBinding by viewBind()

    override fun ActFirebaseStorageBinding.onBoundView() {
        escolherImagem.onClick(::openFileChooser)
        upload.onClick(::fazerUpload)
        mostrarUploads.onClick(::mostrar)
    }

    private fun fazerUpload() {
        if (uploadTask != null && uploadTask!!.isInProgress) toast("Fazendo upload...") else uploadFile()
    }

    private fun mostrar() {
        toast("WIP")
    }

    private fun openFileChooser() {
        val intent = Intent()
        intent.type = "image/*"
        intent.action = Intent.ACTION_GET_CONTENT
        startActivityForResult(intent, PICK_IMAGE_REQUEST)
    }

    override fun onActivityResult(code: Int, result: Int, intent: Intent?) {
        super.onActivityResult(code, result, intent)
        if (code == PICK_IMAGE_REQUEST && result == RESULT_OK && intent?.data != null) {
            imageURI = intent.data
            binding.imageView.setImageFromURL(imageURI)
        }
    }

    private fun uploadFile() {
        imageURI?.run {
            val fileReference = storage.child(
                currentTimeMillis().toString() + "." + getFileExtension(this)
            )
            uploadTask = fileReference.putFile(this)
                .addOnSuccessListener { onSuccess(fileReference) }
                .addOnFailureListener { toast(it.message ?: "Erro") }
                .addOnProgressListener { updateProgressBar(it) }
        }
        if (imageURI == null) toast("Nenhum arquivo selectionado.")
    }

    private fun getFileExtension(uri: Uri): String? =
        MimeTypeMap.getSingleton().getExtensionFromMimeType(contentResolver.getType(uri))

    private fun onSuccess(storageReference: StorageReference) {
        Handler().postDelayed({ binding.progressBar.progress = 0 }, 500)
        toast("Upload realizado com sucesso!")
        storageReference.downloadUrl.addOnCompleteListener { downloadURL ->
            FirebaseDatabase.getInstance().getReference("uploads").run {
                child(push().key!!).setValue(
                    Upload(
                        binding.fileName.string.trim { it <= ' ' },
                        downloadURL.result.toString()
                    )
                )
            }
        }
    }

    private fun updateProgressBar(taskSnapshot: UploadTask.TaskSnapshot) {
        val progress = 100.0 * taskSnapshot.bytesTransferred / taskSnapshot.totalByteCount
        binding.progressBar.progress = progress.toInt()
    }
}