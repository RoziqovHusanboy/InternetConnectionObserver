package boy.roziqov.internetconnectionobserver.presentation

import boy.roziqov.internetconnectionobserver.R
import boy.roziqov.internetconnectionobserver.core.presentation.BaseFragmentWithVM
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment :
    BaseFragmentWithVM<HomeViewModel>(R.layout.fragment_home, HomeViewModel::class.java) {

    companion object {
        fun newInstance(): HomeFragment {
            return HomeFragment()
        }
    }

}