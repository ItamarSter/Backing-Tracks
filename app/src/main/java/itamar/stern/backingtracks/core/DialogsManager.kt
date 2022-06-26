package itamar.stern.backingtracks.core

import android.app.AlertDialog
import android.content.Context

class DialogsManager(
    private val context: Context
) {
    fun showDialog(
        message: String,
        cancelable: Boolean,
        positiveButton: String? = null,
        negativeButton: String? = null
    ) {
        with(AlertDialog.Builder(context)) {
            setMessage(message)
            positiveButton?.let {
                setPositiveButton(
                    positiveButton
                ) { dialog, id ->

                }
            }
            negativeButton?.let {
                setNegativeButton(
                    negativeButton
                ) { dialog, id ->

                }
            }
            setCancelable(cancelable)
            create()
            show()
        }

    }
}