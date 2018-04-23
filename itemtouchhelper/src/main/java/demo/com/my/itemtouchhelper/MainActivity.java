package demo.com.my.itemtouchhelper;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

public class MainActivity extends AppCompatActivity {

    RecyclerView mRecyclerVeiw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerVeiw = findViewById(R.id.recyclerview);
        mRecyclerVeiw.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerVeiw.setHasFixedSize(true);
        MyAdapter mAdapter = new MyAdapter();
        mRecyclerVeiw.setAdapter(mAdapter);
        TouchHelperCallBack callBack = new TouchHelperCallBack(mAdapter);
        new ItemTouchHelper(callBack).attachToRecyclerView(mRecyclerVeiw);

    }
}
