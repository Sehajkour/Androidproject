// Inside your RegisterFragment
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.sk.LoginPage
import com.example.sk.R

class RegisterFragment : Fragment() {
    private val PREFS_NAME = "MyPrefsFile"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_register, container, false)
        val sharedPrefs = activity?.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
        val editor = sharedPrefs?.edit()

        val email = view.findViewById(R.id.et_email) as EditText
        val password = view.findViewById(R.id.et_password) as EditText
        val name = view.findViewById(R.id.et_name) as EditText


        val registerButton = view.findViewById<Button>(R.id.btn_register)

        registerButton.setOnClickListener {
            val nameText = name.text.toString()
            val emailText = email.text.toString()
            val passwordText = password.text.toString()
            if (!emailText.endsWith("@gmail.com")) {
                Toast.makeText(activity, "Please enter a valid Gmail address", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            editor?.putBoolean("isRegistered", true)
            editor?.putString("email", emailText)
            editor?.putString("password", passwordText)
            editor?.putString("name", nameText) // Save the name
            editor?.apply()

            val intent = Intent(activity, LoginPage::class.java)
            startActivity(intent)
        }

        return view
    }
}