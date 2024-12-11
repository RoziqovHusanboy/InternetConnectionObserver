package boy.roziqov.internetconnectionobserver.presentation

import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import boy.roziqov.internetconnectionobserver.R
import boy.roziqov.internetconnectionobserver.core.presentation.BaseFragmentWithVM
import boy.roziqov.internetconnectionobserver.core.utils.findViewById
import com.getkeepsafe.taptargetview.TapTarget
import com.getkeepsafe.taptargetview.TapTargetView
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment :
    BaseFragmentWithVM<HomeViewModel>(R.layout.fragment_home, HomeViewModel::class.java) {
    private var imageView: ImageView? = null
    lateinit var button: Button
    override fun onInit() {
        super.onInit()
        imageView = findViewById(R.id.image_view)
        button = findViewById(R.id.button)
        showCase()
    }

    private fun showCase() {

        TapTargetView.showFor(requireActivity(), TapTarget.forView(
            imageView, "New Feature", "This button lets you access our new feature!"
        ).outerCircleAlpha(0.96f).targetCircleColor(R.color.white)    // Highlight circle color
            .titleTextSize(20)
            .titleTextColor(R.color.white)
            .descriptionTextColor(R.color.black)
            .descriptionTextSize(16)
            .textColor(R.color.white)
            .dimColor(R.color.black)
            .drawShadow(true)
            .cancelable(true)
            .transparentTarget(true)
            .targetRadius(50),
            object : TapTargetView.Listener() {

                override fun onTargetClick(view: TapTargetView) {

                    super.onTargetClick(view)
                    Toast.makeText(requireContext(), "Target clicked!", Toast.LENGTH_SHORT).show()
                }
            })
    }


    companion object {
        fun newInstance(): HomeFragment {
            return HomeFragment()
        }
    }
}