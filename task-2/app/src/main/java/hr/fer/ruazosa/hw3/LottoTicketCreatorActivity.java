package hr.fer.ruazosa.hw3;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.*;

public class LottoTicketCreatorActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lotto_ticket_creator);
        onClickButtonListener();
    }

    public static List<Integer> luckyNumbers(int n, int max){
        List<Integer> brojevi = new ArrayList<>();
        Random r = new Random();
        for(int i=0; i<n; i++){
            int broj = r.nextInt(max+1)+1;
            while(brojevi.contains(broj)){
                broj = r.nextInt(max-1)+1;
            }
            brojevi.add(broj);
        }
        return brojevi;
    }

    private Button ticket;
    private EditText minor;
    private EditText major;
    private TextView result;

    public void onClickButtonListener(){
        ticket = (Button)findViewById(R.id.creator_generate);
        ticket.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        minor = (EditText) findViewById(R.id.calculator_minor);
                        major = (EditText) findViewById(R.id.calculator_major);
                        result = (TextView) findViewById(R.id.creator_result);

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

                        List<Integer> lista = new ArrayList<Integer>();
                        lista = luckyNumbers(minorI, majorI);

                        String brojevi = "";
                        for(int i=0; i<lista.size(); i++){
                            int broj = lista.get(i);
                            brojevi = brojevi + " " + Integer.toString(broj);
                        }

                        result.setText(brojevi.toString());


                    }
                }
        );
    }
}
