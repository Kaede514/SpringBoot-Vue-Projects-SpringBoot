package com.kaede.myResources.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author kaede
 * @create 2022-08-14 17:05
 *
 * audio_id   audio_name   audio_singer   audio_url
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Audio {

    private Integer audioId;
    private String audioName;
    private String audioSinger;
    private String audioUrl;

}
