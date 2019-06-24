package com.math.epidemic.Controller;

import com.math.epidemic.Application;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.File;

public class AboutLayoutController {
    @FXML
    public ImageView sirView;
    @FXML
    public ImageView sirmView;
    @FXML
    public ImageView sisView;
    @FXML
    public ImageView sirsView;

    public void initialize() {
        sirmView.setFitHeight(137);
        sirmView.setFitWidth(577);
       Image image1 = new Image("https://pp.userapi.com/c852036/v852036226/1523a1/oo4JQN6GpVw.jpg");
       sirView.setImage(image1);

        Image image2 = new Image("https://lh3.googleusercontent.com/BROvaLgmnLFS-JuwOwfFZFgMonRYmlnkm4-gWtaJnDT0c43QkV0oXJIgMSFzn8YqyijSSMRavJyv_n0kCZN8JM6E_5dWJ7P2iTVxwVxcpTp1jHd0Or3vEn_tLDJT0R40e52ECIDlqKoofGt9NlPMrBz6lG0BZqmIgaQtub2nVuY9O-fdmR9P_TdlpBq5ZK0SU9upeQ-wR2QaCbnUVpwAXNEQAh8HrIks2lf6V072eQ5TLShA3_p6lrryMeRcLTlWgHvpdExOsZDWal2pR6Sjw33HWQsolzWwW1_4YKGuBvIV4fS25iVSjBvAMCWCXyxR1pJuir7SDCg2MeXDxY6LUb4DWinlnSYkMNZImPbNKHt20LBpYmZ6FcNMF41MwKiunpOzWIclI0sUJ0Yzfyy_4Cgo9VVrFNpC2YJ3XxdTfxxjNPBJJHCF4mE-xtT3n6qmpJ-vp2AEBG7FNXKN27IrqxSPRh0CnWosn_IKlDbgITm6lUPM-nvsgIsjD2O4stP9-h9Zrfo5Tpja4WB88X4KLfkhrGtetZCw0wHnp5brX2eZf6F9fd_G9MM8cnR3Wscs3jQ3X4Ly1BcXMEVBA2Mq0PeWNsSjXiLIvDXlhlXSZKoGHfR1VrfcxqfyVI0A7Ef9uMSr1k1lQxBjjzHeo_YLGGe-uAHwEX0=w400-h190-no");
        sirmView.setImage(image2);

      //  File file3 = new File("src/main/resources/SIS.PNG");
        Image image3 = new Image("https://lh3.googleusercontent.com/VJeVY8M4MZjdsrOuku1V78Jn3V_F0rXeiqW8wWNG9zIxQQXv-zq2qYwSpo0UXEaTuiy74LinptiJv6Aq2cc97ddMHkCMLPDrXJTvfjIhU7gyD2imLYxTA7Q8m3WG1wv5Icb1K0cnfTXjyuDO0Sg_cPLI7l8lseHfIngzEFDs4NxbJ46sgqqyHSMjX6uiPirbCOs5M8oTz0lofKiKLNne6PZoewnSYCJRcg86bZHbF1AWhCqtRWhrVJJyR23HTHxX7zZklxQC4fAY87bkw3u0Gb5gYZv1zGlAz4W9hYr_yjfNndOCAH18kcaHh12s4JHnzEgm_8GfhvxpTCNdM8w_wu-uWid8tac6_YUo4-DlK2CAbWkP4-XF21B5UcYTv4Kgel-YsdnuhsRoyYJQaQqMGz2ZC2izKM-nsKw0hs5OM_er2NiaXgZ8P309FAvMFp5dfufAxWZy_zxnXrW8NW2XrvFIkKNDR3ZHoclaqxVdRydFVAG0WEv8tmS2fIzBrjHibr6u02jlqRJ6Ub4QUalgMK2IsZj3-6QN_yf6JwEH7Ra3hWWDm2XCz7DRhH3JsSG1z19iA3lem9t8GkRDZc2nNxJnvEGp6dpYNFztoWTywNjyEafUV-GSjGXUe_HBgLZRs07RjKggwOrsGch9O3S9-ziC18LCnWk=w416-h156-no");
        sisView.setImage(image3);

        /*File file4 = new File("src/main/resources/SIRS.PNG");
        Image image4 = new Image(file4.toURI().toString());
        sirsView.setImage(image4);*/
    }

}
