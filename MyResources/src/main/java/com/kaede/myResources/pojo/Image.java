package com.kaede.myResources.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author kaede
 * @create 2022-08-14 17:08
 *
 * image_id   image_name   image_url   image_tags
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Image {

    private Integer imageId;
    private String imageName;
    private String imageUrl;
    private String[] imageTags;

}
