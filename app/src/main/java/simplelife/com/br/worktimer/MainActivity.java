package simplelife.com.br.worktimer;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.beardedhen.androidbootstrap.BootstrapButton;

import java.util.concurrent.TimeUnit;


public class MainActivity extends Activity {

    private Long tempo_trabalho_diario = 28800000L;
    private Long startTime;
    private Long stopTime;
    private TextView preview;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BootstrapButton btnStart = (BootstrapButton) findViewById(R.id.btn_startWork);
        preview = (TextView) findViewById(R.id.txtPreview);

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getBaseContext(), "Iniciando contador", Toast.LENGTH_SHORT).show();
                startTime = System.currentTimeMillis();
            }
        });

        BootstrapButton btnStop = (BootstrapButton) findViewById(R.id.btn_stoptWork);
        btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopTime = System.currentTimeMillis();
            }
        });

        BootstrapButton btnPreview = (BootstrapButton) findViewById(R.id.btn_preview);
        btnPreview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Long previewLong  = System.currentTimeMillis();

                if(startTime != null){
                    previewLong = previewLong - startTime;
                    long l1 = tempo_trabalho_diario - previewLong;
                    long segundosL = TimeUnit.MILLISECONDS.toSeconds(l1);
                    long minutosL = TimeUnit.MILLISECONDS.toMinutes(l1);
                    long horasL = TimeUnit.MILLISECONDS.toHours(l1);


                    String minutos = "Faltam "+ minutosL + " minutos para ir embora!!";
                    String secondsStr = "Faltam "+ segundosL + " segundos para ir embora";
                    String horas = ("Faltam "+ horasL + " horas para ir embora");

                    preview.setText(minutos + "\n" + secondsStr + "\n" + horas);
                  //  preview.setText(""+ l1);
                }else{
                    Toast.makeText(getBaseContext(),"Comece o trabalho antes", Toast.LENGTH_SHORT).show();
                }


            }
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

    class Timer extends Handler{

    }


}
