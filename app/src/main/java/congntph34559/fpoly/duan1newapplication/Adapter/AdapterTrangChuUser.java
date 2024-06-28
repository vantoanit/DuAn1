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
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.text.DecimalFormat;
import java.util.List;

import congntph34559.fpoly.duan1newapplication.ChiTietSanPhamActivity;
import congntph34559.fpoly.duan1newapplication.DAO.GioHangDAO;
import congntph34559.fpoly.duan1newapplication.DAO.SanPhamTrangChuDAO;
import congntph34559.fpoly.duan1newapplication.DTO.GioHangDTO;
import congntph34559.fpoly.duan1newapplication.DTO.SanPhamTrangChuUserDTO;
import congntph34559.fpoly.duan1newapplication.R;

public class AdapterTrangChuUser extends RecyclerView.Adapter<AdapterTrangChuUser.ViewHolder> {

    Context context;
    List<SanPhamTrangChuUserDTO> list;
    private GioHangDAO gioHangDAO;
    private List<GioHangDTO> listGioHang;
    DecimalFormat decimalFormat = new DecimalFormat("###,###,###");

    public AdapterTrangChuUser(Context context, List<SanPhamTrangChuUserDTO> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view1 = LayoutInflater.from(context).inflate(R.layout.item_san_pham_trang_chu, parent, false);

        return new ViewHolder(view1);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        SanPhamTrangChuUserDTO id = list.get(position);

        String tenImg = list.get(position).getAnhSanPhamUser();
        int resourceImg = (((Activity) context).getResources().
                getIdentifier(tenImg, "drawable", ((Activity) context).getPackageName()));
        holder.ivAnhSanPham.setImageResource(resourceImg);
        holder.tvTenSanPham.setText(list.get(position).getTenSanPhamUser());
        holder.tvGiaSanPham.setText(decimalFormat.format(list.get(position).getGiaSanPhamUser()) + " VND / 1kg");

        String base64 = list.get(position).getAnhSanPhamUser();
        try {
            byte[] imageBytes = android.util.Base64.decode(base64, Base64.DEFAULT);
            Bitmap bitmap = BitmapFactory.decodeByteArray(imageBytes, 0, imageBytes.length);
            if (bitmap != null) {
                holder.ivAnhSanPham.setImageBitmap(bitmap);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


        gioHangDAO = new GioHangDAO(context);
        listGioHang = gioHangDAO.getAll();
        holder.ivIconGioHang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String tenSanPham = id.getTenSanPhamUser();
                int donGia = id.getGiaSanPhamUser();
                String tenAnh = id.getAnhSanPhamUser();


                GioHangDTO objGioHang = new GioHangDTO();
                objGioHang.setTenSanPham(tenSanPham);
                objGioHang.setGiaSanPham(donGia);
                objGioHang.setImgSanPham(tenAnh);
                objGioHang.setSoLuongSanPham(1);
                objGioHang.setTongTienCuaSp(donGia);

                long kq = gioHangDAO.addRow(objGioHang);

                if (kq > 0) {

                    Toast.makeText(context, "Thêm thành công", Toast.LENGTH_SHORT).show();


                } else {

                    Toast.makeText(context, "Thêm thất bại", Toast.LENGTH_SHORT).show();

                }


            }
        });
        holder.layoutItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                remenberItem(id.getTenSanPhamUser(), id.getGiaSanPhamUser(), id.getAnhSanPhamUser(), id.getMoTaSp());
                Intent intent = new Intent(((Activity) context), ChiTietSanPhamActivity.class);
//                intent.putExtra("tenSp",id.getTenSanPhamUser());
//                intent.putExtra("giaSp",id.getGiaSanPhamUser());
//                intent.putExtra("anhSp",id.getAnhSanPhamUser());
//                intent.putExtra("moTaSp",id.getMoTaSp());
                ((Activity) context).startActivity(intent);


            }
        });


    }

    private void remenberItem(String tenSanPhamUser, int giaSanPham, String anhSp, String moTaSp) {

        SharedPreferences sharedPreferences = context.getSharedPreferences("PRODUCT", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("tenSp", tenSanPhamUser);
        editor.putInt("donGia", giaSanPham);
        editor.putString("anhSp", anhSp);
        editor.putString("moTa", moTaSp);
        editor.apply();


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        ImageView ivAnhSanPham, ivIconGioHang;
        TextView tvTenSanPham, tvGiaSanPham;
        CardView layoutItem;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            layoutItem = itemView.findViewById(R.id.layoutItemTrangChu);
            ivAnhSanPham = itemView.findViewById(R.id.imgSanPhamTrangChu);
            ivIconGioHang = itemView.findViewById(R.id.ivIconGioHangItem);
            tvGiaSanPham = itemView.findViewById(R.id.tvGiaSanPhamItemTrangChu);
            tvTenSanPham = itemView.findViewById(R.id.tvTenSanPhamItemTrangChu);

        }
    }

}
