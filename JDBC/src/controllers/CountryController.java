/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.CountryDAO;
import java.util.List;
import models.Country;

/**
 *
 * @author JESSI
 */
public class CountryController {

    private CountryDAO cdao;

    public CountryController() {
        this.cdao = new CountryDAO();
    }

    public List<Country> binding() {
        return this.cdao.getCountry();
    }

    public String insert(String id, String name, String region) {
        Country country = new Country(id, name, Integer.parseInt(region));
        if (this.cdao.insert(country)) {
            return "Insert data berhasil";
        } else {
            return "Insert data gagal";
        }
    }

    public String update(String id, String name, String region) {
        Country country = new Country(id, name, Integer.parseInt(region));
        if (this.cdao.update(country)) {
            return "Update data berhasil";
        } else {
            return "Update data gagal";
        }
    }

    public String delete(String id) {
        if (this.cdao.delete(id)) {
            return "Hapus data berhasil";
        } else {
            return "Hapus data gagal";
        }

    }

    public List<Country> search(String keyword) {
        return this.cdao.search(keyword);
    }

    public List<Country> getbyid(String id) {
        return this.cdao.getbyid(id);
    }

    public List<Country> getbyregion(String region) {
        return this.cdao.getbyregion(Integer.parseInt(region));
    }
}
