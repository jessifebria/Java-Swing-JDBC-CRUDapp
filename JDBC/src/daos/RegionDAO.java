package daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import static jdk.nashorn.internal.runtime.Debug.id;
import models.Region;
import tools.koneksi;

public class RegionDAO {

    private Connection con = null;

    //koneksi
    public RegionDAO() {
        this.con = new koneksi().getkoneksi();
    }

    //ambil data region, return semua data dr region
    public List<Region> getRegion() {

        List<Region> data = new ArrayList<>();
        String query = "SELECT * FROM region";

        try {
            PreparedStatement statement = con.prepareStatement(query);
            ResultSet hasil = statement.executeQuery();

            while (hasil.next()) {
                Region region = new Region(hasil.getInt("id"), hasil.getString("name"));
                data.add(region);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return data;

    }

    public boolean insert(Region region) {
        boolean result = false;
        String query = "INSERT INTO region VALUES (?,?)";
        try {
            PreparedStatement statement = con.prepareStatement(query);
            statement.setInt(1, region.getId());
            statement.setString(2, region.getName());
            statement.executeUpdate();
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    public boolean update(Region region) {
        boolean result = false;
        String query = "UPDATE region SET name=? WHERE id=? ";
        try {
            PreparedStatement statement = con.prepareStatement(query);
            statement.setInt(2, region.getId());
            statement.setString(1, region.getName());
            statement.executeUpdate();
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;

    }

    public boolean delete(int id) {
        boolean result = false;
        String query = "DELETE  FROM region WHERE id=?";
        try {
            PreparedStatement statement = con.prepareStatement(query);
            statement.setInt(1, id);
            statement.executeUpdate();
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    public List<Region> search(String keyword) {

        List<Region> data = new ArrayList<>();
        String query = "SELECT * FROM region WHERE id LIKE ? OR name LIKE ?";

        try {
            PreparedStatement statement = con.prepareStatement(query);
            statement.setString(1, "%" + keyword + "%");
            statement.setString(2, "%" + keyword + "%");
            ResultSet hasil = statement.executeQuery();

            while (hasil.next()) {
                Region region = new Region(hasil.getInt("id"), hasil.getString("name"));
                data.add(region);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return data;

    }

    public List<Region> getbyid(int id) {
        List<Region> data = new ArrayList<>();
        String query = "SELECT * FROM region WHERE id= ?";

        try {
            PreparedStatement statement = con.prepareStatement(query);
            statement.setInt(1, id);
            ResultSet hasil = statement.executeQuery();

            while (hasil.next()) {
                Region region = new Region(hasil.getInt("id"), hasil.getString("name"));
                data.add(region);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return data;

    }

}
