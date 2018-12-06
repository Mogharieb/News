package mg.news;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class AdabterNews extends RecyclerView.Adapter<AdabterNews.ViewHolder> implements View.OnClickListener{

    ArrayList<Datacaps> arrayList;
    Context context;
    Datacaps datacaps =new Datacaps();
    MainActivity mainActivity;

    public AdabterNews(ArrayList<Datacaps> arrayList, Context context ,MainActivity mainActivity) {
        this.arrayList = arrayList;
        this.context = context;
        this.mainActivity=mainActivity;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder( ViewGroup parent, int i) {
         View Layout =LayoutInflater.from(parent.getContext()).inflate(R.layout.news_veiw,parent,false);
         ViewHolder viewHolder=new ViewHolder(Layout);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder( ViewHolder viewHolder, int i) {
         datacaps =arrayList.get(i);
         viewHolder.cardViewVH.setTag(i);

         viewHolder.titleVH.setText(datacaps.getTitle());
       //  viewHolder.descVH.setText(datacaps.getDescrption());
        Picasso.get().load(datacaps.getImg()).into(viewHolder.imageVH);
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    @Override
    public void onClick(View v) {

    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
    {
        private TextView titleVH;
      //  private TextView descVH;
        private ImageView imageVH;
        private CardView cardViewVH;


        public ViewHolder( View itemView) {
            super(itemView);
            titleVH =itemView.findViewById(R.id.title_textview);
            //descVH = itemView.findViewById(R.id.description_Textview);
            imageVH = itemView.findViewById(R.id.newsimage);
            cardViewVH=itemView.findViewById(R.id.card_view);
            cardViewVH.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            int postion = (int) v.getTag();
            datacaps=arrayList.get(postion);

            Intent intent=new Intent(mainActivity,NewsDetials.class);
            intent.putExtra("title",datacaps.getTitle());
            intent.putExtra("date",datacaps.getDate());
            intent.putExtra("image",datacaps.getImg());
            intent.putExtra("desc",datacaps.getDescrption());
            mainActivity.startActivity(intent);

        }
    }
}
