package com.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "amount")
public class Amount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "house_rent")
    private Double houseRent;
    @NotNull
    @Column(name = "medical_allowance")
    private Double medicalAllowance;
    @NotNull
    @Column(name = "conveyance")
    private Double conveyance;
    @NotNull
    @Column(name = "festive_bonus")
    private Double festiveBonus;
    @NotNull
    @Column(name = "male_payable")
    private Double malePayable;
    @NotNull
    @Column(name = "female_payable")
    private Double femalePayable;

    public void setId(Long id) {this.id = id;}
    public Long getId() {return id;}
    public void setHouseRent(Double houseRent) {this.houseRent = houseRent;}
    public Double getHouseRent() {return houseRent;}
    public void setMedicalAllowance(Double medicalAllowance) {this.medicalAllowance = medicalAllowance;}
    public Double getMedicalAllowance() {return medicalAllowance;}
    public void setConveyance(Double conveyance) {this.conveyance = conveyance;}
    public Double getConveyance() {return conveyance;}
    public void setFestiveBonus(Double festiveBonus) {this.festiveBonus = festiveBonus;}
    public Double getFestiveBonus() {return festiveBonus;}
    public void setMalePayable(Double malePayable) {this.malePayable = malePayable;}
    public Double getMalePayable() {return malePayable;}
    public void setFemalePayable(Double femalePayable) {this.femalePayable = femalePayable;}
    public Double getFemalePayable() {return femalePayable;}
}
