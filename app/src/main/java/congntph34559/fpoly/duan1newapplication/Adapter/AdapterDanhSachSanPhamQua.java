package congntph34559.fpoly.duan1newapplication.Adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.text.DecimalFormat;
import java.util.ArrayList;

import congntph34559.fpoly.duan1newapplication.ChiTietSanPhamActivity;
import congntph34559.fpoly.duan1newapplication.DAO.GioHangDAO;
import congntph34559.fpoly.duan1newapplication.DTO.DanhSachSanPhamDTO;
import congntph34559.fpoly.duan1newapplication.DTO.GioHangDTO;
import congntph34559.fpoly.duan1newapplication.R;

public class AdapterDanhSachSanPhamQua extends RecyclerView.Adapter<AdapterDanhSachSanPhamQua.ViewHolderQua> {

    ArrayList<DanhSachSanPhamDTO> list;
    Context context;
    GioHangDAO gioHangDAO;

    DecimalFormat decimalFormat = new DecimalFormat("###,###,###");

    public AdapterDanhSachSanPhamQua(ArrayList<DanhSachSanPhamDTO> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolderQua onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = ((Activity) context).getLayoutInflater();
        View view = inflater.inflate(R.layout.item_qua_danh_sach_san_pham_admin, parent, false);

        return new ViewHolderQua(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderQua holder, int position) {

        DanhSachSanPhamDTO id = list.get(position);

        String nameImg = list.get(position).getImg_url();
        int resourceImg = ((Activity) context).getResources().getIdentifier(nameImg, "drawable", ((Activity) context).getPackageName());

        holder.imgDanhSachSanPhamquaAdmin.setImageResource(resourceImg);
        holder.tvTenDanhSachSanPhamquaAdmin.setText(list.get(position).getTen_san_pham());
        holder.tvGiaSanPhamDanhSachSanPhamquaAdmin.setText(decimalFormat.format(list.get(position).getDon_gia()) + "VND / 1kg");

        String base64 = list.get(position).getImg_url();
        try {
            byte[] imageBytes = android.util.Base64.decode(base64, Base64.DEFAULT);
            Bitmap bitmap = BitmapFactory.decodeByteArray(imageBytes, 0, imageBytes.length);
            if (bitmap != null) {
                holder.imgDanhSachSanPhamquaAdmin.setImageBitmap(bitmap);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


        gioHangDAO = new GioHangDAO(context);
        holder.ivGioHang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String tenSp = id.getTen_san_pham();
                int giaSp = id.getDon_gia();
                String tenAnh = id.getImg_url();

                GioHangDTO objGioHang = new GioHangDTO();
                objGioHang.setTenSanPham(tenSp);
                objGioHang.setGiaSanPham(giaSp);
                objGioHang.setImgSanPham(tenAnh);
                objGioHang.setSoLuongSanPham(1);
                objGioHang.setTongTienCuaSp(giaSp);

                long kq = gioHangDAO.addRow(objGioHang);
                if (kq > 0) {

                    Toast.makeText(context, "Thêm thành công", Toast.LENGTH_SHORT).show();


                } else {

                    Toast.makeText(context, "Thêm thất bại", Toast.LENGTH_SHORT).show();

                }


            }
        });

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(((Activity) context), ChiTietSanPhamActivity.class);
//                intent.putExtra("tenSp",id.getTen_san_pham());
//                intent.putExtra("giaSp",id.getDon_gia());
//                intent.putExtra("anhSp",id.getImg_url());
//                intent.putExtra("moTaSp",id.getMo_ta());
                remenBerProduct(id.getTen_san_pham(), id.getDon_gia(), id.getImg_url(), id.getMo_ta());
                ((Activity) context).startActivity(intent);


            }
        });


    }

    private void remenBerProduct(String tenSanPham, int donGia, String imgUrl, String moTa) {

        SharedPreferences sharedPreferences = context.getSharedPreferences("PRODUCT", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("tenSp", tenSanPham);
        editor.putInt("doGia", donGia);
        editor.putString("anhSp", imgUrl);
        editor.putString("moTa", moTa);

        editor.apply();


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolderQua extends RecyclerView.ViewHolder {
        TextView tvTenDanhSachSanPhamquaAdmin, tvGiaSanPhamDanhSachSanPhamquaAdmin;
        ImageView imgDanhSachSanPhamquaAdmin, ivGioHang;


        public ViewHolderQua(@NonNull View itemView) {
            super(itemView);

            tvGiaSanPhamDanhSachSanPhamquaAdmin = itemView.findViewById(R.id.tvGiaSanPhamDanhSachSanPhamquaAdmin);
            tvTenDanhSachSanPhamquaAdmin = itemView.findViewById(R.id.tvTenDanhSachSanPhamquaAdmin);
            imgDanhSachSanPhamquaAdmin = itemView.findViewById(R.id.imgDanhSachSanPhamquaAdmin);
            ivGioHang = itemView.findViewById(R.id.ivIconGioHangItemQua);
        }
    }
}
