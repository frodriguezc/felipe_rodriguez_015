package tech.carcher.felipe_rodriguez_015

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {
    private lateinit var editTextFoodName: EditText
    private lateinit var editTextQuantity: EditText
    private lateinit var editTextAddress: EditText
    private lateinit var buttonShowOrder: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editTextFoodName = findViewById(R.id.editTextFoodName)
        editTextQuantity = findViewById(R.id.editTextQuantity)
        editTextAddress = findViewById(R.id.editTextAddress)
        buttonShowOrder = findViewById(R.id.buttonShowOrder)

        buttonShowOrder.setOnClickListener {
            val foodName = editTextFoodName.text.toString()
            val quantity = editTextQuantity.text.toString()
            val address = editTextAddress.text.toString()

            val orderInfo = "Pedido:\nComida: $foodName\nCantidad: $quantity\nDirección: $address"
            showAlert(orderInfo)
            Log.d("OrderInfo", orderInfo)
        }
    }

    private fun showAlert(message: String) {
        val builder = AlertDialog.Builder(this)
        builder.setMessage(message)
        builder.setPositiveButton("OK") { dialog, _ ->
            dialog.dismiss()
        }
        val dialog = builder.create()
        dialog.show()
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("AppStatus", "La aplicación ha sido cerrada")
    }
}