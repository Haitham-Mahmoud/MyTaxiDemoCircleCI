package com.mytaxi.android_demo.handler;

import com.mytaxi.android_demo.pages.SearchPageObject;

public class SearchForDrivers {

    SearchPageObject searchPage = new SearchPageObject();

    public void searchForExistingDriver(String searchText, String fullName){
        searchPage.searchForDriver(searchText);
        searchPage.selectFromDisplayedOptions(fullName);
    }
}
