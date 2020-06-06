package facebook

import android.content.Intent
import android.content.pm.PackageInfo
import android.content.pm.PackageManager.GET_SIGNATURES
import android.content.pm.PackageManager.GET_SIGNING_CERTIFICATES
import android.os.Build.VERSION.SDK_INT
import android.os.Build.VERSION_CODES.P
import android.util.Base64
import android.util.Log
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import base.ActBase
import com.example.exemplo.R
import com.facebook.AccessToken
import com.facebook.CallbackManager
import com.facebook.FacebookCallback
import com.facebook.FacebookException
import com.facebook.login.LoginResult
import com.facebook.login.widget.LoginButton
import custom.*
import java.security.MessageDigest
import java.security.NoSuchAlgorithmException

class ActFacebook : ActBase() {

    private val dp16 = 16.dp
    private var zuckerberg = "4"

    private val callbackManager = CallbackManager.Factory.create()
    private val accessToken: AccessToken? get() = AccessToken.getCurrentAccessToken()
    private val userID get() = accessToken?.userId ?: zuckerberg

    override val view by lazy {
        new<LinearLayout>(R.style.LinearVertical) { setPadding(dp16, dp16, dp16, dp16) }
    }

    lateinit var geraHash: Button
    lateinit var login: LoginButton
    lateinit var fotinha: CircleImageView

    override fun ViewGroup.onView() {
        geraHash = new {
            setPadding(dp16, dp16, dp16, dp16)
            text = "Criar e Compartilhar HASH Facebook"
            onClick(::printHashKey)
        }

        fotinha = new {
            setImageFromURL(urlFotoFace(userID))
        }

        login = LoginButton(context).apply {
            setPadding(dp16, dp16, dp16, dp16)
            text = "Login Facebook"
            registerCallback(callbackManager, facebookCallback)
        }

        addView(geraHash)
        addView(login)
        addView(fotinha)
    }

    private val facebookCallback = object : FacebookCallback<LoginResult> {

        override fun onSuccess(result: LoginResult?) {
            toast("SUCESSO!")
            fotinha.setImageFromURL(urlFotoFace(userID))
        }

        override fun onCancel() {
            toast("CANCELÔ =(")
        }

        override fun onError(error: FacebookException?) {
            toast("EROU!")
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        callbackManager.onActivityResult(requestCode, resultCode, data)
        fotinha.setImageFromURL(urlFotoFace(userID))
        super.onActivityResult(requestCode, resultCode, data)
    }

    private fun urlFotoFace(id: String) = "https://graph.facebook.com/$id/picture?type=large"

    private fun printHashKey() = try {
        var hashKey = ""

        val info: PackageInfo = packageManager.getPackageInfo(
            packageName, if (SDK_INT >= P) GET_SIGNING_CERTIFICATES else GET_SIGNATURES
        )

        val signatures =
            if (SDK_INT >= P) info.signingInfo.apkContentsSigners else info.signatures

        signatures.forEach { signature ->
            val md: MessageDigest = MessageDigest.getInstance("SHA")
            md.update(signature.toByteArray())
            hashKey = String(Base64.encode(md.digest(), 0))
            Log.i(javaClass.name, "printHashKey() Hash Key: $hashKey")
        }
        shareText(hashKey)
    } catch (e: NoSuchAlgorithmException) {
        Log.e(javaClass.name, "printHashKey()", e)
    } catch (e: Exception) {
        Log.e(javaClass.name, "printHashKey()", e)
    }
}
