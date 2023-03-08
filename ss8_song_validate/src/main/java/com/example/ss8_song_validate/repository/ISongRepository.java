package com.example.ss8_song_validate.repository;

import com.example.ss8_song_validate.bean.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISongRepository extends JpaRepository<Song,Integer> {

}
