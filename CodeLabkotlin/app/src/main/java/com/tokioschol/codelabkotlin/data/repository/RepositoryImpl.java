package com.tokioschol.codelabkotlin.data.repository;

import com.tokioschol.codelabkotlin.data.response.UserResponse;
import com.tokioschol.codelabkotlin.data.utils.RandonUtils;
import com.tokioschol.codelabkotlin.domain.User;

import java.util.ArrayList;
import java.util.List;


public class RepositoryImpl implements Repository {

    @Override
    public String classificationNameByAges(int ages) {
        if (ages < 0) return "";
        if (ages < 7) {
            return "under7";
        } else if (ages < 16) {
            return "younger";
        } else if (ages < 18) {
            return "teen";
        } else if (ages < 67) {
            return "adult";
        } else if (ages < 100) {
            return "senior";
        } else {
            return "are you alive";
        }
    }

    @Override
    public List<User> segmentationByType(String segmentation) {
        List<User> segmentationByTypeList = new ArrayList<>();
        String classificationName = "";
        List<UserResponse> fakeUserResponseList = fakeRandomUsers();
        for (UserResponse item: fakeUserResponseList) {
            if (item.getAgeResponse() < 7) {
                classificationName =  "under7";
            } else if (item.getAgeResponse() < 16) {
                classificationName =  "younger";
            } else if (item.getAgeResponse() < 18) {
                classificationName =  "teen";
            } else if (item.getAgeResponse() < 67) {
                classificationName =  "adult";
            } else if (item.getAgeResponse() < 100) {
                classificationName =  "senior";
            } else {
                classificationName =  "are you alive";
            }
            if(classificationName.equalsIgnoreCase(segmentation)){
                segmentationByTypeList.add(itemToUserMap(item));
            }
        }
        return segmentationByTypeList;
    }

    @Override
    public int howManyUserBySegmentation(String segmentation) {
        List<UserResponse> fakeUserResponseList = fakeRandomUsers();
        String classificationName = "";
        int countSegmentation = 0;
        for (UserResponse item:fakeUserResponseList) {
            if (item.getAgeResponse() < 7) {
                classificationName =  "under7";
            } else if (item.getAgeResponse() < 16) {
                classificationName =  "younger";
            } else if (item.getAgeResponse() < 18) {
                classificationName =  "teen";
            } else if (item.getAgeResponse() < 67) {
                classificationName =  "adult";
            } else if (item.getAgeResponse() < 100) {
                classificationName =  "senior";
            } else {
                classificationName =  "are you alive";
            }

           if(classificationName.equalsIgnoreCase(segmentation)){
               countSegmentation++;
            }

        }
        return countSegmentation;
    }

    private User itemToUserMap(UserResponse item) {
        return new User(item.getNameResponse()+item.getSurNameResponse(),item.getAgeResponse());
    }


    private List<UserResponse> fakeRandomUsers(){
        List<UserResponse> fakeUserList = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            fakeUserList.add(new UserResponse(RandonUtils.randomNameOrSurname(),RandonUtils.randomNameOrSurname(),RandonUtils.getRandonAge()));
        }
        return fakeUserList;
    }
}
