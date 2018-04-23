package demo.com.my.handlerthread;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        HandlerThread handlerThread = new HandlerThread("handler_thread"){
            @Override
            protected void onLooperPrepared() {

            }
        };
        handlerThread.start();
        Handler handler = new Handler(handlerThread.getLooper()){
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                Log.i("我的消息", "线程： " + Thread.currentThread().getName());
            }
        };
        handler.sendEmptyMessageDelayed(1, 2000);
        Log.i("我的消息", "onCreate: " + Thread.currentThread().getName());
    }
}
