package controllers;

import daos.RegionDAO;
import java.util.List;
import models.Region;
import tools.koneksi;

public class RegionController {

    private RegionDAO rdao;

    public RegionController() {
        this.rdao = new RegionDAO();
    }

    public List<Region> binding() {
        return this.rdao.getRegion();
    }

    public String insert(String id, String name) {
        Region region = new Region(Integer.parseInt(id), name);
        if (this.rdao.insert(region)) {
            return "Insert data berhasil";
        } else {
            return "Insert data gagal";
        }
    }

    public String update(String id, String name) {
        Region region = new Region(Integer.parseInt(id), name);
        if (this.rdao.update(region)) {
            return "Update data berhasil";
        } else {
            return "Update data gagal";
        }
    }

    public String delete(String id) {
        int regionId = Integer.parseInt(id);
        if (this.rdao.delete(regionId)) {
            return "Hapus data berhasil";
        } else {
            return "Hapus data gagal";
        }

    }

    public List<Region> search(String keyword) {
        return this.rdao.search(keyword);
    }

    public List<Region> getbyid(String id) {
        return this.rdao.getbyid(Integer.parseInt(id));
    }
}
