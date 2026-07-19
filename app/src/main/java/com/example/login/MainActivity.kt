package com.example.login

import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.widget.addTextChangedListener
import com.example.login.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val usuarioCorrecto = "user@tic.unam.mx"
    private val passwordCorrecta = "git branch"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Ajuste de insets
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Botón inicia deshabilitado
        binding.btnLogin.isEnabled = false

        // Escucha cambios en los campos
        binding.etCorreo.addTextChangedListener { binding.btnLogin.isEnabled = validarCampos() }
        binding.etPassword.addTextChangedListener { binding.btnLogin.isEnabled = validarCampos() }

        // Acción del botón
        binding.btnLogin.setOnClickListener { validarLogin() }
    }

    private fun validarCampos(): Boolean {
        val correo = binding.etCorreo.text.toString().trim()
        val password = binding.etPassword.text.toString()
        return correo.isNotEmpty() && password.isNotEmpty()
    }

    private fun validarLogin() {
        val correo = binding.etCorreo.text.toString().trim()
        val password = binding.etPassword.text.toString()

        when {
            correo.isEmpty() -> {
                binding.etCorreo.error = getString(R.string.empty_email)
                binding.etCorreo.requestFocus()
            }
            !Patterns.EMAIL_ADDRESS.matcher(correo).matches() -> {
                binding.etCorreo.error = getString(R.string.invalid_email)
                binding.etCorreo.requestFocus()
            }
            password.isEmpty() -> {
                binding.etPassword.error = getString(R.string.empty_password)
                binding.etPassword.requestFocus()
            }
            correo == usuarioCorrecto && password == passwordCorrecta -> {
                // Navegación equivalente al Fragment, pero con Intent
                val intent = Intent(this, WelcomeActivity::class.java).apply {
                    putExtra("usuario", correo)
                }
                startActivity(intent)
                finish()
            }
            else -> {
                Toast.makeText(this, getString(R.string.login_error), Toast.LENGTH_LONG).show()
            }
        }
    }
}
