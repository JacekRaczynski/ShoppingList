package pl.jraczynski.shoppinglist.fragments

import android.Manifest
import android.app.AlertDialog

import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.activity.result.ActivityResultCallback
import androidx.activity.result.ActivityResultLauncher
import androidx.core.content.PermissionChecker
import androidx.fragment.app.Fragment
import com.journeyapps.barcodescanner.ScanContract
import com.journeyapps.barcodescanner.ScanOptions
import pl.jraczynski.shoppinglist.CaptureAct
import pl.jraczynski.shoppinglist.R

abstract class BaseFragment : Fragment() {
    val CAMERA_PERMISSION_REQUEST_CODE: Int = 3;

    fun cameraPermissionRequest() {
        if (!checkCameraPermission()) {
            requestPermissions(
                arrayOf(Manifest.permission.CAMERA),
                CAMERA_PERMISSION_REQUEST_CODE
            );
        } else {
            scanCode()
        }
    }

    private fun checkCameraPermission(): Boolean {
        return context?.let {
            PermissionChecker.checkSelfPermission(
                it,
                Manifest.permission.CAMERA
            )
        } == PermissionChecker.PERMISSION_GRANTED
    }

    private fun scanCode() {
        val options: ScanOptions = ScanOptions()
        options.setPrompt("Volume up to flash on")
        options.setBeepEnabled(true)
        options.setBeepEnabled(true)
        options.setOrientationLocked(true)
        options.setCaptureActivity(CaptureAct::class.java)
        barLaucher.launch(options)
    }

    var barLaucher: ActivityResultLauncher<ScanOptions> = registerForActivityResult(
        ScanContract(),
        ActivityResultCallback { result ->
            if (result.contents != null) {
                var builder: AlertDialog.Builder = AlertDialog.Builder(activity)
                var dialog: AlertDialog = builder.create()

                val customDialogView: ViewGroup = layoutInflater.inflate(
                    R.layout.scan_dialog_confirmation, null
                ) as ViewGroup
                val yesButton: Button = customDialogView.findViewById<Button>(R.id.yesButton)
                val noButton: Button = customDialogView.findViewById<Button>(R.id.noButton)
                val codeDialog: TextView = customDialogView.findViewById<TextView>(R.id.codeDialog)
                codeDialog.text = result.contents


                yesButton.setOnClickListener {
                    dialog.dismiss()
                }
                noButton.setOnClickListener {
                    dialog.dismiss()
                    scanCode()
                }
                dialog.setView(customDialogView)
                dialog.show()

            }
        })
}