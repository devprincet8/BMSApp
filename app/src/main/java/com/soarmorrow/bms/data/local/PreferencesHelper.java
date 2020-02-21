
package com.soarmorrow.bms.data.local;


import com.soarmorrow.bms.data.DataManager;

public interface PreferencesHelper {

    String getAccessToken();

    Boolean isFirstInstall();

    void setFirstInstall(Boolean isFirst);

    Boolean isLoggedIn();

    void setLoggedIn(Boolean logged);

    void setAccessToken(String accessToken);

    String getCurrentUserEmail();

    void setCurrentUserEmail(String email);

    Long getCurrentUserId();

    void setCurrentUserId(Long userId);

    String getCurrentUserName();

    void setCurrentUserName(String userName);

    String getCurrentUserProfilePicUrl();

    void setCurrentUserProfilePicUrl(String profilePicUrl);
}
