package boy.roziqov.internetconnectionobserver.core.presentation

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import boy.roziqov.internetconnectionobserver.R
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

abstract class BaseFragmentWithVM<VM : BaseViewModel>(
    @LayoutRes layoutRes: Int, private val clazz: Class<VM>
) : BaseFragment(layoutRes) {

    protected open val viewModel by lazy { ViewModelProvider(this)[clazz] }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        super.onViewCreated(view, savedInstanceState)


//        viewModel.isConnect.observe(viewLifecycleOwner) {
//            if (it == false) baseDialog()
////            Toast.makeText(requireContext(), "Connect $it", Toast.LENGTH_SHORT).show()
//        }

        lifecycleScope.launch {

            viewModel.isConnect.collectLatest {

                if (!it) baseDialog().show() else baseDialog().hide()
            }

        }
    }

    private fun baseDialog(): AlertDialog {

        val dialogView = layoutInflater.inflate(R.layout.internet_dialog_base, null)
        val dialog = AlertDialog.Builder(requireContext())
            .setView(dialogView)
            .create()

        val button = dialogView.findViewById<Button>(R.id.button)

        button.setOnClickListener {
            lifecycleScope.launch {

                viewModel.isConnect.collect()
            }
            dialog.dismiss() // Close the dialog
        }
        return dialog
    }
}