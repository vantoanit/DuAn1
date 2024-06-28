package congntph34559.fpoly.duan1newapplication.DAO;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import congntph34559.fpoly.duan1newapplication.DBHelper.MyDBHelper;
import congntph34559.fpoly.duan1newapplication.DTO.DanhSachSanPhamDTO;

public class ThongKeDAO {
    MyDBHelper myDBHelper;
    SQLiteDatabase sqLiteDatabase;
    public ThongKeDAO(Context context){
        myDBHelper = new MyDBHelper(context);
        sqLiteDatabase = myDBHelper.getWritableDatabase();
    }

    public int getDoanhThu(String ngaybatdau, String ngayketthuc){
//        ngaybatdau = ngaybatdau.replace("/", "");
//        ngayketthuc =  ngayketthuc.replace("/", "");
//        SQLiteDatabase  sqLiteDatabase = myDBHelper.getWritableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT SUM(tong_tien) FROM tb_hoa_don WHERE ngay_dat  BETWEEN ? AND ? AND trang_thai LIKE '%Đã thanh toán%' ",new String[]{ngaybatdau, ngayketthuc});
        ArrayList<Integer> list = new ArrayList<>();

        if(cursor.getCount() > 0){
            cursor.moveToFirst();
          //  return cursor.getInt(0);
            while (!cursor.isAfterLast()){
                try {
                    int doanhthu = cursor.getInt(0);
                    list.add(doanhthu);
                }catch (Exception e){
                    list.get(0);
                }
                cursor.moveToNext();

            }

        }
        return list.get(0);
    }
}
