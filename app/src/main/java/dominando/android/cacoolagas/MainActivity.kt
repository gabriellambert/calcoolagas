package dominando.android.cacoolagas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import dominando.android.cacoolagas.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonCalculate.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        when (view.id) {
            R.id.button_calculate -> {
                val gasPrice = binding.editTextGas.text.toString().toFloat()
                val alcoholPrice = binding.editTextAlcohol.text.toString().toFloat()
                if (gasPrice > 0.0 && alcoholPrice > 0.0) {
                    calculateBetterOption(gasPrice, alcoholPrice)
                } else {
                    Toast.makeText(
                        this,
                        "Informe um valor válido",
                        Toast.LENGTH_LONG
                    ).show()
                }
            }
        }
    }

    private fun calculateBetterOption(gasPrice: Float, alcoholPrice: Float) {
        val result = alcoholPrice / gasPrice

        if (result >= 0.74) {
            binding.resultTextview.setText(R.string.gas_result)
        } else if (result < 0.74) {
            binding.resultTextview.setText(R.string.alcohol_result)
        }
    }
}