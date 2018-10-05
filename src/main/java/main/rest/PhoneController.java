package main.rest;


import main.Service.PhoneService;
import main.domain.Employee;
import main.domain.Phone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PhoneController {

    @Autowired
    private final PhoneService phoneService;

    public PhoneController(PhoneService phoneService) {
        this.phoneService = phoneService;
    }

    @RequestMapping(value = "getAllPhones")
    public List<Phone> getAllPhones() {
        return phoneService.getAllPhones();
    }

    @RequestMapping(value = "getOnePhone")
    public Phone getOnePhone(Integer id) {
        return phoneService.getOnePhone(id);
    }

    @RequestMapping(value = "savePhone")
    public Phone savePhone(@RequestParam String type, String area_code, Integer p_number, Employee employee) {
        return phoneService.savePhone(type, area_code, p_number, employee);
    }

    @RequestMapping(value = "deletePhone")
    public void deletePhone(Integer id) {
        phoneService.deletePhone(id);
    }
}
