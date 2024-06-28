package congntph34559.fpoly.duan1newapplication.Fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import congntph34559.fpoly.duan1newapplication.Adapter.AdapterDanhSachSanPhamQua;
import congntph34559.fpoly.duan1newapplication.DAO.DanhSachSanPhamDAO;
import congntph34559.fpoly.duan1newapplication.DTO.DanhSachSanPhamDTO;
import congntph34559.fpoly.duan1newapplication.R;

public class FragQuaDanhSachSanPhamUse extends Fragment {
    public static RecyclerView recyclerDanhSachSanPhamQuaUse;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_qua_danh_sach_san_pham_user, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerDanhSachSanPhamQuaUse = view.findViewById(R.id.recyclerDanhSachSanPhamQuaUse);
        DanhSachSanPhamDAO danhSachSanPhamDAO = new DanhSachSanPhamDAO(getContext());
        ArrayList<DanhSachSanPhamDTO> list = danhSachSanPhamDAO.getDSSanPhamQua();

        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 2, GridLayoutManager.VERTICAL, false);
        recyclerDanhSachSanPhamQuaUse.setLayoutManager(gridLayoutManager);

        AdapterDanhSachSanPhamQua adapterDanhSachSanPhamQua = new AdapterDanhSachSanPhamQua(list, getContext());
        recyclerDanhSachSanPhamQuaUse.setAdapter(adapterDanhSachSanPhamQua);
        adapterDanhSachSanPhamQua.notifyDataSetChanged();
    }
}
