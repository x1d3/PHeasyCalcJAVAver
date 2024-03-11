package com.example.pheasycalc;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;



public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button Ibutton = findViewById(R.id.button6);
        Button Ubutton = findViewById(R.id.button);
        Button Abutton = findViewById(R.id.button5);
        Button Pbutton = findViewById(R.id.button3);
        Button Rbutton = findViewById(R.id.button1);
        Button Qbutton = findViewById(R.id.button4);
        Button OMbutton = findViewById(R.id.button2);

        String str = Test.INSTANCE.getHelloStr();

        Ibutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Iactivity1.class);
                startActivity(intent);
            }
        });

        Ubutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Uactivity1.class);
                startActivity(intent);
            }
        });

        Abutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Aactivity1.class);
                startActivity(intent);
            }
        });

        Pbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Pactivity1.class);
                startActivity(intent);
            }
        });

        Rbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Ractivity1.class);
                startActivity(intent);
            }
        });

        Qbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Qactivity1.class);
                startActivity(intent);
            }
        });

        OMbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, OMactivity1.class);
                startActivity(intent);
            }
        });
    }
}
