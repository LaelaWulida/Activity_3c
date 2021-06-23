package com.example.simpleconstraintlayout;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class ActivityKedua extends AppCompatActivity {
    //Mendeklarasikan variable dengan tipe data TextView
    TextView txEmail, txPassword;
    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kedua);

        //menghubungkan variabel txEmail dengan componen TextView pada Layout
        txEmail = findViewById(R.id.tvEmail);

        //menghubungkan variable txEmail dengan componen Textview pada layout
        txPassword = findViewById(R.id.tvPassword);

        //mendeklarasikan variabel bundle yang akan digunakan untuk mengambil
        //pesan yang dikiramkan melalui method intent
        Bundle bundle = getIntent().getExtras();

        //membuat variable string yang digunakan untuk menyimpan data yang
        //dikirimkan dari activity sebelumnya dengan kunci "a"
        String email = bundle.getString("a");

        //membuat variable string yang digunakan untuk menyimpan data yang
        //dikirimkan dari activity sebelumnya dengan kunci "b"
        String pass = bundle.getString("b");

        //menampilkan value dari variable email kedalam txEmail
        txEmail.setText(email);

        //menampilkan value dari variable pass kedalam txPassword
        txPassword.setText(pass);

    }
}
