package cpsc411.miniapp1

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.text.Editable
import android.text.TextWatcher
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val nsField = editText
        val fsField = editText2
        val result = textView3

        nsField.text = Editable.Factory.getInstance().newEditable("1")
        fsField.text = Editable.Factory.getInstance().newEditable("1")
        result.text = String.format("%1$,.1f seconds", 8.2)

        nsField.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {

            }

            override fun afterTextChanged(s: Editable) {
                if (s.isEmpty()) {
                    nsField.text = Editable.Factory.getInstance().newEditable("1")
                } else {
                    val networkSpeed = s.toString().toDouble()*1000
                    val fsField = editText2
                    val fileSize = fsField.text.toString().toDouble() * 1024.0 * 8.0
                    val result = textView3
                    result.text = String.format("%1$,.1f seconds", 1 / networkSpeed * fileSize)
                }

            }
        })

        fsField.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {

            }

            override fun afterTextChanged(s: Editable) {
                if (s.isEmpty()) {
                    fsField.text = Editable.Factory.getInstance().newEditable("1")

                } else {
                    val fileSize = s.toString().toDouble() * 1024.0 * 8.0
                    val nsField = editText
                    val networkSpeed = nsField.text.toString().toDouble() * 1000
                    val result = textView3
                    result.text = String.format("%1$,.1f seconds", 1 / networkSpeed * fileSize)
                }
            }
        })
    }


}
