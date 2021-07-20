package id.diantara.temanjalan

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationMenu
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import id.diantara.temanjalan.fragment.HomeFragment
import id.diantara.temanjalan.fragment.SettingsFragment
import id.diantara.temanjalan.fragment.UserFragment
import kotlinx.android.synthetic.main.activity_home_page.*
import kotlinx.android.synthetic.main.fragment_home.*

class HomePageActivity : AppCompatActivity() {

    private val homeFragment = HomeFragment()
    private val userFragment = UserFragment()
    private val settingsFragment = SettingsFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_page)
        replaceFragment(homeFragment)

        val botNav: BottomNavigationView = findViewById(R.id.bottom_navigation)
        botNav.setOnNavigationItemSelectedListener {
            when(it.itemId) {
                R.id.ic_home -> replaceFragment(homeFragment)
                R.id.ic_user -> replaceFragment(userFragment)
                R.id.ic_settings -> replaceFragment(settingsFragment)
            }
            true
        }
        btn_signout.setOnClickListener{
            Log.d("homeFragment", "mau logout")
            signout()
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragment_container, fragment)
        transaction.commit()
    }

    private fun signout() {
        Firebase.auth.signOut()
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }

}