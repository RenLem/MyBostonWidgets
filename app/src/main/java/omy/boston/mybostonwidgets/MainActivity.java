package omy.boston.mybostonwidgets;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView tekst = (TextView) findViewById(R.id.textView_tekst);
        final EditText wrightSomething = (EditText) findViewById(R.id.editText_wrigrtSomething);
        final Button button = (Button) findViewById(R.id.button);

        /**Stavlja uneseni tekst u dispaly**/
        button.setOnClickListener(
                new Button.OnClickListener(){
                    @Override
                    public void onClick(View view) {
                        //Dohvačanje tekstova iz objekata
                        String uneseniTekst = wrightSomething.getText().toString();
                        String postojeciTekst = ((TextView) findViewById(R.id.textView_tekst)).getText().toString();

                        if (wrightSomething.length()>0){
                            ((TextView) findViewById(R.id.textView_tekst)).setText(postojeciTekst + (char)10 + uneseniTekst);
                            wrightSomething.setText("");
                        }else{
                            Toast toast = Toast.makeText(MainActivity.this, "Oups! Tekst upiši! ;)", Toast.LENGTH_SHORT);
                            toast.show();
                        }
                    }
                }
        );

        /**Brisanje sa LongClicom**/
        button.setOnLongClickListener(
                new Button.OnLongClickListener(){
                    public boolean onLongClick(View view){
                        ((TextView) findViewById(R.id.textView_tekst)).setText("");
                        return true;
                    }
                }
        );



    }// onCreate the end!

    @Override
    protected void onStart() {
        super.onStart();
    }

    /**Metoda za povratak podataka**/
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        qLog("Zabilježena je metoda - onRestoreInstanceState");
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    /**Spremanje podataka**/
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        qLog("Zabilježena je metoda - onSaveInstanceState");
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    //Pračenje loga
    private void qLog(String logTekst){
        Log.d("napravi Log", logTekst);
    }

}
