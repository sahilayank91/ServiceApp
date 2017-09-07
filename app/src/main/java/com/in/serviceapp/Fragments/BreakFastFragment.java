package com.in.serviceapp.Fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.in.serviceapp.R;

import static com.in.serviceapp.R.id.parent;


/**
 * Created by root on 6/9/17.
 */


import android.content.Context;

import android.content.Intent;

import android.content.res.Resources;

import android.content.res.TypedArray;

import android.graphics.drawable.Drawable;

import android.os.Bundle;


import android.support.v7.widget.LinearLayoutManager;

import android.support.v7.widget.RecyclerView;

import android.view.LayoutInflater;

import android.view.View;

import android.view.ViewGroup;

import android.widget.HorizontalScrollView;
import android.widget.ImageView;

import android.widget.TextView;



/**

 * Provides UI for the view with List.

 */

public class BreakFastFragment extends android.support.v4.app.Fragment {

    @Override

    public View onCreateView(LayoutInflater inflater, ViewGroup container,

                             Bundle savedInstanceState) {

        RecyclerView recyclerView = (RecyclerView) inflater.inflate(

                R.layout.recycler_view, container, false);

        ContentAdapter adapter = new ContentAdapter(recyclerView.getContext());

        recyclerView.setAdapter(adapter);

        recyclerView.setHasFixedSize(true);

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
     

        return recyclerView;

    }



    public static class ViewHolder extends RecyclerView.ViewHolder {

        public ImageView avator;

        public TextView name;

        public TextView description;

        public ViewHolder(LayoutInflater inflater, ViewGroup parent) {

            super(inflater.inflate(R.layout.item_list, parent, false));

            avator = (ImageView) itemView.findViewById(R.id.list_avatar);

            name = (TextView) itemView.findViewById(R.id.list_title);

            description = (TextView) itemView.findViewById(R.id.list_desc);

        }

    }

    /**

     * Adapter to display recycler view.

     */

    public static class ContentAdapter extends RecyclerView.Adapter<ViewHolder> {

        // Set numbers of List in RecyclerView.

        private static final int LENGTH = 18;


        public ContentAdapter(Context context) {

            Resources resources = context.getResources();




        }



        @Override

        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

            return new ViewHolder(LayoutInflater.from(parent.getContext()), parent);

        }



        @Override

        public void onBindViewHolder(ViewHolder holder, int position) {


        }



        @Override

        public int getItemCount() {

            return LENGTH;

        }

    }

}