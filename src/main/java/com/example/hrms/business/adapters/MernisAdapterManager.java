package com.example.hrms.business.adapters;

import com.example.hrms.business.abstracts.IdentityValidationService;
import com.example.hrms.outsource.mernis.ISHKPSPublicSoap;
import com.example.hrms.outsource.mernis.ISHKPSPublicSoap12;
import org.springframework.stereotype.Service;

import java.time.ZoneId;
import java.util.Date;
import java.util.GregorianCalendar;
@Service
public class MernisAdapterManager implements IdentityValidationService {
    @Override
    public boolean checkIdentityNumber(String identityNumber, String firstName, String lastName, Date birthDate) {
        Long identity = Long.parseLong(identityNumber);
        int year = birthDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate().getYear();

        ISHKPSPublicSoap12 ishkpsPublicSoap=new ISHKPSPublicSoap12();
        try {
            return ishkpsPublicSoap.TCKimlikNoDogrula(identity,firstName,lastName,year);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
