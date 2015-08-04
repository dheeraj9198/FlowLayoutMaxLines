package mebeerhu.dheeraj.sachan.flowlayout;

import android.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.TextView;

import mebeerhu.dheeraj.sachan.flowlayout.flow.FlowLayout;

public class MainActivity extends ActionBarActivity {

    private FlowLayout flowLayout;
    private FlowLayout flowLayout0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        flowLayout = (FlowLayout) findViewById(R.id.flow);
        flowLayout0 = (FlowLayout) findViewById(R.id.flow0);
        for (int k = 0; k < 30; k++) {
            TextView textView = new TextView(this);
            float size = textView.getTextSize();
            textView.setText(String.valueOf(System.currentTimeMillis()) + "_" + k);
            textView.setPadding(10, 10, 10, 10);
            flowLayout.addView(textView);
        }

        ViewTreeObserver vto = flowLayout.getViewTreeObserver();
        vto.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                flowLayout.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                for (int k = 0; k < flowLayout.getMax(); k++) {
                    TextView textView = new TextView(MainActivity.this);
                    float size = textView.getTextSize();
                    textView.setText(String.valueOf(System.currentTimeMillis()) + "*" + k);
                    textView.setPadding(10, 10, 10, 10);
                    flowLayout0.addView(textView);
                }            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
