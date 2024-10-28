package lat.pam.utsproject

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ConfirmationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_confirmation)

        val foodName = intent.getStringExtra("foodName")
        val servings = intent.getStringExtra("servings")
        val orderingName = intent.getStringExtra("orderingName")
        val additionalNotes = intent.getStringExtra("additionalNotes")

        val foodNameTextView = findViewById<TextView>(R.id.tvFoodName)
        val servingsTextView = findViewById<TextView>(R.id.tvServings)
        val orderingNameTextView = findViewById<TextView>(R.id.tvOrderingName)
        val additionalNotesTextView = findViewById<TextView>(R.id.tvAdditionalNotes)

        foodNameTextView.text = foodName
        servingsTextView.text = "Number of Servings: $servings"
        orderingNameTextView.text = "Ordering Name: $orderingName"
        additionalNotesTextView.text = "Additional Notes: $additionalNotes"

        val btnBackToMenu = findViewById<Button>(R.id.backtoMenu)
        btnBackToMenu.setOnClickListener {
            val intent_BackToMenu = Intent(this, ListFoodActivity::class.java)
            startActivity(intent_BackToMenu)
        }
    }
}