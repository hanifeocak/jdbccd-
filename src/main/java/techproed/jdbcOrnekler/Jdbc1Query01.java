package techproed.jdbcOrnekler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Jdbc1Query01 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		// 1) ilgili driver i yüklemeliyiz. Örnek: TVnin fisini tak, baska alet
		// calismasin, ne calisacagini bilsin
		Class.forName("com.mysql.cj.jdbc.Driver");

		// 2) Baglanti olusturmaliyiz uydu sifrelerini girmeliyiz
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sys?serverTimezone=UTC", "root",
				"1234");

		//// 3) SQL komutları için bir Statement nesnesi oluştur her kanal için kumanda
		//// da yer ayarlamak
		Statement st = con.createStatement();
		// SQL ifadeleri yazilabilir ve calstirilabiliriz durumda kumandada 1 'e basip
		// TRT1 'i calistirabiliriz
		ResultSet veri = st.executeQuery("Select isim,maas from personel where id=123456789");

		// 5) sonuçları aldık ve işledik

		while (veri.next()) {
			System.out.println(veri.getString("isim") + veri.getInt("maas"));
			System.out.println("Personel Adi : " + veri.getString(1) + "\nMaas : " + veri.getInt(2));
		}
			// olusturulan nesneleri bellekten kaldiralim
		    con.close();
			st.close();
			veri.close();
		}

	}


