package cab.andrew.common_ui_view

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

fun View.visible() {
	this.visibility = View.VISIBLE
}

fun View.gone() {
	this.visibility = View.GONE
}
