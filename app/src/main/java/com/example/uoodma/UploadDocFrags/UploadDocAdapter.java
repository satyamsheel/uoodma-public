package com.example.uoodma.UploadDocFrags;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.uoodma.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class UploadDocAdapter extends RecyclerView.Adapter<UploadDocAdapter.uploadDocViewHolder> {

    private ArrayList<String> list;
    Context context;
    FirebaseAuth auth;
    Button uploadButton2;

    public UploadDocAdapter(Context context, ArrayList<String> list) {
        this.list = list;
        this.context = context;

    }

    @NonNull
    @Override
    public uploadDocViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        FirebaseUser user = auth.getInstance().getCurrentUser();
        if (user.isEmailVerified()) {
         uploadButton2.setEnabled(true);
        } else {
     uploadButton2.setEnabled(false);
        }
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.doc_upload_item, parent, false);
        return new uploadDocViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull uploadDocViewHolder holder, int position) {
        String docTypeText = list.get(position);
        holder.documentType.setText(docTypeText);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class uploadDocViewHolder extends RecyclerView.ViewHolder{
        TextView documentType;

        public uploadDocViewHolder(@NonNull View itemView) {
            super(itemView);
            documentType = itemView.findViewById(R.id.documentType);
            uploadButton2=itemView.findViewById(R.id.uploadButton2);
        }
    }
}
