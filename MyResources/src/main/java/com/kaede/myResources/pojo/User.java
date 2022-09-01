package com.kaede.myResources.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author kaede
 * @create 2022-08-14 17:03
 *
 * user_id   user_name   user_password   user_headshot
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private Integer userId;
    private String userName;
    private String userPassword;
    private String userGender;
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GTM+8")
    private Date userBirth;

}
