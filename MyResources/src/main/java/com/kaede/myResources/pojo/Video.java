package com.kaede.myResources.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author kaede
 * @create 2022-08-14 17:09
 *
 * video_id   video_name   video_url   video_tags
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Video {

    private Integer videoId;
    private String videoName;
    private String videoUrl;
    private String[] videoTags;
    private Integer userId;

}
