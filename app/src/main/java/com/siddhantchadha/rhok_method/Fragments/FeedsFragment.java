package com.siddhantchadha.rhok_method.Fragments;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.siddhantchadha.rhok_method.Activities.QueryTaken;
import com.siddhantchadha.rhok_method.R;
import com.siddhantchadha.rhok_method.models.Query;

import java.util.ArrayList;

/**
 * Created by siddh on 7/16/2017.
 */

public class FeedsFragment extends Fragment {

    static ArrayList<Query> feeds = new ArrayList<Query>();
    public static int type = 0;
    static RecyclerView recyclerView;
    static FeedsAdapter homeFeedAdapter;
    DividerItemDecoration horizontalDecoration;
    Drawable horizontalDivider;
    static Context ctx;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_feed, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerview);
        feeds = createFeedsList(20);

        homeFeedAdapter = new FeedsAdapter(view.getContext(), feeds, type);
        recyclerView.setAdapter(homeFeedAdapter);

        ctx = view.getContext();
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));

//        horizontalDecoration = new DividerItemDecoration(recyclerView.getContext(),
//                DividerItemDecoration.VERTICAL);
//        horizontalDivider = ContextCompat.getDrawable(view.getContext(), R.drawable.horizontal_divider);
//        horizontalDecoration.setDrawable(horizontalDivider);
//        recyclerView.addItemDecoration(horizontalDecoration);

    }

       ArrayList<Query> createFeedsList(int num){
           ArrayList<Query> queryArrayList = new ArrayList<Query>();
           for (int i=0;i<num;i++){
               Query query = new Query();
               query.setId(i);
               query.setKey("random key "+ i);
               query.setQuery("this is a "+i+" number random query");
               queryArrayList.add(query);
           }

           return queryArrayList;
       }

    private  class FeedsAdapter extends RecyclerView.Adapter<MyViewHolder> {

        ArrayList<Query> list;


        public FeedsAdapter(Context context, ArrayList<Query> feeds, int type) {
            this.list=feeds;
        }

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

            View itemview= LayoutInflater.from(getActivity()).inflate(R.layout.feeds_holder, parent, false);


            return new MyViewHolder(itemview);
        }

        @Override
        public void onBindViewHolder(MyViewHolder holder, int position) {

            Query q= list.get(position);
            holder.queryTv.setText(q.getQuery());
            holder.takeQuery.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent= new Intent(getActivity(), QueryTaken.class);
                    startActivity(intent);
                }
            });

        }




        @Override
        public int getItemCount() {
            return list.size();
        }
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView queryTv;

        Button takeQuery;


        public MyViewHolder(View itemView) {



            super(itemView);


            queryTv= (TextView) itemView.findViewById(R.id.query);
            takeQuery= (Button) itemView.findViewById(R.id.takeUp);
        }
    }
}
