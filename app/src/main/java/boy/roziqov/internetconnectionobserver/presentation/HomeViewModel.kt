package boy.roziqov.internetconnectionobserver.presentation

import boy.roziqov.internetconnectionobserver.core.domain.ConnectivityObserver
import boy.roziqov.internetconnectionobserver.core.presentation.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    observer: ConnectivityObserver
) : BaseViewModel(observer) {

}