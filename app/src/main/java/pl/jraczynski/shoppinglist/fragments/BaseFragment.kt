package pl.jraczynski.shoppinglist.fragments

import android.Manifest
import android.app.AlertDialog

import android.util.Log

import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.activity.result.ActivityResultCallback
import androidx.activity.result.ActivityResultLauncher
import androidx.core.content.PermissionChecker
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import com.google.firebase.Timestamp
import com.google.firebase.auth.FirebaseAuth
import com.journeyapps.barcodescanner.ScanContract
import com.journeyapps.barcodescanner.ScanOptions
import pl.jraczynski.shoppinglist.CaptureAct
import pl.jraczynski.shoppinglist.R
import pl.jraczynski.shoppinglist.activities.MainActivity
import pl.jraczynski.shoppinglist.data.Categories
import java.time.LocalDate
import java.time.format.DateTimeFormatter

abstract class BaseFragment : Fragment() {
    val CAMERA_PERMISSION_REQUEST_CODE: Int = 3;
    private val fbAuth = FirebaseAuth.getInstance()
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
                    (activity as MainActivity).userViewModel.user.value?.listofProducts?.list?.forEach {
                       if( it.uid == result.contents){
                           (activity as MainActivity).userViewModel.item = it
                           (activity as MainActivity).userViewModel.currentItem.postValue(it)
                           val navHostFragment = requireActivity().supportFragmentManager.findFragmentById(R.id.fragment) as NavHostFragment
                           val navController = navHostFragment.navController
                           navController.navigate(R.id.addItemFragment)
                           return@forEach
                       }
                    }
                    try {
                        (activity as MainActivity).foodViewModel.performFetchSingleFoodProduct(id = result.contents.toLong())
                        (activity as MainActivity).foodViewModel.getFoodProduct()
                            .observe(this) { it ->
                                if(it != null) {
                                    val currentDate = LocalDate.now()
                                    val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd") // Opcjonalny format daty
                                    val formattedDate = currentDate.format(formatter)
                                    val item: pl.jraczynski.shoppinglist.data.Item =
                                        pl.jraczynski.shoppinglist.data.Item(
                                            uid = it?.code,
                                            name = it.product?.productName,
                                            productData = it.toString(),
                                            amount = 1,
                                            image ="",
                                           // categories = listOf( Categories.food),
                                            authorId = fbAuth.currentUser?.uid,
                                            date = Timestamp.now()
                                        )
                                    (activity as MainActivity).userViewModel.user.value?.let { it1 ->
                                        (activity as MainActivity).foodViewModel.addItem(item,
                                            it1
                                        )
                                    }
                                    Log.d("PROCESS_D", it.toString())
                                }
                            }
                    }catch (e:java.lang.Exception){
                        Log.d("PROCESS_D", e.message.toString())
                    }


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