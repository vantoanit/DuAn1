package congntph34559.fpoly.duan1newapplication.Fragment;

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

import congntph34559.fpoly.duan1newapplication.Adapter.DonDatAdminAdapter;
import congntph34559.fpoly.duan1newapplication.DAO.DonDatUserDAO;
import congntph34559.fpoly.duan1newapplication.DTO.DonDatUserDTO;
import congntph34559.fpoly.duan1newapplication.R;

public class DonDatAdminFragment extends Fragment {
    RecyclerView recyclerChoXacNhan;
    List<DonDatUserDTO> list;
    DonDatUserDAO donDatUserDAO;
    DonDatAdminAdapter adapter;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.cho_xac_nhan_don_fragment, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        super.onViewCreated(view, savedInstanceState);
        recyclerChoXacNhan = view.findViewById(R.id.recyclerChoXacNhan);

        donDatUserDAO = new DonDatUserDAO(getContext());
        list = donDatUserDAO.donDat();

        adapter = new DonDatAdminAdapter(list, getContext());
        LinearLayoutManager manager = new LinearLayoutManager(getContext(),
                LinearLayoutManager.VERTICAL, false);
        recyclerChoXacNhan.setLayoutManager(manager);
        recyclerChoXacNhan.setAdapter(adapter);


    }

    @Override
    public void onResume() {
        super.onResume();
        donDatUserDAO = new DonDatUserDAO(getContext());
        list = donDatUserDAO.donDat();
        adapter = new DonDatAdminAdapter(list, getContext());
        LinearLayoutManager manager = new LinearLayoutManager(getContext(),
                LinearLayoutManager.VERTICAL, false);
        recyclerChoXacNhan.setLayoutManager(manager);
        recyclerChoXacNhan.setAdapter(adapter);
    }
}
