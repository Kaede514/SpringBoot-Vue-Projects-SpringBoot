package com.kaede.myResources.mapper;

import com.kaede.myResources.pojo.Audio;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author kaede
 * @create 2022-08-18 12:55
 */

@Mapper
public interface AudioMapper {

    //查询所有歌曲信息
    List<Audio> selectAll();

    //添加歌曲
    void insert(Audio audio);

    //根据url查询歌曲信息
    Audio selectByUrl(@Param("url") String url);

    //根据id删除歌曲
    void deleteById(@Param("id") Integer id);

    //根据id查询歌曲信息
    Audio selectById(@Param("id") Integer id);

    //修改歌曲信息
    void update(Audio audio);

    //查询歌曲总条数
    Long selectCount();

    //分页查询歌曲信息
    List<Audio> selectByPage(@Param("offset") Integer offset);

}
