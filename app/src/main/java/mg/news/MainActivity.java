package mg.news;

import android.graphics.ColorSpace;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.widget.Toast;
import android.support.v7.widget.DividerItemDecoration;


import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity {

     final static String api="https://newsapi.org/v2/top-headlines?sources=bbc-news&apiKey=965ea98df5844da08ff4d95fe70783f4";
    private RecyclerView recyclerView;
     private AdabterNews adapter;
     Jsonparser parser =new Jsonparser();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Connector connector =new Connector();
        try {

            ArrayList<Datacaps>arrayList= parser.JsonProcess(connector.execute(api).get());

           Recyclerveiw_main();

        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
    private void  Recyclerveiw_main()
    {
         recyclerView= findViewById(R.id.recycler_view);
         RecyclerView.LayoutManager layoutManager =new LinearLayoutManager(getApplicationContext());
         recyclerView.setLayoutManager(layoutManager);
      //  recyclerView.addItemDecoration(new DividerItemDecoration(getApplicationContext(), DividerItemDecoration.VERTICAL));

         adapter =new AdabterNews(parser.getlist(),getApplicationContext(),this);
         recyclerView.setAdapter(adapter);
      //  recyclerView.setLayoutManager(new StaggeredGridLayoutManager(,StaggeredGridLayoutManager.VERTICAL));
         adapter.notifyDataSetChanged();

    }
}
