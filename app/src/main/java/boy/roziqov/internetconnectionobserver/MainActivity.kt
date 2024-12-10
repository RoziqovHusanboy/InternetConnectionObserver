package boy.roziqov.internetconnectionobserver

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.commit
import boy.roziqov.internetconnectionobserver.presentation.HomeFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        savedInstanceState ?: run {

            supportFragmentManager.commit {
                add(R.id.main, HomeFragment.newInstance())
                addToBackStack(javaClass.name)
            }
        }
    }
}