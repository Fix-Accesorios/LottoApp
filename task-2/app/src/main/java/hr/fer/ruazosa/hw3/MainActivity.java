package hr.fer.ruazosa.hw3;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends Activity {

    private static Button lottoCalc;
    private static Button lottoTicket;
    private static Button wheel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        onClickButtonListener1();
        onClickButtonListener2();
        onClickButtonListener3();
    }

    public void onClickButtonListener1(){
        lottoCalc = (Button)findViewById(R.id.launch_chance_calculator);
        lottoCalc.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(MainActivity.this, LottoChanceCalculatorActivity.class);
                        startActivity(intent);
                    }
                }
        );
    }

    public void onClickButtonListener2(){
        lottoCalc = (Button)findViewById(R.id.launch_ticket_creator);
        lottoCalc.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(MainActivity.this, LottoTicketCreatorActivity.class);
                        startActivity(intent);
                    }
                }
        );
    }

    public void onClickButtonListener3(){
        lottoCalc = (Button)findViewById(R.id.launch_wheel_of_fortune);
        lottoCalc.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(MainActivity.this, WheelOfFortuneActivity.class);
                        startActivity(intent);
                    }
                }
        );
    }

    private void launchActivity(final Class<? extends Activity> activityClass) {
        final Intent i = new Intent(this, activityClass);
        startActivity(i);
    }

    private void launchWheelOfFortuneActivity() {
        launchActivity(WheelOfFortuneActivity.class);
    }

    private void launchChanceCalculatorActivity() {
        launchActivity(LottoChanceCalculatorActivity.class);
    }

    private void launchLottoTicketCreatorActivity() {
        launchActivity(LottoTicketCreatorActivity.class);
    }

}
