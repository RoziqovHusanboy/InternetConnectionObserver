package boy.roziqov.internetconnectionobserver.core.domain

import kotlinx.coroutines.flow.Flow

interface ConnectivityObserver {

    fun isConnected(): Flow<Boolean>
}