package com.example.demo2.controller;

import com.example.demo2.model.Expense;
import com.example.demo2.service.ExpenseService;
import com.fasterxml.jackson.core.sym.Name;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
@RequestMapping("api/expense")
@RequiredArgsConstructor
public class ExpenseController {
    private final ExpenseService expenseService;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addExpense(@ModelAttribute Expense expense) {

        expenseService.addExpense(expense);
        // return ResponseEntity.status(HttpStatus.CREATED).build();
        return "redirect:/api/expense";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String updateExpense(@ModelAttribute Expense expense) {
        expenseService.updateExpense(expense);
        // return ResponseEntity.ok().build();
        return "redirect:/api/expense";
    }

    @GetMapping
    public String getAllExpense(Model model) {
        List<Expense> DataExpense = expenseService.getAllExpenses();
        model.addAttribute("Data", DataExpense);
        model.addAttribute("edit", false);

        // return ResponseEntity.ok(expenseService.getAllExpense());
        return "index";
    }

    @GetMapping("/{name}")
    public String updateExpense(Model model, @PathVariable String name) {
        List<Expense> DataExpense = expenseService.getAllExpenses();
        Expense DataEdit = expenseService.getExpenseByName(name);
        model.addAttribute("Data", DataExpense);
        model.addAttribute("edit", true);

        model.addAttribute("DataEdit", DataEdit);
        // return ResponseEntity.ok(expenseService.getAllExpense());
        return "index";
    }

    @GetMapping("/{name}")
    public String deleteExpense(Model model, @PathVariable String name) {
        List<Expense> DataExpense = expenseService.getAllExpenses();
        Expense DataDelete = expenseService.getExpenseByName(name);
        model.addAttribute("Data", DataExpense);

        model.addAttribute("DataDelete", DataDelete);
        return "index";
    }

    // @GetMapping("/{name}")
    // public ResponseEntity<List<Expense>> getExpenseByName(@PathVariable String
    // name) {
    // return ResponseEntity.ok(expenseService.getExpenseByName(name));
    // }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteExpense(@PathVariable String id) {
        expenseService.deleteExpense(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
