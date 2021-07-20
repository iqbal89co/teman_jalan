package id.diantara.temanjalan

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        btn_login.setOnClickListener{
            val intent = Intent(this, OtpScreenLoginActivity::class.java)
            intent.putExtra("phoneNum", input_phone_login.text.toString())
            startActivity(intent)
        }
    }

}