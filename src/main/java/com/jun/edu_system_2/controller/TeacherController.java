package com.jun.edu_system_2.controller;

import com.jun.edu_system_2.model.Teacher;
import com.jun.edu_system_2.repository.TeacherRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller @RequestMapping("/teachers") @RequiredArgsConstructor
public class TeacherController {
    private final TeacherRepository teacherRepository;

    @GetMapping
    public String list(Model model) {
        model.addAttribute("teachers", teacherRepository.findAll());

        return "teacher-list";
    }

    @GetMapping("/add")
    public String addForm(Model model){
        model.addAttribute("teacher", new Teacher());
        return "teacher-form";
    }

    @PostMapping("/add")
    public String add(@ModelAttribute Teacher teacher){
        teacherRepository.save(teacher);

        return "redirect:/teachers";
    }

    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable int id, Model model){
        model.addAttribute("teacher", teacherRepository.findById(id));
        return "teacher-form";
    }

    @PostMapping("/edit")
    public String edit(@ModelAttribute Teacher teacher){
        teacherRepository.update(teacher);

        return "redirect:/teachers";
    }

    @PostMapping("/delete/{id}")
    public String deleteMemo(@PathVariable int id) {
        try{
            int affected = teacherRepository.deleteById(id);
            if (affected == 0) {
                System.out.println("Cannot find Teacher");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return "redirect:/teachers";
    }
}
