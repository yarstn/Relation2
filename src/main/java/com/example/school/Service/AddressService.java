package com.example.school.Service;

import com.example.school.Api.ApiException;
import com.example.school.DTO.AddressDTO;
import com.example.school.Model.Teacher;
import com.example.school.Model.Address;
import com.example.school.Repository.TeacherRepo;
import com.example.school.Repository.AddressRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AddressService {
    private final AddressRepo addressRepo;
    private final TeacherRepo teacherRepo;

    public List<Address> getAdress() {
       return addressRepo.findAll();
    }
    public void addAdress(AddressDTO addressDTO) {
        Teacher teacher = teacherRepo.findByid(addressDTO.getTeacher_id());
        if (teacher == null) {
            throw new ApiException("teach not found");
        }

Address address1 = new Address(null,addressDTO.getArea(),addressDTO.getStreet(),addressDTO.getBuildingNo(), teacher);
 addressRepo.save(address1);


    }
    public void updateAdress(AddressDTO addressDTO) {
Address address1 = addressRepo.findByid(addressDTO.getTeacher_id());
    if (address1 == null) {
            throw new ApiException("teach not found");
        }
        address1.setArea(addressDTO.getArea());
        address1.setStreet(addressDTO.getStreet());
        address1.setBuildingNo(addressDTO.getBuildingNo());
        addressRepo.save(address1);
    }

    public void deleteAdress(Integer id) {
Teacher address = teacherRepo.findByid(id);
    if (address == null) {
            throw new ApiException("address not found");
        }
        teacherRepo.delete(address);
    }
    public Teacher getTeacherDetails(Integer teacherId) {
        Teacher teacher = teacherRepo.findByid(teacherId);
        if (teacher == null) {
            throw new ApiException("Teacher not found");
        }
        return teacher;
    }

}
