package sg.edu.rp.c346.id20022280.demomyprofile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView tvName,tvGPA,tvAge;
    EditText etName,etGPA,etAge;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = findViewById(R.id.editTextName);
        etGPA = findViewById(R.id.editTextGPA);
        etAge = findViewById(R.id.editTextAge);
    }

    //pause
    @Override
    protected void onPause() {
        super.onPause();
        String strName = etName.getText().toString();
        String strGPA = etGPA.getText().toString();
        float fltGPA = Float.parseFloat(strGPA);
        String strAge = etAge.getText().toString();
        int intAge = Integer.parseInt(strAge);

        SharedPreferences prefs = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor prefEdit = prefs.edit();

        prefEdit.putString("name",strName);
        prefEdit.putFloat("gpa",fltGPA);
        prefEdit.putInt("age",intAge);

        prefEdit.commit();
    }

    //resume
    @Override
    protected void onResume() {
        super.onResume();


        SharedPreferences prefs = getPreferences(MODE_PRIVATE);
        String strName = prefs.getString("name","No Name Set");

        Float fltGPA = prefs.getFloat("gpa",0.0f);
        String strGpa = String.valueOf(fltGPA);

        int intAge = prefs.getInt("age", 0);
        String strAge = String.valueOf(intAge);

        etName.setText(strName);
        etGPA.setText(strGpa);
        etAge.setText(strAge);


    }
}