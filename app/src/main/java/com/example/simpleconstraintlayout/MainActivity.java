package com.example.simpleconstraintlayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //Deklarasi variabel untuk button
    Button btnLogin;

    //Deklarasi variabel untuk EditText
    EditText edemail, edpassword;

    TextView teksHasil;

    //Deklarasi variabel untuk menyimpan email dan password
    String nama, password ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Menghubungkan variabel btnLogin dengan componen button pada Layout
        btnLogin=findViewById(R.id.btSignin);

        //Menghubungkan variabel edemail dengan componen button pada Layout
        edemail=findViewById(R.id.edEmail);

        //Menghubungkan variabel edpassword dengan componen button pada Layout
        edpassword=findViewById(R.id.edPassword);

        teksHasil=(TextView)findViewById(R.id.textHasil);

        //membuat fungsi onclick pada button btnLogin
        btnLogin.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                //menyimpan input user di edittext password kedalam variable nama
                nama = edemail.getText().toString();

                //menyimpan input user di edittext password kedalam variable password
                password = edpassword.getText().toString();

                //mengeset email yang benar
                String email = "laela@gmail.com";

                //mengeset password yang benar
                String pass = "1234";

                //mengecek apakah edittext email dan password terdapat isi atau tidak
                if (nama.isEmpty() || password.isEmpty()) {
                    //membuat variable toast dan menampilkan pesan "edittext tidak boleh kosong"
                    Toast t = Toast.makeText(getApplicationContext(),
                            "Email dan password wajib diisi!!!",
                            Toast.LENGTH_LONG);
                } else {
                    //mengecek apakah isi dari email dan password
                    if (nama.equals(email) && password.equals(pass))
                    {
                        //membuat variabel toast dan menampilkan pesan "login sukses"
                        Toast t = Toast.makeText(getApplicationContext(),
                                "Login Sukses", Toast.LENGTH_LONG);
                        t.show();

                        //membuat objek bundle
                        Bundle b = new Bundle();

                        //memasukan value dari variable nama dengan kunci "a"
                        //dan dimasukan kedalam bundle
                        b.putString("a", nama.trim());

                        //masukan value dari variable password dengan kunci "b"
                        //dan dimasukan kedalam bundle
                        b.putString("b", password.trim());

                        //membuat objek intent berpindah activity dari mainactivity ke activityHasil
                        Intent i = new Intent(getApplicationContext(), ActivityKedua.class);

                        //memasukkan bundle kedalam intent untuk dikirimkan ke Activity Hasil
                        i.putExtras(b);

                        //berpindah ke activityHasil
                        startActivity(i);
                    } else {
                        //membuat variable toast dan membuat toast dan menampilkan pesan "login gagal
                        Toast t = Toast.makeText(getApplicationContext(),
                                "Login Gagal", Toast.LENGTH_LONG);

                        t.show();
                    }
                }
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //Method untuk menampilkan menu.
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        //Membuat kondisi jika yang dipilih adalah id mnDaftar
        if (item.getItemId() == R.id.mnDaftar)
        {
            //Method untuk memanggil activity "DaftarActivity"
            Intent i = new Intent(getApplicationContext(), Home_Activity.class);
            startActivity(i);
        }
        return super.onOptionsItemSelected(item);
    }
}