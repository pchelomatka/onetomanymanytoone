package main.Service;


import main.domain.Employee;
import main.domain.Phone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import main.repository.PhoneRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class PhoneService {

    @Autowired
    private final PhoneRepository phoneRepository;

    public PhoneService(PhoneRepository phoneRepository) {
        this.phoneRepository = phoneRepository;
    }

    public List<Phone> getAllPhones() {
        List<Phone> phones = new ArrayList<>();
        phoneRepository.findAll().forEach(phones::add);
        return phones;
    }

    public Phone getOnePhone(Integer id) {
        return phoneRepository.findById(id).get();
    }

    public Phone savePhone(String type, String area_code, Integer p_number, Employee employee) {
        Phone phone = new Phone();
        phone.setType(type);
        phone.setArea_code(area_code);
        phone.setP_number(p_number);
        phone.setEmployee(employee);
        return phoneRepository.save(phone);
    }

    public void deletePhone(Integer id) {
        phoneRepository.deleteById(id);
    }


}
