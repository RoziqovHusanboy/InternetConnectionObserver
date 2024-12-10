package boy.roziqov.internetconnectionobserver.core.utils

import android.view.View
import androidx.annotation.IdRes
import androidx.fragment.app.Fragment

fun <T : View> Fragment.findViewById(@IdRes id: Int): T {

    return requireView().findViewById<T>(id)
}