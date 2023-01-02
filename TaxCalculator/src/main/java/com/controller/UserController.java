package com.controller;

import com.domain.TaxCalculate;
import com.domain.Amount;
import com.domain.User;
import com.service.TaxCalculateService;
import com.service.AmountService;
import com.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.security.Principal;
import java.sql.*;
import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    private final TaxCalculateService taxCalculateService;
    private final UserService userService;
    private final AmountService amountService;
    public Long userID;
    public String userGender;
    public int userAge;
    public double hr=0,ma=0,con=0,fb=0,mp=0,fp=0,gv=0;
    public User user;
    double taxableInc=0;double taxLiability=0;double totalRebate=0;double netTax=0;double totalInc=0;


    public UserController(TaxCalculateService taxCalculateService, UserService userService, AmountService amountService) {
        this.taxCalculateService = taxCalculateService;
        this.userService = userService;
        this.amountService = amountService;
    }

    @RequestMapping("/dashboard")
    public String dashboard(Principal principal, Model model) throws SQLException {
        User user = userService.fetchUserByUsername(principal.getName());
        userID=user.getId();
        userGender=user.getGender();
        userAge=user.getAge();
        List<TaxCalculate> dashboardData=taxCalculateService.getByUserId(userID);
        model.addAttribute("entries", dashboardData);
        return "UserDashboard";
    }
    @RequestMapping("/entries")
    public String entries(Principal principal, Model model) throws SQLException {
        List<TaxCalculate> dashboardData=taxCalculateService.findByUserId(userID);
        model.addAttribute("entries", dashboardData);
        return "ViewEntries";
    }
    @RequestMapping("/calculateTax")
    public String calculateTax()
    {
        getTaxVar();
        return "CalculateTax";
    }
    @RequestMapping("/calculate")
    public String submit(@Valid @ModelAttribute("calculatedTax")TaxCalculate taxCalculate,
                         BindingResult bindingResult) throws SQLException {
        double bs=taxCalculate.getBasicSalary();
        double hor=taxCalculate.getHouseRent();
        double mea=taxCalculate.getMedicalAllowance();
        double conv=taxCalculate.getConveyance();
        double feb=taxCalculate.getFestivalBonus();

        calculation(bs*12,hor*12,mea*12,conv*12,feb);
        taxCalculate.setTaxAbleIncome(taxableInc);
        taxCalculate.setTaxLiability(taxLiability);
        taxCalculate.setRebate(totalRebate);
        taxCalculate.setNetTax(netTax);
        taxCalculate.setUser_id(userID);
        taxCalculate.setDate(LocalDate.now());
        taxCalculateService.insert(taxCalculate);
        return "redirect:/user/dashboard";
    }

    public void getTaxVar()
    {
        Amount amount= amountService.get(2L);
        hr=amount.getHouseRent();
        ma=amount.getMedicalAllowance();
        con=amount.getConveyance();
        fb=amount.getFestiveBonus();
        mp=amount.getMalePayable();
        fp=amount.getFemalePayable();
        getGv();
    }
    public void getGv()
    {
        if(userGender=="Male" && userAge<65)
        {
            this.gv=mp;
        }
        if(userGender=="Female" || userAge>=65)
        {
            gv=fp;
        }
    }

    public void calculation(double basicSalary,double houseRent,double medicalAllowance,double conveyance,double festivalBonus)
    {
        double govHouseRent=hr;
        double halfBasicSal=basicSalary/2;
        double taxableHR=0;
        double taxableCon=0;
        double taxableMA=0;
        double taxableFB=0;
        totalInc=basicSalary+houseRent+medicalAllowance+festivalBonus+conveyance;
        double rebateAble=0;
        if (govHouseRent>halfBasicSal)
        {
            taxableHR = houseRent - halfBasicSal;
        }
        else
        {
            taxableHR=houseRent-govHouseRent;
        }

        if (conveyance>con)
        {
            taxableCon=conveyance-con;
        }
        else
        {
            taxableCon=0;
        }
        if (medicalAllowance>ma)
        {
            taxableMA=medicalAllowance-ma;
        }
        else
        {
            taxableMA=0;
        }
        taxableFB=festivalBonus;
        taxableInc=basicSalary+taxableCon+taxableFB+taxableHR+taxableMA;
        double remainingTaxableInc=0;
        if (taxableInc>gv)
        {
            remainingTaxableInc=taxableInc-300000;
            if (remainingTaxableInc>100000)
            {
                taxLiability=taxLiability+5000;
                remainingTaxableInc=remainingTaxableInc-100000;
                if (remainingTaxableInc>300000)
                {
                    taxLiability=taxLiability+30000;
                    remainingTaxableInc=remainingTaxableInc-300000;
                    if(remainingTaxableInc>400000)
                    {
                        taxLiability=taxLiability+60000;
                        remainingTaxableInc=remainingTaxableInc-400000;
                        if(remainingTaxableInc>500000)
                        {
                            taxLiability=taxLiability+100000;
                            remainingTaxableInc=remainingTaxableInc-500000;
                            if (remainingTaxableInc>0)
                            {
                                taxLiability = taxLiability + (remainingTaxableInc * 0.25);
                            }
                        }
                        else
                        {
                            taxLiability=taxLiability+(remainingTaxableInc*0.2);
                        }
                    }
                    else
                    {
                        taxLiability=taxLiability+(remainingTaxableInc*0.15);
                    }
                }
                else
                {
                    taxLiability=taxLiability+(remainingTaxableInc*0.1);
                }
            }
            else
            {
                taxLiability=remainingTaxableInc*0.05;
            }
        }
        else
        {
            taxLiability=0;
        }
        if (taxableInc>10000000)
        {
            rebateAble=10000000*0.25;
        }
        else
        {
            rebateAble=taxableInc*0.25;
        }
        totalRebate=rebateAble*0.15;
        netTax=taxLiability-totalRebate;
    }
}
