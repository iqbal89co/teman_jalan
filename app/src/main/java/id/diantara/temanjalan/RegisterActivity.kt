package id.diantara.temanjalan

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        btn_register.setOnClickListener {
            performRegister()
        }

    }
    private fun performRegister() {
        val email = input_email_register.text.toString()
        val name = input_name_register.text.toString()
        val phoneNo = input_phone_register.text.toString()
        if (email.isEmpty() || name.isEmpty() || phoneNo.isEmpty()) {
            Toast.makeText(
                this,
                "Please complete all required data to register",
                Toast.LENGTH_SHORT
            ).show()
            return
        }

        // registering user data

        btn_register.setOnClickListener{
            Log.d("otp", "button register clicked")
            val intent = Intent(this, OtpScreenRegisterActivity::class.java)
            intent.putExtra("phoneNum", input_phone_register.text.toString())
            intent.putExtra("name", input_name_register.text.toString())
            intent.putExtra("email", input_email_register.text.toString())
            startActivity(intent)
        }


        /* FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, "123123")
            .addOnCompleteListener {
                if (!it.isSuccessful) return@addOnCompleteListener

                Log.d("Register", "Successfully registered user with uid: ${it.result?.user?.uid}")
            }
            .addOnFailureListener {
                Log.d("Register", "Failed to create user ${it.message}")
                Toast.makeText(this, it.message, Toast.LENGTH_SHORT).show()
            } */

    }
}