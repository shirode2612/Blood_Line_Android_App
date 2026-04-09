package com.example.bloodline.Fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bloodline.Adapter.AdminRequestlistAdapter;
import com.example.bloodline.Adapter.RequestlistAdapter;
import com.example.bloodline.DataModels.RequestModel;
import com.example.bloodline.R;
import com.example.bloodline.Utilities.DataBaseClient;

import java.util.ArrayList;
import java.util.List;

public class AdminRequestFragment extends Fragment
{
    List<RequestModel> rqlist=new ArrayList<>();
    RecyclerView rv_rfeed;
    Context ctx;

    @Override
    public void onAttach(@NonNull Context context)
    {
        super.onAttach(context);
        ctx=context;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        return inflater.inflate(R.layout.requestfeedrecyclerview,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);
        rv_rfeed=view.findViewById(R.id.rv_rfeed);

        rqlist= DataBaseClient.getInstance(getContext()).getDatabase()
                .requestDao().getAllRequest();

      /*  rqlist.add(new RequestModel("Komal Shirode","Jalgaon","AB+","3 bags","9325342307","30/12/19","10:00","Chinmay Hospital","For Operation"));
        rqlist.add(new RequestModel("Komal Shirode","Jalgaon","AB+","3 bags","9325342307","30/12/19","10:00","Chinmay Hospital","For Operation"));
        rqlist.add(new RequestModel("Komal Shirode","Jalgaon","AB+","3 bags","9325342307","30/12/19","10:00","Chinmay Hospital","For Operation"));
        rqlist.add(new RequestModel("Komal Shirode","Jalgaon","AB+","3 bags","9325342307","30/12/19","10:00","Chinmay Hospital","For Operation"));
        rqlist.add(new RequestModel("Komal Shirode","Jalgaon","AB+","3 bags","9325342307","30/12/19","10:00","Chinmay Hospital","For Operation"));
        rqlist.add(new RequestModel("Komal Shirode","Jalgaon","AB+","3 bags","9325342307","30/12/19","10:00","Chinmay Hospital","For Operation"));
*/


        AdminRequestlistAdapter adminRequestlistAdapter = new AdminRequestlistAdapter(rqlist,ctx);
        rv_rfeed.setLayoutManager(new LinearLayoutManager(ctx,LinearLayout.VERTICAL,false));
        rv_rfeed.setAdapter(adminRequestlistAdapter);
        adminRequestlistAdapter.notifyDataSetChanged();

    }

    @Override
    public void onDetach()
    {
        super.onDetach();
    }


}
