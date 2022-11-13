package cosc2657.a1.unicheck.data;

import java.util.ArrayList;

import cosc2657.a1.unicheck.R;
import cosc2657.a1.unicheck.model.University;

public class UniversityList {
    protected ArrayList<University> universities = new ArrayList<>();

    public UniversityList() {
        this.universities.add(new University(1, "RMIT University", "RMIT", R.drawable.logo, "702 Nguyen Van Linh, Tan Hung Ward, District 7, Ho Chi Minh City", 300.596, "RMIT University Vietnam (informally RMIT Vietnam or RMIT) is the Vietnamese branch of the Australian research university the Royal Melbourne Institute of Technology, known in Australia as RMIT University. It has three campuses located in Ho Chi Minh City, Hanoi and Danang.\n\nRMIT was the first completely foreign-owned university granted permission to operate in Vietnam. Since its establishment in 2000, it has won 17 Golden Dragon Awards from the Vietnamese Government for excellence in education", "https://www.rmit.edu.vn/vi"));
        this.universities.add(new University(2, "RMIT University", "RMIT", R.drawable.logo, "702 Nguyen Van Linh, Tan Hung Ward, District 7, Ho Chi Minh City", 300.596, "RMIT University Vietnam (informally RMIT Vietnam or RMIT) is the Vietnamese branch of the Australian research university the Royal Melbourne Institute of Technology, known in Australia as RMIT University. It has three campuses located in Ho Chi Minh City, Hanoi and Danang.\n\nRMIT was the first completely foreign-owned university granted permission to operate in Vietnam. Since its establishment in 2000, it has won 17 Golden Dragon Awards from the Vietnamese Government for excellence in education", "https://www.rmit.edu.vn/vi"));
        this.universities.add(new University(3, "RMIT University", "RMIT", R.drawable.logo, "702 Nguyen Van Linh, Tan Hung Ward, District 7, Ho Chi Minh City", 300.596, "RMIT University Vietnam (informally RMIT Vietnam or RMIT) is the Vietnamese branch of the Australian research university the Royal Melbourne Institute of Technology, known in Australia as RMIT University. It has three campuses located in Ho Chi Minh City, Hanoi and Danang.\n\nRMIT was the first completely foreign-owned university granted permission to operate in Vietnam. Since its establishment in 2000, it has won 17 Golden Dragon Awards from the Vietnamese Government for excellence in education", "https://www.rmit.edu.vn/vi"));
        this.universities.add(new University(4, "RMIT University", "RMIT", R.drawable.logo, "702 Nguyen Van Linh, Tan Hung Ward, District 7, Ho Chi Minh City", 300.596, "RMIT University Vietnam (informally RMIT Vietnam or RMIT) is the Vietnamese branch of the Australian research university the Royal Melbourne Institute of Technology, known in Australia as RMIT University. It has three campuses located in Ho Chi Minh City, Hanoi and Danang.\n\nRMIT was the first completely foreign-owned university granted permission to operate in Vietnam. Since its establishment in 2000, it has won 17 Golden Dragon Awards from the Vietnamese Government for excellence in education", "https://www.rmit.edu.vn/vi"));
        this.universities.add(new University(5, "RMIT University", "RMIT", R.drawable.logo, "702 Nguyen Van Linh, Tan Hung Ward, District 7, Ho Chi Minh City", 300.596, "RMIT University Vietnam (informally RMIT Vietnam or RMIT) is the Vietnamese branch of the Australian research university the Royal Melbourne Institute of Technology, known in Australia as RMIT University. It has three campuses located in Ho Chi Minh City, Hanoi and Danang.\n\nRMIT was the first completely foreign-owned university granted permission to operate in Vietnam. Since its establishment in 2000, it has won 17 Golden Dragon Awards from the Vietnamese Government for excellence in education", "https://www.rmit.edu.vn/vi"));

    }

    public ArrayList<University> getUniversities() {
        return universities;
    }

    public void setUniversities(ArrayList<University> universities) {
        this.universities = universities;
    }
}
