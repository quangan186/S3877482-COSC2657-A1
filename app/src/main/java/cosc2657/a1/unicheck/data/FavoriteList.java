package cosc2657.a1.unicheck.data;

import java.io.Serializable;
import java.util.ArrayList;

import cosc2657.a1.unicheck.model.University;

public class FavoriteList implements Serializable {
    private ArrayList<University> favoriteList;

    public FavoriteList() {
        this.favoriteList = new ArrayList<>();
    }

    public ArrayList<University> getFavoriteList() {
        return favoriteList;
    }

    public void setFavoriteList(ArrayList<University> favoriteList) {
        this.favoriteList = favoriteList;
    }

    public void addFavoriteUniversity(University university){
        favoriteList.add(university);
    }

    public void deleteFavoriteUniversity(University university){
//        for (University university : favoriteList){
//            if (university.getId() == uniId){
//                favoriteList.remove(university);
//                System.out.println("Removed successful");
//                break;
//            } else {
//                System.out.println("Unsuccessful");
//            }
//        }
        if (favoriteList.size() != 0 && favoriteList.contains(university)){
            favoriteList.remove(university);
        } else {
            System.out.println("There is no university in list");
        }
    }
}
