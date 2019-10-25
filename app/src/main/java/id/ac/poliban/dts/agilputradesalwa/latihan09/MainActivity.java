package id.ac.poliban.dts.agilputradesalwa.latihan09;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Button;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private EditText etFirts;
    private EditText etSecond;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etFirts = findViewById(R.id.etFirst);
        etSecond = findViewById(R.id.etSecond);
        Button btCalculate = findViewById(R.id.btCalculate);

        btCalculate.setOnClickListener(v -> {
            int fno = Integer.parseInt(etFirts.getText().toString());
            int sno = Integer.parseInt(etSecond.getText().toString());
            Intent intent = new Intent(this, Activity_Calculate.class);
            intent.putExtra("fno", fno);
            intent.putExtra("sno", sno);
            startActivity(intent);
        });
    }

    @Override
    public void onBackPressed(){
        new AlertDialog.Builder(this)
                .setTitle("close confirmation")
                .setTitle("close app?")
                .setIcon(android.R.drawable.star_big_on)
                .setCancelable(true)
                .setPositiveButton("YES", ((dialog, which) -> super.onBackPressed()))
                .setNegativeButton("NO", null)
                .show();
    }

    @Override
    protected void onStart(){
        super.onStart();
        etFirts.setText("");
        etSecond.setText("");
        etFirts.requestFocus();
    }
}
