package cat.urv.deim.asm.patinfly.views.login
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.TextView
import cat.urv.deim.asm.patinfly.R
import cat.urv.deim.asm.patinfly.views.profile.ProfileActivity
import cat.urv.deim.asm.patinfly.views.signup.SignupActivity

class LoginActivity : AppCompatActivity(), LoginView {

    private val presenter = LoginPresenter(this, LoginInteractor())
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        val email: EditText = this.findViewById(R.id.loginEmailEditText)
        val password: EditText =this.findViewById(R.id.loginPasswordEditText)

        val signInButton:Button = this.findViewById<Button>(R.id.loginSignIn)
        signInButton.setOnClickListener {

            val emailValue = email.text.toString()
            val passwordValue = password.text.toString()
            val message = String.format("email: %s password: %s",
                emailValue,passwordValue)

            navigateToProfile()

            this.showProgress()
            Log.d("MainActivity-Debug", message )
            validateCredentials()
        }
        val signUpButton:Button = this.findViewById<Button>(R.id.loginSignUp)
        signUpButton.setOnClickListener {
            this.navigateToSignup()
        }
    }
    private fun validateCredentials() {
        val email: EditText = this.findViewById(R.id.loginEmailEditText)
        val password: EditText =this.findViewById(R.id.loginPasswordEditText)
        presenter.validateCredentials(email.text.toString(), password.text.toString())
    }


    override fun onStart() {
        super.onStart()

    }

    override fun onRestart() {
        super.onRestart()
        this.hideProgress()
    }

    override fun showProgress() {
        this.findViewById<ProgressBar>(R.id.loginProgressBar).visibility = View.VISIBLE
    }

    override fun hideProgress() {
        this.findViewById<ProgressBar>(R.id.loginProgressBar).visibility = View.INVISIBLE
    }

    override fun setUsernameError() {
        this.findViewById<EditText>(R.id.loginEmailEditText).setText("")
        this.findViewById<TextView>(R.id.textView2).setText("Enter a correct email")

    }

    override fun setPasswordError() {
        this.findViewById<EditText>(R.id.loginPasswordEditText).setText("")
        this.findViewById<TextView>(R.id.textView2).setText("Enter a correct password")

    }


    override fun navigateToProfile() {
        val intent: Intent = Intent()
        intent.putExtra("key", "value")
        intent.setClass(this, ProfileActivity::class.java)
        this.startActivity(intent)
    }
    override fun navigateToSignup() {
        val intent: Intent = Intent()
        intent.putExtra("key", "value")
        intent.setClass(this, SignupActivity::class.java)
        this.startActivity(intent)
    }
    private fun navigateToLogIn() {
        val intent: Intent = Intent()
        intent.putExtra("key", "value")
        intent.setClass(this, LoginActivity::class.java)
        this.startActivity(intent)
    }
}
