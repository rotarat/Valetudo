package bg.valetudo.mobile.model.observable.user;

import androidx.databinding.ObservableField;

import bg.valetudo.mobile.model.api.user.UserDataDTO;
import bg.valetudo.mobile.model.enums.configuration.GenderEnum;

public class UserDataObservable {
    private final ObservableField<String> age = new ObservableField<>();
    private final ObservableField<GenderEnum> gender = new ObservableField<>();
    private final ObservableField<String> weight = new ObservableField<>();
    private final ObservableField<String> height = new ObservableField<>();
    private final ObservableField<String> waist = new ObservableField<>();
    private final ObservableField<String> hip = new ObservableField<>();
    private final ObservableField<String> rightArm = new ObservableField<>();
    private final ObservableField<String> leftArm = new ObservableField<>();
    private final ObservableField<String> rightThigh = new ObservableField<>();
    private final ObservableField<String> leftThigh = new ObservableField<>();
    private final ObservableField<String> goalFood = new ObservableField<>();

    public UserDataDTO toDTO() {
        UserDataDTO dto = new UserDataDTO();

        dto.setAge(Integer.valueOf(age.get()));
        dto.setGender(gender.get());
        dto.setWeight(Double.valueOf(weight.get()));
        dto.setHeight(Double.valueOf(height.get()));
        dto.setWaist(Double.valueOf(waist.get()));
        dto.setHip(Double.valueOf(hip.get()));
        dto.setRightArm(Double.valueOf(rightArm.get()));
        dto.setLeftArm(Double.valueOf(leftArm.get()));
        dto.setRightThigh(Double.valueOf(rightThigh.get()));
        dto.setLeftThigh(Double.valueOf(leftThigh.get()));

        dto.setGoalFood(Integer.valueOf(goalFood.get()));

        return dto;
    }

    public ObservableField<String> getAge() {
        return age;
    }

    public ObservableField<GenderEnum> getGender() {
        return gender;
    }

    public ObservableField<String> getWeight() {
        return weight;
    }

    public ObservableField<String> getHeight() {
        return height;
    }

    public ObservableField<String> getWaist() {
        return waist;
    }

    public ObservableField<String> getHip() {
        return hip;
    }

    public ObservableField<String> getRightArm() {
        return rightArm;
    }

    public ObservableField<String> getLeftArm() {
        return leftArm;
    }

    public ObservableField<String> getRightThigh() {
        return rightThigh;
    }

    public ObservableField<String> getLeftThigh() {
        return leftThigh;
    }

    public ObservableField<String> getGoalFood() {
        return goalFood;
    }
}
