package by.itacademy.javaenterprise.borisevich;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

@Slf4j
public class Developer {
    private String name;
    private String specialty;
    private Integer experience;

    public Developer(String name, String specialty, Integer experience) {
        this.name = name;
        this.specialty = specialty;
        this.experience = experience;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public Integer getExperience() {
        return experience;
    }

    public void setExperience(Integer experience) {
        this.experience = experience;
    }

    public String initProfile() {
        log.info("Do method initProfile:");
        return this.toString();
    }

    public void throwSomeMysticException() {
        log.error("We have some strange and mystic exception here:");
        throw new ClassCastException();
    }

    public String doSomeCode(Integer workHours, Integer degreeOfDifficulty, Integer salaryPerHour) {
        Integer salary = degreeOfDifficulty * salaryPerHour * workHours;
        return "Project will cost:" + salary;
    }

    @Override
    public String toString() {
        return "Developer:\n" +
                "Name: " + name + '\n' +
                "Specialty: " + specialty + '\n' +
                "Experience: " + experience + "\n";
    }
}
