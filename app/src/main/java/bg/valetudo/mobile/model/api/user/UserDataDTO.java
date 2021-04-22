package bg.valetudo.mobile.model.api.user;

import java.util.Set;

import bg.valetudo.mobile.model.enums.configuration.GenderEnum;
import bg.valetudo.mobile.model.enums.configuration.ModulesEnum;

public class UserDataDTO {
    private Integer id;
    private Integer age;
    private Double weight;
    private Double height;
    private GenderEnum gender;
    private Double leftArm;
    private Double rightArm;
    private Double waist;
    private Double hip;
    private Double leftThigh;
    private Double rightThigh;

    private Integer goalFood;

    private Set<ModulesEnum> modules;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public GenderEnum getGender() {
        return gender;
    }

    public void setGender(GenderEnum gender) {
        this.gender = gender;
    }

    public Double getLeftArm() {
        return leftArm;
    }

    public void setLeftArm(Double leftArm) {
        this.leftArm = leftArm;
    }

    public Double getRightArm() {
        return rightArm;
    }

    public void setRightArm(Double rightArm) {
        this.rightArm = rightArm;
    }

    public Double getWaist() {
        return waist;
    }

    public void setWaist(Double waist) {
        this.waist = waist;
    }

    public Double getHip() {
        return hip;
    }

    public void setHip(Double hip) {
        this.hip = hip;
    }

    public Double getLeftThigh() {
        return leftThigh;
    }

    public void setLeftThigh(Double leftThigh) {
        this.leftThigh = leftThigh;
    }

    public Double getRightThigh() {
        return rightThigh;
    }

    public void setRightThigh(Double rightThigh) {
        this.rightThigh = rightThigh;
    }

    public void setGoalFood(Integer goalFood) {
        this.goalFood = goalFood;
    }

    public Integer getGoalFood() {
        return goalFood;
    }

    public Set<ModulesEnum> getModules() {
        return modules;
    }

    public void setModules(Set<ModulesEnum> modules) {
        this.modules = modules;
    }
}
