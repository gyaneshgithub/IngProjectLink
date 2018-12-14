package com.ing.atm.locator.service;

import com.ing.atm.locator.dao.AtmLocatorDao;
import com.ing.atm.locator.model.Location;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AtmLocatorService {

    @Autowired
    AtmLocatorDao atmLocatorDao;

    public List<Location> getAllLocation() {
        return atmLocatorDao.getAllLocation();
    }

    public Boolean addAtmLocation(Location location) {
        atmLocatorDao.addLocation(location);
        return true;
    }
}
