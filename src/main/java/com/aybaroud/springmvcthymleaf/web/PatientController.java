package com.aybaroud.springmvcthymleaf.web;

import com.aybaroud.springmvcthymleaf.entities.Patient;
import com.aybaroud.springmvcthymleaf.repositories.PatientRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@AllArgsConstructor
public class PatientController {
    private PatientRepository patientRepository;

    @GetMapping(path="/index")
    public String getPatients(Model model,
                              @RequestParam(name="page",defaultValue = "0") int page,
                              @RequestParam(name="size",defaultValue = "5") int size){
        Page<Patient> pagePatients = patientRepository.findAll(PageRequest.of(page,size));
        model.addAttribute("listPatients",pagePatients.getContent());
        model.addAttribute("pages",new int[pagePatients.getTotalPages()]);
        return "patients";
    }
}
