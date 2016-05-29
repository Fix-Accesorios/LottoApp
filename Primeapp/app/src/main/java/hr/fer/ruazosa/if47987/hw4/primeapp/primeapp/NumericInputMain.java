package hr.fer.ruazosa.if47987.hw4.primeapp.primeapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class NumericInputMain extends AppCompatActivity {

    private EditText numInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numeric_input_main);
        clickButtonListener();


    }

    private Button validate;

    public void clickButtonListener(){
        validate = (Button) findViewById(R.id.num_validate_button);
        validate.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View v){
                        Intent intent = new Intent(NumericInputMain.this, GraphScreen.class);

                        EditText numText = (EditText) findViewById(R.id.num_validate_input);
                        int num =Integer.parseInt(numText.getText().toString());

                        if(num >= 1 && num <= 10000){
                            intent.putExtra("NumPrimes", num);
                            startActivity(intent);
                        }else{
                            Toast.makeText(NumericInputMain.this, "Number must be in [1-10000]", Toast.LENGTH_LONG).show();
                        }

                    }
                }
        );
    }
}
