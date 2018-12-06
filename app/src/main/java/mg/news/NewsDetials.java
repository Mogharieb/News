package mg.news;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;


import com.squareup.picasso.Picasso;

public class NewsDetials extends AppCompatActivity {

    private TextView titleND;
    private TextView dateND;
    private ImageView imageND;
    private TextView descND;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_detials);

        titleND = findViewById(R.id.title_detials);
        dateND=findViewById(R.id.data_details);
        imageND = findViewById(R.id.image_detial);
        descND = findViewById(R.id.desc_detials);

        Intent intent = getIntent();
        titleND.setText(intent.getStringExtra("title"));
        dateND.setText(intent.getStringExtra("date"));
        Picasso.get().load(intent.getStringExtra("image")).into(imageND);
        descND.setText(intent.getStringExtra("desc"));




    }
}
