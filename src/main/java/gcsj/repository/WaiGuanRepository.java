package gcsj.repository;

import gcsj.entity.OnlineClient;
import gcsj.entity.WaiGuan;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WaiGuanRepository extends JpaRepository<WaiGuan,Long> {

}
