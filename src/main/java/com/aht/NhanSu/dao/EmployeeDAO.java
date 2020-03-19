package com.aht.NhanSu.dao;

import com.aht.NhanSu.model.Aht_Employee;
import com.aht.NhanSu.model.Aht_Parts;
import com.aht.NhanSu.model.EmpResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

@Repository
public interface EmployeeDAO extends JpaRepository<Aht_Employee, Integer> {
    @Query("select emp " +
            " from Aht_Employee emp left outer join emp.department department" +
            " left outer join department.parts part "+
            " where part.partsId = :partsId" +
            " and department.departmentId = :departmentId")
    List<Aht_Employee> findEmpByDepartment(@Param("partsId") Integer partsId,@Param("departmentId") Integer departId);

    @Modifying
    @Transactional
    @Query("update Aht_Employee emp " +
            " set emp.empType = 1 " +
            " where emp.empId = :empId")
    void remove(@Param("empId") Integer id);

    @Query("select emp from Aht_Employee emp where emp.empType = 0")
    List<Aht_Employee> findAll();
}
