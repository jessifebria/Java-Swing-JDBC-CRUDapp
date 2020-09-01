package daos;

import com.mysql.jdbc.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import models.Country;
import tools.koneksi;

public class CountryDAO {

    private Connection con = null;

    public CountryDAO() {
        this.con = new koneksi().getkoneksi();
    }

    //ambil data country, return semua data dr region
    public List<Country> getCountry() {

        List<Country> data = new ArrayList<>();
        String query = "SELECT country.id,country.name,country.region,region.name FROM country INNER JOIN region ON country.region=region.id";

        try {
            PreparedStatement statement = con.prepareStatement(query);
            ResultSet hasil = statement.executeQuery();

            while (hasil.next()) {
                Country country = new Country(hasil.getString(1), hasil.getString(2), hasil.getInt(3), hasil.getString(4));
                data.add(country);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return data;

    }

    public boolean insert(Country country) {
        boolean result = false;
        String query = "INSERT INTO country VALUES (?,?,?)";
        try {
            PreparedStatement statement = con.prepareStatement(query);
            statement.setString(1, country.getId());
            statement.setString(2, country.getName());
            statement.setInt(3, country.getRegion());
            statement.executeUpdate();
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    public boolean update(Country country) {
        boolean result = false;
        String query = "UPDATE country SET name=?, region=? WHERE id=? ";
        try {
            PreparedStatement statement = con.prepareStatement(query);
            statement.setString(1, country.getName());
            statement.setInt(2, country.getRegion());
            statement.setString(3, country.getId());
            statement.executeUpdate();
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;

    }

    public boolean delete(String id) {
        boolean result = false;
        String query = "DELETE  FROM country WHERE id=?";
        try {
            PreparedStatement statement = con.prepareStatement(query);
            statement.setString(1, id);
            statement.executeUpdate();
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    public List<Country> search(String keyword) {

        List<Country> data = new ArrayList<>();
        String query = "SELECT country.id,country.name,country.region,region.name FROM country INNER JOIN region on country.region=region.id WHERE country.id LIKE ? OR country.name LIKE ? OR country.region LIKE ? OR region.name LIKE ?";

        try {
            PreparedStatement statement = con.prepareStatement(query);
            statement.setString(1, "%" + keyword + "%");
            statement.setString(2, "%" + keyword + "%");
            statement.setString(3, "%" + keyword + "%");
            statement.setString(4, "%" + keyword + "%");
            ResultSet hasil = statement.executeQuery();

            while (hasil.next()) {
                Country country = new Country(hasil.getString(1), hasil.getString(2), hasil.getInt(3), hasil.getString(4));
                data.add(country);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return data;

    }

    public List<Country> getbyid(String id) {
        List<Country> data = new ArrayList<>();
        String query = "SELECT country.id,country.name,country.region,region.name FROM country INNER JOIN region ON country.region=region.id WHERE country.id= ?";

        try {
            PreparedStatement statement = con.prepareStatement(query);
            statement.setString(1, id);
            ResultSet hasil = statement.executeQuery();

            while (hasil.next()) {
                Country country = new Country(hasil.getString(1), hasil.getString(2), hasil.getInt(3), hasil.getString(4));
                data.add(country);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return data;

    }

    public List<Country> getbyregion(int region) {
        List<Country> data = new ArrayList<>();
        String query = "SELECT country.id,country.name,country.region,region.name FROM country INNER JOIN region ON country.region=region.id WHERE country.region= ?";

        try {
            PreparedStatement statement = con.prepareStatement(query);
            statement.setInt(1, region);
            ResultSet hasil = statement.executeQuery();

            while (hasil.next()) {
                Country country = new Country(hasil.getString(1), hasil.getString(2), hasil.getInt(3), hasil.getString(4));
                data.add(country);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return data;

    }
}
