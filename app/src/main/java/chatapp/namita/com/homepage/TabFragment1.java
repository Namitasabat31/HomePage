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
    private List<ImagesData> persons;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab_fragment_1, container, false);
        RecyclerView rv = (RecyclerView)view.findViewById(R.id.recycler_view);
        rv.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        rv.setLayoutManager(llm);
        initializeData();
        RVAdapter adapter = new RVAdapter(persons);
        rv.setAdapter(adapter);
        return view;
    }
    private void initializeData(){
        persons = new ArrayList<>();
        persons.add(new ImagesData("Emma Wilson", "23 years old", R.drawable.album1));
        persons.add(new ImagesData("Lavery Maiss", "25 years old", R.drawable.album2));
        persons.add(new ImagesData("Lillie Watts", "35 years old", R.drawable.album3));
        persons.add(new ImagesData("Emma Wilson", "23 years old", R.drawable.album4));
        persons.add(new ImagesData("Lavery Maiss", "25 years old", R.drawable.album5));
        persons.add(new ImagesData("Lillie Watts", "35 years old", R.drawable.album6));
    }
}
   class RVAdapter extends RecyclerView.Adapter<RVAdapter.PersonViewHolder>{
       List<ImagesData> persons;

       RVAdapter(List<ImagesData> persons){
           this.persons = persons;
       }
       @Override
       public PersonViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
           View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.images_row, parent, false);
           PersonViewHolder pvh = new PersonViewHolder(v);
           return pvh;
       }

       @Override
       public void onBindViewHolder(PersonViewHolder holder, int i) {
           holder.personName.setText(persons.get(i).name);
           holder.personAge.setText(persons.get(i).age);
           holder.personPhoto.setImageResource(persons.get(i).photoId);
       }

       @Override
       public int getItemCount() {
           return persons.size();
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

