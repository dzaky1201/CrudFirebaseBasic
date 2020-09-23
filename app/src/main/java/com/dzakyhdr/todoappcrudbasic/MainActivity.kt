package com.dzakyhdr.todoappcrudbasic

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    //buat variable database reference yang akan diisi oleh database firebase
    private lateinit var databaseRef: DatabaseReference

    //variable cekData dibuat untuk read
    private lateinit var cekData: DatabaseReference

    //untuk memantau perubahan database
    private lateinit var readDataListener: ValueEventListener

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        databaseRef = FirebaseDatabase.getInstance().reference
        //ketika tombol tambah diklik
        btn_tambah.setOnClickListener {
            //ambil text dari edittext input nama
            val nama = input_nama.text.toString()
            if (nama.isBlank()){
                toastData("Kolom Nama Harus Diisi")
            }
        }
    }

    private fun toastData(pesan: String){
        Toast.makeText(this, pesan, Toast.LENGTH_SHORT).show()
    }

}