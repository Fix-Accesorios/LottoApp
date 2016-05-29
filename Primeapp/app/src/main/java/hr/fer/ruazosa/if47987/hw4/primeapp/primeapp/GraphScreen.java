package hr.fer.ruazosa.if47987.hw4.primeapp.primeapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import org.apache.commons.math3.primes.Primes;
import java.util.*;
import com.github.mikephil.charting.charts.*;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;

public class GraphScreen extends AppCompatActivity {


    private TextView result;
    private EditText num_input;
    private List<Integer> lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graph_screen);

        //int num = Integer.parseInt(num_input.getText().toString());
        //String ps = "";
        //while(num>1){
        //   int n = Primes.nextPrime(num);
        //    ps = ps + n + " ";
        //    lista.add(n);
        //    num = num / n;
        //}

        Intent i = getIntent();
        int num = i.getIntExtra("NumPrimes", 2);
        result = (TextView)findViewById(R.id.primes_display);
        lista = new ArrayList<>();
        lista = Primes.primeFactors(num);

        String ps = "";
        for(int p: lista){
            ps = ps + p + " ";
        }
        result.setText(ps);

        LineChart chart = (LineChart)findViewById(R.id.chart);

        ArrayList<Entry> lista2 = new ArrayList<Entry>();
        int k = 0;
        for(int p2: lista){
            lista2.add(new Entry((float)p2, k));
            k = k + 1;
        }

        LineDataSet setComp = new LineDataSet(lista2, "primes");
        setComp.setAxisDependency(YAxis.AxisDependency.LEFT);
        ArrayList<ILineDataSet> dataSets = new ArrayList<ILineDataSet>();
        dataSets.add(setComp);

        ArrayList<String> vals = new ArrayList<>();
        vals.add("2");
        vals.add("3");
        vals.add("5");
        vals.add("7");
        LineData data = new LineData(vals, dataSets);
        chart.setData(data);

    }





}
