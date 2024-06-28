package congntph34559.fpoly.duan1newapplication.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import congntph34559.fpoly.duan1newapplication.Adapter.AdapterDonHuyUser;
import congntph34559.fpoly.duan1newapplication.DAO.DonDatUserDAO;
import congntph34559.fpoly.duan1newapplication.DTO.DonDatUserDTO;
import congntph34559.fpoly.duan1newapplication.R;

public class FragDonHuyUser extends Fragment {

    RecyclerView recyclerView;
    List<DonDatUserDTO> list;
    DonDatUserDAO donDatUserDAO;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.frag_don_huy_user,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        recyclerView = view.findViewById(R.id.rcvDonHuyFragment);
        donDatUserDAO = new DonDatUserDAO(getContext());
        list = donDatUserDAO.donHuy();
        AdapterDonHuyUser adapterDonHuyUser = new AdapterDonHuyUser(getContext(),list);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext()
                ,LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapterDonHuyUser);
        adapterDonHuyUser.notifyDataSetChanged();



        super.onViewCreated(view, savedInstanceState);

    }

    @Override
    public void onResume() {
        super.onResume();
        donDatUserDAO = new DonDatUserDAO(getContext());
        list = donDatUserDAO.donHuy();
        AdapterDonHuyUser adapterDonHuyUser = new AdapterDonHuyUser(getContext(),list);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext()
                ,LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapterDonHuyUser);
        adapterDonHuyUser.notifyDataSetChanged();


    }
}
