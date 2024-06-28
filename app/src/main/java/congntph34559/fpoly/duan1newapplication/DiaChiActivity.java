package congntph34559.fpoly.duan1newapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;

import congntph34559.fpoly.duan1newapplication.Adapter.DiaChiUserAdapter;
import congntph34559.fpoly.duan1newapplication.DAO.DiaChiKhachHangDAO;
import congntph34559.fpoly.duan1newapplication.DAO.ThongTinKhachHangDAO;
import congntph34559.fpoly.duan1newapplication.DTO.ThongTinKhachHangDTO;

public class DiaChiActivity extends AppCompatActivity {

    RecyclerView recyclerDiaChi;
    private ImageView imgBackDiaChi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dia_chi);

        recyclerDiaChi = findViewById(R.id.recyclerDiaChi);
        imgBackDiaChi = findViewById(R.id.imgBackDiaChi);
        imgBackDiaChi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        DiaChiKhachHangDAO diaChiKhachHangDAO = new DiaChiKhachHangDAO(this);
        ArrayList<ThongTinKhachHangDTO> list = diaChiKhachHangDAO.getDiaChiAll();
        LinearLayoutManager manager = new LinearLayoutManager(this);

        DiaChiUserAdapter adapter = new DiaChiUserAdapter(list, this);
        recyclerDiaChi.setLayoutManager(manager);
        recyclerDiaChi.setAdapter(adapter);

    }
}