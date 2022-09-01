package com.kaede.myResources.controller;

import com.kaede.myResources.pojo.Audio;
import com.kaede.myResources.service.AudioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author kaede
 * @create 2022-08-18 12:56
 *
 * 查询所有的音乐信息 --> /audio --> GET
 * 新增音乐信息 --> /audio --> POST
 * 修改音乐信息 --> /audio --> PUT
 * 删除音乐信息 --> /audio/{id} --> DELETE
 * 分页查询音乐信息 --> /audio/{page}/{limit} --> GET
 */

@RestController
@CrossOrigin
@RequestMapping("/audios")
public class AudioController {

    @Autowired
    private AudioService audioService;

    @GetMapping("/all")
    public List<Audio> selectAll() {
        return audioService.selectAll();
    }

    @PostMapping()
    public boolean insert(@RequestParam("file") MultipartFile upFile) throws IOException {
        //获取上传的文件的文件名
        String fileName = upFile.getOriginalFilename();
        int i = fileName.lastIndexOf("-");
        String singer = fileName.substring(0,i).trim();
        int j = fileName.lastIndexOf(".mp3");
        String name = fileName.substring(i+1,j).trim();
        fileName = singer + "-" + name + ".mp3";
        Audio audio = audioService.selectByUrl(fileName);
        if(audio != null) {
            return false;
        }
        Audio upAudio = new Audio(null, name, singer, fileName);
        audioService.insert(upAudio);
        String upFilePath = "E:/WebSiteResources/audio/";
        String finalPath = upFilePath + fileName;
        upFile.transferTo(new File(finalPath));
        return true;
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") Integer id) {
        String prefixPath = "E:/WebSiteResources/audio/";
        String filePath = prefixPath + audioService.selectById(id).getAudioUrl();
        File file = new File(filePath);
        file.delete();
        audioService.deleteById(id);
    }

    @PutMapping()
    public boolean update(@RequestBody Audio audio) {
        Audio audio1 = audioService.selectByUrl(audio.getAudioUrl());
        if (audio1 != null) {
            return false;
        }
        String prefixPath = "E:/WebSiteResources/audio/";
        String oldPath = prefixPath + audioService.selectById(audio.getAudioId()).getAudioUrl();
        String newPath = prefixPath + audio.getAudioUrl();
        File file = new File(oldPath);
        file.renameTo(new File(newPath));
        audioService.update(audio);
        return true;
    }

    @GetMapping()
    public Map<String,Object> selectByPage(Integer page) {
        Map<String,Object> map = new HashMap<>();
        page = (page == null) ? 1 : page;
        List<Audio> audios = audioService.selectByPage(page);
        Long count = audioService.selectCount();
        map.put("audios",audios);
        map.put("count", count);
        return map;
    }

    @DeleteMapping()
    public void multiDelete(@RequestBody Integer[] audioIds) {
        String prefixPath = "E:/WebSiteResources/audio/";
        if (audioIds != null) {
            for (int i = 0; i < audioIds.length; i++) {
                String filePath = prefixPath + audioService.selectById(audioIds[i]).getAudioUrl();
                File file = new File(filePath);
                file.delete();
                audioService.deleteById(audioIds[i]);
            }
        }
    }
}
