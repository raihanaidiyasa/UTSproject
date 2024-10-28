package lat.pam.utsproject

import android.content.Intent
import android.os.Bundle
import android.provider.Telephony.Mms.Intents
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class OrderActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_order)
        val foodName = intent.getStringExtra("foodName")
        val foodNameTextView = findViewById<TextView>(R.id.etFoodName)
        foodNameTextView.text = foodName
        Log.d("OrderActivity", "Food Name received: $foodName")


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btnOrder = findViewById<Button>(R.id.btnOrder)
        btnOrder.setOnClickListener {
            val servings = findViewById<EditText>(R.id.etServings).text.toString()
            val orderingName = findViewById<EditText>(R.id.etName).text.toString()
            val additionalNotes = findViewById<EditText>(R.id.etNotes).text.toString()

            val intent_Confirmation = Intent(this, ConfirmationActivity::class.java)

            intent.putExtra("foodName", foodName)
            intent.putExtra("servings", servings)
            intent.putExtra("orderingName", orderingName)
            intent.putExtra("additionalNotes", additionalNotes)

            startActivity(intent_Confirmation)
        }
    }
}