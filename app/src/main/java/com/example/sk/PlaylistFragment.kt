import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Button
import android.widget.Toast
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.example.sk.R

class PlaylistFragment : Fragment() {

    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_playlist, container, false)

        val items = listOf("Fighter ", "Believer", "Demons", "Royals")

        val autoComplete: AutoCompleteTextView = view.findViewById(R.id.auto_complete)

        val adapter = ArrayAdapter(requireContext(), R.layout.list_item, items)

        autoComplete.setAdapter(adapter)

        autoComplete.onItemClickListener = AdapterView.OnItemClickListener { _, _, i, _ ->
            val itemSelected = adapter.getItem(i)
            Toast.makeText(requireContext(), "Item: $itemSelected", Toast.LENGTH_SHORT).show()
        }

        val playButton = view.findViewById<Button>(R.id.button)
        // Assuming you have a Button with the id "myButton" in your layout

        playButton.setOnClickListener {
            // Handle the click event for the play button
            onPlayButtonClicked()
        }

        return view
    }

    private fun onPlayButtonClicked() {

        // Handle the play button click event here
        Toast.makeText(requireContext(), "Play button clicked", Toast.LENGTH_SHORT).show()
    }
}
