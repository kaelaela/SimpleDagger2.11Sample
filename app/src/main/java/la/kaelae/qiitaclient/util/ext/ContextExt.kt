package la.kaelae.qiitaclient.util.ext

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.support.design.widget.Snackbar

inline fun <reified T : Any> Context.intent() = Intent(this, T::class.java)

fun Activity.snackBar(text: String) = Snackbar.make(this.findViewById(android.R.id.content), text, Snackbar.LENGTH_SHORT)