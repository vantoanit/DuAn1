package congntph34559.fpoly.duan1newapplication.Fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import congntph34559.fpoly.duan1newapplication.Adapter.AdapterDonDangGiaoUser;
import congntph34559.fpoly.duan1newapplication.DAO.DonDatUserDAO;
import congntph34559.fpoly.duan1newapplication.DTO.DonDatUserDTO;
import congntph34559.fpoly.duan1newapplication.R;

public class FragGiaoHangUser extends Fragment {

    RecyclerView recyclerView;
    DonDatUserDAO donDatUserDAO;
    List<DonDatUserDTO> list;
    AdapterDonDangGiaoUser adapterDonDangGiaoUser;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.frag_giao_hang_user, container, false);
    }

    @SuppressLint("NotifyDataSetChanged")
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        recyclerView = view.findViewById(R.id.rcvDonGiaoHangUser);
        donDatUserDAO = new DonDatUserDAO(getContext());
        list = donDatUserDAO.selectDangGiaoHang();
        adapterDonDangGiaoUser = new AdapterDonDangGiaoUser(getContext(), list);
        LinearLayoutManager manager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adapterDonDangGiaoUser);
        adapterDonDangGiaoUser.notifyDataSetChanged();


        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onResume() {
        super.onResume();
        donDatUserDAO = new DonDatUserDAO(getContext());
        list = donDatUserDAO.selectDangGiaoHang();
        adapterDonDangGiaoUser = new AdapterDonDangGiaoUser(getContext(), list);
        LinearLayoutManager manager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adapterDonDangGiaoUser);
        adapterDonDangGiaoUser.notifyDataSetChanged();


    }
}
