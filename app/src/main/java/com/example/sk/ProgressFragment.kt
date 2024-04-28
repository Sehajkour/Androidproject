package com.example.sk
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.fragment.app.Fragment
import com.example.sk.R

class ProgressFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_progress, container, false)

        val button1 = view.findViewById<ImageButton>(R.id.img1)


        button1.setOnClickListener {
            val intent = Intent(activity, Progress1::class.java)
            startActivity(intent)
        }

        val button2 = view.findViewById<ImageButton>(R.id.img2)


        button2.setOnClickListener {
            val intent = Intent(activity, Progress2::class.java)
            startActivity(intent)
        }

        val button3 = view.findViewById<ImageButton>(R.id.img3)


        button3.setOnClickListener {
            val intent = Intent(activity, Progress3::class.java)
            startActivity(intent)
        }

        val button4 = view.findViewById<ImageButton>(R.id.img4)


        button4.setOnClickListener {
            val intent = Intent(activity, Progress4::class.java)
            startActivity(intent)
        }




        return view
    }
}
