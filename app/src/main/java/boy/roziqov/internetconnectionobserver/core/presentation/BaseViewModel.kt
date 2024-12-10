package boy.roziqov.internetconnectionobserver.core.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import boy.roziqov.internetconnectionobserver.core.domain.ConnectivityObserver
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn

abstract class BaseViewModel(
    private val connectivityObserver: ConnectivityObserver
) : ViewModel() {

//    private val _isConnect = MutableLiveData<Boolean>()
//    val isConnect: LiveData<Boolean> = _isConnect

//    init {
//        connectInternet()
//    }

    val isConnect = connectivityObserver.isConnected()
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000L), false)

//    fun connectInternet() = viewModelScope.launch {
//
//      connectivityObserver.isConnected().collectLatest {
//
//            _isConnect.postValue(it)
//        }
//    }
}