package hr.fer.ruazosa.if47987.hw4.colorflavor.mylibrary;

/**
 * Created by Tiyanak on 18.4.2016..
 */
import android.app.Activity;
import android.os.Handler;
import android.widget.Toast;

import java.lang.Object.*;

public class timeBomb {

    private Activity isus;

    public timeBomb(Activity activity){
        Handler h = new Handler();
        Handler r = new Handler();

        this.isus = activity;

        r.postDelayed(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(isus, "10 sec more", Toast.LENGTH_LONG).show();
            }
        }, 50000);

        h.postDelayed(new Runnable() {
            @Override
            public void run() {
                android.os.Process.killProcess(android.os.Process.myPid());
                System.exit(1);
            }
        }, 60000);
    }




}
