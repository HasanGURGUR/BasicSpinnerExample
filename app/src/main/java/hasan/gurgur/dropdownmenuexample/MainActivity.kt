package hasan.gurgur.dropdownmenuexample


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.core.content.res.ResourcesCompat
import hasan.gurgur.dropdownmenuexample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    private val list  = arrayListOf<String>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        list.add("All Types")
        list.add("Assignments")
        list.add("Exam")
        list.add("Lab")

        val adapter = ArrayAdapter(
            this,
            R.layout.support_simple_spinner_dropdown_item,
            list
        )
        binding.typesFilter.setAdapter(adapter)

        binding.typesFilter.setDropDownBackgroundDrawable(
            ResourcesCompat.getDrawable(
                resources,
                R.drawable.filter_spinner_dropdown_bg,
                null
            )
        )

        binding?.typesFilter.onItemClickListener =
            AdapterView.OnItemClickListener { parent, view, position, id->
                Toast.makeText(this, "You clicked  " + list[position] , Toast.LENGTH_SHORT).show()
            }
    }
}