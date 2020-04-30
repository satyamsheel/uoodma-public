package com.example.uoodma.UploadDocFrags;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.uoodma.R;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class UploadDocFragmentOne extends Fragment {

    RecyclerView recyclerView;
    UploadDocAdapter uploadDocAdapter;
    ArrayList<String> docList = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
         View view = inflater.inflate(R.layout.upload_doc_frag_one, container, false);


        addListItem();
        recyclerView = view.findViewById(R.id.docRcyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        uploadDocAdapter = new UploadDocAdapter(view.getContext(), docList);
        recyclerView.setAdapter(uploadDocAdapter);
        recyclerView.addItemDecoration(new
                DividerItemDecoration(getActivity(),
                DividerItemDecoration.VERTICAL));
        return view;
    }

    public void addListItem(){
        for (String strings: UploadDocTypes.firstFragDocNames){
            docList.add(strings);

        }
    }
}
