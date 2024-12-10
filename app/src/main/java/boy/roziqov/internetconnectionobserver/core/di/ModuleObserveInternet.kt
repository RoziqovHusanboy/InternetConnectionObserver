package boy.roziqov.internetconnectionobserver.core.di

import boy.roziqov.internetconnectionobserver.core.data.observeInternetConnection.AndroidConnectivityObserver
import boy.roziqov.internetconnectionobserver.core.domain.ConnectivityObserver
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface ModuleObserveInternet {

    @Binds
    fun bindObserveInternet(androidConnectivityObserver: AndroidConnectivityObserver): ConnectivityObserver
}