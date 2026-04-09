package com.example.bloodline.Fragment;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.SearchView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bloodline.Adapter.Admin_donor_list;
import com.example.bloodline.DataModels.DonorModel;
import com.example.bloodline.R;
import com.example.bloodline.Utilities.DataBaseClient;

import java.util.ArrayList;
import java.util.List;

public class AdminDonorFragment extends Fragment
{

    RecyclerView rvBloodGroup;
    List<DonorModel> donorList=new ArrayList<>();
    Context ctx;
    Admin_donor_list admin_donor_list;

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
        return inflater.inflate(R.layout.donorlistlayoutrecyclerview,container,false);

    }

    @SuppressLint("WrongConstant")
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);

        rvBloodGroup=view.findViewById(R.id.rvBloodGroup);

       donorList= DataBaseClient.getInstance(getContext())
                .getDatabase()
                .donorDao()
                .getAllDonor();

      donorList = DataBaseClient.getInstance(getContext()).getDatabase().donorDao().getAllDonor();


         admin_donor_list = new Admin_donor_list(donorList,ctx);
        rvBloodGroup.setLayoutManager(new LinearLayoutManager(ctx,LinearLayout.VERTICAL,false));
        rvBloodGroup.setAdapter(admin_donor_list);
        admin_donor_list.notifyDataSetChanged();

        setHasOptionsMenu(true);

    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater)
    {
        getActivity().getMenuInflater().inflate(R.menu.search_menu,menu);
        MenuItem menuItem = menu.findItem(R.id.action_search);
        SearchView searchView =(SearchView) menuItem.getActionView();
        searchView.setQueryHint("Search Donor");

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                final List<DonorModel>fList = filter(donorList,newText);
                admin_donor_list.setFilterList(fList);
                return true;
            }
        });

    }
    private List<DonorModel>filter(List<DonorModel>donerList,String newText)
    {
        final List<DonorModel>fList=new ArrayList<>();

        for (DonorModel donorModel : donerList)
        {
            final String text = donorModel.getD_bloodgoup().toLowerCase();
            if (text.contains(newText)){
                fList.add(donorModel);
            }
        }
        return fList;
    }

    @Override
    public void onDetach()
    {
        super.onDetach();
    }
}
