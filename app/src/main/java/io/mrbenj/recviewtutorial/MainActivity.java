package io.mrbenj.recviewtutorial;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // Some Dummy Data
        ArrayList<String> myDataset = new ArrayList<>();
        myDataset.add(0, "Hello");
        myDataset.add(1, "Hi");
        myDataset.add(2, "Hello");
        myDataset.add(3, "Hel");

        // Your standard view linking
        RecyclerView mRecyclerView = (RecyclerView) findViewById(R.id.cardList);


        /**
         *
         * When using RecyclerView, you don't need to set a fixed size,
         * but you should really set a layout manager. The layout manager
         * sets how all the list items will be viewed (linear is most common
         * from what I'm inferring).
         *
         * If you don't specify a layout manager, then it's ok. Defaults are available
         * from good ol' Google.
         */


        mRecyclerView.setHasFixedSize(true);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        RecyclerView.Adapter mAdapter = new MyAdapter(myDataset);
        mRecyclerView.setAdapter(mAdapter);

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
