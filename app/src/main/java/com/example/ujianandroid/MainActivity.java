package com.example.ujianandroid;

import static com.example.ujianandroid.R.id;
import static com.example.ujianandroid.R.layout;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_main);

        EditText edNamaDepan = (EditText) findViewById(id.edNamaDepan);
        EditText edNamaBelakang = (EditText) findViewById(id.edNamaBelakang);
        EditText edUmur = (EditText) findViewById(id.edUmur);
        Button btnSimpan = (Button) findViewById(id.btnSimpan);

        ArrayList<String> daftar_nama = new ArrayList<>();

        Intent intent_list = new Intent(MainActivity.this, ListActivity.class);

        btnSimpan.setOnClickListener(view -> {
            String isian_nama_depan = edNamaDepan.getText().toString();
            String isian_nama_belakang = edNamaBelakang.getText().toString();
            String isian_umur = edUmur.getText().toString();

            if(isian_nama_depan.isEmpty() && isian_nama_belakang.isEmpty() && isian_umur.isEmpty()){
                Toast.makeText(getApplicationContext(), "Isian masih kosong", Toast.LENGTH_SHORT).show();
            }else{
                int counter = Integer.parseInt(isian_umur);
                String nama_lengkap = isian_nama_depan.concat(" ").concat(isian_nama_belakang).concat(", ").concat("Status : ");
                daftar_nama.clear();
                for(Integer i = 1; i <= counter; i++) {
                    if(counter <= 10) {
                        daftar_nama.add( i + " " +  nama_lengkap.concat("Anak"));
                    } else if(counter <= 20) {
                        daftar_nama.add( i + " " +  nama_lengkap.concat("Remaja"));
                    } else if(counter <= 40) {
                        daftar_nama.add( i + " " +  nama_lengkap.concat("Dewasa"));
                    } else {
                        daftar_nama.add( i + " " +  nama_lengkap.concat("Tua"));
                    }
                    edNamaDepan.setText("");
                    edNamaBelakang.setText("");
                    intent_list.putStringArrayListExtra("daftar_nama", daftar_nama);
                    startActivity(intent_list);
                }
            }
        });
    }
}