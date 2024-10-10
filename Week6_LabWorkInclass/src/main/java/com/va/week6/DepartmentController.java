package com.va.week6;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.validation.Valid;

@Controller
public class DepartmentController {

	@Autowired
	private DepartmentRepo departmentRepo;
	// will provide remote invocation of the methods.. supporing
	// dependency injection.. of the methods.. 

	// now goes the annotations for URIs..

	@GetMapping("/dept")
	public String home(Department department) {
		return "add-dept";
	}

	@PostMapping("/add")
	public String add(@Valid Department department, BindingResult result, Model model) {

		if (result.hasErrors()) {

			return "add-dept";
		}

		departmentRepo.save(department); // insert into.. sql ...

		model.addAttribute("departments", departmentRepo.findAll());

		return "index";

	}

	// Update an existing department

	@GetMapping("/edit/{id}")

	public String edit(@PathVariable("id") int no, Model model) {

		Department dept = departmentRepo.findById(no)

				.orElseThrow(() -> new IllegalArgumentException("Invalid department number:" + no));

		model.addAttribute("department", dept);
		return "update-dept";
	}

	@PostMapping("/update/{id}")
	public String update(@PathVariable("id") int no, @Valid Department department, BindingResult result, Model model) {
		if (result.hasErrors()) {
			department.setDeptno(no);
			return "update-dept";
		}
		departmentRepo.save(department);

		model.addAttribute("departments", departmentRepo.findAll());

		return "index";

	}

	// Delete a department using deptId

	@GetMapping("/delete/{id}")

	public String delete(@PathVariable("id") int no, Model model) {

		Department dept = departmentRepo.findById(no)

				.orElseThrow(() -> new IllegalArgumentException("Invalid department Number:" + no));

		departmentRepo.delete(dept);

		model.addAttribute("users", departmentRepo.findAll());

		return "index";

	}

}
