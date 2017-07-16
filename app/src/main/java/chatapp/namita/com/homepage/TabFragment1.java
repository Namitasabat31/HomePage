package chatapp.namita.com.homepage;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sahusun on 7/16/2017.
 */

public class TabFragment1 extends Fragment {
    private List<ImagesData> imageslist;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab_fragment_1, container, false);
        RecyclerView rv = (RecyclerView)view.findViewById(R.id.recycler_view);
        rv.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        rv.setLayoutManager(llm);
        initializeData();
        RVAdapter adapter = new RVAdapter(imageslist);
        rv.setAdapter(adapter);
        return view;
    }
    private void initializeData(){
        imageslist = new ArrayList<>();
        imageslist.add(new ImagesData("Emma Wilson", "2 hours ago", R.drawable.album1));
        imageslist.add(new ImagesData("Lavery Maiss", "5 hours ago", R.drawable.album2));
        imageslist.add(new ImagesData("Lillie Watts", "3 hours ago", R.drawable.album3));
        imageslist.add(new ImagesData("Emma Wilson", "8 hours ago", R.drawable.album4));
        imageslist.add(new ImagesData("Lavery Maiss", "25 hours ago", R.drawable.album5));
        imageslist.add(new ImagesData("Lillie Watts", "3 hours ago", R.drawable.album6));
    }
}
   class RVAdapter extends RecyclerView.Adapter<RVAdapter.PersonViewHolder>{
       List<ImagesData> imageslist;

       RVAdapter(List<ImagesData> imageslist){
           this.imageslist = imageslist;
       }
       @Override
       public PersonViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
           View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.images_row, parent, false);
           PersonViewHolder pvh = new PersonViewHolder(v);
           return pvh;
       }

       @Override
       public void onBindViewHolder(PersonViewHolder holder, int i) {
           holder.personName.setText(imageslist.get(i).name);
           holder.personAge.setText(imageslist.get(i).age);
           holder.personPhoto.setImageResource(imageslist.get(i).photoId);
       }

       @Override
       public int getItemCount() {
           return imageslist.size();
       }

       public static class PersonViewHolder extends RecyclerView.ViewHolder {
            CardView cv;
            TextView personName;
            TextView personAge;
            ImageView personPhoto;

            PersonViewHolder(View itemView) {
                super(itemView);
                cv = (CardView)itemView.findViewById(R.id.cv);
                personName = (TextView)itemView.findViewById(R.id.person_name);
                personAge = (TextView)itemView.findViewById(R.id.person_age);
                personPhoto = (ImageView)itemView.findViewById(R.id.person_photo);
            }
        }

    }

