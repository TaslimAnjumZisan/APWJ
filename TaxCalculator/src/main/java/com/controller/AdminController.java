package com.controller;

import com.domain.Amount;
import com.domain.TaxCalculate;
import com.domain.User;
import com.service.AmountService;
import com.service.TaxCalculateService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {
    private final AmountService amountService;
    private final TaxCalculateService taxCalculateService;
    public Long calidForUpDelOp;

    public AdminController(AmountService amountService, TaxCalculateService taxCalculateService) {
        this.amountService = amountService;
        this.taxCalculateService = taxCalculateService;
    }

    @RequestMapping("/dashboard")
    public String dashboard(Model model) {
        List<TaxCalculate> dashboardData=taxCalculateService.getAll();
        model.addAttribute("allUser", dashboardData);
        return "AdminDashboard";
    }

    @RequestMapping("/addUser")
    public String submit(@Valid @ModelAttribute("addCalculation") TaxCalculate taxCalculate,
                         BindingResult bindingResult) throws SQLException {
        if (bindingResult.hasErrors()) {
            return "AddCalculation";
        }
        else {
            taxCalculateService.insert(taxCalculate);
            return "redirect:/admin/dashboard";
        }
    }
    @RequestMapping("/updateDeleteCalculation")
    public String upDel(@ModelAttribute("calidForUpDel") String id,Model model) throws SQLException {
        calidForUpDelOp=Long.parseLong(id);
        TaxCalculate taxCalculate=taxCalculateService.get(calidForUpDelOp);
        model.addAttribute("updateCalculationData", taxCalculate);
        return "UpdateCalculation";
    }
    @RequestMapping("/updateCalculation")
    public String userUpdate(@Valid @ModelAttribute("updateCalculation")TaxCalculate taxCalculate,
                             BindingResult bindingResult) throws SQLException {
            taxCalculate.setId(calidForUpDelOp);
            taxCalculate.setDate(LocalDate.now());
            taxCalculateService.update(taxCalculate);
            return "redirect:/admin/dashboard";
    }

    @RequestMapping("deleteCalculation")
    public String profileDelete(TaxCalculate taxCalculate)
    {
        taxCalculateService.delete(calidForUpDelOp);
        return "redirect:/admin/dashboard";
    }

    @RequestMapping("/amount")
    public String showTaxVariables(Model model) {
        Amount amount=amountService.get(2L);
        model.addAttribute("taxAmountUpdate", amount);
        return "Amount";
    }
    @RequestMapping("/updateAmount")
    public String taxVarUpdate(@Valid @ModelAttribute("taxAmountUpdate") Amount taxVariables,
                                BindingResult bindingResult) throws SQLException {
        if (bindingResult.hasErrors()) {
            return "Amount";
        }
        else {
            taxVariables.setId(2L);
            amountService.update(taxVariables);
            return "redirect:/admin/amount";
        }
    }
}
