package com.kaede.myResources.service.impl;

import com.kaede.myResources.mapper.AudioMapper;
import com.kaede.myResources.pojo.Audio;
import com.kaede.myResources.service.AudioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author kaede
 * @create 2022-08-18 12:55
 */

@Service
@Transactional
public class AudioServiceImpl implements AudioService {

    @Autowired
    private AudioMapper audioMapper;

    @Override
    public List<Audio> selectAll() {
        return audioMapper.selectAll();
    };

    @Override
    public void insert(Audio audio) {
        audioMapper.insert(audio);
    }

    @Override
    public Audio selectByUrl(String url) {
        return audioMapper.selectByUrl(url);
    }

    @Override
    public void deleteById(Integer id) {
        audioMapper.deleteById(id);
    }

    @Override
    public Audio selectById(Integer id) {
        return audioMapper.selectById(id);
    }

    @Override
    public void update(Audio audio) {
        audioMapper.update(audio);
    }

    @Override
    public Long selectCount() {
        return audioMapper.selectCount();
    }

    @Override
    public List<Audio> selectByPage(Integer page) {
        int offset = (page - 1) * 8;
        return audioMapper.selectByPage(offset);
    }

}
