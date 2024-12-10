package boy.roziqov.internetconnectionobserver.core.presentation

import android.os.Bundle
import android.view.View
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment


abstract class BaseFragment(@LayoutRes resLayout: Int) : Fragment(resLayout) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        onInit()
        onListener()
    }

    protected open fun onInit() = Unit
    protected open fun onListener() = Unit
}