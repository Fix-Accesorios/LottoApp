package hr.fer.ruazosa.hw3;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class LottoChanceCalculatorActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lotto_chance_calculator);
        onClickButtonListener();
    }

    private EditText minor;
    private EditText major;
    private static Button calculate;
    private TextView result;

    public static int lotto(int n, int k){
		double fakt = 1;
		for(int i=1; i<=k; i++){
			double clan = n / i;
			fakt = fakt * clan;
			n = n-1;
		}
		return (int)fakt;
	}

    public void onClickButtonListener(){
        calculate = (Button)findViewById(R.id.calculator_calculate);
        calculate.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        minor = (EditText) findViewById(R.id.calculator_minor);
                        major = (EditText) findViewById(R.id.calculator_major);
                        result = (TextView) findViewById(R.id.calculator_result);

                        minor.addTextChangedListener(new TextWatcher() {
                            @Override
                            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                            }

                            @Override
                            public void onTextChanged(CharSequence s, int start, int before, int count) {

                            }

                            @Override
                            public void afterTextChanged(Editable s) {
                                int minorI = Integer.parseInt(minor.getText().toString());
                                int majorI = Integer.parseInt(major.getText().toString());

                                if(minorI > majorI){
                                    minor.setError("first number need to be smaller!");
                                }else if(minorI < 0){
                                    minor.setError("first number cant be negative!");
                                }else{
                                    minor.setError(null);
                                }
                            }
                        });

                        int minorI = Integer.parseInt(minor.getText().toString());
                        int majorI = Integer.parseInt(major.getText().toString());
                        int resValue = lotto(majorI, minorI);

                        result.setText("1 in " + Integer.toString(resValue));

                    }
                }
        );
    }


}
