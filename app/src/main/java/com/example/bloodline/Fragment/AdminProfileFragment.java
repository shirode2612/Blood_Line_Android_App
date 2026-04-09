package com.example.bloodline.Fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.bloodline.R;

import de.hdodenhof.circleimageview.CircleImageView;

public class AdminProfileFragment extends Fragment
{
    TextView txtname,txtemail,txtpincode,txtno,txtbgroup,txtaddress;
    CircleImageView profile_new;



    @Override
    public void onAttach(@NonNull Context context)
    {
        super.onAttach(context);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        return inflater.inflate(R.layout.admin_profile_layout,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);

        txtname=view.findViewById(R.id.txtname);
        txtemail=view.findViewById(R.id.txtemail);
        txtno=view.findViewById(R.id.txtno);
        txtaddress=view.findViewById(R.id.txtaddress);
        txtpincode=view.findViewById(R.id.txtpincode);
        txtbgroup=view.findViewById(R.id.txtbgroup);
        profile_new=view.findViewById(R.id.profile_new);

    }

    @Override
    public void onDetach()
    {
        super.onDetach();
    }
}
