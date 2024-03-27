package com.example.meuprimeiroprojeto

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.findViewTreeViewModelStoreOwner

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnCalcular: Button = findViewById(R.id.btnCalcular)
        val edtWeight : EditText = findViewById(R.id.edttext_weight)
        val edtHeight : EditText = findViewById(R.id.edttext_height)

        btnCalcular.setOnClickListener {

            val heightStr = edtHeight.text.toString()
            val weightStr = edtWeight.text.toString()

            if (heightStr.isNotEmpty() && weightStr.isNotEmpty()) {
                val height: Float = edtHeight.text.toString().toFloat()
                val weight: Float = edtWeight.text.toString().toFloat()
                val finalHeight: Float = height * height
                val result: Float = weight / finalHeight

                val intent = Intent(this, ResultActivity::class.java)
                    .apply {
                        putExtra("EXTRA_RESULT", result)
                    }
                startActivity(intent)
            } else {
                Toast.makeText(this, "Preencher todos os campos", Toast.LENGTH_LONG).show()
            }
        }
    }
}
