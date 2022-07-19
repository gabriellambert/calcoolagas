package dominando.android.cacoolagas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import dominando.android.cacoolagas.databinding.ActivityInitBinding

class InitActivity : AppCompatActivity() {

    private lateinit var binding: ActivityInitBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityInitBinding.inflate(layoutInflater )
        setContentView(binding.root)

        binding.buttonStartApp.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }
    }
}